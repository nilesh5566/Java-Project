import java.sql.SQLOutput;
import java.util.Scanner;

public class fibbnoice {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of Terms : ");
        int n=sc.nextInt();
        sc.close();

        long[] dp=new long[n+1];
        System.out.println("Fibonacci Series is : ");
        int sum=0;
        for(int i=0;i<n;i++) {
            System.out.println(fibonacci(i, dp) + " ");
            sum+=fibonacci(i,dp);

        }
        System.out.println();
        System.out.println( "Sum of number is : "+sum);
    }

    private static long fibonacci(int n, long[] dp) {
        if (n <= 1) return n;
        if (dp[n] != 0) return dp[n];
        return dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
    }
}
