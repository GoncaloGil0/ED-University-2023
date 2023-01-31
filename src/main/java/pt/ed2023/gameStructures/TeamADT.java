/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.gameStructures;

import pt.ed2023.dataStructures.list.ArrayUnorderedList;
import pt.ed2023.exceptions.ElementNotFoundException;
import pt.ed2023.exceptions.EmptyCollectionException;

/**
 *
 * @author 8200335
 */
public interface TeamADT {
    
    /**
     * 
     * @return 
     */
    public Team.TeamName getName();
    
    /**
     * 
     * @param playerName
     * @return 
     */
    public boolean validateUserExistence(String playerName);
    
    /**
     * 
     * @param playerName
     * @return 
     */
    public int getUserIDbyName(String playerName) throws ElementNotFoundException;
    
    /**
     * 
     * @param name 
     */
    public void setName(Team.TeamName name);
    
    /**
     * 
     * @return 
     */
    public ArrayUnorderedList<Players> getTeamPlayers();
    
    /**
     * 
     * @param teamPlayers 
     */
    public void setTeamPlayers(ArrayUnorderedList<Players> teamPlayers);
    
    /**
     * 
     * @param player 
     */
    public void addPlayer(Players player);
    
    /**
     * 
     * @param player
     * @throws EmptyCollectionException 
     */
    public void removePlayer(Players player) throws EmptyCollectionException;
    
    /**
     * 
     * @param player
     * @return 
     */
    public boolean findPlayer(Players player);
    
    /**
     * 
     * @param ID
     * @return 
     */
    public Players findPlayerByID(int ID);
    
    /**
     * 
     * @return 
     */
    public boolean isEmpty();
    
    /**
     * 
     * @return 
     */
    public int size();
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString();
    
}
