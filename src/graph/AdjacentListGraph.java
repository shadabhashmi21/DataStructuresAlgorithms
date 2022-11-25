package graph;

import java.util.LinkedList;
import java.util.Queue;

public class AdjacentListGraph {
    private LinkedList<Integer>[ ] adj;
    private int V; // number of vertices
    private int E; // number of edges

    public AdjacentListGraph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for(int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for(int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for(int w : adj[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void bfs(int s){
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.offer(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.println(u + " ");
            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }
    public static void main(String[] args) {
        AdjacentListGraph g = new AdjacentListGraph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        System.out.println(g);
    }
}
