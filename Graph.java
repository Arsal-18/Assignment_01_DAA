import java.util.*;

public class Graph {
    int vertices;
    int[][] adjacencyMatrix;
    LinkedList<Integer>[] adjacencyList;
    
    public Graph(int vertices){
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
        this.adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        adjacencyMatrix[u - 1][v - 1] = 1;
        adjacencyMatrix[v - 1][u - 1] = 1;

        adjacencyList[u - 1].add(v - 1);
        adjacencyList[v - 1].add(u - 1);
    }

    public void displayAdjacencyMatrix(){
        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void displayAdjacencyList(){
        System.out.println("\nAdjacency List (0-indexed):");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i+1 + ": ");
            for (Integer neighbor : adjacencyList[i]) {
                System.out.print(neighbor+1 + " ");
            }
            System.out.println();
        }
    }
}

class Main {
    public static void main(String[] args) {
        int v = 4;
        Graph g = new Graph(v);
        
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(1, 4);

        g.displayAdjacencyList();
        g.displayAdjacencyMatrix();
    }
}