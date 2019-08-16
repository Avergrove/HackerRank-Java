package ArtificialIntelligence;

import ArtificialIntelligence.Helper.Pair;

import java.util.Scanner;

// Problem statement: https://www.hackerrank.com/challenges/saveprincess?hr_b=1
public class BotSavesPrincess {

    private static void displayPathtoPrincess(int n, String[] grid) {
        Pair playerPosition = new Pair(-1, -1);
        Pair princessPosition = new Pair(-1, -1);

        // Search for player and princess position
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                switch (grid[i].charAt(j)){
                    case 'm':
                        playerPosition = new Pair(j, i);
                        break;

                    case 'p':
                        princessPosition = new Pair(j,i);
                        break;

                    default:
                        break;
                }
            }
        }

        // Find the wae to the princess
        int xDiff = princessPosition.getX() - playerPosition.getX();
        int yDiff = princessPosition.getY() - playerPosition.getY();

        while(xDiff != 0 || yDiff != 0){
            if(xDiff > 0){
                System.out.println("RIGHT");
                xDiff--;
            }

            else if(xDiff < 0){
                System.out.println("LEFT");
                xDiff++;
            }

            if(yDiff > 0){
                System.out.println("DOWN");
                yDiff--;
            }

            else if(yDiff < 0){
                System.out.println("UP");
                yDiff++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String[] grid = new String[m];
        for (int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

        displayPathtoPrincess(m, grid);
    }
}