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
public class Routes implements RoutesADT {

    private int from;
    private int to;

    public Routes(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public int getFrom() {
        return from;
    }

    @Override
    public void setFrom(int from) {
        this.from = from;
    }

    @Override
    public int getTo() {
        return to;
    }

    @Override
    public void setTo(int to) {
        this.to = to;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("from", from);
        json.put("to", to);
        return json;
    }

    @Override
    public String toString() {
        return "Routes [from=" + from + ", to=" + to + "]";
    }
}
