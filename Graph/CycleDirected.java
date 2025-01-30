
//store graph using array of arraylist of edge i.e. ArrayList<Edge> graph[]

import java.util.*;

public class CycleDirected {

    // to store edge
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                if(isCycleUtil(graph, visited,stack, i)){
                    return true; //cycle exists in one of components
                }
            }
        }
        return false;
    }

    private static boolean isCycleUtil(ArrayList<Edge>[] graph,boolean[] visited,boolean[] stack, int curr){
        visited[curr] = true;
        stack[curr]=true;

        //for each neighbor
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            //case 1 vneighbor visited in cuurent stack-->cycle
            if(stack[e.dest]) return true;

            //case 2 not visited--> recursion
            else if(!visited[e.dest]){
                if(isCycleUtil(graph, visited,stack, e.dest)){
                    return true;
                }             
            }
            // case 3 visited, parent-->ignore
        }
        stack[curr]=false;
        return false;
    }
    public static void main(String[] args) {
        /*
         *    0
         *   / \
         *  /   \
         * .     .
         * 2     1
         *  \   /
         *   \ /
         *    ..
         *    3
         */

        /* ex 2
            0 <----1<----3
                   |    /
                   |   /
                   .  .
                    2
        */

        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));

        // 1 vertex
        // graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // vertex 2
        graph[2].add(new Edge(2, 3));

        // vertex 3
        graph[3].add(new Edge(3, 1));


        System.out.println("Cycle detected in graph: "+ isCycle(graph));


    }

}
