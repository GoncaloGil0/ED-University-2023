/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.gameStructures;

import pt.ed2023.dataStructures.list.ArrayUnorderedList;
import pt.ed2023.exceptions.ElementNotFoundException;
import pt.ed2023.exceptions.EmptyCollectionException;

/**
 *
 * @author 8200335
 */
public class Team implements TeamADT {

    private TeamName name;
    private ArrayUnorderedList<Players> teamPlayers;

    public Team(TeamName name) {
        this.name = name;
        this.teamPlayers = new ArrayUnorderedList<>();
    }

    @Override
    public TeamName getName() {
        return name;
    }

    @Override
    public boolean validateUserExistence(String playerName) {
        for (Players player : teamPlayers) {
            if (player.getName().equals(playerName)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public int getUserIDbyName(String playerName) throws ElementNotFoundException{
        for (Players player : teamPlayers) {
            if (player.getName().equals(playerName)) {
                return player.getId();
            }
        }
        
        throw new ElementNotFoundException("Jogador não encontrado");
    }

    @Override
    public void setName(TeamName name) {
        this.name = name;
    }

    @Override
    public ArrayUnorderedList<Players> getTeamPlayers() {
        return teamPlayers;
    }

    @Override
    public void setTeamPlayers(ArrayUnorderedList<Players> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    @Override
    public void addPlayer(Players player) {
        teamPlayers.addToRear(player);
    }

    @Override
    public void removePlayer(Players player) throws EmptyCollectionException {
        teamPlayers.remove(player);
    }

    @Override
    public boolean findPlayer(Players player) {
        return teamPlayers.contains(player);
    }

    @Override
    public Players findPlayerByID(int ID) {
        return teamPlayers.get(ID);
    }

    @Override
    public boolean isEmpty() {
        return teamPlayers.isEmpty();
    }

    @Override
    public int size() {
        return teamPlayers.size();
    }

    public enum TeamName {
        Sparks, Giants, Extra
    }
    
    @Override
    public String toString() {
        return "Team [name=" + name + ", teamPlayers=" + teamPlayers.toString() + "]";
    }
}
