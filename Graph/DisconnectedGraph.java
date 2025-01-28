
//store graph using array of arraylist of edge i.e. ArrayList<Edge> graph[]

import java.util.*;

public class DisconnectedGraph {

    // to store edge
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }


    public static void bfs(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!visited[i]) bfsUtil(graph,i, visited);
        }
    }

    private static void bfsUtil(ArrayList<Edge>[] graph, int src, boolean visited[]) {
        Queue<Integer> q = new LinkedList<>();

        System.out.print("BFS: ");
        int curr = src; // Start from the src node
        q.add(curr);
        visited[curr] = true; 

        while (!q.isEmpty()) {
            curr = q.remove();
            System.out.print(curr + " "); // Process the current node

            for (int i = 0; i < graph[curr].size(); i++) {
                int neighbor = graph[curr].get(i).dest; // Assuming 'dest' is the destination node of the edge
                if (!visited[neighbor]) {
                    q.add(neighbor);
                    visited[neighbor] = true; // Mark the neighbor as visited
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) dfs_util(graph, visited, i);
        }
    }

    private static void dfs_util(ArrayList<Edge>[] graph, boolean[] visited, int src) {
        Stack<Integer> stack = new Stack<>();

        System.out.print("DFS: ");
        int curr = src; // Start from the source node
        stack.push(curr);

        while (!stack.isEmpty()) {
            curr = stack.pop();

            if (!visited[curr]) {
                System.out.print(curr + " "); // Process the current node
                visited[curr] = true; // Mark the node as visited

                for (int i = graph[curr].size() - 1; i >= 0; i--) {
                    int neighbor = graph[curr].get(i).dest; // Assuming 'dest' is the destination node of the edge
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        /*
         *    (5)
         * 0-------1
         *          \
         *           \ (3)
         *            \
         *     2       3
         *     | 
         *  (2)|
         *     |
         *     4
         */

        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1, 5));

        // 1 vertex
        graph[1].add(new Edge(1, 0, 5));
        // graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // vertex 2
        // graph[2].add(new Edge(2, 1, 1));
        // graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2,4,2));

        // vertex 3
        graph[3].add(new Edge(3, 1, 3));
        // graph[3].add(new Edge(3, 2, 1));

        // vertex 4
        graph[4].add(new Edge(4,2,2));

        // bfs(graph);
        dfs(graph);

    }

}
