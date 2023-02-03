/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.gameStructures;

/**
 * Este Tipo Abstrato de Dados define as os métodos ou operações que podem ser
 * realizadas no tocante dos locais do Jogo
 *
 * @author 8200335
 */
public interface LocalADT {

    /**
     * Retorna o id do local
     *
     * @return
     */
    int getId();

    /**
     * Define o ID do local
     *
     * @param id
     */
    void setId(int id);

    /**
     * Retorna o tipo do Local
     *
     * @return
     */
    Local.Types getType();

    /**
     * Define o tipo de local
     *
     * @param type
     */
    void setType(Local.Types type);

    /**
     * retorna as coordenadas do local
     *
     * @return
     */
    Coordinates getCoordinates();

    /**
     * Define as doordenadas do local
     *
     * @param coordinates
     */
    void setCoordinates(Coordinates coordinates);

    /**
     * Retorna a energia do local
     *
     * @return
     */
    int getEnergy();

    /**
     * Define a energia do local
     *
     * @param energy
     */
    void setEnergy(int energy);
}
