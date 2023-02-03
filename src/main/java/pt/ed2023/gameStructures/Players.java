/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.gameStructures;

import org.json.simple.JSONObject;

/**
 * Classe representativa dos jogadores
 *
 * @author 8200335
 */
public class Players implements PlayersADT {

    private String name;
    private Team.TeamName team;
    private int level;
    private int experiencePoints;
    private int maxEnergy;
    private int currentEnergy;
    private final int id;
    private static int currentID = 0;

    /**
     * Construtor primario do Jogador
     *
     * @param name
     * @param team
     * @param level
     * @param experiencePoints
     * @param maxEnergy
     * @param currentEnergy
     */
    public Players(String name, Team.TeamName team, int level, int experiencePoints, int maxEnergy, int currentEnergy) {
        this.id = generateID();
        this.name = name;
        this.team = team;
        this.level = level;
        this.experiencePoints = experiencePoints;
        this.maxEnergy = maxEnergy;
        this.currentEnergy = currentEnergy;
        setLevel();
    }

    /**
     * Retorna o ID do jogador
     *
     * @return
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Gera um ID diferente para cada jogador
     *
     * @return
     */
    private int generateID() {
        return currentID++;
    }

    /**
     * Retorna o nome de cada jogador
     *
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Define o nome do jogador
     *
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna a equipa a que pertence o jogador
     *
     * @return
     */
    @Override
    public Team.TeamName getTeam() {
        return team;
    }

    /**
     * Define a equipa do jogador
     *
     * @param team
     */
    @Override
    public void setTeam(Team.TeamName team) {
        this.team = team;
    }

    /**
     * Retorna o nivel do jogador
     *
     * @return
     */
    @Override
    public int getLevel() {
        return level;
    }

    /**
     * Calcula o nivel do jogador consoante os pçontos de experiencia
     */
    private void setLevel() {
        this.level = (int) Math.ceil(0.07 * Math.sqrt(this.experiencePoints));
    }

    /**
     * Retorna os pontos de experiencia do jogador
     *
     * @return
     */
    @Override
    public int getExperiencePoints() {
        return experiencePoints;
    }

    /**
     * Define os pontos de experiencia do jogador
     *
     * @param experiencePoints
     */
    @Override
    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
        setLevel();
    }

    /**
     * Retorna a energia maxima do jogador
     *
     * @return
     */
    @Override
    public int getMaxEnergy() {
        return maxEnergy;
    }

    /**
     * Define a energia maxima do jogador
     *
     * @param maxEnergy
     */
    @Override
    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }
    
    /**
     * Retorna a energia do jogador neste momento
     * @return 
     */
    @Override
    public int getCurrentEnergy() {
        return currentEnergy;
    }

    /**
     * Define a enrgia do jogador neste momento
     * @param currentEnergy 
     */
    @Override
    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    /**
     * Retorna um objeto JSON representativo do Jogador
     * @return 
     */
    @Override
    public JSONObject toJson() {
        JSONObject jsonPlayer = new JSONObject();
        jsonPlayer.put("id", this.id);
        jsonPlayer.put("name", this.name);
        jsonPlayer.put("team", this.team.toString());
        jsonPlayer.put("level", this.level);
        jsonPlayer.put("experiencePoints", this.experiencePoints);
        jsonPlayer.put("maxEnergy", this.maxEnergy);
        jsonPlayer.put("currentEnergy", this.currentEnergy);
        return jsonPlayer;
    }

    /**
     * Retorna uma string representativa do Jogador 
     * @return 
     */
    @Override
    public String toString() {
        return "Players [id=" + id + ", name=" + name + ", team=" + team + ", level=" + level + ", experiencePoints="
                + experiencePoints + ", maxEnergy=" + maxEnergy + ", currentEnergy=" + currentEnergy + "]";
    }
}
