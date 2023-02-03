/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.gameStructures;

import org.json.simple.JSONObject;

/**
 * Classe representativa das coordenadas
 *
 * @author 8200335
 */
public class Coordinates implements CoordinatesADT {

    private final double latitude;
    private final double longitude;

    /**
     * Construtor da classe
     *
     * @param latitude
     * @param longitude
     */
    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Retorna a latitude das coordenadas
     *
     * @return
     */
    @Override
    public double getLatitude() {
        return latitude;
    }

    /**
     * Retorna a longitude das coordenadas
     *
     * @return
     */
    @Override
    public double getLongitude() {
        return longitude;
    }

    /**
     * Retorna um objeto em JSON caracterizante das coordenadas
     *
     * @return
     */
    @Override
    public JSONObject toJson() {
        JSONObject jsonCoordinates = new JSONObject();
        jsonCoordinates.put("latitude", this.latitude);
        jsonCoordinates.put("longitude", this.longitude);
        return jsonCoordinates;
    }

    /**
     * Retorna uma String representativa das coordenadas
     *
     * @return
     */
    @Override
    public String toString() {
        return "Coordinates [latitude=" + latitude + ", longitude=" + longitude + "]";
    }
}
