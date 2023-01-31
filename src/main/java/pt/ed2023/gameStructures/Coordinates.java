/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.gameStructures;

import org.json.simple.JSONObject;

/**
 *
 * @author 8200335
 */
public class Coordinates implements CoordinatesADT{

    private final double latitude;
    private final double longitude;

    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public double getLatitude() {
        return latitude;
    }

    @Override
    public double getLongitude() {
        return longitude;
    }

    @Override
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
