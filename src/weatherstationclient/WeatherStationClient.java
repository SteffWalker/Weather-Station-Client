package weatherstationclient;

import core.Reciever;

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
