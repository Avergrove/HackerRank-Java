package TenDaysOfStatistics;

import java.util.Arrays;
import java.util.Scanner;

public class Quartiles {

    private static int median(int[] numbers){
        if(numbers.length % 2 == 1){
            return numbers[numbers.length/2];
        }

        else{
            return (numbers[numbers.length/2] + numbers[numbers.length/2 - 1]) / 2;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++){
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        if(numbers.length % 2 == 0){
            System.out.println(median(Arrays.copyOfRange(numbers, 0, numbers.length / 2)));
            System.out.println(median(numbers));
            System.out.println(median(Arrays.copyOfRange(numbers, numbers.length / 2, numbers.length)));
        }

        else {
            System.out.println(median(Arrays.copyOfRange(numbers, 0, numbers.length / 2)));
            System.out.println(median(numbers));
            System.out.println(median(Arrays.copyOfRange(numbers, numbers.length / 2 + 1, numbers.length)));
        }
    }
}
