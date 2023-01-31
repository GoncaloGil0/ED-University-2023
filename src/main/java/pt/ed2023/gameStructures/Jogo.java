/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.gameStructures;

import pt.ed2023.dataStructures.list.ArrayUnorderedList;
import pt.ed2023.dataStructures.network.Network;
import pt.ed2023.exceptions.EmptyCollectionException;
import pt.ed2023.exceptions.UnknownPathException;

/**
 *
 * @author 8200335
 */
public class Jogo implements JogoADT {

    private Team teamSpark = new Team(Team.TeamName.Sparks);
    private Team teamGiants = new Team(Team.TeamName.Giants);
    private Team teamExtra = new Team(Team.TeamName.Extra);
    private ArrayUnorderedList<Routes> routesAttay;
    private ArrayUnorderedList<ArrayUnorderedList> calculatedPaths;
    private Network localNetwork;

    public Jogo() {
        this.teamSpark = new Team(Team.TeamName.Sparks);
        this.teamGiants = new Team(Team.TeamName.Giants);
        this.teamExtra = new Team(Team.TeamName.Extra);
        this.routesAttay = new ArrayUnorderedList();
        this.calculatedPaths = new ArrayUnorderedList();
        this.localNetwork = new Network<Local>();
    }

    @Override
    public void setCalculatedPaths(ArrayUnorderedList<ArrayUnorderedList> calculatedPaths) {
        this.calculatedPaths = calculatedPaths;
    }

    @Override
    public ArrayUnorderedList<ArrayUnorderedList> getCalculatedPaths() {
        return calculatedPaths;
    }

    @Override
    public void setTeamSpark(Team teamSpark) {
        this.teamSpark = teamSpark;
    }

    @Override
    public void setTeamGiants(Team teamGiants) {
        this.teamGiants = teamGiants;
    }

    @Override
    public void setTeamExtra(Team teamExtra) {
        this.teamExtra = teamExtra;
    }

    @Override
    public Team getTeamSpark() {
        return teamSpark;
    }

    @Override
    public Team getTeamGiants() {
        return teamGiants;
    }

    @Override
    public Team getTeamExtra() {
        return teamExtra;
    }

    @Override
    public ArrayUnorderedList<Routes> getRoutesAttay() {
        return routesAttay;
    }

    @Override
    public Network getLocalNetwork() {
        return localNetwork;
    }

    @Override
    public void setRoutesAttay(ArrayUnorderedList<Routes> routesAttay) {
        this.routesAttay = routesAttay;
    }

    @Override
    public void setLocalNetwork(Network localNetwork) {
        this.localNetwork = localNetwork;
    }

    @Override
    public Players getPlayerByID(int ID) throws UnknownPathException {
        for (Players player : teamGiants.getTeamPlayers()) {
            if (player.getId() == ID) {
                return player;
            }
        }

        for (Players player : teamSpark.getTeamPlayers()) {
            if (player.getId() == ID) {
                return player;
            }
        }

        for (Players player : teamExtra.getTeamPlayers()) {
            if (player.getId() == ID) {
                return player;
            }
        }

        throw new UnknownPathException("User não existe");

    }

    @Override
    public boolean disassociatePlayer(Players player) throws UnknownPathException {
        try {
            if (player.getTeam().equals(Team.TeamName.Sparks)) {
                this.teamSpark.removePlayer(player);
                player.setTeam(Team.TeamName.Extra);
                this.teamExtra.addPlayer(player);
                return true;
            } else {
                this.teamGiants.removePlayer(player);
                player.setTeam(Team.TeamName.Extra);
                this.teamExtra.addPlayer(player);
                return true;
            }
        } catch (EmptyCollectionException e) {
            throw new UnknownPathException("Não foi possivel associar o utilizador");
        }
    }

    @Override
    public boolean associatePlayer(Players player, Team.TeamName teamTo) {
        try {
            if (player.getTeam().equals(Team.TeamName.Extra) && teamTo.equals(Team.TeamName.Giants)) {
                this.teamGiants.addPlayer(player);
                this.teamExtra.removePlayer(player);
                return true;
            }

            if (player.getTeam().equals(Team.TeamName.Extra) && teamTo.equals(Team.TeamName.Sparks)) {
                this.teamSpark.addPlayer(player);
                this.teamExtra.removePlayer(player);
                return true;
            }

        } catch (EmptyCollectionException e) {
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Equipas{" + "teamSpark=" + teamSpark.toString() + ", \nteamGiants=" + teamGiants.toString() + ", \nteamExtra=" + teamExtra.toString() + '}';
    }

}
