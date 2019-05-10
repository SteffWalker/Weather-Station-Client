/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author N0741707
 */
public class Functions {

    public static Timer timer = new Timer();

    public static JSONObject getIdentifier() throws NullPointerException {

        InputStream databaseFile = Functions.class.getResourceAsStream("../identifier.json");
        JSONTokener databaseTokener = new JSONTokener(databaseFile);
        JSONObject databaseRoot = new JSONObject(databaseTokener);

        return databaseRoot;
    }

    public static void registerStation() throws SocketException, IOException {
        JSONObject json = new JSONObject();
        Date date = new Date();
        JSONObject identifier = getIdentifier();

        if (identifier.getString("stationId").isEmpty()) {

            json.put("stationId", UUID.randomUUID().toString());

        String file = new File("src/identifier.json").getAbsolutePath();
        FileWriter fileWriter = new FileWriter(file);
            try {
                fileWriter.write(json.toString());
            } catch (IOException e) {
            } finally {
                fileWriter.flush();
                fileWriter.close();
            }
        } else {
            json.put("stationId", identifier.getString("stationId"));
        }
        json.put("lastContact", String.valueOf(date.getTime()));
        json.put("method", "registerStation");

        scheduleUpdate();

        try {
            Reciever.sendData(json);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    static void scheduleUpdate() {
        timer.scheduleAtFixedRate(updater, 10000, 10000);
    }

    static TimerTask updater = new TimerTask() {
        @Override
        public void run() {
            JSONObject json = new JSONObject();
            Date date = new Date();
            StationClient client = new StationClient();
            JSONObject identifier = getIdentifier();

            if (!identifier.getString("stationId").isEmpty()) {

                json.put("stationId", identifier.getString("stationId"));
                json.put("stationData", client.generateData());
                json.put("lastContact", String.valueOf(date.getTime()));
                json.put("method", "updateStationValues");

                new Thread() {
                    public void run() {
                        try {
                            Reciever.sendData(json);
                        } catch (InterruptedException e) {
                            System.out.println(e);
                        }
                    }
                }.start();
            }
        }
    };
}
