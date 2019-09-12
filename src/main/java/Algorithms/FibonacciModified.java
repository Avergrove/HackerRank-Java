package Algorithms;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

    // Complete the fibonacciModified function below.
    private static BigInteger fibonacciModified(int t1, int t2, int n) {
        BigInteger[] table = new BigInteger[n+1];

        table[3] = BigInteger.valueOf(t1).add(BigInteger.valueOf(t2).pow(2));
        table[4] = BigInteger.valueOf(t2).add(table[3].pow(2));

        for(int i = 5; i < n+1; i++){
            table[i] = table[i-2].add(table[i-1].pow(2));
        }

        return table[n];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] t1T2n = scanner.nextLine().split(" ");

        int t1 = Integer.parseInt(t1T2n[0]);

        int t2 = Integer.parseInt(t1T2n[1]);

        int n = Integer.parseInt(t1T2n[2]);

        BigInteger result = fibonacciModified(t1, t2, n);
        System.out.println(result);

        scanner.close();
    }
}
