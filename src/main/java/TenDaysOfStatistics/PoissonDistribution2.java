package TenDaysOfStatistics;

import java.util.Scanner;

public class PoissonDistribution2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double meanA = scanner.nextDouble();
        double meanB = scanner.nextDouble();

        System.out.println(String.format("%.3f", poissonDistribution2(meanA, 160, 40)));
        System.out.println(String.format("%.3f", poissonDistribution2(meanB, 128, 40)));

        scanner.close();
    }

    private static double poissonDistribution2(double mean, int shift, int k){
        return shift + k * (mean + Math.pow(mean, 2));
    }
}
