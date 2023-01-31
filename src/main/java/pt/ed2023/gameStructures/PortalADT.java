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
public interface PortalADT extends LocalADT{
    
    /**
     * 
     * @return 
     */
    public Portal.State getState();
    
    /**
     * 
     * @param state 
     */
    public void setState(Portal.State state);
    
    /**
     * 
     * @param ownership 
     */
    public void setOwnership(int ownership);
    
    /**
     * 
     * @return 
     */
    public int getOwnership();
    
    /**
     * 
     * @return 
     */
    public String getName();
    
    /**
     * 
     * @param name 
     */
    public void setName(String name);
    
    /**
     * 
     * @return 
     */
    public JSONObject ownershipToJson();
    
    /**
     * 
     * @return 
     */
    public JSONObject gameSettingsToJson();
    
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
