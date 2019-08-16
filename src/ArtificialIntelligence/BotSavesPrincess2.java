package ArtificialIntelligence;

import ArtificialIntelligence.Helper.Pair;

import java.awt.geom.Point2D;
import java.util.Scanner;

public class BotSavesPrincess2 {

    private static void nextMove(int n, int r, int c, String[] grid) {
        Pair playerPosition = new Pair(-1, -1);
        Pair princessPosition = new Pair(-1, -1);

        // Search for player and princess position
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                switch (grid[i].charAt(j)) {
                    case 'm':
                        playerPosition = new Pair(j, i);
                        break;

                    case 'p':
                        princessPosition = new Pair(j, i);
                        break;

                    default:
                        break;
                }
            }
        }

        // Find the wae to the princess
        int xDiff = princessPosition.getX() - playerPosition.getX();
        int yDiff = princessPosition.getY() - playerPosition.getY();

        if (xDiff > 0) {
            System.out.println("RIGHT");
        } else if (xDiff < 0) {
            System.out.println("LEFT");
        } else if (yDiff > 0) {
            System.out.println("DOWN");
        } else if (yDiff < 0) {
            System.out.println("UP");
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, r, c;
        n = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        in.useDelimiter("\n");
        String[] grid = new String[n];


        for (int i = 0; i < n; i++) {
            grid[i] = in.next();
        }

        nextMove(n, r, c, grid);

    }
}