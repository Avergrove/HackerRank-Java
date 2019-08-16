package Algorithms;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /**
     * Computes ways to return unit n using c coins.
     * @param n The total amount of unit to return
     * @param c The types of coins available
     * @return The number of ways to return n units with coins of types c
     */
    static long getWays(int n, List<Long> c) {
        // Write your code here

    }

}

public class TheCoinChangeProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = Result.getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
