public class Swasthik {
    public static void main(String[] args) {
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(i==0 && j==1) System.out.print(" ");
                else if(i==1 && (j==1 || j>=3 )) System.out.print(" ");
                else if(i==3 && (j<=1 || j==3)) System.out.print(" ");
                else if(i==4 && j==3) System.out.print(" ");
                else System.out.print("*");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
