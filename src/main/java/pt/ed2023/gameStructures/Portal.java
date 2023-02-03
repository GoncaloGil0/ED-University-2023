/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.gameStructures;

import org.json.simple.JSONObject;

/**
 * Classe que representa os Portais do Jogo
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

    /**
     * Constutor principal da classe Portal
     *
     * @param id
     * @param coordinates
     * @param ownershipPlayerID
     * @param name
     * @param state
     * @param energy
     */
    public Portal(int id, Coordinates coordinates, int ownershipPlayerID, String name, State state, int energy) {
        super(id, Local.Types.Portal, coordinates, energy);
        this.name = name;
        this.ownership = ownershipPlayerID;
        this.state = state;

    }

    /**
     * Construtor basico dos Portais
     *
     * @param id
     * @param coordinates
     * @param name
     * @param energy
     */
    public Portal(int id, Coordinates coordinates, String name, int energy) {
        super(id, Local.Types.Connector, coordinates, energy);
        this.name = name;
        this.ownership = -1;
        this.state = State.NEUTRO;

    }

    /**
     * Retorna o estado do portal
     *
     * @return
     */
    @Override
    public State getState() {
        return state;
    }

    /**
     * Define o estado do portal
     *
     * @param state
     */
    @Override
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Define a propriedade do portal
     *
     * @param ownership
     */
    @Override
    public void setOwnership(int ownership) {
        this.ownership = ownership;
    }

    /**
     * Retorna o proprietario do portal
     *
     * @return
     */
    @Override
    public int getOwnership() {
        return ownership;
    }

    /**
     * Rettorna o nome do portal
     *
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Define o nome do Portal
     *
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna um objeto JSON com a informação de propriedade do Portal
     *
     * @return
     */
    @Override
    public JSONObject ownershipToJson() {
        JSONObject jsonOwnership = new JSONObject();
        // EM VEZ DO ID TEM DE PASSAR O NOME
        jsonOwnership.put("player", this.ownership);
        return jsonOwnership;
    }

    /**
     * Retorna um JSON com as definições do Portal
     *
     * @return
     */
    @Override
    public JSONObject gameSettingsToJson() {
        JSONObject jsonGameSettings = new JSONObject();
        jsonGameSettings.put("energy", this.getEnergy());
        jsonGameSettings.put("ownership", ownershipToJson());
        return jsonGameSettings;
    }

    /**
     * Retorna um objeto JSON com toda a informação do Portal
     *
     * @return
     */
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

    /**
     * Retorna um epresentação do portal em formato de String
     * @return 
     */
    @Override
    public String toString() {
        return "Portal [name=" + name + ", id=" + getId() + ", type=" + getType() + ", coordinates=" + getCoordinates()
                + ", OwnerShip=" + getOwnership() + ", state=" + getState() + "]";
    }
}
