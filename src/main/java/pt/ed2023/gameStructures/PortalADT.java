/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.gameStructures;

import org.json.simple.JSONObject;

/**
 * Este Tipo Abstrato de Dados define as os métodos ou operações que podem ser
 * realizadas no tocante dos Portais do Jogo
 *
 * @author 8200335
 */
public interface PortalADT extends LocalADT {

    /**
     * Retorna o estado do portal
     *
     * @return
     */
    public Portal.State getState();

    /**
     * Define o estado do Portal
     *
     * @param state
     */
    public void setState(Portal.State state);

    /**
     * Define o proprieitario do portal
     *
     * @param ownership
     */
    public void setOwnership(int ownership);

    /**
     * Retorna o proprietario do Portal
     *
     * @return
     */
    public int getOwnership();

    /**
     * Retorna o norme do portal
     *
     * @return
     */
    public String getName();

    /**
     * Define o nome do portal
     *
     * @param name
     */
    public void setName(String name);

    /**
     * Retorna um objeto JSON que representa a propriedade do Portal
     *
     * @return
     */
    public JSONObject ownershipToJson();

    /**
     * Retorna um objeto JSON que representa as definições de jogo do Portal
     *
     * @return
     */
    public JSONObject gameSettingsToJson();

    /**
     * Retorna um objeto JSON que representa o Portal como um todo
     *
     * @return
     */
    public JSONObject toJson();

    /**
     * Retorna um String que representa o Portal
     *
     * @return
     */
    @Override
    public String toString();

}
