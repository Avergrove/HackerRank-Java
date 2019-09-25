package ProblemSolving.GameTheory;

import java.util.Scanner;

public class FunGame {

    private static final int ALICE = 0;
    private static final int BOB = 1;

    // Complete the funGame function below.
    static String funGame(int[] a, int[] b) {
        // Ideally, both players will try to **maximize** their gap in points, instead of gaining **more** points
        boolean[] chosen = new boolean[a.length];

        int aScore = 0;
        int bScore = 0;

        int turnsToFinish = a.length;   // Determines the number of turns left in the game.
        int whosTurn = ALICE; // Determines who's turn it is, 0 for a, 1 for b

        while(turnsToFinish > 0){
            if(whosTurn == ALICE){
                int maxGap = Integer.MIN_VALUE;
                int maxGapIndex = -1;

                for(int i = 0; i < a.length; i++){
                    if(!chosen[i]) {
                        int gap = a[i] + b[i];
                        if (gap > maxGap) {
                            maxGap = gap;
                            maxGapIndex = i;
                        }
                    }
                }

                // Alice choses [MaxGapIndex]
                chosen[maxGapIndex] = true;
                aScore += a[maxGapIndex];

                whosTurn = BOB;
            }

            else if(whosTurn == BOB){
                int maxGap = Integer.MIN_VALUE;
                int maxGapIndex = -1;

                for(int i = 0; i < b.length; i++){
                    if(!chosen[i]) {
                        int gap = b[i] + a[i];
                        if (gap > maxGap) {
                            maxGap = gap;
                            maxGapIndex = i;
                        }
                    }
                }

                // Bob chooses [MaxGapIndex]
                chosen[maxGapIndex] = true;
                bScore += b[maxGapIndex];

                whosTurn = ALICE;
            }

            turnsToFinish--;
        }

        // Determine game outcome
        if(aScore > bScore){
            return "First";
        }

        else if(aScore < bScore){
            return "Second";
        }

        else {
            return "Tie";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
            }

            int[] b = new int[n];

            String[] bItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int bItem = Integer.parseInt(bItems[i]);
                b[i] = bItem;
            }

            String result = funGame(a, b);

            System.out.println(result);
        }

        scanner.close();
    }
}
