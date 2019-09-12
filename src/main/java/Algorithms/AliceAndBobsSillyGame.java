package Algorithms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class AliceAndBobsSillyGame {


    static String sillyGame(int n) {
        /*
         * Write your code here.
         */
        boolean[] isPrimeList = new boolean[n+1];
        Arrays.fill(isPrimeList, true);

        for(int i = 2; i < n + 1; i++){
            if(isPrimeList[i]){
                for(int j = 2 * i; j < n + 1; j += i){
                    isPrimeList[j] = false;
                }
            }
        }

        // Check whether there is even or odd number of primes
        int primeCount = 0;
        for (boolean b : isPrimeList) {
            if (b) {
                primeCount++;
            }
        }

        if(primeCount % 2 == 0){
            return "Bob";
        }

        else{
            return "Alice";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            String result = sillyGame(n);

            System.out.println(result);
        }
    }
}
