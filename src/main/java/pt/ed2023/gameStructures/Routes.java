/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.gameStructures;

import org.json.simple.JSONObject;

/**
 * Classe representativa das Rotas do jogo
 *
 * @author 8200335
 */
public class Routes implements RoutesADT {

    private int from;
    private int to;

    /**
     * Construtor principal das Classe das Rotas
     *
     * @param from
     * @param to
     */
    public Routes(int from, int to) {
        this.from = from;
        this.to = to;
    }

    /**
     * Retorna a origem da Rota
     *
     * @return
     */
    @Override
    public int getFrom() {
        return from;
    }

    /**
     * Define a origem da Rota
     *
     * @param from
     */
    @Override
    public void setFrom(int from) {
        this.from = from;
    }

    /**
     * Retorna o destino da rota
     *
     * @return
     */
    @Override
    public int getTo() {
        return to;
    }

    /**
     * Define o destino da rota
     *
     * @param to
     */
    @Override
    public void setTo(int to) {
        this.to = to;
    }

    /**
     * Retorna um objeto JSON representativo da Rota
     *
     * @return
     */
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("from", from);
        json.put("to", to);
        return json;
    }

    /**
     * Retirna uma string representativa da Rota
     *
     * @return
     */
    @Override
    public String toString() {
        return "Routes [from=" + from + ", to=" + to + "]";
    }
}
