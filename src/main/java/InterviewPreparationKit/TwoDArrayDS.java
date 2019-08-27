package InterviewPreparationKit;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoDArrayDS {
    /**
     * Finds the largest hourglass sum in a 2d Array
     * @param arr Its a 2d array LOL
     * @return The largest hourglass sum
     */
    private static int hourglassSum(int[][] arr) {
        int largestHourglassSum = Integer.MIN_VALUE;

        int currentSum = 0;
        for(int i = 1; i < arr.length - 1; i++){
            for(int j = 1; j < arr[i].length - 1; j++){
                // For every hourglass core (which is the top left of each hourglass), calculate the hourglass sum
                currentSum = arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] + arr[i][j] + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];

                if(currentSum > largestHourglassSum){
                    largestHourglassSum = currentSum;
                }
            }
        }

        return largestHourglassSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        System.out.println(result);

        scanner.close();
    }
}
