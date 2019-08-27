package TenDaysOfStatistics;

import java.util.Scanner;
import java.util.stream.IntStream;

public class WeightedMean {

    private static double weightedMean(int[] numbers, int[] weights){

        int weightSum = IntStream.of(weights).sum();
        int valueSum = 0;

        for(int i = 0; i < numbers.length; i++){
            valueSum += numbers[i] * weights[i];
        }

        return (double) valueSum / weightSum;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] weights = new int[n];
        int[] numbers = new int[n];

        for(int i = 0; i < n; i++){
            numbers[i] = scanner.nextInt();
        }

        for(int i = 0; i < n; i++){
            weights[i] = scanner.nextInt();
        }

        scanner.close();

        System.out.println(String.format("%.1f", weightedMean(numbers, weights)));
    }
}
