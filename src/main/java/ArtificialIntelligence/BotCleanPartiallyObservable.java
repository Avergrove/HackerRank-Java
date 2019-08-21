package ArtificialIntelligence;

import ArtificialIntelligence.Helper.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BotCleanPartiallyObservable {


    private static void next_move(int posr, int posc, int dimh, int dimw, String[] board) {
        Pair megaMaidPosition = new Pair(posr, posc);
        ArrayList<Pair> dirtPositions = new ArrayList<>();
        ArrayList<Pair> unknownPositions = new ArrayList<>();

        // Search for player and princess position
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'd') {
                    dirtPositions.add(new Pair(i, j));
                }

                else if (board[i].charAt(j) == 'o'){
                    unknownPositions.add(new Pair(i, j));
                }
            }
        }

        // Get reference to the nearest dirt pile and unknown
        Pair nearestDirtPile = getPositionOfNearestPOI(megaMaidPosition, dirtPositions);
        Pair nearestUnknownPosition = getPositionOfNearestPOI(megaMaidPosition, unknownPositions);

        // Visit the nearest dirt pile if available, otherwise, go exploring.
        Pair destination = nearestDirtPile != null ? nearestDirtPile : nearestUnknownPosition;
        Pair distance = Pair.subtract(destination, megaMaidPosition);

        if (distance.getRow() == 0 && distance.getCol() == 0) {
            System.out.println("CLEAN");
        } else {
            if (distance.getRow() > 0) {
                System.out.println("DOWN");
            } else if (distance.getRow() < 0) {
                System.out.println("UP");
            } else if (distance.getCol() > 0) {
                System.out.println("RIGHT");
            } else if (distance.getCol() < 0) {
                System.out.println("LEFT");
            }
        }
    }

    /**
     * Looks for the position of the nearest POI (Point of Interest)
     * @param botPosition The position of the bot
     * @param poiPositions A list of Points of interests to look at.
     * @return The position of the nearest dirt pile
     */
    private static Pair getPositionOfNearestPOI(Pair botPosition, ArrayList<Pair> poiPositions){
        // Get reference to the nearest dirt pile
        int rowMinDiff = Integer.MAX_VALUE / 2;
        int colMinDiff = Integer.MAX_VALUE / 2;

        Pair nearestPoi = null;

        for (Pair poiPosition : poiPositions) {
            int rowDiff = poiPosition.getRow() - botPosition.getRow();
            int colDiff = poiPosition.getCol() - botPosition.getCol();

            if (Math.abs(rowDiff) + Math.abs(colDiff) < Math.abs(rowMinDiff) + Math.abs(colMinDiff)) {
                rowMinDiff = rowDiff;
                colMinDiff = colDiff;
                nearestPoi = poiPosition;
            }
        }

        return nearestPoi;
    }



    private static String[] loadMap(int dimH, int dimW) throws IOException {

        String[] returnBoard;

        File file = new File("temp/map.txt");
        if(file.exists()) {
            Scanner scanner = new Scanner(file);

            ArrayList<String> tempBoard = new ArrayList<>();

            while (scanner.hasNextLine()) {
                tempBoard.add(scanner.nextLine());
            }
            returnBoard = tempBoard.toArray(new String[0]);
        }

        else{
            // Return a blank slate if file does not exist... yet.
            returnBoard = new String[dimH];
            for(int i = 0; i < dimH; i++){
                StringBuilder builder = new StringBuilder();
                for(int j = 0; j < dimW; j++) {
                    builder.append("o");
                }
                returnBoard[i] = builder.toString();
            }
        }

        return returnBoard;
    }

    private static void updateMap(String[] board, String[] newData) {
        for (int i = 0; i < newData.length; i++) {
            StringBuilder builder = new StringBuilder(board[i]);
            for (int j = 0; j < newData[i].length(); j++) {
                if (newData[i].charAt(j) != 'o') {
                    builder.setCharAt(j, newData[i].charAt(j));
                }
            }
            board[i] = builder.toString();
        }
    }

    private static void saveMap(String[] board) {
        File mapFile = new File("temp/map.txt");
        try {
            FileWriter fileWriter = new FileWriter(mapFile, false);
            for (String s : board) {
                fileWriter.write(s);
                fileWriter.write("\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    static void nextMove(int player, String [] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                if(board[i].charAt(j) == '1'){
                    System.out.println(String.format("%d %d", i, j));
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int[] pos = new int[2];
        int[] dim = new int[2];

        // Our provided input is always 5x5
        dim[0] = 5;
        dim[1] = 5;

        for (int i = 0; i < 2; i++) pos[i] = in.nextInt();

        // Convert currently observable map into data
        String[] perceivedBoard = new String[dim[0]];
        for (int i = 0; i < dim[0]; i++) {
            perceivedBoard[i] = in.next();
        }

        String[] board = loadMap(dim[0], dim[1]);
        updateMap(board, perceivedBoard);
        next_move(pos[0], pos[1], dim[0], dim[1], board);
        saveMap(board);
    }
}
