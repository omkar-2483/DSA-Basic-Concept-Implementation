import java.util.*;

public class TopologicalSort {
    public static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    public static void findTS(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                findTSUtil(graph, visited, st, i);
            }
        }

        System.out.print("Topological Sort: ");
        while (!st.isEmpty()) {
            System.out.print(st.pop()+", ");
        }   
    }

    private static void findTSUtil(ArrayList<Edge>[] graph, boolean visited[], Stack<Integer> st, int curr){
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                findTSUtil(graph, visited, st, e.dest);
            }
        }
        st.push(curr);
    }
    
    public static void buildGraph(ArrayList<Edge>[]graph){

        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 5));

        // graph[1].add(new Edge(1, 2));

        // graph[2].add(new Edge(2, 3));

        // graph[3].add(new Edge(4, 3));
        // graph[3].add(new Edge(4, 5));

        // Ex. 2
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5,2));
    }

    public static void main(String[] args) {

        /*  0-----> 5 <-----4
            |               |
            |               |
            -->1--->2--->3<--
         
         */

        int V=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> [] graph = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }        
        buildGraph(graph);

        findTS(graph);
    }
}
