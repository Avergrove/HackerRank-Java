package TenDaysOfStatistics;

import java.util.Scanner;

public class PoissonDistribution1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double mean = scanner.nextDouble();
        int n = scanner.nextInt();

        System.out.println(String.format("%.3f", poissonDistribution(mean, n)));

        scanner.close();
    }

    private static double poissonDistribution(double average, int k){
        return Math.pow(average, k) * Math.exp(-average) / factorial(k);
    }

    private static int factorial(int k){

        int result = 1;
        for(int i = 1; i <= k; i++){
            result *= i;
        }

        return result;
    }
}
