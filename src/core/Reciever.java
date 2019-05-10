package core;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/**
 *
 * @author N0741707
 */
public class Reciever {

    private static String serverAddress;
    private static Scanner in;
    private static PrintWriter out;
    private static String message = "";
    public static CountDownLatch latch = new CountDownLatch(1);

    public static void startListener() throws Exception {
        serverAddress = "localhost";

        try (Socket socket = new Socket(serverAddress, 1337)) {
            Scanner in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            Functions.registerStation();
            while (in.hasNextLine()) {
                message = in.nextLine();
                latch.countDown();
                latch = new CountDownLatch(1);
            }
        }
    }

    public static String sendData(JSONObject data) throws InterruptedException {
        data.put("serverType", "station");
        out.println(data);
        latch.await();
        return message;
    }

}
