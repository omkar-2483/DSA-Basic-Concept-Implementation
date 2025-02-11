import java.util.*;

public class kosarajuAlgo {
    public static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    
    public static void buildGraph(ArrayList<Edge>[]graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        } 
        // graph[0].add(new Edge(0, 3));
        // graph[0].add(new Edge(0, 2));
        // graph[1].add(new Edge(1, 0));
        // graph[2].add(new Edge(2, 1));
        // graph[3].add(new Edge(3, 4));

        // Ex. 2
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
    }

    public static void topSort(ArrayList<Edge>[] graph, boolean visited[], Stack<Integer> st, int curr){
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                topSort(graph, visited, st, e.dest);
            }
        }
        st.push(curr);
    }

    public static void dfs(ArrayList<Edge> [] graph, boolean[] visited, int curr){
        visited[curr]=true;
        System.out.print(curr+" ");
        for(int i=0; i< graph[curr].size(); i++){
            Edge e= graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph, visited, e.dest);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge> [] graph, int V){
        //setp 1- find stack of topological stack
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                topSort(graph, visited, st, i);
            }
        }


        //step 2 - transpose graph
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] transpose = new ArrayList[V];
        for (int i = 0; i < transpose.length; i++) {
            transpose[i] = new ArrayList<>();
        }
        for(int i=0; i<V; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        //setp 3 - DFS for transose graph using topological stack 
        visited = new boolean[V]; //re-initialize visited
        while (!st.isEmpty()) {
            int curr = st.pop();
            if(!visited[curr]){
                System.out.print("SCC: ");
                dfs(transpose, visited, curr); // print one SCC
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        int V=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> [] graph = new ArrayList[V];       
        buildGraph(graph);
        kosaraju(graph, V);
    }
}
