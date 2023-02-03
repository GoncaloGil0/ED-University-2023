/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.handlers;

import pt.ed2023.dataStructures.list.ArrayUnorderedList;
import pt.ed2023.dataStructures.network.Network;
import pt.ed2023.gameStructures.Connector;
import pt.ed2023.gameStructures.Coordinates;
import pt.ed2023.gameStructures.Jogo;
import pt.ed2023.gameStructures.Local;
import pt.ed2023.gameStructures.Players;
import pt.ed2023.gameStructures.Portal;
import pt.ed2023.gameStructures.Routes;
import pt.ed2023.gameStructures.Team;
import pt.ed2023.exceptions.EmptyCollectionException;
import pt.ed2023.exceptions.NonComparableElementException;
import pt.ed2023.exceptions.NullException;
import pt.ed2023.exceptions.UnknownPathException;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

/**
 *  Classe responsavel pela gestão dos Menus (APIs) todos do Jogo
 * 
 * @author 8200335
 */
public class apiHandler {

    /**
     * Menu principal
     * 
     * @param jogo
     * @return
     * @throws IOException
     * @throws ParseException
     * @throws NonComparableElementException
     * @throws EmptyCollectionException
     * @throws NullException
     * @throws UnknownPathException
     * @throws InterruptedException 
     */
    public static boolean mainAPI(Jogo jogo) throws IOException, ParseException, NonComparableElementException, EmptyCollectionException, NullException, UnknownPathException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Gestão de Portals e Connectors (<= Incompleto)");
            System.out.println("2. Gestão de rotas (<= Melhorias a fazer)");
            System.out.println("3. Gestão de jogadores (<= Incompleto)");
            System.out.println("4. Gestão de jogo (<= Incompleto)");
            System.out.println("5. Importar ficheiro JSON");
            System.out.println("6. Exportar ficheiro JSON");
            System.out.println("7. Sair");
            System.out.print("Opção: ");
            int selection = scanner.nextInt();
            switch (selection) {
                case 1 -> {
                    portalConnectorAPI(jogo.getLocalNetwork());
                }
                case 2 -> {
                    routesAPI(
                            jogo.getLocalNetwork(),
                            jogo.getRoutesAttay()
                    );
                }
                case 3 -> {
                    playersAPI(jogo);
                }
                case 4 -> {
                    gameAPI(jogo);
                }
                case 5 -> {
                    String JSONFile = "InputFiles\\inputExemplo.json";
                    pt.ed2023.handlers.fileHandler.readJSON(
                            JSONFile,
                            jogo
                    );
                }
                case 6 -> {
                    String JSONFileExport = "InputFiles\\output.json";
                    pt.ed2023.handlers.fileHandler.exportToJSON(
                            JSONFileExport,
                            jogo
                    );
                }
                case 7 -> {
                    System.out.println("A sair...");
                    return false;
                }
                default ->
                    System.out.println("Input invalido, tente outra vez.");
            }
        }
    }

    /**
     * Menu da gestão de Portais e Connectores 
     * 
     * @param localNetwork
     * @return 
     */
    private static boolean portalConnectorAPI(Network<Local> localNetwork) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nGestão de Portals e Connectors:");
            System.out.println("1. Adicionar Portal/Connector");
            System.out.println("2. Editar Portal/Connector");
            System.out.println("3. Remover Portal/Connector");
            System.out.println("4. Adicionar/Remover interações de jogadores em Connectors (<= Falta Fazer)");
            System.out.println("5. Listar Portals/Connectors por parâmetro");
            System.out.println("6. Voltar");
            System.out.print("Opção: ");
            int selection = scanner.nextInt();
            switch (selection) {
                case 1 -> {
                    while (true) {
                        System.out.println("\nAdicionar de Portais e Conectores:");
                        System.out.println("1. Adicionar Portal");
                        System.out.println("2. Adicionar Connector");
                        System.out.println("3. Voltar");
                        System.out.print("Opção: ");
                        int add = scanner.nextInt();
                        switch (add) {
                            case 1 -> {
                                System.out.print("\nDigite a informação relativa ao Portal \n");
                                System.out.print("ID: ");
                                int id = scanner.nextInt();
                                System.out.print("Latitude: ");
                                double Latitude = scanner.nextDouble();
                                System.out.print("longitude: ");
                                double longitude = scanner.nextDouble();
                                Coordinates coordinates = new Coordinates(Latitude, longitude);
                                System.out.print("Nome: ");
                                scanner.nextLine();
                                String name = scanner.nextLine();
                                System.out.print("Energy: ");
                                int energy = scanner.nextInt();
                                localNetwork.addVertex(new Portal(id, coordinates, name, energy));
                                System.out.print("- Portal criado com sucesso \n");
                            }
                            case 2 -> {
                                System.out.print("\nDigite a informação relativa ao Connector \n");
                                System.out.print("ID: ");
                                int id = scanner.nextInt();
                                System.out.print("Latitude: ");
                                double Latitude = scanner.nextDouble();
                                System.out.print("longitude: ");
                                double longitude = scanner.nextDouble();
                                Coordinates coordinates = new Coordinates(Latitude, longitude);
                                System.out.print("Cooldown: ");
                                int cooldown = scanner.nextInt();
                                System.out.print("Energy: ");
                                int energy = scanner.nextInt();
                                localNetwork.addVertex(new Connector(id, coordinates, cooldown, energy));
                                System.out.print("- Connector criado com sucesso \n");
                            }
                            case 3 -> {
                                return false;
                            }
                        }
                    }
                }
                case 2 -> {
                    System.out.print("Digite o ID que deseja editar:");
                    int id = scanner.nextInt();
                    Local localToEdit = localNetwork.getLocalByID(id);

                    if (localToEdit != null) {
                        System.out.println("Selecione o valor que deseja alterar:");
                        System.out.println("1. Nome");
                        System.out.println("2. Coordenadas");
                        System.out.println("3. Energia");
                        System.out.println("4. Propriedade");
                        System.out.println("5. Tempo de cooldown");
                        System.out.println("6. Sair");
                        System.out.print("Opção: ");
                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1 -> {

                                if (localToEdit instanceof Portal portal) {
                                    System.out.print("Digite o novo nome:");
                                    scanner.nextLine();
                                    String newName = scanner.nextLine();
                                    portal.setName(newName);
                                } else {
                                    System.out.println("Os Conectores não tem nome");
                                }
                            }
                            case 2 -> {
                                System.out.print("Digite o novo valor da latitude:");
                                double newLatitude = scanner.nextDouble();
                                System.out.print("Digite o novo valor da longitude:");
                                double newLongitude = scanner.nextDouble();
                                Coordinates newCoordinates = new Coordinates(newLatitude, newLongitude);
                                localToEdit.setCoordinates(newCoordinates);
                            }
                            case 3 -> {
                                System.out.print("Digite o novo valor da energia:");
                                int newEnergy = scanner.nextInt();
                                localToEdit.setEnergy(newEnergy);
                            }
                            case 4 -> {

                                if (localToEdit instanceof Portal portal) {
                                    System.out.print("Digite o novo owner ID:");
                                    int newPlayerID = scanner.nextInt();
                                    portal.setOwnership(newPlayerID);
                                } else {
                                    System.out.println("Os Conectores não tem proprietarios");
                                }
                            }
                            case 5 -> {
                                if (localToEdit instanceof Connector connector) {
                                    System.out.print("Digite o novo valor de cooldown:");
                                    int cooldown = scanner.nextInt();
                                    connector.setCooldown(cooldown);
                                } else {
                                    System.out.println("Os Portais não tem tempo de cooldown");
                                }
                            }
                            case 6 -> {
                                return false;
                            }

                            default ->
                                System.out.println("Escolha invalida.");
                        }
                    } else {
                        System.out.println("ID não encontrado.");
                    }
                }
                case 3 -> {
                    System.out.println("\nRemover Portais e Conectores:");
                    localNetwork.printPortalVertices();
                    localNetwork.printConnectorVertices();

                    System.out.print("Digite o id que quer apagar: ");
                    localNetwork.removeVertexById(scanner.nextInt());

                }
                case 4 -> {

                }
                case 5 -> {
                    while (true) {
                        System.out.println("\nListar Portais e Conectores:");
                        System.out.println("1. Listar Portal");
                        System.out.println("2. Listar Connector");
                        System.out.println("3. Listar Todos");
                        System.out.println("4. Voltar");
                        System.out.print("Opção: ");
                        int add = scanner.nextInt();
                        switch (add) {
                            case 1 -> {
                                localNetwork.printPortalVertices();
                            }
                            case 2 -> {
                                localNetwork.printConnectorVertices();
                            }
                            case 3 -> {
                                localNetwork.printPortalVertices();
                                localNetwork.printConnectorVertices();

                            }
                            case 4 -> {
                                return false;
                            }
                        }
                    }
                }
                case 6 -> {
                    return false;
                }
                default ->
                    System.out.println("Input invalido, tente outra vez.");
            }
        }
    }

    /**
     * Menu de gestão de Rotas 
     * 
     * @param localNetwork
     * @param routesArray
     * @return
     * @throws EmptyCollectionException 
     */
    private static boolean routesAPI(Network<Local> localNetwork, ArrayUnorderedList<Routes> routesArray) throws EmptyCollectionException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nGestão de rotas:");
            System.out.println("1. Criar Rota");
            System.out.println("2. Remover Rota (<= Melhorias a fazer)");
            System.out.println("3. Voltar");
            System.out.print("Opção: ");
            int selection = scanner.nextInt();
            switch (selection) {
                case 1 -> {
                    System.out.print("\nDigite os dados relativos á Rota\n");
                    System.out.print("Origem: ");
                    int from = scanner.nextInt();
                    System.out.print("Destinho: ");
                    int to = scanner.nextInt();
                    Routes rota = new Routes(to, from);
                    Object locais[] = (Object[]) localNetwork.getVertices();
                    Local fromSave = null;
                    Local toSave = null;

                    for (Object local : locais) {
                        Local loc = (Local) local;

                        if (loc != null && loc.getId() == rota.getFrom()) {
                            fromSave = ((Local) local);
                        }
                        if (loc != null && loc.getId() == rota.getTo()) {
                            toSave = ((Local) local);
                        }
                    }

                    if (toSave != null && fromSave != null) {
                        localNetwork.addEdge(toSave, fromSave);
                        routesArray.addToRear(new Routes(toSave.getId(), fromSave.getId()));
                    }
                }
                case 2 -> {
                    System.out.print("Rotas existentes\n");
                    System.out.println(routesArray.toString());
                    System.out.print("Digite os dados relativos á Rota que quer remover\n");
                    System.out.print("Origem: ");
                    int from = scanner.nextInt();
                    System.out.print("Destinho: ");
                    int to = scanner.nextInt();
                    Object locais[] = (Object[]) localNetwork.getVertices();
                    Local fromSave = null;
                    Local toSave = null;
                    Routes rota = new Routes(from, to);
                    for (Object local : locais) {
                        Local loc = (Local) local;

                        if (loc != null && loc.getId() == rota.getFrom()) {
                            fromSave = ((Local) local);
                        }
                        if (loc != null && loc.getId() == rota.getTo()) {
                            toSave = ((Local) local);
                        }
                    }
                    if (toSave != null && fromSave != null) {
                        localNetwork.removeEdge(toSave, fromSave);
                        System.out.println("Elemento " + rota.toString() + " eliminado com sucesso na network");
                        //System.out.println(rota.toString());
                        //routesArray.remove(rota);
                    }
                }
                case 3 -> {
                    return false;
                }
                default ->
                    System.out.println("Input invalido, tente outra vez.");
            }
        }
    }

    /**
     * Menu de gestão de Jogadores 
     * 
     * @param jogo
     * @return
     * @throws EmptyCollectionException
     * @throws UnknownPathException 
     */
    private static boolean playersAPI(Jogo jogo) throws EmptyCollectionException, UnknownPathException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nGestão de jogadores:");
            System.out.println("1. Adicionar jogador");
            System.out.println("2. Atualizar jogador");
            System.out.println("3. Remover jogador ");
            System.out.println("4. Associar/Desassociar jogador a equipa");
            System.out.println("5. Listar jogadores por equipa, nível, e Portals conquistados");
            System.out.println("6. Voltar");
            System.out.print("Opção: ");
            int selection = scanner.nextInt();
            switch (selection) {
                case 1 -> {
                    System.out.println("\n Criação de novo jogador:");

                    System.out.print("Nome: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    System.out.print("Equipa (Sparks or Giants): ");
                    String team = scanner.nextLine();

                    while (!(team.equalsIgnoreCase(Team.TeamName.Sparks.toString()) || team.equalsIgnoreCase(Team.TeamName.Giants.toString()))) {
                        System.out.print("Equipa Errada!");
                        System.out.print("Equipa (Sparks or Giants): ");
                        team = scanner.nextLine();
                    }

                    System.out.print("Nivel: ");
                    int level = scanner.nextInt();

                    System.out.print("Pontos: ");
                    int experiencePoints = scanner.nextInt();

                    System.out.print("Energia: ");
                    int maxEnergy = scanner.nextInt();

                    System.out.print("Energia atualmente: ");
                    int currentEnergy = scanner.nextInt();

                    if (team.equals(Team.TeamName.Giants)) {
                        jogo.getTeamGiants().addPlayer(new Players(name, Team.TeamName.Giants, level, experiencePoints, maxEnergy, currentEnergy));
                    } else {
                        jogo.getTeamSpark().addPlayer(new Players(name, Team.TeamName.Sparks, level, experiencePoints, maxEnergy, currentEnergy));

                    }
                    System.out.println("Jogador criado com sucesso");

                }
                case 2 -> {

                    System.out.println(jogo.toString());

                    System.out.println("\nDigite o nome do jogador a editar: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    Players playerEdit = null;
                    for (Players player : jogo.getTeamGiants().getTeamPlayers()) {
                        if (name.equals(player.getName())) {
                            playerEdit = player;
                        }
                    }
                    for (Players player : jogo.getTeamSpark().getTeamPlayers()) {
                        if (name.equals(player.getName())) {
                            playerEdit = player;
                        }
                    }
                    if (playerEdit == null) {
                        System.out.println("Jogador não encontrado");
                    } else {
                        int choice;
                        do {
                            System.out.println("\nSelecione o que deseja alterar?");
                            System.out.println("1. Nome");
                            System.out.println("2. Equipa");
                            System.out.println("3. Pontos de experiencia");
                            System.out.println("4. Energia Maxima");
                            System.out.println("5. Energia no momento");
                            System.out.println("6. Voltar");
                            System.out.print("Opção: ");
                            choice = scanner.nextInt();
                            scanner.nextLine();
                            switch (choice) {
                                case 1 -> {
                                    System.out.print("Digite o nome:");
                                    playerEdit.setName(scanner.nextLine());
                                    System.out.println("Nome alterado com sucesso");

                                }
                                case 2 -> {

                                    if (playerEdit.getTeam().equals(Team.TeamName.Giants)) {
                                        playerEdit.setTeam(Team.TeamName.Sparks);
                                    } else {
                                        playerEdit.setTeam(Team.TeamName.Giants);

                                    }
                                    System.out.println("Equipa alterada com sucesso");
                                }
                                case 3 -> {
                                    System.out.print("Digite os novos pontos de experiencia:");
                                    playerEdit.setExperiencePoints(scanner.nextInt());
                                    scanner.nextLine();
                                    System.out.println("Pontos alterados com sucesso");
                                }
                                case 4 -> {
                                    System.out.print("Digite a nova energia maxima:");
                                    playerEdit.setMaxEnergy(scanner.nextInt());
                                    scanner.nextLine();
                                    System.out.println("Energia maxima alterada com sucesso");
                                }
                                case 5 -> {
                                    System.out.print("Digite a nova energia atual:");
                                    playerEdit.setCurrentEnergy(scanner.nextInt());
                                    scanner.nextLine();
                                    System.out.println("Energia atual alterada com sucesso");
                                }
                                case 6 -> {
                                    return false;
                                }
                                default ->
                                    System.out.println("Opção invalida");
                            }
                        } while (choice != 7);
                    }
                }
                case 3 -> {
                    System.out.println(jogo.toString());

                    System.out.println("\nDigite o nome do jogador a remover: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    for (Players player : jogo.getTeamGiants().getTeamPlayers()) {
                        if (name.equals(player.getName())) {
                            jogo.getTeamGiants().removePlayer(player);
                        }
                    }
                    for (Players player : jogo.getTeamSpark().getTeamPlayers()) {
                        if (name.equals(player.getName())) {
                            jogo.getTeamSpark().removePlayer(player);
                        }
                    }
                    System.out.println("Jogador removido com sucesso");

                }
                case 4 -> {
                    int choice;
                    System.out.println("\nSelecione o que deseja fazer?");
                    System.out.println("1. Desassociar jogador de equipa");
                    System.out.println("2. Associar jodador a uma equipa");
                    System.out.println("3. Voltar");
                    System.out.print("Opção: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("\nDesassociação de um user de uma equipa");

                            System.out.println(jogo.getTeamGiants().toString());
                            System.out.println(jogo.getTeamSpark().toString());

                            System.out.print("\nDigite o ID do jogador a alterar: ");
                            int id = scanner.nextInt();

                            Players player = jogo.getPlayerByID(id);

                            if (player != null) {
                                if (jogo.disassociatePlayer(player)) {
                                    System.out.println("User " + player.getName() + " com ID " + player.getId() + " desassociado com sucesso da equipa " + player.getTeam());
                                } else {
                                    System.out.println("Algo correu mal com a desassociação do jogador " + player.getName() + " com id " + player.getId());
                                }
                            } else {
                                System.out.println("Jogador não encontrado");
                            }
                        }

                        case 2 -> {
                            System.out.println("\nAssociação de um user a uma equipa");
                            System.out.println(jogo.getTeamExtra().toString());

                            System.out.print("\nDigite o ID do jogador associar a uma equipa: ");
                            int id = scanner.nextInt();
                            int team;

                            do {
                                System.out.println("\nEscolha a equipa onde deseja inserir o jogador:");
                                System.out.println("1. " + Team.TeamName.Giants);
                                System.out.println("2. " + Team.TeamName.Sparks);
                                System.out.print("Opção: ");
                                team = scanner.nextInt();
                            } while (team < 0 || team > 2);

                            Players player = jogo.getPlayerByID(id);

                            if (team == 1) {
                                if (jogo.associatePlayer(player, Team.TeamName.Giants)) {
                                    System.out.println("Jogador associado com sucesso");
                                } else {
                                    System.out.println("Algo deu errado");
                                }
                            } else {
                                if (jogo.associatePlayer(player, Team.TeamName.Sparks)) {
                                    System.out.println("Jogador associado com sucesso");
                                } else {
                                    System.out.println("Algo deu errado");
                                }
                            }
                        }

                        case 3 -> {
                            return false;
                        }
                        default ->
                            System.out.println("Opção invalida");
                    }
                }
                case 5 -> {
                    System.out.println("\nListar jogadores por equipa, nível, e Portals conquistados:");
                    System.out.println("1. Por equipa");
                    System.out.println("2. Por Nivel");
                    System.out.println("3. Por numero de portais conquistados (<= Falta fazer)");
                    System.out.println("4. Voltar");
                    System.out.print("Opção: ");
                    int opt = scanner.nextInt();
                    switch (opt) {
                        case 1 -> {
                            System.out.println("\nListar jogadores por equipa:");
                            System.out.println("1. " + Team.TeamName.Giants);
                            System.out.println("2. " + Team.TeamName.Sparks);
                            System.out.println("3. " + Team.TeamName.Extra);
                            System.out.println("4. Todas");

                            System.out.println("5. Voltar");
                            System.out.print("Opção: ");
                            int opt2 = scanner.nextInt();
                            switch (opt2) {
                                case 1 ->
                                    System.out.println(jogo.getTeamGiants().toString());
                                case 2 ->
                                    System.out.println(jogo.getTeamSpark().toString());
                                case 3 ->
                                    System.out.println(jogo.getTeamExtra().toString());
                                case 4 ->
                                    System.out.println(jogo.toString());
                                case 5 -> {
                                    return false;
                                }
                                default ->
                                    System.out.println("Opção invalida");
                            }
                        }
                        case 2 -> {
                            System.out.println("\nListagem de jogadores por nivel:");
                            System.out.print("Digite o nivel a procurar");
                            int nivel = scanner.nextInt();
                            for (Players player : jogo.getTeamGiants().getTeamPlayers()) {
                                if (nivel == player.getLevel()) {
                                    System.out.println(player.toString());
                                }
                            }
                            for (Players player : jogo.getTeamSpark().getTeamPlayers()) {
                                if (nivel == player.getLevel()) {
                                    System.out.println(player.toString());
                                }
                            }
                        }
                        case 3 -> {
                            System.out.println("\nListagem de jogadores pelo numero de portais conquistados:");
                            System.out.print("Digite o numero de portais conquistados que deseja procurar: ");
                            int portal = scanner.nextInt();

                        }
                        case 4 -> {
                            return false;
                        }
                        default ->
                            System.out.println("Opção invalida");
                    }
                }
                case 6 -> {
                    return false;
                }
                default ->
                    System.out.println("Input invalido, tente outra vez.");
            }
        }
    }

    /**
     * Menu de gestão das definições do Jogo
     * 
     * @param jogo
     * @return
     * @throws EmptyCollectionException
     * @throws UnknownPathException
     * @throws IOException
     * @throws InterruptedException 
     */
    private static boolean gameAPI(Jogo jogo) throws EmptyCollectionException, UnknownPathException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nGestão de jogo:");
            System.out.println("1. Calcular caminho mais curto entre dois pontos ");
            System.out.println("2. Calcular caminho mais curto considerando recarga de energia (<= Falta Fazer)");
            System.out.println("3. Exportar ficheiro JSON de caminhos gerados");
            System.out.println("4. Voltar");
            System.out.print("Opção: ");
            int selection = scanner.nextInt();
            switch (selection) {
                case 1 -> {
                    System.out.println("\nCalcular caminho mais curto entre dois pontos:");
                    System.out.println(jogo.getLocalNetwork().verticesToString());

                    System.out.print("Escolha a origem (usando o ID): ");
                    int origem = scanner.nextInt();
                    System.out.print("Escolha o destino (usando o ID): ");
                    int destino = scanner.nextInt();

                    try {
                        ArrayUnorderedList resposta = jogo.getLocalNetwork().shortestPathWeight(
                                jogo.getLocalNetwork().getLocalByID(origem),
                                jogo.getLocalNetwork().getLocalByID(destino)
                        );
                        jogo.getCalculatedPaths().addToFront(resposta);
                        System.out.println(resposta.toString());
                    } catch (EmptyCollectionException | UnknownPathException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("\nCalcular caminho mais curto entre dois pontos:");
                    System.out.println(jogo.getLocalNetwork().verticesToString());
/*
                    System.out.print("Escolha a origem (usando o ID): ");
                    int origem = scanner.nextInt();
                    System.out.print("Escolha o destino (usando o ID): ");
                    int destino = scanner.nextInt();
*/
                    ((Connector) jogo.getLocalNetwork().getVertices()[5]).rechargeUser(jogo.getTeamGiants().getTeamPlayers().get(1));
                    
                    ((Connector) jogo.getLocalNetwork().getVertices()[5]).rechargeUser(jogo.getTeamGiants().getTeamPlayers().get(1));
                }
                case 3 -> {
                    String JSONFileExport = "InputFiles\\calculatedPaths.json";

                    pt.ed2023.handlers.fileHandler.exportCalculatedRoutesToJSON(JSONFileExport, jogo.getCalculatedPaths());
                }
                case 4 -> {
                    return false;
                }
                default ->
                    System.out.println("Input invalido, tente outra vez.");
            }
        }
    }

}
