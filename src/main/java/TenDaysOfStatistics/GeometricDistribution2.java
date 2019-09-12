package TenDaysOfStatistics;

import java.util.Scanner;

public class GeometricDistribution2 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double failureNumerator = scanner.nextInt();
        double failureDenominator = scanner.nextInt();
        int n = scanner.nextInt();

        System.out.println(String.format("%.3f", geometricDistribution2(failureNumerator, failureDenominator, n)));
    }

    private static double geometricDistribution2(double failureNumerator, double denominator, int n){

        // Question can be rephrased into "at least 1 defect is in first 5 tries"
        // 1 - no defective ones
        double successNumerator = denominator - failureNumerator;

        double probabilityOfNConsecutiveSuccesses = Math.pow(successNumerator / denominator, n);
        return 1 - probabilityOfNConsecutiveSuccesses;
    }
}
