public class BinaryStrings {
    //print all combinations of binary string of size n without consecutive 1s
    public static void printBS(int n, int last, String str){
        if(n==0){
            System.out.println(str);
            return;
        }

        printBS(n-1, 0, str+"0");
        if(last != 1) printBS(n-1, 1, str+"1");
    }

    public static void main(String[] args) {
        printBS(4, 0, "");
    }
}
