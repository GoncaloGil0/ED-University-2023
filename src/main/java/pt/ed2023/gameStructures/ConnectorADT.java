/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pt.ed2023.gameStructures;

import java.time.LocalDateTime;
import org.json.simple.JSONObject;

/**
 * Este Tipo Abstrato de Dados define as os métodos ou operações que podem ser
 * realizadas no tocante dos Conectores do Jogo
 *
 * @author 8200335
 */
public interface ConnectorADT extends LocalADT {

    /**
     * Recarrega as energias de um Jogador
     *
     * @param player
     * @return
     * @throws InterruptedException
     */
    public boolean rechargeUser(Players player) throws InterruptedException;

    /**
     * Define a ultima vez que foi utilizado
     *
     * @param lastUsed
     */
    public void setLastUsed(LocalDateTime lastUsed);

    /**
     * Retorna a ultima vez que foi utilizado
     *
     * @return
     */
    public LocalDateTime getLastUsed();

    /**
     * Define o tempo de cooldown do conector
     *
     * @param cooldown
     */
    public void setCooldown(int cooldown);

    /**
     * Retorna um objeto JSON caracterizante dos settings do connector
     *
     * @return
     */
    public JSONObject gameSettingsToJson();

    /**
     * Retorna um objeto caracterizante do conector em JSON
     *
     * @return
     */
    public JSONObject toJson();

    /**
     * Retorna uma String caracterizante do connector
     *
     * @return
     */
    @Override
    public String toString();
}
