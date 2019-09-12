package TenDaysOfStatistics;

import java.util.Scanner;

public class BinomialDistribution1 {

    /**
     * Computes combinations
     * @param n n
     * @param k k
     * @return nCk
     */
    private static int combination(int n, int k){
        int[][] triangle = new int[n+1][n+1];

        for(int i = 0; i < n +1; i++){
            triangle[i][0] = 1;
            for(int j = 1; j < i + 1; j++){
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
        }

        return triangle[n][k];
    }

    /**
     * Calculates the binomial of a test result
     * @param n The number of tests
     * @param k The number of desirable outcome
     * @param ratioA The probability of A(desirable) occuring
     * @param ratioB The probability of B(undesirable) occuring
     * @return BINOMIALS
     */
    private static double binomial(int n, int k, double ratioA, double ratioB){
        double fullRatio = ratioA + ratioB;
        return combination(n, k) * Math.pow(ratioA / fullRatio, k) * Math.pow(ratioB / fullRatio, n-k);
    }

    /**
     * @return the probability of a family having 6 children with at least 3 boys.
     */
    private static double binomialDistribution1(double boyRatio, int childPerBirth){
        // 1 - no boi - 1 boi - 2 boi\
        double totalProb = boyRatio + 1;
        double girlRatio = totalProb - boyRatio;

        double probability = 1;
        for(int i = 0; i < 3; i++){
            probability -= binomial(6, i, boyRatio, girlRatio);
        }
        return probability;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double boyRatio = scanner.nextDouble();
        int childPerBirth = scanner.nextInt();

        System.out.println(String.format("%.3f", binomialDistribution1(boyRatio, childPerBirth)));
    }
}
