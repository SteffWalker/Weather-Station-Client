/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import java.util.Random;

/**
 *
 * @author Steffan
 */
public class StationClient {
    private double longitude, latitude, temp, humidity;
    
    public StationClient()
    {
        longitude = (Math.random() * ((180 - -180) + 1)) + -180;
        latitude = (Math.random() * ((90 - -90) + 1)) + -90;
    }
    
    public void generateData()
    {
        //Random rand = new Random();
        this.temp = (Math.random() * ((58 - -88) + 1)) + -88;
        this.humidity = (Math.random() * ((100 - 0) + 1)) + 0;
    }
}