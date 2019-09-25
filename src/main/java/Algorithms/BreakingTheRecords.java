package Algorithms;

import java.util.Scanner;

public class BreakingTheRecords {

    // Complete the breakingRecords function below.
    private static int[] breakingRecords(int[] scores) {

        // [0] = lowest, [1] = highest.
        int[] recordScores = new int[2];
        int[] recordBreaks = new int[2];

        // Initialize
        recordScores[0] = scores[0];
        recordScores[1] = scores[0];

        for(int i = 1; i < scores.length; i++){
            if(scores[i] > recordScores[0]){
                recordBreaks[0]++;
                recordScores[0] = scores[i];
            }

            if(scores[i] < recordScores[1]){
                recordBreaks[1]++;
                recordScores[1] = scores[i];
            }
        }

        return recordBreaks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        scanner.close();
    }
}
