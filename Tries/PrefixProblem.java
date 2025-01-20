public class PrefixProblem{
    static class Node{
        Node[] childrens= new Node[26];
        boolean eow = false;
        int freq;
    
        public Node(){
            for (int i = 0; i < childrens.length; i++) {
                childrens[i]=null;
            }
        }
    }


    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int level=0; level<word.length(); level++){
            int idx = word.charAt(level)-'a';
            if(curr.childrens[idx]==null){
                curr.childrens[idx]= new Node();
            }
            curr = curr.childrens[idx];
            curr.freq++;
        }
        curr.eow=true;
    }

    public static String searchPrefix (String word){
        Node curr = root;
        for(int level=0; level<word.length(); level++){
            int idx = word.charAt(level)-'a';
            curr = curr.childrens[idx];
            if(curr.freq==1){
                return word.substring(0, level+1);
            }
        }
        return null;
    }

    public static void  main(String[] args){
        String words[] = {"zebra", "dog", "duck", "dove", "zebre","cow","cat"};

        for (String word : words) {
            insert(word);
        }
        System.out.println("unique prefixes: ");
        for(String word : words){
            System.out.print(searchPrefix(word)+", ");
            
        }
    }
}