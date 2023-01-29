/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.main;

/**
 *
 * @author 8200335
 */
public abstract class Local {

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

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

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
