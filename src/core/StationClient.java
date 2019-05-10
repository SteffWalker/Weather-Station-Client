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
        humidity = (Math.random() * ((100) + 1));
        temp = (Math.random() * ((135 - -130) + 1)) + -130; //  Degrees fahrenheit.
        ultraviolet = (Math.random() * ((11) + 1));
        windDir = (Math.random() * ((360) + 1));        // Degrees clockwise from North.
        windSpeed = (Math.random() * ((110) + 1));  //  Metres per second.
        windChill = (Math.random() * ((58 - -88) + 1)) + -88;
        precipitation = (Math.random() * ((50) + 1));   //  Rainfall millimetres per hour.
        soilPH = (Math.random() * ((14) + 1));
        dewPoint = (Math.random() * ((90) + 1));    //  Degrees fahrenheit.
        bmPressure = (Math.random() * ((30 - 20) + 1)) + 20;    //  Pressure in inches Hg
    }

    public JSONObject generateData() {
        JSONObject clientData = new JSONObject();

        clientData.put("longitude", String.valueOf(this.longitude));
        clientData.put("temp", String.valueOf(this.temp));
        clientData.put("humidity", String.valueOf(this.humidity));
        clientData.put("latitude", String.valueOf(this.latitude));
        clientData.put("ultraviolet", String.valueOf(this.ultraviolet));
        clientData.put("windDir", String.valueOf(this.windDir));
        clientData.put("windSpeed", String.valueOf(this.windSpeed));
        clientData.put("windChill", String.valueOf(this.windChill));
        clientData.put("precipitation", String.valueOf(this.precipitation));
        clientData.put("soilPH", String.valueOf(this.soilPH));
        clientData.put("dewPoint", String.valueOf(this.dewPoint));
        clientData.put("bmPressure", String.valueOf(this.bmPressure));

        return clientData;

    }
}
