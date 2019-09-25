package ProblemSolving.DynamicProgramming;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class TheMaximumSubarray {

    // Complete the maxSubarray function below.
    static int[] maxSubarray(int[] arr) {

        int[] results = new int[2];

        // Maximum sum of sub array
        results[0] = Arrays.stream(arr).filter(x -> x > 0).sum();

        // Maximum contiguous subset sum of array
        int[] maxContiguousSums = new int[arr.length];
        maxContiguousSums[0] = arr[0]; // Base case
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                // Just keep adding if both are positive
                if(maxContiguousSums[i-1] > 0) {
                    maxContiguousSums[i] = maxContiguousSums[i - 1] + arr[i];
                }

                // Reset value if previous max sum is negative.
                else{
                    maxContiguousSums[i] = arr[i];
                }
            }

            else{
                if(maxContiguousSums[i-1] > arr[i]){

                }
            }
        }

        Arrays.stream(arr).max().ifPresent(x -> results[1] = x);

        return results;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = maxSubarray(arr);

            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);

                if (i != result.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
