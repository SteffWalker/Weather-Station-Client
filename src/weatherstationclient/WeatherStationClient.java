package weatherstationclient;

import core.Reciever;
import core.StationClient;

/**
 *
 * @author Steffan
 */
public class WeatherStationClient {

    private static final StationClient station = new StationClient();

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
