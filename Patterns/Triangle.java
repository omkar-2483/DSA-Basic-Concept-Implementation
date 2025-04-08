
public class Triangle {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) { 
            for (int j = 0; j < 11; j++) { 
                if (j >= 5 - i && j <= 5 + i) { 
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
