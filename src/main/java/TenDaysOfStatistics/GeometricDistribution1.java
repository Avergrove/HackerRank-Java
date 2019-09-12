package TenDaysOfStatistics;

import java.util.Scanner;

public class GeometricDistribution1 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double failureNumerator = scanner.nextInt();
        double failureDenominator = scanner.nextInt();
        int defectOnN = scanner.nextInt();

        System.out.println(String.format("%.3f", geometricDistribution1(failureNumerator, failureDenominator, defectOnN)));
    }

    /**
     * Finds the probability of event failing on sample N
     * @param failureNumerator failureNumerator of probability of failure
     * @param denominator denominator of probability of failure
     * @param n Which N to fail on, to conclude sample result.
     * @return Probability of test finally failing on N
     */
    private static double geometricDistribution1(double failureNumerator, double denominator, int n){

        // n-1 successes, followed by 1 failure.
        double successNumerator = denominator - failureNumerator;

        double probabilityOfNConsecutiveSuccesses = Math.pow(successNumerator / denominator, n-1);
        double probabilityOfFailure = failureNumerator / denominator;

        return probabilityOfNConsecutiveSuccesses * probabilityOfFailure;
    }
}
