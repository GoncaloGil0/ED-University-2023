/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.gameStructures;

import pt.ed2023.dataStructures.list.ArrayUnorderedList;
import pt.ed2023.exceptions.ElementNotFoundException;
import pt.ed2023.exceptions.EmptyCollectionException;

/**
 * Classe representativa das Equipas do Jogo
 *
 * @author 8200335
 */
public class Team implements TeamADT {

    private TeamName name;
    private ArrayUnorderedList<Players> teamPlayers;

    /**
     * Construtor da Class
     *
     * @param name
     */
    public Team(TeamName name) {
        this.name = name;
        this.teamPlayers = new ArrayUnorderedList<>();
    }

    /**
     * Retorna o nome da equipa
     *
     * @return
     */
    @Override
    public TeamName getName() {
        return name;
    }

    /**
     * Valida se um jogador pertence á equipa
     *
     * @param playerName
     * @return
     */
    @Override
    public boolean validateUserExistence(String playerName) {
        for (Players player : teamPlayers) {
            if (player.getName().equals(playerName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna o ID de um utilizador da equipa recebendo o nome do mesmo
     *
     * @param playerName
     * @return
     * @throws ElementNotFoundException
     */
    @Override
    public int getUserIDbyName(String playerName) throws ElementNotFoundException {
        for (Players player : teamPlayers) {
            if (player.getName().equals(playerName)) {
                return player.getId();
            }
        }

        throw new ElementNotFoundException("Jogador não encontrado");
    }

    /**
     * Define o nome da equipa
     * @param name 
     */
    @Override
    public void setName(TeamName name) {
        this.name = name;
    }

    /**
     * Retorna a lista de jogadores da Equipa 
     * @return 
     */
    @Override
    public ArrayUnorderedList<Players> getTeamPlayers() {
        return teamPlayers;
    }

    /**
     * Define a lista de jogadores da Equipa, recebendo uma.
     * 
     * @param teamPlayers 
     */
    @Override
    public void setTeamPlayers(ArrayUnorderedList<Players> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    /**
     * Adiciona um jogador á equipa
     * 
     * @param player 
     */
    @Override
    public void addPlayer(Players player) {
        teamPlayers.addToRear(player);
    }

    /**
     * Remove um jogador da equipa 
     * @param player
     * @throws EmptyCollectionException 
     */
    @Override
    public void removePlayer(Players player) throws EmptyCollectionException {
        teamPlayers.remove(player);
    }

    /**
     * Procura um jogador na equipa 
     * @param player
     * @return 
     */
    @Override
    public boolean findPlayer(Players player) {
        return teamPlayers.contains(player);
    }

    /**
     * Procura um jogador na equipa a partir do seu ID
     * @param ID
     * @return 
     */
    @Override
    public Players findPlayerByID(int ID) {
        return teamPlayers.get(ID);
    }

    /**
     * Varifica se a lista de jogadores está vazia ou não
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return teamPlayers.isEmpty();
    }

    /**
     * Retorna o numero de jogadores na Equipa
     * @return 
     */
    @Override
    public int size() {
        return teamPlayers.size();
    }

    /**
     * Enumeração dos nomes possiveis para as Equipas 
     */
    public enum TeamName {
        Sparks, Giants, Extra
    }

    /**
     * Retorna uma String representativa da Equipa em questão
     * @return 
     */
    @Override
    public String toString() {
        return "Team [name=" + name + ", teamPlayers=" + teamPlayers.toString() + "]";
    }
}
