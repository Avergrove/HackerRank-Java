package InterviewPreparationKit;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Primality {
    // Complete the primality function below.
    private static String primality(int n) {

        // Problem definition of not prime for 0 and 1
        if (n < 2) {
            return "Not prime";
        } else if (n == 2) {
            return "Prime";
        } else if (n % 2 == 0) {
            return "Not prime";
        } else {
            // We only need to check up to and including square root of n, due to how multiplication mirrors itself
            for (int i = 3; i <= Math.sqrt(n); i += 2) {
                if (n % i == 0) {
                    return "Not prime";
                }
            }
            return "Prime";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int pItr = 0; pItr < p; pItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = primality(n);

            System.out.println(result);
        }

        scanner.close();
    }
}
