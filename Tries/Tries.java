
public class Tries{
    static class Node{
        Node[] childrens= new Node[26];
        boolean eow = false;
    
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
        }
        curr.eow=true;
    }

    public static boolean search (String word){
        Node curr = root;
        for(int level=0; level<word.length(); level++){
            int idx = word.charAt(level)-'a';
            if(curr.childrens[idx]==null){
                return false;
            }
            curr = curr.childrens[idx];
        }
        return curr.eow==true;
    }

    public static boolean wordBreak(String key){
        if(key.length()==0) return true;

        for(int i=1; i<=key.length(); i++){
            String sub = key.substring(0, i);
            if(search(sub) && wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }

    public static void  main(String[] args){
        // String[] words = {"the", "a", "there", "their", "any", "thee"};

        // for (int i = 0; i < words.length; i++) {
        //     insert(words[i]);
        // }

        // System.out.println("the present: "+ search("the"));
        // System.out.println("there present: "+ search("there"));
        // System.out.println("thor present: "+ search("thor"));

        String words[] = {"i", "like", "sam", "samsung", "mobile","ice"};
        for (String string : words) {
            insert(string);
        }
        String key = "ilikesamsungmobile";
        System.out.println("key can be split: "+ wordBreak(key));
    }
}