/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.gameStructures;

import pt.ed2023.dataStructures.list.ArrayUnorderedList;
import pt.ed2023.dataStructures.network.Network;
import pt.ed2023.exceptions.UnknownPathException;

/**
 * Este Tipo Abstrato de Dados define as os métodos ou operações que podem ser
 * realizadas no tocante do Jogo como um todo
 *
 * @author 8200335
 */
public interface JogoADT {

    /**
     * Guarda as caminhos calculados
     *
     * @param calculatedPaths
     */
    public void setCalculatedPaths(ArrayUnorderedList<ArrayUnorderedList> calculatedPaths);

    /**
     * Retorna os caminhos calculados
     *
     * @return
     */
    public ArrayUnorderedList<ArrayUnorderedList> getCalculatedPaths();

    /**
     * Guarda a equipa Spark
     *
     * @param teamSpark
     */
    public void setTeamSpark(Team teamSpark);

    /**
     * Guarda a Equipa Giants
     *
     * @param teamGiants
     */
    public void setTeamGiants(Team teamGiants);

    /**
     * Guarda a equipa Extra
     *
     * @param teamExtra
     */
    public void setTeamExtra(Team teamExtra);

    /**
     * Retorna a equipa Spark
     *
     * @return
     */
    public Team getTeamSpark();

    /**
     * Retorna a equipa Giants
     *
     * @return
     */
    public Team getTeamGiants();

    /**
     * Retorna a Equipa extra
     *
     * @return
     */
    public Team getTeamExtra();

    /**
     * Retorna a lista de rotas existentes
     *
     * @return
     */
    public ArrayUnorderedList<Routes> getRoutesAttay();

    /**
     * Retorna a network criada com os locais
     *
     * @return
     */
    public Network getLocalNetwork();

    /**
     * Guarda a lista de rotas possiveis
     *
     * @param routesAttay
     */
    public void setRoutesAttay(ArrayUnorderedList<Routes> routesAttay);

    /**
     * Guarda a network de locais
     *
     * @param localNetwork
     */
    public void setLocalNetwork(Network localNetwork);

    /**
     * Retorna o player do Jogo a partir do ID dele
     *
     * @param ID
     * @return
     * @throws UnknownPathException
     */
    public Players getPlayerByID(int ID) throws UnknownPathException;

    /**
     * Dessassocia um jogador de uma equipa
     *
     * @param player
     * @return
     * @throws UnknownPathException
     */
    public boolean disassociatePlayer(Players player) throws UnknownPathException;

    /**
     * Associa um jogador a uma equipa
     *
     * @param player
     * @param teamTo
     * @return
     */
    public boolean associatePlayer(Players player, Team.TeamName teamTo);

    /**
     * Retorna uma String representativa do Jogo
     *
     * @return
     */
    @Override
    public String toString();

}
