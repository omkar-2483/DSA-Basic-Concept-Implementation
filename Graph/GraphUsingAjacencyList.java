
//store graph using array of arraylist of edge i.e. ArrayList<Edge> graph[]

import java.util.*;

public class GraphUsingAjacencyList {

    //to store edge
    static class Edge {
        int src;
        int dest;
        int wt;
        
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
    
        System.out.print("BFS: ");
        int curr = 0; // Start from the first node (index 0)
        q.add(curr);
        visited[curr] = true; // Mark the starting node as visited
    
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
    
    
    public static void dfs(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
    
        System.out.print("DFS: ");
        int curr = 0; // Start from the first node (index 0)
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
    
    public static void dfsRecursive(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        System.out.print("DFS Recursive: ");
        dfsHelper(0, graph, visited);
    }
    
    private static void dfsHelper(int node, ArrayList<Edge>[] graph, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[node] = true;
        System.out.print(node + " ");
    
        // Recursively visit all unvisited neighbors
        for (int i = 0; i < graph[node].size(); i++) {
            int neighbor = graph[node].get(i).dest; // Assuming 'dest' is the destination node
            if (!visited[neighbor]) {
                dfsHelper(neighbor, graph, visited);
            }
        }
    }


    //function to check if there is path between two nodes
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean visited[]){
        if(src==dest) return true;
        visited[src]=true;

        for(int i=0; i<graph[src].size(); i++){
            Edge e= graph[src].get(i);
            if(! visited[e.dest] && hasPath(graph, e.dest, dest, visited)){
                return true;
            }
        }
        return false;
    } 
    
    public static void main(String[] args) {
        /*    (5)
         * 0-------1
         *        / \
         *   (1) /   \ (3)
         *      /     \
         *     2-------3
         *     |   (1)
         *  (2)|
         *     |
         *     4
         */

         int V = 5;
         @SuppressWarnings("unchecked")
         ArrayList<Edge>[] graph = new ArrayList[V];
         for(int i=0; i<V; i++){
            graph[i]= new ArrayList<>();
         }

         //0 vertex
         graph[0].add(new Edge(0,1,5));

         //1 vertex
         graph[1].add(new Edge(1,0,5));
         graph[1].add(new Edge(1,2,1));
         graph[1].add(new Edge(1,3,3));

         //vertex 2
         graph[2].add(new Edge(2,1,1));
         graph[2].add(new Edge(2,3,1));
        //  graph[2].add(new Edge(2,4,2)); 

         //vertex 3
         graph[3].add(new Edge(3,1,3));
         graph[3].add(new Edge(3,2,1));

         //vertex 4
        //  graph[4].add(new Edge(4,2,2));

        //  bfs(graph);
        //  dfs(graph);
        //  dfsRecursive(graph);

        System.out.println("Has path between 0 and 4: "+ hasPath(graph, 0, 4, new boolean[V]));
        System.out.println("Has path between 3 and 0: "+ hasPath(graph, 3, 0, new boolean[V]));
    }
    
}