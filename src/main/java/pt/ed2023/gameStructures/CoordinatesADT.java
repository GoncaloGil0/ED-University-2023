/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.gameStructures;

import org.json.simple.JSONObject;

/**
 * Este Tipo Abstrato de Dados define as os métodos ou operações que podem ser
 * realizadas no tocante das coordenasas dos Locais
 *
 * @author peter
 */
public interface CoordinatesADT {

    /**
     * Retorna a latitude
     *
     * @return
     */
    public double getLatitude();

    /**
     * Retorna a longitude
     *
     * @return
     */
    public double getLongitude();

    /**
     * Retorna um objeto representativo das coordenadas no formato JSON
     *
     * @return
     */
    public JSONObject toJson();

    /**
     * Retorna um String representativa das coordenadas
     *
     * @return
     */
    @Override
    public String toString();
}
