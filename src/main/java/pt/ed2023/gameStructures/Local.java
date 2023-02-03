/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.gameStructures;

/**
 *  Classe representativa dos Locais do Jogo
 * 
 * @author 8200335
 */
public abstract class Local implements LocalADT {

    private int id;
    private Types type;
    private Coordinates coordinates;
    private int energy;

    /**
     * Construtor principal dos Locais
     * @param id
     * @param type
     * @param coordinates
     * @param energy 
     */
    public Local(int id, Types type, Coordinates coordinates, int energy) {
        this.id = id;
        this.type = type;
        this.coordinates = coordinates;
        this.energy = energy;
    }

    /**
     * Define a energia do local
     * @param energy 
     */
    @Override
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     * Retorna a energia do local 
     * @return 
     */
    @Override
    public int getEnergy() {
        return energy;
    }

    /**
     * Retorna o ID do local
     * @return 
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Define o ID do local
     * @param id 
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o tipo de local 
     * @return 
     */
    @Override
    public Types getType() {
        return type;
    }

    /**
     * Define o tipo de local
     * @param type 
     */
    @Override
    public void setType(Types type) {
        this.type = type;
    }

    /**
     * Retorna as coordenadas de um local 
     * @return 
     */
    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Define as coordenadas de um local 
     * @param coordinates 
     */
    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public enum Types {
        Portal, Connector;
    }

    /**
     * Retorna uma string representativa do Local
     * @return 
     */
    @Override
    public String toString() {
        return "Local [id=" + id + ", type=" + type + ", coordinates=" + coordinates + "]";
    }
}
