/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pt.ed2023.dataStructures.network;

import java.math.BigDecimal;
import pt.ed2023.dataStructures.list.UnorderedListADT;
import pt.ed2023.dataStructures.list.ArrayUnorderedList;
import pt.ed2023.gameStructures.Connector;
import pt.ed2023.gameStructures.Portal;
import pt.ed2023.exceptions.EmptyCollectionException;
import pt.ed2023.exceptions.UnknownPathException;
import java.util.Iterator;
import pt.ed2023.gameStructures.Coordinates;
import pt.ed2023.gameStructures.Local;

/**
 *
 * @author 8200335
 * @param <T>
 */
public class Network<T> extends MatrixGraph<T> implements NetworkADT<T> {

    protected final int DEFAULT_NETWORK_CAPACITY = 10;
    private double[][] networkAdjMatrix;

    public Network() {
        super();
        this.networkAdjMatrix = new double[this.DEFAULT_NETWORK_CAPACITY][this.DEFAULT_NETWORK_CAPACITY];
    }

    @Override
    public void addVertex(T vertex) {
        if (this.numVertices + 1 >= this.networkAdjMatrix.length) {
            this.expandMatrix();
        }

        super.addVertex(vertex);
    }

    @Override
    public void addEdge(T vertex1, T vertex2) {

        if (vertex1 instanceof Local && vertex2 instanceof Local) {
            double weight = calculateDistance(((Local) vertex1).getCoordinates(), ((Local) vertex1).getCoordinates());
            super.addEdge(vertex1, vertex2);
            this.setEdgeWeight(vertex1, vertex2, weight);
        } else {
            super.addEdge(vertex1, vertex2);
            this.setEdgeWeight(vertex1, vertex2, 0);
        }
    }

    private double calculateDistance(Coordinates ponto1, Coordinates ponto2) {
        // ESTA A RETORNAR SEMPRE 0!!
        double lat1 = ponto1.getLatitude();
        double lon1 = ponto1.getLongitude();
        double lat2 = ponto2.getLatitude(); 
        double lon2 = ponto2.getLongitude();
        
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return 6371 * c;
    }

    protected int[] getEdgeWithWeightOf(double weight, boolean[] visited) {
        int[] edge = new int[2];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if ((networkAdjMatrix[i][j] == weight) && (visited[i] ^ visited[j])) {
                    edge[0] = i;
                    edge[1] = j;
                    return edge;
                }
            }
        }

        // Will only get to here if a valid edge is not found
        edge[0] = -1;
        edge[1] = -1;
        return edge;
    }

    public void setEdgeWeight(T firstVertex, T secondVertex, double weight) {
        if (weight < 0.0D) {
            throw new IllegalArgumentException("O peso não pode ser inferior ao default.");
        }

        int first = this.getIndex(firstVertex);
        int second = this.getIndex(secondVertex);

        if (secondVertex.equals("exterior") || firstVertex.equals("exterior") || secondVertex.equals("entrada") || firstVertex.equals("entrada")) {
            this.networkAdjMatrix[first][second] = 0;
            this.networkAdjMatrix[second][first] = 0;
        } else {
            this.networkAdjMatrix[first][second] = weight;
        }

    }

    public void printPortalVertices() {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i] instanceof Portal) {
                System.out.println(vertices[i].toString());
            }
        }
    }

    public void printConnectorVertices() {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i] instanceof Connector) {
                System.out.println(vertices[i].toString());
            }
        }
    }

    public double getEdgeWeight(T firstVertex, T secondVertex) {
        int first = this.getIndex(firstVertex);
        int second = this.getIndex(secondVertex);

        return this.networkAdjMatrix[first][second];
    }

    private void expandMatrix() {
        double[][] tempMatrix = new double[this.numVertices * 2][this.numVertices * 2];

        for (int i = 0; i < this.numVertices; ++i) {
            for (int j = 0; j < this.numVertices; ++j) {
                tempMatrix[i][j] = this.networkAdjMatrix[i][j];
            }
        }

        this.networkAdjMatrix = tempMatrix;
    }

    public Iterator<T> iteratorShortestWeight(T startVertex, T targetVertex) throws UnknownPathException, EmptyCollectionException {
        return shortestPathWeight(startVertex, targetVertex).iterator();
    }

    @Override
    public ArrayUnorderedList<T> shortestPathWeight(T vertex1, T vertex2) throws EmptyCollectionException, UnknownPathException {
        PriorityQueue<Pair<T>> priorityQueue = new PriorityQueue<>();
        UnorderedListADT<T> verticesFromPossiblePath = new ArrayUnorderedList<>();
        ArrayUnorderedList<T> result = new ArrayUnorderedList<>();
        Pair<T> startPair = new Pair<>(null, vertex1, 0.0);

        priorityQueue.addElement(startPair, (int) startPair.cost);

        while (!priorityQueue.isEmpty()) {
            Pair<T> pair = priorityQueue.removeNext();
            T vertex = pair.vertex;
            double minCost = pair.cost;

            if (vertex.equals(vertex2)) {
                Pair<T> finalPair = pair;

                while (finalPair != null) {
                    result.addToFront(finalPair.vertex);
                    finalPair = finalPair.previous;
                }

                return result;
            }

            verticesFromPossiblePath.addToRear(vertex);

            for (int i = 0; i < numVertices; i++) {
                if (super.adjMatrix[getIndex(vertex)][i] && !verticesFromPossiblePath.contains(vertices[i])) {
                    double minCostToVertex = minCost + networkAdjMatrix[getIndex(vertex)][i];
                    Pair<T> tmpPair = new Pair<>(pair, vertices[i], minCostToVertex);
                    priorityQueue.addElement(tmpPair, (int) tmpPair.cost);
                }
            }
        }

        throw new UnknownPathException("Não existe caminho entre os pontos");
    }

    public ArrayUnorderedList<T> shortestPathWeightEnergy(T vertex1, T vertex2) throws EmptyCollectionException, UnknownPathException {
        PriorityQueue<Pair<T>> priorityQueue = new PriorityQueue<>();
        UnorderedListADT<T> verticesFromPossiblePath = new ArrayUnorderedList<>();
        ArrayUnorderedList<T> result = new ArrayUnorderedList<>();
        Pair<T> startPair = new Pair<>(null, vertex1, 0.0);

        priorityQueue.addElement(startPair, (int) startPair.cost);

        while (!priorityQueue.isEmpty()) {
            Pair<T> pair = priorityQueue.removeNext();
            T vertex = pair.vertex;
            double minCost = pair.cost;

            if (vertex.equals(vertex2)) {
                Pair<T> finalPair = pair;

                while (finalPair != null) {
                    result.addToFront(finalPair.vertex);
                    finalPair = finalPair.previous;
                }

                return result;
            }

            verticesFromPossiblePath.addToRear(vertex);

            for (int i = 0; i < numVertices; i++) {
                if (super.adjMatrix[getIndex(vertex)][i] && !verticesFromPossiblePath.contains(vertices[i])) {
                    double minCostToVertex = minCost + networkAdjMatrix[getIndex(vertex)][i];
                    Pair<T> tmpPair = new Pair<>(pair, vertices[i], minCostToVertex);
                    priorityQueue.addElement(tmpPair, (int) tmpPair.cost);
                }
            }
        }

        throw new UnknownPathException("Não existe caminho entre os pontos");
    }

    @SuppressWarnings("unchecked")
    public Network<T> mstNetwork() {
        int x, y;
        int index;
        double weight;
        int[] edge = new int[2];
        LinkedHeap<Double> minHeap = new LinkedHeap<>();
        Network<T> resultGraph = new Network<>();
        if (isEmpty() || !isConnected()) {
            return resultGraph;
        }
        resultGraph.networkAdjMatrix = new double[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                resultGraph.networkAdjMatrix[i][j] = Double.POSITIVE_INFINITY;
            }
        }
        resultGraph.vertices = (T[]) (new Object[numVertices]);
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        edge[0] = 0;
        resultGraph.vertices[0] = this.vertices[0];
        resultGraph.numVertices++;
        visited[0] = true;

        for (int i = 0; i < numVertices; i++) {
            minHeap.addElement(networkAdjMatrix[0][i]);
        }
        while ((resultGraph.size() < this.size()) && !minHeap.isEmpty()) {
            do {
                try {
                    weight = minHeap.removeMin();
                    edge = getEdgeWithWeightOf(weight, visited);
                } catch (EmptyCollectionException e) {
                    System.out.println(e.getMessage());
                }
            } while (!indexIsValid(edge[0]) || !indexIsValid(edge[1]));
            x = edge[0];
            y = edge[1];
            if (!visited[x]) {
                index = x;
            } else {
                index = y;
            }
            resultGraph.vertices[index] = this.vertices[index];
            visited[index] = true;
            resultGraph.numVertices++;
            resultGraph.networkAdjMatrix[x][y] = this.networkAdjMatrix[x][y];
            resultGraph.networkAdjMatrix[y][x] = this.networkAdjMatrix[y][x];

            for (int i = 0; i < numVertices; i++) {
                if (!visited[i] && (this.networkAdjMatrix[i][index] < Double.POSITIVE_INFINITY)) {
                    edge[0] = index;
                    edge[1] = i;
                    minHeap.addElement(networkAdjMatrix[index][i]);
                }
            }
        }
        return resultGraph;
    }

    public T[] getVertices() {
        return super.vertices;
    }

    public String verticesToString() {
        if (numVertices == 0) {
            return "Não existem vertices";
        }

        String result = "";

        for (int i = 0; i < numVertices; i++) {
            result += vertices[i].toString() + '\n';
        }

        return result;
    }

    @Override
    public String toString() {
        if (numVertices == 0) {
            return "Grafo está vazio";
        }

        String result = super.toString();

        //Print the weights of the edges
        result += "\n\nPeso das arestas";
        result += "\n----------------\n";
        result += "Indice\tPeso\n\n";

        for (int i = 0; i < numVertices; i++) {
            for (int j = numVertices - 1; j > i; j--) {
                if (super.adjMatrix[i][j]) {
                    result += i + " to " + j + "\t";
                    result += networkAdjMatrix[i][j] + "\n";
                }
            }
        }

        result += "\n";
        return result;
    }

    @Override
    public void addEdge(T vertex1, T vertex2, double weight) throws EmptyCollectionException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
