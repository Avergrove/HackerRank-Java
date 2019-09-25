package ProblemSolving.GameTheory;

import java.util.Scanner;

public class AChessboardGame {

    // Complete the chessboardGame function below.
    private static String chessboardGame(int x, int y) {

        int xShift = x - 1;
        int yShift = y - 1;

        String result = null;
        if(xShift % 4 < 2 && yShift % 4 < 2){
            return "Second";
        }

        else{
            return "First";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] xy = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xy[0]);

            int y = Integer.parseInt(xy[1]);

            String result = chessboardGame(x, y);
            System.out.println(result);
        }

        scanner.close();
    }
}
