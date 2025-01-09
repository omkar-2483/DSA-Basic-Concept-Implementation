import java.util.*;

public class HashMapCode{

    //  hashmap class for all implementation of hashmap
    static class HashMap<K,V>{  //generics <K,V>

        //node to store key value pair
        private class Node{
            K key;
            V value;
            public Node(K key, V value){
                this.key=key;
                this.value=value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];  //Array of LinkedList

        @SuppressWarnings("unchecked")  //suppresswarning in LinkedList[4]
        // constructor to initialize size and buckets
        public HashMap(){
            this.N=4;
            this.buckets=new LinkedList[N];
            for(int i=0; i<4; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        //hash function
        private int hashFunction(K key){
            int hc = key.hashCode();  //hashcode which is any int
            return Math.abs(hc)%N;  //index should be between 0 and N-1
        }

        private int searchInLL(K key,int bi){
            LinkedList<Node> ll=buckets[bi];
            for(int i=0; i<ll.size(); i++){
                Node node= ll.get(i);
                if(node.key==key){
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N*2];
            N=N*2;
            for(int i=0; i<buckets.length; i++){
                buckets[i]= new LinkedList<>();
            }

            for(int i=0; i<oldBuck.length; i++){
                LinkedList<Node> ll= oldBuck[i];
                for(int j=0; j<ll.size(); j++){
                    Node node= ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        //all utility functions
        public void put(K key, V value){
            int bi = hashFunction(key); //bucket index
            int di = searchInLL(key,bi); //data index //check if key is already present or not

            if(di != -1){  //kay already exists, update value
                Node node=buckets[bi].get(di);
                node.value=value;
            }else{
                buckets[bi].add(new Node(key, value));
                n++;
            }

            //check for re-hashing
            double lambda=n/N;
            if(lambda > 2){
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di == -1){
                return false;
            }else{
                return true;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key); //bucket index
            int di = searchInLL(key,bi); //data index //check if key is already present or not

            if(di != -1){  //kay already exists, update value
                Node node=buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }

        public V get(K key){
            int bi = hashFunction(key); //bucket index
            int di = searchInLL(key,bi); //data index //check if key is already present or not

            if(di != -1){  //kay already exists, update value
                Node node=buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }

        
    }

    //main function
    public static void main(String[] args) {
        HashMap<Character, Integer> hm= new HashMap<>();
        hm.put('A', 1);
        hm.put('B', 2);
        hm.put('C', 3);

        System.out.println(hm.keySet());

        System.out.println("Key=A, value="+ hm.get('A'));
        System.out.println("Key=C, value="+ hm.get('C'));
        System.out.println("Key=D, value="+ hm.get('D'));

        System.out.println("HashMap Contains Key A: "+ hm.containsKey('A'));
        System.out.println("HashMap Contains Key D: "+ hm.containsKey('D'));

        hm.remove('A');
        System.out.println("HashMap Contains Key A: "+ hm.containsKey('A'));

        hm.put('B',5);
        System.out.println("Key=B, updated value="+ hm.get('B'));

        System.out.println(hm.keySet());

    }
}