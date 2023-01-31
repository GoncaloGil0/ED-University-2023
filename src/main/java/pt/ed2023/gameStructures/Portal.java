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
public class Portal extends Local implements PortalADT {

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
    
    @Override
    public State getState() {
        return state;
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void setOwnership(int ownership) {
        this.ownership = ownership;
    }

    @Override
    public int getOwnership() {
        return ownership;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public JSONObject ownershipToJson() {
        JSONObject jsonOwnership = new JSONObject();
        // EM VEZ DO ID TEM DE PASSAR O NOME
        jsonOwnership.put("player", this.ownership);
        return jsonOwnership;
    }

    @Override
    public JSONObject gameSettingsToJson() {
        JSONObject jsonGameSettings = new JSONObject();
        jsonGameSettings.put("energy", this.getEnergy());
        jsonGameSettings.put("ownership", ownershipToJson());
        return jsonGameSettings;
    }

    @Override
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
