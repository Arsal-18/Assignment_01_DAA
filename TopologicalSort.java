import java.util.*;

public class TopologicalSort {

    int vertices;
    LinkedList<Integer>[] adj;

    public TopologicalSort(int vertices) {
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                topologicalSortUtil(neighbor, visited, stack);
            }
        }
        stack.push(v);
    }

    public void solve() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print((char) (stack.pop() + 'm') + " ");
        }
    }

    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(14);

        g.addEdge(0, 4);  // m -> q
        g.addEdge(0, 5);  // m -> r
        g.addEdge(0, 11); // m -> x 
        g.addEdge(1, 2);  // n -> o
        g.addEdge(1, 4);  // n -> q
        g.addEdge(1, 8);  // n -> u
        g.addEdge(2, 5);  // o -> r
        g.addEdge(2, 6);  // o -> s
        g.addEdge(2, 9);  // o -> v
        g.addEdge(3, 2);  // p -> o
        g.addEdge(3, 6);  // p -> s
        g.addEdge(3, 13); // p -> z
        g.addEdge(4, 7);  // q -> t
        g.addEdge(5, 8);  // r -> u
        g.addEdge(5, 12); // r -> y
        g.addEdge(6, 5);  // s -> r
        g.addEdge(8, 7);  // u -> t
        g.addEdge(9, 11); // v -> x
        g.addEdge(9, 10); // v -> w
        g.addEdge(10, 13); // w -> z
        g.addEdge(12, 9); // y -> v

        System.out.println("Topological Sort (DFS):");
        g.solve();
    }
}