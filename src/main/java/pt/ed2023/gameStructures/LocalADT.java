/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.gameStructures;

/**
 *
 * @author 8200335
 */
public interface LocalADT {
    
    /**
     * 
     * @return 
     */
    int getId();
    
    /**
     * 
     * @param id 
     */
    void setId(int id);
    
    /**
     * 
     * @return 
     */
    Local.Types getType();
    
    /**
     * 
     * @param type 
     */
    void setType(Local.Types type);
    
    /**
     * 
     * @return 
     */
    Coordinates getCoordinates();
    
    /**
     * 
     * @param coordinates 
     */
    void setCoordinates(Coordinates coordinates);
    
    /**
     * 
     * @return 
     */
    int getEnergy();
    
    /**
     * 
     * @param energy 
     */
    void setEnergy(int energy);
}
