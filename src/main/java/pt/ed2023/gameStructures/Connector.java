/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.gameStructures;

import java.time.LocalDateTime;
import org.json.simple.JSONObject;

/**
 *
 * @author 8200335
 */
public class Connector extends Local implements ConnectorADT {

    private int cooldown;
    private LocalDateTime lastUsed = LocalDateTime.now();
    private int lastPlayerID;

    public Connector(int id, Coordinates coordinates, int cooldown, int energy) {
        super(id, Local.Types.Connector, coordinates, energy);
        this.cooldown = cooldown;
    }

    @Override
    public boolean rechargeUser(Players player) throws InterruptedException {

        if (lastPlayerID == player.getId()) {
            return false;
        }

        int energyNeeded = player.getMaxEnergy() - player.getCurrentEnergy();

        if (energyNeeded > super.getEnergy()) {
            return false;
        }

        LocalDateTime diff = this.lastUsed.plusMinutes(this.cooldown);
        
        //AQUI SÒ PARA TESTES 
        Thread.sleep(5000);

        if (diff.isBefore(LocalDateTime.now())) {
            player.setCurrentEnergy(player.getCurrentEnergy() + energyNeeded);
            this.lastUsed = LocalDateTime.now();
            this.lastPlayerID = player.getId();
            return true;
        }
        
        return false;
    }

    @Override
    public void setLastUsed(LocalDateTime lastUsed) {
        this.lastUsed = lastUsed;
    }

    @Override
    public LocalDateTime getLastUsed() {
        return lastUsed;
    }

    @Override
    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    @Override
    public JSONObject gameSettingsToJson() {
        JSONObject jsonGameSettings = new JSONObject();
        jsonGameSettings.put("energy", this.getEnergy());
        jsonGameSettings.put("cooldown", this.cooldown);
        return jsonGameSettings;
    }

    @Override
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
