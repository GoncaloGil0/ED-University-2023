/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.utils;

import pt.ed2023.dataStructures.list.ArrayUnorderedList;
import pt.ed2023.gameStructures.Connector;
import pt.ed2023.gameStructures.Coordinates;
import pt.ed2023.gameStructures.Jogo;
import pt.ed2023.gameStructures.Local;
import pt.ed2023.gameStructures.Players;
import pt.ed2023.gameStructures.Portal;
import pt.ed2023.gameStructures.Team;
import pt.ed2023.gameStructures.Routes;
import pt.ed2023.gameStructures.Team.TeamName;
import pt.ed2023.exceptions.EmptyCollectionException;
import pt.ed2023.exceptions.NonComparableElementException;
import pt.ed2023.exceptions.NullException;
import java.io.FileWriter;

import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.json.simple.parser.ParseException;

/**
 *
 * @author 8200335
 */
public class fileHandler {

    public static void readJSON(String jsonFilePath, Jogo jogo) throws IOException, ParseException {

        System.out.println("\nAdição de dados a partir de um ficheiro JSON");

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new java.io.FileReader(jsonFilePath));
        JSONObject jsonObject = (JSONObject) obj;

        JSONArray players = (JSONArray) jsonObject.get("Players");
        for (Object playerObject : players) {
            JSONObject jsonPlayer = (JSONObject) playerObject;
            String name = (String) jsonPlayer.get("name");
            String team = (String) jsonPlayer.get("team");
            int level = (int) (long) jsonPlayer.get("level");
            int experiencePoints = (int) (long) jsonPlayer.get("experiencePoints");
            int maxEnergy = (int) (long) jsonPlayer.get("maxEnergy");
            int currentEnergy = (int) (long) jsonPlayer.get("currentEnergy");

            Team.TeamName teamName;
            if (team.equals("Sparks")) {
                teamName = TeamName.Sparks;
                jogo.getTeamSpark().addPlayer(new Players(name, teamName, level, experiencePoints, maxEnergy, currentEnergy));
            } else {
                teamName = TeamName.Giants;
                jogo.getTeamGiants().addPlayer(new Players(name, teamName, level, experiencePoints, maxEnergy, currentEnergy));
            }
            System.out.println("Jogador adicionado com sucesso vindo de: " + jsonFilePath);

        }

        JSONArray locals = (JSONArray) jsonObject.get("locals");
        for (Object localObject : locals) {
            JSONObject jsonLocal = (JSONObject) localObject;
            int id = (int) (long) jsonLocal.get("id");
            String type = (String) jsonLocal.get("type");
            JSONObject coordinatesJSON = (JSONObject) jsonLocal.get("coordinates");
            JSONObject gameSettings = (JSONObject) jsonLocal.get("gameSettings");
            int energy = (int) (long) gameSettings.get("energy");

            String name = (String) jsonLocal.get("name");
            Coordinates coordinates = new Coordinates((double) coordinatesJSON.get("latitude"), (double) coordinatesJSON.get("longitude"));

            Local local;

            if (type.equals("Portal")) {
                JSONObject ownership = (JSONObject) gameSettings.get("ownership");
                String player = (String) ownership.get("player");

                if (jogo.getTeamSpark().validateUserExistence(player)) {
                    local = new Portal(id, coordinates, jogo.getTeamSpark().getUserIDbyName(player), name, Portal.State.SPARKS, energy);
                } else if (jogo.getTeamGiants().validateUserExistence(player)) {
                    local = new Portal(id, coordinates, jogo.getTeamGiants().getUserIDbyName(player), name, Portal.State.GIANTS, energy);
                } else {
                    local = new Portal(id, coordinates, name, energy);
                }

            } else {
                int cooldown = (int) (long) gameSettings.get("cooldown");
                local = new Connector(id, coordinates, cooldown, energy);

            }

            jogo.getLocalNetwork().addVertex(local);
            System.out.println("Local adicionado com sucesso vindo de: " + jsonFilePath);

        }

        JSONArray routes = (JSONArray) jsonObject.get("routes");
        for (Object routeObject : routes) {
            JSONObject jsonRoute = (JSONObject) routeObject;
            int from = (int) (long) jsonRoute.get("from");
            int to = (int) (long) jsonRoute.get("to");

            Routes route = new Routes(from, to);

            Local fromSave = null;
            Local toSave = null;

            Object locais[] = (Object[]) jogo.getLocalNetwork().getVertices();
            for (Object local : locais) {
                Local loc = (Local) local;

                if (loc != null && loc.getId() == route.getFrom()) {
                    fromSave = ((Local) local);
                }
                if (loc != null && loc.getId() == route.getTo()) {
                    toSave = ((Local) local);
                }
            }

            if (toSave != null && fromSave != null) {
                jogo.getLocalNetwork().addEdge(toSave, fromSave);
                jogo.getRoutesAttay().addToRear(new Routes(toSave.getId(), fromSave.getId()));
                System.out.println("Rota adicionada com sucesso vinda de: " + jsonFilePath);

            }
        }
    }

    public static void exportToJSON(String jsonFilePath, Jogo jogo) throws IOException, NonComparableElementException, EmptyCollectionException, NullException {

        System.out.println("\nExtração de dados para um ficheiro JSON");

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonLocals = new JSONArray();
        for (Object local : jogo.getLocalNetwork().getVertices()) {
            if (local != null && Local.Types.Portal.equals(((Local) local).getType())) {
                jsonLocals.add(((Portal) local).toJson());
            } else if (local != null && Local.Types.Connector.equals(((Local) local).getType())) {
                jsonLocals.add(((Connector) local).toJson());
            }
        }
        jsonObject.put("locals", jsonLocals);

        JSONArray jsonRoutes = new JSONArray();
        for (Routes route : jogo.getRoutesAttay()) {
            if (route != null) {
                jsonRoutes.add(route.toJson());
            }
        }
        jsonObject.put("routes", jsonRoutes);

        JSONArray jsonPlayers = new JSONArray();
        for (Object player : jogo.getTeamGiants().getTeamPlayers()) {
            jsonPlayers.add(((Players) player).toJson());
        }
        for (Object player : jogo.getTeamSpark().getTeamPlayers()) {
            jsonPlayers.add(((Players) player).toJson());
        }
        jsonObject.put("players", jsonPlayers);

        try ( FileWriter file = new FileWriter(jsonFilePath)) {
            file.write(jsonObject.toJSONString());
            file.flush();
        }

        System.out.println("Ficheiro gruadado com sucesso em: " + jsonFilePath);

    }

    public static void exportCalculatedRoutesToJSON(String jsonFilePath, ArrayUnorderedList<ArrayUnorderedList> calculatedRoutes) throws IOException {
        System.out.println("\nExtração de dados para um ficheiro JSON");

        JSONObject jsonObject = new JSONObject();
        JSONArray calculatedPaths = new JSONArray();
        for (ArrayUnorderedList path : calculatedRoutes) {
            JSONArray jsonPath2 = new JSONArray();
            for (Object local : path) {
                JSONObject result = new JSONObject();
                if (local != null && Local.Types.Portal.equals(((Local) local).getType())) {
                    Portal portal = (Portal) local;
                    result.put("Type", portal.getType().toString());
                    result.put("ID", portal.getId());
                } else if (local != null && Local.Types.Connector.equals(((Local) local).getType())) {
                    Connector connerctor = (Connector) local;
                    result.put("Type", connerctor.getType().toString());
                    result.put("ID", connerctor.getId());
                }
                jsonPath2.add(result);

            }
            calculatedPaths.add(jsonPath2);
        }
        jsonObject.put("CalculatedPaths", calculatedPaths);

        try ( FileWriter file = new FileWriter(jsonFilePath)) {
            file.write(jsonObject.toJSONString());
            file.flush();
        }
        System.out.println("Ficheiro gruadado com sucesso em: " + jsonFilePath);

    }
}
