/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.gameStructures;

/**
 *
 * @author 8200335
 */
public abstract class Local implements LocalADT {

    private int id;
    private Types type;
    private Coordinates coordinates;
    private int energy;

    public Local(int id, Types type, Coordinates coordinates, int energy) {
        this.id = id;
        this.type = type;
        this.coordinates = coordinates;
        this.energy = energy;
    }

    @Override
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Types getType() {
        return type;
    }

    @Override
    public void setType(Types type) {
        this.type = type;
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public enum Types {
        Portal, Connector;
    }

    @Override
    public String toString() {
        return "Local [id=" + id + ", type=" + type + ", coordinates=" + coordinates + "]";
    }
}
