/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.gameStructures;

import org.json.simple.JSONObject;

/**
 *
 * @author peter
 */
public interface CoordinatesADT {
 
    /**
     * 
     * @return 
     */
    public double getLatitude();
 
    /**
     * 
     * @return 
     */
    public double getLongitude();
    
    /**
     * 
     * @return 
     */
    public JSONObject toJson();
    
    /**
     * 
     * @return 
     */
    public String toString();
}

