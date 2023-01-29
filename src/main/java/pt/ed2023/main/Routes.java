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
public class Routes {

    private int from;
    private int to;

    public Routes(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

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
