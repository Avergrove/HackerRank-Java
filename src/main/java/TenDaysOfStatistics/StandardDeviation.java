package TenDaysOfStatistics;

import java.util.Scanner;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StandardDeviation {

    private static double mean(double[] numbers) {
        return DoubleStream.of(numbers).sum() / numbers.length;
    }

    private static double standardDeviation(double[] numbers, double mean) {

        double variance = DoubleStream.of(numbers).map(x -> x - mean).map(x -> x * x).sum() / numbers.length;
        return Math.sqrt(variance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] numbers = new double[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextDouble();
        }

        double mean = mean(numbers);
        double standardDeviation = standardDeviation(numbers, mean);
        System.out.println(String.format("%.1f", standardDeviation));
    }
}
