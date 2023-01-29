/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.main;

import pt.ed2023.dataStructures.list.ArrayUnorderedList;
import pt.ed2023.exceptions.EmptyCollectionException;

/**
 *
 * @author 8200335
 */
public class Team {

    private TeamName name;
    private ArrayUnorderedList<Players> teamPlayers;

    public Team(TeamName name) {
        this.name = name;
        this.teamPlayers = new ArrayUnorderedList<>();
    }

    public TeamName getName() {
        return name;
    }

    public boolean validateUserExistence(String playerName) {
        for (Players player : teamPlayers) {
            if (player.getName().equals(playerName)) {
                return true;
            }
        }
        return false;
    }

    public int getUserIDbyName(String playerName) {
        for (Players player : teamPlayers) {
            if (player.getName().equals(playerName)) {
                return player.getId();
            }
        }
        return -1;
    }

    public void setName(TeamName name) {
        this.name = name;
    }

    public ArrayUnorderedList<Players> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(ArrayUnorderedList<Players> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    public void addPlayer(Players player) {
        teamPlayers.addToRear(player);
    }

    public void removePlayer(Players player) throws EmptyCollectionException {
        teamPlayers.remove(player);
    }

    public boolean findPlayer(Players player) {
        return teamPlayers.contains(player);
    }

    public Players findPlayerByID(int ID) {
        return teamPlayers.get(ID);
    }

    public boolean isEmpty() {
        return teamPlayers.isEmpty();
    }

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
