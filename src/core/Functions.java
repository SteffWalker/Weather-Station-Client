/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONObject;

/**
 *
 * @author N0741707
 */
public class Functions {
    
        public static void registerStation() throws SocketException {
        JSONObject json = new JSONObject();
        try {
            NetworkInterface ni = NetworkInterface.getByName("eth0");
            json.put("stationId", Arrays.toString(ni.getHardwareAddress()));
        } catch (Exception e) {
            json.put("stationId", UUID.randomUUID().toString());
        }
        json.put("method", "registerStation");
        try {
            Reciever.sendData(json);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}