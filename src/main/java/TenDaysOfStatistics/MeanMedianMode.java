package TenDaysOfStatistics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.LongStream;

public class MeanMedianMode {

    private static double mean(long[] numbers){
        return (double) LongStream.of(numbers).sum() / (double) numbers.length;
    }

    private static double median(long[] numbers){
        if(numbers.length % 2 == 0){
            return ((double) numbers[numbers.length/2] + (double) numbers[numbers.length/2 - 1]) / 2;
        }

        else {
            return numbers[numbers.length / 2];
        }
    }

    private static long mode (long[] numbers){

        // Create a table of frequencies
        HashMap<Long, Integer> frequencies = new HashMap<>();
        for(long number : numbers){
            if(frequencies.containsKey(number)){
                frequencies.put(number, frequencies.get(number) + 1);
            }

            else{
                frequencies.put(number, 1);
            }
        }

        // Find the modal value
        long maxNumber = Long.MAX_VALUE;
        int maxCount = 0;
        for(long number : frequencies.keySet()){
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

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        int inputCount = scanner.nextInt();
        long[] numbers = new long[inputCount];
        for(int i = 0; i < inputCount; i++){
            numbers[i] = scanner.nextLong();
        }
        scanner.close();

        Arrays.sort(numbers);

        System.out.println(String.format("%.1f", mean(numbers)));
        System.out.println(String.format("%.1f", median(numbers)));
        System.out.println(mode(numbers));

    }
}