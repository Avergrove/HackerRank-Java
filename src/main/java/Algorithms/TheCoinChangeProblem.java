package Algorithms;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /**
     * Computes ways to return unit n using c coins.
     *
     * @param n The total amount of unit to return
     * @param c The types of coins available
     * @return The number of ways to return n units with coins of types c
     */
    static long getWays(int n, List<Integer> c) {

        int[] waysToMakeN = new int[n+1];
        waysToMakeN[0] = 1;

        for(int value : c){
            for(int i = 0; i < n + 1; i++){
                if(value <= i) {
                    waysToMakeN[i] += waysToMakeN[i - value];
                }
            }
        }

        return waysToMakeN[n];
    }

}

public class TheCoinChangeProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = Result.getWays(n, c);

        System.out.println(ways);

        bufferedReader.close();
    }
}
