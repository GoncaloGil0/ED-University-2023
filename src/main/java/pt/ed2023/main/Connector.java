/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.main;

import java.time.LocalDateTime;
import org.json.simple.JSONObject;

/**
 *
 * @author 8200335
 */
public class Connector extends Local {

    private int cooldown;
    private LocalDateTime lastUsed = LocalDateTime.now();

    public Connector(int id, Coordinates coordinates, int cooldown, int energy) {
        super(id, Local.Types.Connector, coordinates, energy);
        this.cooldown = cooldown;
    }
    
    public boolean rechargeUser(Players player) throws InterruptedException{
        
        LocalDateTime diff = this.lastUsed.plusMinutes(this.cooldown);
        Thread.sleep(5000);
        int energyNeeded = player.getMaxEnergy() - player.getCurrentEnergy();
        
        if (energyNeeded < super.getEnergy() && diff.isBefore(LocalDateTime.now())){
            player.setCurrentEnergy(player.getCurrentEnergy() + energyNeeded);
            return true;
        }
        return false;
    }
        
    public void setLastUsed(LocalDateTime lastUsed) {
        this.lastUsed = lastUsed;
    }

    public LocalDateTime getLastUsed() {
        return lastUsed;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public JSONObject gameSettingsToJson() {
        JSONObject jsonGameSettings = new JSONObject();
        jsonGameSettings.put("energy", this.getEnergy());
        jsonGameSettings.put("cooldown", this.cooldown);
        return jsonGameSettings;
    }

    public JSONObject toJson() {
        JSONObject jsonConnector = new JSONObject();
        jsonConnector.put("id", this.getId());
        jsonConnector.put("coordinates", this.getCoordinates().toJson());
        jsonConnector.put("energy", this.getEnergy());
        jsonConnector.put("gameSettings", gameSettingsToJson());
        jsonConnector.put("type", this.getType().toString());

        return jsonConnector;
    }

    @Override
    public String toString() {
        return "Connector [id=" + getId() + ", type=" + getType() + ", coordinates=" + getCoordinates()
                + "]";
    }
}
