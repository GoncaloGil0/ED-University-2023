/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.gameStructures;

import pt.ed2023.dataStructures.list.ArrayUnorderedList;
import pt.ed2023.exceptions.ElementNotFoundException;
import pt.ed2023.exceptions.EmptyCollectionException;

/**
 * Este Tipo Abstrato de Dados define as os métodos ou operações que podem ser
 * realizadas no tocante das Equipas do Jogo
 *
 * @author 8200335
 */
public interface TeamADT {

    /**
     * Retorna o nome da Equipa
     *
     * @return
     */
    public Team.TeamName getName();

    /**
     * Valida se um user pertence á equipa ou não
     *
     * @param playerName
     * @return
     */
    public boolean validateUserExistence(String playerName);

    /**
     * Retorna o ID de um user da Equipa
     *
     * @param playerName
     * @return
     */
    public int getUserIDbyName(String playerName) throws ElementNotFoundException;

    /**
     * Define o nome da equipa
     *
     * @param name
     */
    public void setName(Team.TeamName name);

    /**
     * Retorna o array de jogadores
     *
     * @return
     */
    public ArrayUnorderedList<Players> getTeamPlayers();

    /**
     *
     * Recebe um array de jogadores e assicia-os á equipa
     *
     * @param teamPlayers
     */
    public void setTeamPlayers(ArrayUnorderedList<Players> teamPlayers);

    /**
     * Adiciona um jogador á equipa
     *
     * @param player
     */
    public void addPlayer(Players player);

    /**
     * Remove um jogador da equipa
     *
     * @param player
     * @throws EmptyCollectionException
     */
    public void removePlayer(Players player) throws EmptyCollectionException;

    /**
     * Verifica se um utilizador pertence á equipa
     *
     * @param player
     * @return
     */
    public boolean findPlayer(Players player);

    /**
     * Retorna o utilizador com o id recebido
     *
     * @param ID
     * @return
     */
    public Players findPlayerByID(int ID);

    /**
     * Valida se a lista de Jogadores está vazia ou não
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * Retorna o tamanho da lita de Jogadores
     *
     * @return
     */
    public int size();

    /**
     * Retorna uma string com toda a informação da equipa e seus participantes
     *
     * @return
     */
    @Override
    public String toString();

}
