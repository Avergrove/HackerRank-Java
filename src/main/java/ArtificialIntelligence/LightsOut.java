package ArtificialIntelligence;

import java.util.Scanner;

// It doesn't matter which lightbulb you pick, the outcome of the game is decided by the initial state of the board.
public class LightsOut {
    static void nextMove(int player, String [] board){
        checkLoop:
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                if(board[i].charAt(j) == '1'){
                    System.out.println(String.format("%d %d", i, j));
                    break checkLoop;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int player;
        String[] board = new String[8];

        //If player is 1, I'm the first player.
        //If player is 2, I'm the second player.
        player = in.nextInt();

        //Read the board now. The board is a 8x8 array filled with 1 or 0.
        for(int i = 0; i < 8; i++) {
            board[i] = in.next();
        }

        nextMove(player,board);

    }
}
