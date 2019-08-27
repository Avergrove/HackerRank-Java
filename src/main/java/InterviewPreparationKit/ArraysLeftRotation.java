package InterviewPreparationKit;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysLeftRotation {
    // Complete the rotLeft function below.
    private static int[] rotLeft(int[] a, int d) {
        List<Integer> list = IntStream.of(a).boxed().collect(Collectors.toList());
        Collections.rotate(list, -d);

        return list.stream().mapToInt(i -> i).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        scanner.close();
    }
}
