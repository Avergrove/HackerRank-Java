package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BirthdayChocolate {

    /**
     * Finds the number of ways to share Ron's chocolate such that there are m chocolate where sum of those chocolate is d
     * @param s The numbers on each chocolate
     * @param d Ron's birth day
     * @param m Ron's birth month
     * @return The number of ways to share chocolate
     */
    static int birthday(List<Integer> s, int d, int m) {
        int numberOfWays = 0;

        for(int i = 0; i < s.size() - m + 1; i++){
            int sum = 0;
            for(int j = 0; j < m; j++){
                sum += s.get(i + j);
            }

            if(sum == d){
                numberOfWays++;
            }
        }

        return numberOfWays;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        System.out.println(result);

        bufferedReader.close();
    }
}
