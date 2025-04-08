public class Power{
    public static int power(int num, int n){
        if(n==0) return 1;

        int halfPower = power(num, n/2);
        if(n%2 == 0) return halfPower*halfPower;
        else return halfPower*halfPower*num;
    }
    public static void main(String[] args) {
        System.out.println(power(2,9));
        System.out.println(power(2,10));
    }
}