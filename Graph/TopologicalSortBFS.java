import java.util.*;

public class TopologicalSortBFS {
    public static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    public static void calDeg(ArrayList<Edge>[] graph, int[]inDeg){
        for (int i = 0; i < graph.length; i++) {  //for each node
            for(int j=0; j<graph[i].size(); j++){  //for each edge coming from node
                Edge e= graph[i].get(j);
                inDeg[e.dest]++;
            }
        }
    }

    public static void findTS(ArrayList<Edge>[] graph){
        int inDeg[] = new int[graph.length];
        calDeg(graph, inDeg);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<inDeg.length; i++){
            if(inDeg[i]==0) q.add(i);
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+", ");
            for(int i=0; i<graph[curr].size(); i++){//for each child
                Edge e=graph[curr].get(i);
                inDeg[e.dest]--;
                if(inDeg[e.dest]==0) q.add(e.dest);
            }
        }
    }
    
    public static void buildGraph(ArrayList<Edge>[]graph){

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 5));

        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 3));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        // Ex. 2
        // graph[2].add(new Edge(2,3));
        // graph[3].add(new Edge(3, 1));
        // graph[4].add(new Edge(4,0));
        // graph[4].add(new Edge(4, 1));
        // graph[5].add(new Edge(5, 0));
        // graph[5].add(new Edge(5,2));
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

        System.out.print("Topological Sort: ");
        findTS(graph);
    }
}
