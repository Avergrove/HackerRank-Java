package ArtificialIntelligence;

import java.util.Scanner;

public class BiddingTicTacToe {
    static void next_move(String player, int[] first_player_bids, int [] second_player_bids, String [] board, String move) {
        int firstPlayerFund;
        int secondPlayerFund;

        switch(move){
            case "BID":

                break;

            default:
                break;
        }
    }

    static int getBestBid(int playerOnefund, int playerTwoFund){
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String player = in.next();                     //1 if first player 2 if second
        String move = in.next();
        int bid = 0;                                   //Amount bid by the player
        int[] first_player_bids = new int[100];
        int[] second_player_bids = new int[100];
        String [] board = new String[3];
        in.useDelimiter("\\n");
        String first_move = in.next();
        String[] move_1 = first_move.split(" ");
        String second_move = in.next();
        String[] move_2= second_move.split(" ");
        for(int i=0;i<3;i++) {
            board[i] = in.next();
        }
        if(!first_move.equals("")) {
            for (int i=0;i<move_1.length;i++) {
                first_player_bids[i] = Integer.parseInt(move_1[i]);
            }
        }
        if(!second_move.equals("")) {
            for (int i=0;i<move_2.length;i++) {
                second_player_bids[i] = Integer.parseInt(move_2[i]);
            }
        }
        next_move(player, first_player_bids, second_player_bids, board, move);
    }
}
