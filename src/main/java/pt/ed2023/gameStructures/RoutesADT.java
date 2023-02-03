/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.gameStructures;

import org.json.simple.JSONObject;

/**
 * Este Tipo Abstrato de Dados define as os métodos ou operações que podem ser
 * realizadas no tocante das Rotas do Jogo
 *
 * @author 8200335
 */
public interface RoutesADT {

    /**
     * Retorna a origem da rota
     * @return
     */
    public int getFrom();

    /**
     * Define o destino da rota
     * @param from
     */
    public void setFrom(int from);

    /**
     * Retorna o destino da rota
     * @return
     */
    public int getTo();

    /**
     * Define o destino da Rota 
     * @param to
     */
    public void setTo(int to);

    /**
     * Retorna um objeto JSON representativo da Rota
     * @return
     */
    public JSONObject toJson();

    /**
     * Retorna uma String representativa da Rota
     * @return
     */
    @Override
    public String toString();
}
