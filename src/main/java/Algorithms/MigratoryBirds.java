package Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MigratoryBirds {

    // BIRDS
    private static int migratoryBirds(List<Integer> arr) {
        int[] sightings = new int[6];

        for(Integer birdId : arr){
            sightings[birdId]++;
        }

        int idWithMostSighting = 0;
        for(int i = 0; i < sightings.length; i++){
            if(sightings[i] > sightings[idWithMostSighting]){
                idWithMostSighting = i;
            }
        }

        return idWithMostSighting;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arrCount = scanner.nextInt();

        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < arrCount; i++){
            arr.add(scanner.nextInt());
        }

        int result = migratoryBirds(arr);

        System.out.println(result);

        scanner.close();
    }


}
