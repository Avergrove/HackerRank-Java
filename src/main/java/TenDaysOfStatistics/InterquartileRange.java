package TenDaysOfStatistics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class InterquartileRange {

    private static double mean(double[] numbers) {
        return DoubleStream.of(numbers).sum() / numbers.length;
    }

    /**
     * Finds the median in a list of number
     * @param numbers A list of numbers
     * @return The median of the lsit of nubmers
     */
    private static double median(double[] numbers){
        if(numbers.length % 2 == 0){
            return (numbers[numbers.length/2] + numbers[numbers.length/2 - 1]) / 2;
        }

        else {
            return numbers[numbers.length / 2];
        }
    }

    /**
     * Finds the Nth quartile in a range of numbers
     * @param numbers The list of numbers to search quartile in
     * @param whichQuartile The nth quartile to find (1 - 3)
     * @return The nth quartile
     */
    private static double quartile(double[] numbers, int whichQuartile){

        double quartile;

        switch (whichQuartile){

            case 1:
                quartile = median(Arrays.copyOfRange(numbers, 0, numbers.length / 2));
                break;

            case 2:
                quartile = median(numbers);
                break;

            case 3:
                if(numbers.length % 2 == 0) {
                    quartile = median(Arrays.copyOfRange(numbers, numbers.length / 2, numbers.length));
                }

                else{
                    quartile = median(Arrays.copyOfRange(numbers, numbers.length/2 + 1, numbers.length));
                }
                break;

            default:
                throw new RuntimeException(String.format("Search for quartile %d not implemented!", whichQuartile));
        }

        return quartile;
    }

    /**
     * Finds the interquartile range from a list of numbers
     * @param numbers The list of numbers
     * @return The interquartile range
     */
    private static double interquartileRange(double[] numbers){
        return quartile(numbers, 3) - quartile(numbers, 1);
    }

    /**
     * Returns the mode from a list of number
     * @param numbers A list of numbers
     * @return The mode of a list of numbers
     */
    private static double mode (double[] numbers){

        // Create a table of frequencies
        HashMap<Double, Integer> frequencies = new HashMap<>();
        for(double number : numbers){
            if(frequencies.containsKey(number)){
                frequencies.put(number, frequencies.get(number) + 1);
            }

            else{
                frequencies.put(number, 1);
            }
        }

        // Find the modal value
        double maxNumber = Double.MAX_VALUE;
        int maxCount = 0;
        for(double number : frequencies.keySet()){
            if(frequencies.get(number) == maxCount && number < maxNumber){
                maxNumber = number;
            }

            else if(frequencies.get(number) > maxCount){
                maxNumber = number;
                maxCount = frequencies.get(number);
            }
        }

        return maxNumber;
    }

    private static double standardDeviation(double[] numbers, double mean) {

        double variance = DoubleStream.of(numbers).map(x -> x - mean).map(x -> x * x).sum() / numbers.length;
        return Math.sqrt(variance);
    }

    /**
     * Flattens a list of values and frequencies into a single array.
     * @param numbers The list of numbers
     * @param frequencies The list of frequencies corresponding to their values respectively
     * @return A flattened and sorted list populated with frequency numbers of value.
     */
    private static double[] flatten(double[] numbers, int[] frequencies){
        double[] flattened = new double[IntStream.of(frequencies).sum()];
        int index = 0;
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < frequencies[i]; j++){
                flattened[index] = numbers[i];
                index++;
            }
        }

        Arrays.sort(flattened);

        return flattened;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] numbers = new double[n];
        int[] frequencies = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextDouble();
        }

        for(int i = 0; i <n ;i++){
            frequencies[i] = scanner.nextInt();
        }

        double[] values = flatten(numbers, frequencies);
        System.out.println(String.format("%.1f", interquartileRange(values)));
    }
}
