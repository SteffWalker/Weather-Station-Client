package weatherstationclient;

import core.Functions;
import core.Reciever;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Steffan
 */
public class WeatherStationClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Reciever.startListener();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
