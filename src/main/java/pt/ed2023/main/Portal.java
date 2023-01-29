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
public class Portal extends Local {

    private String name;
    private int ownership;
    private State state;
    public enum State {
        NEUTRO, SPARKS, GIANTS;
    }

    public Portal(int id, Coordinates coordinates, int ownershipPlayerID, String name, State state, int energy) {
        super(id, Local.Types.Portal, coordinates, energy);
        this.name = name;
        this.ownership = ownershipPlayerID;
        this.state = state;

    }
    public Portal(int id, Coordinates coordinates, String name, int energy) {
        super(id, Local.Types.Connector, coordinates, energy);
        this.name = name;
        this.ownership = -1;
        this.state = State.NEUTRO;

    }
    
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setOwnership(int ownership) {
        this.ownership = ownership;
    }

    public int getOwnership() {
        return ownership;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JSONObject ownershipToJson() {
        JSONObject jsonOwnership = new JSONObject();
        // EM VEZ DO ID TEM DE PASSAR O NOME
        jsonOwnership.put("player", this.ownership);
        return jsonOwnership;
    }

    public JSONObject gameSettingsToJson() {
        JSONObject jsonGameSettings = new JSONObject();
        jsonGameSettings.put("energy", this.getEnergy());
        jsonGameSettings.put("ownership", ownershipToJson());
        return jsonGameSettings;
    }

    public JSONObject toJson() {
        JSONObject jsonPortal = new JSONObject();
        jsonPortal.put("id", this.getId());
        jsonPortal.put("name", this.name);
        jsonPortal.put("type", this.getType().toString());
        jsonPortal.put("coordinates", this.getCoordinates().toJson());
        jsonPortal.put("gameSettings", gameSettingsToJson());
        return jsonPortal;
    }

    @Override
    public String toString() {
        return "Portal [name=" + name + ", id=" + getId() + ", type=" + getType() + ", coordinates=" + getCoordinates()
                + ", OwnerShip=" + getOwnership() + ", state=" + getState() + "]";
    }
}
