package Algorithms;

import java.io.IOException;
import java.util.Scanner;

public class ConstructTheArray {

    /**
     * Constructs an array such that consecutive positions have different values.
     * @param n Array Length
     * @param k Available digits [1-k]
     * @param x The last digit
     * @return The number of ways to construct such an array.
     */
    static long countArray(int n, int k, int x) {

        long[][] waysToConstructN = new long[n+1][k+1]; // Dictates an array[i][j] of length i, which ends with j, and the number of combinations to form it.

        for(int i = 2; i < k + 1; i++) {
            waysToConstructN[2][i] = 1;
        }

        // Iteration
        for(int currentLength = 3; currentLength < n + 1; currentLength++){
            for(int currVal = 1; currVal < k + 1; currVal++) {
                // General case
                for (int prevVal = 1; prevVal < k + 1; prevVal++) {
                    if(prevVal != currVal) {
                        waysToConstructN[currentLength][currVal] = (waysToConstructN[currentLength][currVal] + waysToConstructN[currentLength - 1][prevVal]) % ((long) Math.pow(10, 9) + 7);
                    }
                }

            }
        }
        return waysToConstructN[n][x];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nkx = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkx[0]);

        int k = Integer.parseInt(nkx[1]);

        int x = Integer.parseInt(nkx[2]);

        long answer = countArray(n, k, x);

        System.out.println(answer);

        scanner.close();
    }
}
