
//store graph using array of arraylist of edge i.e. ArrayList<Edge> graph[]

import java.util.*;

public class CycleUndirected {

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

    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                if(detectCycleUtil(graph, visited, i, -1)){
                    return true; //cycle exists in one of components
                }
            }
        }
        return false;
    }

    private static boolean detectCycleUtil(ArrayList<Edge>[] graph,boolean[] visited, int curr, int parent ){
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            //case 1 visited and not parent-->cycle
            if(visited[e.dest] && e.dest!=parent) return true;

            //case 2 not visited--> recursion
            else if(!visited[e.dest]){
                if(detectCycleUtil(graph, visited, e.dest, curr)){
                    return true;
                }             
            }
            // case 3 visited, parent-->ignore
        }
        return false;
    }
    public static void main(String[] args) {
        /*
         *    (5)
         * 0-------1
         *        / \
         *       /   \ (3)
         *      /     \
         *     2-------3
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
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2,4,2));

        // vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // vertex 4
        graph[4].add(new Edge(4,2,2));


        System.out.println("Cycle detected in graph: "+ detectCycle(graph));


    }

}
