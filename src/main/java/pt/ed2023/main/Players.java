/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.main;

import org.json.simple.JSONObject;

/**
 *
 * @author 8200335
 */
public class Players {

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
    }

    public int getId() {
        return id;
    }

    public static int generateID() {
        return currentID++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team.TeamName getTeam() {
        return team;
    }

    public void setTeam(Team.TeamName team) {
        this.team = team;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }
    
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
