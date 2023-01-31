/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.gameStructures;

import pt.ed2023.dataStructures.list.ArrayUnorderedList;
import pt.ed2023.dataStructures.network.Network;
import pt.ed2023.exceptions.UnknownPathException;

/**
 *
 * @author 8200335
 */
public interface JogoADT {

    /**
     *
     * @param calculatedPaths
     */
    public void setCalculatedPaths(ArrayUnorderedList<ArrayUnorderedList> calculatedPaths);

    /**
     *
     * @return
     */
    public ArrayUnorderedList<ArrayUnorderedList> getCalculatedPaths();

    /**
     *
     * @param teamSpark
     */
    public void setTeamSpark(Team teamSpark);

    /**
     *
     * @param teamGiants
     */
    public void setTeamGiants(Team teamGiants);

    /**
     *
     * @param teamExtra
     */
    public void setTeamExtra(Team teamExtra);

    /**
     * 
     * @return 
     */
    public Team getTeamSpark();

    /**
     * 
     * @return 
     */
    public Team getTeamGiants();

    /**
     * 
     * @return 
     */
    public Team getTeamExtra();

    /**
     * 
     * @return 
     */
    public ArrayUnorderedList<Routes> getRoutesAttay();

    /**
     * 
     * @return 
     */
    public Network getLocalNetwork();

    /**
     * 
     * @param routesAttay 
     */
    public void setRoutesAttay(ArrayUnorderedList<Routes> routesAttay);

    /**
     * 
     * @param localNetwork 
     */
    public void setLocalNetwork(Network localNetwork);

    /**
     * 
     * @param ID
     * @return
     * @throws UnknownPathException 
     */
    public Players getPlayerByID(int ID) throws UnknownPathException;

    /**
     * 
     * @param player
     * @return
     * @throws UnknownPathException 
     */
    public boolean disassociatePlayer(Players player) throws UnknownPathException;

    /**
     * 
     * @param player
     * @param teamTo
     * @return 
     */
    public boolean associatePlayer(Players player, Team.TeamName teamTo);

    /**
     * 
     * @return 
     */
    @Override
    public String toString();

}
