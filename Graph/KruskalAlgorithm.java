import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgorithm {

    //class edge to store information of Edge
    static class  Edge  implements Comparable<Edge> {
        int src;
        int dest;
        int wt;
        
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt-e2.wt;
        }
    }

    //create graph which is array of edges
    static void createGraph(ArrayList<Edge> edges){
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(1,2,40));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(2,3,50));
    }

    //implement union find (disjoint set)
    static int n=4;
    static int parent[] = new int[n]; // to store parent of disjoint set elements
    static int rank[] = new int[n]; //to store rank of disjoint set elements

    //initialize parent
    public static void init(){
        for (int i = 0; i < parent.length; i++) {
            parent[i]=i;
        }
    }

    //write function to find leader of disjoint set element
    public static int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]); //optimization using path compression
    }

    //union to join two disjoint sets
    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA]==rank[parB]){
            parent[parA] = parB;
            rank[parB]++;
        }else if(rank[parA]<rank[parB]){
            parent[parA] = parB;
        }else{
            parent[parB] = parA;
        }
    }

    //kruskal algorithm to fund cost of MST
    public static void kruskalMST(ArrayList<Edge> edges, int V){  // O(V+E*logE)
        //sort edges
        Collections.sort(edges);                               //O(E*logE)
        int mstCost=0;
        int count=0;  //to connect V vertices we need V-1 Edges

        //initialize union find
        init();

        //pick edges one by one untill V-1 edges included
        for(int i=0; count<V-1; i++){                               //O(V)
            Edge e = edges.get(i); //ith edge
            //check if cycle forms if edge considered
            if(find(e.src)==find(e.dest)){
                //cycle forms dont include cycle
            }else{
                //consider edge in MST
                mstCost+=e.wt;
                union(e.src, e.dest);
                count++;
            }
        }

        System.out.println("Minimum cost of MST: "+mstCost);
    }

    public static void main(String[] args) {
        //create graph
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalMST(edges, V);
    }
}
