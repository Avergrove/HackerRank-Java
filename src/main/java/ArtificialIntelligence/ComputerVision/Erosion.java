package ArtificialIntelligence.ComputerVision;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

// TODO: Fix issues
public class Erosion {

    /**
     * Erodes a map by 1-pixel
     *
     * @param map Map to erode
     */
    private static String[] erode(String[] map) {

        String[] copyMap = copyOf(map);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length(); j++) {

                adjacentCheck:
                // Check adjacent tiles
                for (int a = -1; a < 2; a++) {
                    for (int b = -1; b < 2; b++) {
                        if ((i + a > -1 && i + a < map.length) &&
                                (j + b > -1 && j + b < map[i].length()) &&
                                (a != 0 && b != 0) &&
                                map[i + a].charAt(j + b) == '0') {
                            StringBuilder builder = new StringBuilder(map[i]);
                            builder.replace(j, j + 1, "0");
                            copyMap[i] = builder.toString();

                            break adjacentCheck;
                        }
                    }
                }
            }
        }

        return copyMap;
    }

    /**
     * Counts the number of 1s on a 2d int map
     */
    private static int count1s(String[] map) {
        int oneCount = 0;

        for (String row : map) {
            for (char c : row.toCharArray()) {
                if (c == '1') {
                    oneCount++;
                }
            }
        }
        return oneCount;
    }

    private static String[] copyOf(String[] toCopy) {
        String[] result = new String[toCopy.length];

        for (int i = 0; i < toCopy.length; i++) {
            result[i] = String.copyValueOf(toCopy[i].toCharArray());
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        final int HEIGHT = 3;
        String[] map = new String[HEIGHT];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < HEIGHT; i++) {
            map[i] = reader.readLine();
        }


        String[] copyMap = erode(map);
        System.out.println(count1s(copyMap));

        reader.close();
    }
}
