package ArtificialIntelligence;

import ArtificialIntelligence.Helper.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class BotClean {
    private static void next_move(int posr, int posc, String[] board) {
        Pair markZoidPosition = new Pair(posr, posc);
        ArrayList<Pair> dirtPositions = new ArrayList<>();

        // Search for player and princess position
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'd') {
                    dirtPositions.add(new Pair(i, j));
                }
            }
        }

        // Get reference to the nearest dirt pile
        int rowMinDiff = Integer.MAX_VALUE / 2;
        int colMinDiff = Integer.MAX_VALUE / 2;

        for (Pair dirtPosition : dirtPositions) {
            int rowDiff = dirtPosition.getRow() - markZoidPosition.getRow();
            int colDiff = dirtPosition.getCol() - markZoidPosition.getCol();

            if (Math.abs(rowDiff) + Math.abs(colDiff) < Math.abs(rowMinDiff) + Math.abs(colMinDiff)) {
                rowMinDiff = rowDiff;
                colMinDiff = colDiff;
            }
        }

        if (rowMinDiff == 0 && colMinDiff == 0) {
            System.out.println("CLEAN");
        } else {
            if (rowMinDiff > 0) {
                System.out.println("DOWN");
            } else if (rowMinDiff < 0) {
                System.out.println("UP");
            } else if (colMinDiff > 0) {
                System.out.println("RIGHT");
            } else if (colMinDiff < 0) {
                System.out.println("LEFT");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] pos = new int[2];
        String[] board = new String[5];
        for (int i = 0; i < 2; i++) pos[i] = in.nextInt();
        for (int i = 0; i < 5; i++) board[i] = in.next();
        next_move(pos[0], pos[1], board);
    }
}
