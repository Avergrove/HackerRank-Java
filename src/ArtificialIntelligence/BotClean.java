package ArtificialIntelligence;

import java.util.Scanner;

public class BotClean {
    static void next_move(int posr, int posc, String[] board){
        //add logic here
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        String board[] = new String[5];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<5;i++) board[i] = in.next();
        next_move(pos[0], pos[1], board);
    }
}
