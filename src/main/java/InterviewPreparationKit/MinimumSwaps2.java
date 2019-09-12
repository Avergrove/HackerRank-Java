package InterviewPreparationKit;

import java.util.Scanner;

public class MinimumSwaps2 {

    // We can measure the number of cycles in the array.
    // Swaps = sum of each (cycle length - 1)
    private static int minimumSwaps(int[] arr) {

        // Reduce index


        boolean[] checked = new boolean[arr.length];
        int totalSwaps = 0;

        for(int i = 0; i < arr.length; i++){
            if(!checked[i]) {
                if(arr[i] == i + 1){
                    // Do nothing, number is already in correct position
                    checked[i] = true;
                }

                else{
                    boolean isLooping = true;
                    int currIndex = i;
                    int initIndex = i;
                    int cycleLength = 0;

                    while(isLooping){
                        currIndex = arr[currIndex] - 1;
                        cycleLength++;
                        checked[currIndex] = true;

                        if(currIndex == initIndex){
                            isLooping = false;
                        }
                    }

                    totalSwaps += cycleLength - 1;
                }

                checked[i] = true;
            }
        }

        return totalSwaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        System.out.println(res);
        scanner.close();
    }
}
