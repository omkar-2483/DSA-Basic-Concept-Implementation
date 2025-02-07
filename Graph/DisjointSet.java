public class DisjointSet {
    static int n=8;
    static int[] parent = new int[n];
    static int[] rank = new int[n];

    public static void init(){
        for (int i = 0; i < parent.length; i++) {
            parent[i]=i;
        }
    }

    public static int find(int x){
        if(parent[x]==x) return x;
        //return find(parent[x]);

        //path compression
        return parent[x]=find(parent[x]);
    } 

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] > rank[parB]){
            parent[parB] = parA;
        }else if(rank[parB] > rank[parA]){
            parent[parA]=parB;
        }else{
            parent[parB]=parA;
            rank[parA]++;
        }
    }

    public static void main(String[] args) {
        init();
        for (int i = 0; i < n; i++) {
            System.out.print(", parent of "+i+" : "+find(i));
        }
        System.out.println();
        union(1, 3);
        System.out.println("parent of 3: "+ find(3));
        union(2,4);
        union(3, 6);
        union(1, 4);
        System.out.println("Parent of 4: "+ find(4));
        union(1,5);
        System.out.println("final parent array:");
        for (int i : parent) {
            System.out.print(i+", ");
        }
        System.out.println();
        System.out.println("final rank array:");
        for (int i : rank) {
            System.out.print(i+", ");
        }
    }
}
