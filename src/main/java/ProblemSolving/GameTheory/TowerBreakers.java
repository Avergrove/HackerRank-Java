package ProblemSolving.GameTheory;

import java.util.Scanner;

public class TowerBreakers {

    // Complete the towerBreakers function below.

    /**
     *
     * @param n Number of towers
     * @param m Height of each tower
     * @return The game outcome, 1 if player 1 wins, 2 if player 2 wins
     */
    static int towerBreakers(int n, int m) {
        return (m == 1 || n % 2 == 0 ? 2 : 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int result = towerBreakers(n, m);

            System.out.println(result);
        }

        scanner.close();
    }
}
