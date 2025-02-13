import java.util.*;

public class ArticulationPoint {
    public static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void buildGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static void tarjanArtPoint(ArrayList<Edge>[] graph, int V) {
        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;
        boolean[] vis = new boolean[V];

        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(graph, i, -1, vis, dt, low, time);
            }
        }

    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par,
            boolean[] vis, int[] dt, int[] low, int time) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        int children=0;
        //for all neighbours
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);  //e.src---e.dest

            //case 1--> neigh == parent
            if(e.dest == par){
                continue;  //ignore
            }

            //case 2--> neigh is visited already
            else if(vis[e.dest]){
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }

            //case 3--> neigh is not visited yet
            else if(!vis[e.dest]){
                dfs(graph, e.dest, curr, vis, dt, low, time); // first visit neighbour
                //after backtracked
                low[curr] = Math.min(low[curr], low[e.dest]);
                if(par!=-1 && dt[curr] <= low[e.dest]){
                    System.out.println("Articulation Point: "+curr);
                }
                children++;
            }
        }

        //after traveesing allchildrens
        if(par==-1 && children > 1){
            System.out.println("Articulation Point: "+curr);
        }
    }

    public static void main(String[] args) {

        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        buildGraph(graph);
        tarjanArtPoint(graph, V);
    }
}
