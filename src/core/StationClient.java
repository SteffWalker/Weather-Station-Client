/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import org.json.JSONObject;

/**
 *
 * @author Steffan
 */
public class StationClient {

    private double longitude, latitude, temp, humidity, ultraviolet, windDir, windChill, heatIndex, precipitation,
                	soilPH, windSpeed, dewPoint, bmPressure;

    public StationClient() {
    	
        longitude = (Math.random() * ((180 - -180) + 1)) + -180;
        latitude = (Math.random() * ((90 - -90) + 1)) + -90;
        humidity = (Math.random() * ((100 ) + 1));
        temp = (Math.random() * ((135 - -130) + 1)) + -130; //  Degrees fahrenheit.
        ultraviolet = (Math.random() * ((11) + 1));
        windDir = (Math.random() * ((360) + 1));        // Degrees clockwise from North.
        windSpeed = (Math.random() * ((110) + 1));  //  Metres per second.
        windChill = (Math.random() * ((58 - -88) + 1)) + -88;
        precipitation = (Math.random() * ((50) + 1));   //  Rainfall millimetres per hour.
        soilPH = (Math.random() * ((14) + 1));
        dewPoint = (Math.random() * ((90) + 1));    //  Degrees fahrenheit.
        bmPressure = (Math.random() * ((30 - 20) + 1)) + 20;    //  Pressure in inches Hg

        heatIndex = -42.379 + 2.04901523*temp + 10.14333127*humidity - .22475541*temp*humidity - .00683783*temp*temp -
                    .05481717*humidity*humidity + .00122874*temp*temp*humidity + .00085282*temp*humidity*humidity -
                    .00000199*temp*temp*humidity*humidity;
    }

    public JSONObject generateData() {
        JSONObject clientData = new JSONObject();

        clientData.put("temp", String.valueOf(this.temp));
        clientData.put("humidity", String.valueOf(this.humidity));
        clientData.put("latitude", String.valueOf(this.latitude));
        clientData.put("longitude", String.valueOf(this.longitude));

        return clientData;

    }
}
