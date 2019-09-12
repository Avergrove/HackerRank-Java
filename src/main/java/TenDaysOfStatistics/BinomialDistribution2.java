package TenDaysOfStatistics;

import java.util.Scanner;

public class BinomialDistribution2 {
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
     * @return the probability of a a batch of n pistons having no more than 2 defects.
     */
    private static double binomialDistribution2a(double faultProbability, int n){
        // No reject + 1 reject + 2 reject
        double probability = 0;
        for(int i = 0; i < 3; i++){
            probability += binomial(n, i, faultProbability, 1-faultProbability);
        }
        return probability;
    }

    /**
     * @return the probability of a a batch of n pistons having at least 2 defects.
     */
    private static double binomialDistribution2b(double faultProbability, int n){
        // 1 - no defect - 1 defect
        double probability = 1;
        for(int i = 0; i < 2; i++){
            probability -= binomial(n, i, faultProbability, 1-faultProbability);
        }
        return probability;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double faultProbability = scanner.nextDouble() / 100;
        int sampleSize = scanner.nextInt();

        System.out.println(String.format("%.3f", binomialDistribution2a(faultProbability, sampleSize)));
        System.out.println(String.format("%.3f", binomialDistribution2b(faultProbability, sampleSize)));
    }
}
