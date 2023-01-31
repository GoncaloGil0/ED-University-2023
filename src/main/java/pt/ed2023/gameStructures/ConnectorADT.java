/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.gameStructures;

import java.time.LocalDateTime;
import org.json.simple.JSONObject;

/**
 *
 * @author 8200335
 */
public interface ConnectorADT extends LocalADT {
    
    /**
     * 
     * @param player
     * @return
     * @throws InterruptedException 
     */
    public boolean rechargeUser(Players player) throws InterruptedException;
    
    /**
     * 
     * @param lastUsed 
     */
    public void setLastUsed(LocalDateTime lastUsed);
    
    /**
     * 
     * @return 
     */
    public LocalDateTime getLastUsed();
    
    /**
     * 
     * @param cooldown 
     */
    public void setCooldown(int cooldown);
    
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
