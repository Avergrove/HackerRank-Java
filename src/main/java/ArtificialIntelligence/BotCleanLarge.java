package ArtificialIntelligence;

import ArtificialIntelligence.Helper.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class BotCleanLarge {


    static void next_move(int posr, int posc, int dimh, int dimw, String[] board){
        Pair megaMaidPosition = new Pair(posr, posc);
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
            int rowDiff = dirtPosition.getRow() - megaMaidPosition.getRow();
            int colDiff = dirtPosition.getCol() - megaMaidPosition.getCol();

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
        int [] pos = new int[2];
        int [] dim = new int[2];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<2;i++) dim[i] = in.nextInt();
        String board[] = new String[dim[0]];
        for(int i=0;i<dim[0];i++) board[i] = in.next();
        next_move(pos[0], pos[1], dim[0], dim[1], board);
    }
}
