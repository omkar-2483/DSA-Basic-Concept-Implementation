//find shortest distances from source to all nodes

import java.util.*;

public class BellmanFord {
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

    public static void bellmanFord(ArrayList<Edge>[] graph, int src){
        int[] dist = new int[graph.length];

        //initialize all distances with infinity
        for (int i = 0; i < dist.length; i++) {
            if(i!=src) dist[i] = Integer.MAX_VALUE;
        }

        int V = graph.length;
        //bellman ford algorithm
        for (int i = 0; i < V-1; i++) {
            // for all edges
            for(int j=0; j<graph.length; j++){
                for(int k=0; k<graph[j].size(); k++){
                    Edge e = graph[j].get(k);

                    //if dist[u]=infinity hen dist[u]+any positive become negative in java
                    if(dist[e.src]!=Integer.MAX_VALUE && dist[e.src]+e.wt < dist[e.dest]){
                        dist[e.dest] = dist[e.src]+e.wt;
                    }
                }
            }
        }

        //print all src to vertices distances
        for(int i=0; i<dist.length; i++){
            System.out.println("dist from src to node "+i+" :"+ dist[i]);
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-1));
    }

    
    public static void main(String[] args) {
        int V =5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int src =0;
        bellmanFord(graph, src);
    }
}

