package ProjectEuler;

import java.util.Arrays;
import java.util.Scanner;

public class Euler201 {

    /**
     * Finds the sum of unique subsets
     * @param m The size of the subset
     * @param values The list of values to create a subset from
     * @return The sum of the unique subsets
     */
    private static long euler201(int m, int[] values){

        Arrays.sort(values);

        // Start with the primitive implementation

        // Iterate normally
        for(int i = 0; i < values.length; i++){
            
        }

        // Pick out unique values to sum
        // CODE HERE

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int subsetSize = scanner.nextInt();

        int[] values = new int[n];

        for(int a0 = 0; a0 < n; a0++){
            values[a0] = scanner.nextInt();
        }

        System.out.println(euler201(subsetSize, values));
    }
}
