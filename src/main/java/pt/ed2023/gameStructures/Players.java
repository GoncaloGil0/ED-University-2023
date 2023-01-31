/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.gameStructures;

import org.json.simple.JSONObject;

/**
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

    @Override
    public int getId() {
        return id;
    }

    private int generateID() {
        return currentID++;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Team.TeamName getTeam() {
        return team;
    }

    @Override
    public void setTeam(Team.TeamName team) {
        this.team = team;
    }

    @Override
    public int getLevel() {
        return level;
    }
    
    private void setLevel() {
        this.level = (int) Math.ceil(0.07 * Math.sqrt(this.experiencePoints));
    }

    @Override
    public int getExperiencePoints() {
        return experiencePoints;
    }

    @Override
    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
        setLevel();
    }

    @Override
    public int getMaxEnergy() {
        return maxEnergy;
    }

    @Override
    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    @Override
    public int getCurrentEnergy() {
        return currentEnergy;
    }

    @Override
    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

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

    @Override
    public String toString() {
        return "Players [id=" + id + ", name=" + name + ", team=" + team + ", level=" + level + ", experiencePoints="
                + experiencePoints + ", maxEnergy=" + maxEnergy + ", currentEnergy=" + currentEnergy + "]";
    }
}
