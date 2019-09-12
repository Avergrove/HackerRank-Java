package InterviewPreparationKit;

import java.util.Arrays;
import java.util.Scanner;

public class NewYearChaos {
    /**
     * Computes the number of bribes required for a queue to reach state q
     * @param q The current state of the queue
     */
    static void minimumBribes(int[] q) {
        // Note: This is a 1-index array
        int totalBribes = 0;
        for(int i = 0; i < q.length; i++){

            if(i + 3 < q[i]){
                System.out.println("Too chaotic");
                return;
            }

            for(int j = Math.max(0, q[i] - 2); j < i; j++){
                if(q[j] > q[i]) {
                    totalBribes++;
                }
            }
        }

        System.out.println(totalBribes);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
