//find shortest distances from source to all nodes

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
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

    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));

    }

    static class Pair implements Comparable<Pair>{
        int n;
        int path;

        public Pair(int n, int path){
            this.n = n;
            this.path =  path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path-p2.path;
        }
    }

    public static void dijikstra(ArrayList<Edge>[] graph, int src){
        int dist[] = new int[graph.length];  //dist[i]==> src to i
        //initialize distance
        for (int i = 0; i < graph.length; i++) {
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;  //infinite
            }
        }

        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));

        while (!pq.isEmpty()) {
            Pair curr= pq.remove();
            if(!visited[curr.n]){
                visited[curr.n]=true;
                // for all neighboours
                for(int i=0; i<graph[curr.n].size(); i++){
                    Edge e = graph[curr.n].get(i);
                    if(dist[e.src]+e.wt< dist[e.dest]){  //update distance of neighbour
                        dist[e.dest]= dist[e.src]+e.wt;
                        pq.add(new Pair(e.dest, dist[e.dest]));
                    }
                }
            }
        }

        //print all src to vertices distances
        for(int i=0; i<dist.length; i++){
            System.out.println("distance from src to node "+i+" :"+ dist[i]);
        }
    }

    public static void main(String[] args) {
        int V =6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int src =0;
        dijikstra(graph, src);
    }
}
