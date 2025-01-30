
//store graph using array of arraylist of edge i.e. ArrayList<Edge> graph[]

import java.util.*;

public class BipartiteGraph {

    // to store edge
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }


    public static boolean isBipartitie(ArrayList<Edge>[] graph){
        int[] color = new int[graph.length];  //0 no color, 1=blue, -1=red
        for(int i=0; i<graph.length; i++){   //for disconnected graph
            if(color[i]==0){
                if(!isBipartitieUtil(graph,i, color)) return false;
            }
        }
        return true;
    }

    private static boolean isBipartitieUtil(ArrayList<Edge>[] graph, int src, int color[]) {
        Queue<Integer> q = new LinkedList<>();

        int curr = src; // Start from the src node
        q.add(curr);
        color[curr] = -1;  //first assign blue 

        while (!q.isEmpty()) {
            curr = q.remove();

            for (int i = 0; i < graph[curr].size(); i++) {
                int neighbor = graph[curr].get(i).dest; // Assuming 'dest' is the destination node of the edge
                // case 1: neighbour has same color, return false--> non bipartite
                if(color[curr]==color[neighbor]) return false;

                //case 3: neighbor has no color, assign opposite color
                else if(color[neighbor]==0){
                    color[neighbor]= - color[curr];
                    q.add(neighbor);
                }

                //case 2: neighbor has same color continue
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*
         *  0-----1-----2
         *   \           \
         *    \           \
         *     4-----------3
         */

        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        // 1 vertex
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));  //edge 1--3

        // vertex 2
        // graph[2].add(new Edge(2, 1));
        // graph[2].add(new Edge(2, 3));

        // vertex 3
        graph[3].add(new Edge(3, 1)); //edge 3--1
        graph[3].add(new Edge(3, 4));

        // vertex 4
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,0));

        System.out.println("Is Graph Bi-partite: "+ isBipartitie(graph));

    }

}
