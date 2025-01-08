import java.util.*;

public class HashMapCode{

    //  hashmap class for all implementation of hashmap
    static class HashMap<K,V>{

        //node to store key value pair
        private class Node{
            K key;
            V value;
            public node(K key, V value){
                this.key=key;
                this.value=value;
            }
        }

        private int size; //n
        private LinkedList<Node> buckets[];  //Array of LinkedList

        @SuppressWarnings("unchecked")  //suppresswarning in LinkedList[4]
        // constructor to initialize size and buckets
        public HashMap(){
            this.size=0;
            this.buckets=new LinkedList[4];
            for(int i=0; i<4; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        //all utility functions
        public void put(K key, V value){

        }

        public boolean containsKey(K key){

        }

        public V remove(K key){

        }

        public V get(K key){

        }

        public 
    }
}