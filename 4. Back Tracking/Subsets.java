public class Subsets {
    public static void findSubsets(String str, String ans, int i){
        if(i==str.length()){
            System.out.println(ans);
            return;
        }

        // each character has two chioces
        findSubsets(str, ans+str.charAt(i), i+1); //include
        findSubsets(str, ans, i+1); //dont include
    }
    public static void main(String[] args) {
        findSubsets("abc", "", 0);
    }
}
