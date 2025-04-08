public class Fibonacci {
    // Function to calculate the nth Fibonacci number using recursion
    public static int nthfib(int n) {
        // Base case: if n is 0 or 1, return n
        if (n == 0 || n == 1) {
            return n;
        }
        // Recursive case: return the sum of the two preceding Fibonacci numbers
        return nthfib(n - 1) + nthfib(n - 2);
    }
    public static void main(String[] args) {
        System.out.println(nthfib(5)); // Output: 5
        System.out.println(nthfib(10)); // Output: 55  
    }
}
//ways to place 2*1 size tiles on 2*n board