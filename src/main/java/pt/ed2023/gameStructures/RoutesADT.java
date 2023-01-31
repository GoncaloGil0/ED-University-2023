/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.gameStructures;

import org.json.simple.JSONObject;

/**
 *
 * @author 8200335
 */
public interface RoutesADT {
 
    /**
     * 
     * @return 
     */
    public int getFrom();
    
    /**
     * 
     * @param from 
     */
    public void setFrom(int from);
    
    /**
     * 
     * @return 
     */
    public int getTo();
    
    /**
     * 
     * @param to 
     */
    public void setTo(int to);
    
    /**
     * 
     * @return 
     */
    public JSONObject toJson();
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString();
}
