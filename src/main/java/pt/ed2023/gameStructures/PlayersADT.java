/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.gameStructures;

import org.json.simple.JSONObject;

/**
 * * Este Tipo Abstrato de Dados define as os métodos ou operações que podem
 * ser realizadas no tocante dos Jogadores do Jogo
 *
 * @author 8200335
 */
public interface PlayersADT {

    /**
     * Retorna o ID od Jogador
     *
     * @return
     */
    public int getId();

    /**
     * Retorna o nome do Jogador
     *
     * @return
     */
    public String getName();

    /**
     * Define o nome do Jogador
     *
     * @param name
     */
    public void setName(String name);

    /**
     * Retorna o nome da equipa á qual o jogador pertence
     *
     * @return
     */
    public Team.TeamName getTeam();

    /**
     * Atribui uma equipa ao jogador
     *
     * @param team
     */
    public void setTeam(Team.TeamName team);

    /**
     * Retorna o Nivel do Jogador
     *
     * @return
     */
    public int getLevel();

    /**
     * Retorna os porntos de experiencia que o jogador detem
     *
     * @return
     */
    public int getExperiencePoints();

    /**
     * Define o pontos de experiencia do jogador
     *
     * @param experiencePoints
     */
    public void setExperiencePoints(int experiencePoints);

    /**
     * Retorna a energia maxima do Jogador
     *
     * @return
     */
    public int getMaxEnergy();

    /**
     * Define a energia maxima do jogador
     *
     * @param maxEnergy
     */
    public void setMaxEnergy(int maxEnergy);

    /**
     * Retorna a energia no presente momento do Jogador
     *
     * @return
     */
    public int getCurrentEnergy();

    /**
     * Defin e energia atual do jogador
     *
     * @param currentEnergy
     */
    public void setCurrentEnergy(int currentEnergy);

    /**
     * Retorna um objeto JSON cm a informação do jogador
     *
     * @return
     */
    public JSONObject toJson();

    /**
     * Retorna um strig representativa do Jogador
     *
     * @return
     */
    @Override
    public String toString();
}
