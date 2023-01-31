/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.gameStructures;

import org.json.simple.JSONObject;

/**
 *
 * @author peter
 */
public interface PlayersADT {
    
    /**
     * 
     * @return 
     */
    public int getId();
    
    /**
     * 
     * @return 
     */
    public String getName();
    
    /**
     * 
     * @param name 
     */
    public void setName(String name);
    
    /**
     * 
     * @return 
     */
    public Team.TeamName getTeam();
    
    /**
     * 
     * @param team 
     */
    public void setTeam(Team.TeamName team);
    
    /**
     * 
     * @return 
     */
    public int getLevel();
    
    
    /**
     * 
     * @return 
     */
    public int getExperiencePoints();
    
    /**
     * 
     * @param experiencePoints 
     */
    public void setExperiencePoints(int experiencePoints);
    
    /**
     * 
     * @return 
     */
    public int getMaxEnergy();
    
    /**
     * 
     * @param maxEnergy 
     */
    public void setMaxEnergy(int maxEnergy);
    
    /**
     * 
     * @return 
     */
    public int getCurrentEnergy();
    
    /**
     * 
     * @param currentEnergy 
     */
    public void setCurrentEnergy(int currentEnergy);
    
    /**
     * 
     * @return 
     */
    public JSONObject toJson();
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString();
}
