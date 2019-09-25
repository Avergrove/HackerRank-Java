package Algorithms;

import java.io.IOException;
import java.util.Scanner;

public class DivisibleSumPairs {

    // Complete the divisibleSumPairs function below.
    private static int divisibleSumPairs(int n, int k, int[] ar) {

        int divisibleSumPairs = 0;

        for(int i = 0; i < ar.length - 1; i++){
            for(int j = i + 1; j < ar.length; j++){
                if((ar[i] + ar[j]) % k == 0){
                    divisibleSumPairs++;
                }
            }
        }
        return divisibleSumPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = divisibleSumPairs(n, k, ar);

        System.out.println(result);

        scanner.close();
    }

}