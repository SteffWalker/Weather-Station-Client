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

    private double longitude, latitude, temp, humidity;

    public StationClient() {
        longitude = (Math.random() * ((180 - -180) + 1)) + -180;
        latitude = (Math.random() * ((90 - -90) + 1)) + -90;
        humidity = (Math.random() * ((100 - 0) + 1)) + 0;
        temp = (Math.random() * ((58 - -88) + 1)) + -88;
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
