/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.main;

import org.json.simple.JSONObject;

/**
 *
 * @author 8200335
 */
public class Coordinates {

    private final double latitude;
    private final double longitude;

    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public JSONObject toJson() {
        JSONObject jsonCoordinates = new JSONObject();
        jsonCoordinates.put("latitude", this.latitude);
        jsonCoordinates.put("longitude", this.longitude);
        return jsonCoordinates;
    }

    @Override
    public String toString() {
        return "Coordinates [latitude=" + latitude + ", longitude=" + longitude + "]";
    }
}
