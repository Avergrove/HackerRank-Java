package InterviewPreparationKit;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    private static long arrayManipulation(int n, int[][] queries) {
        // An array that shows the difference between the current value and the last value, with first value as zero.
        int[] differenceArray = new int[n+1];

        for(int[] query : queries){
            differenceArray[query[0]] += query[2];
            differenceArray[query[1]+1] -= query[2];
        }

        // Standardize array
        int[] manipulationArray = new int[differenceArray.length];
        for(int i = 1; i < differenceArray.length; i++){
            manipulationArray[i] = differenceArray[i] + manipulationArray[i-1];
        }

        return Arrays.stream(manipulationArray).max().getAsInt();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(result);

        scanner.close();
    }
}
