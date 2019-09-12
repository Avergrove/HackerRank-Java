package Algorithms;

import java.util.Scanner;

public class KingdomDivision {

    // Complete the kingdomDivision function below.
    private static int kingdomDivision(int n, int[][] roads) {
        Graph graph = new Graph(n, roads);

        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] roads = new int[n-1][2];

        for (int i = 0; i < n-1; i++) {
            String[] roadsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int roadsItem = Integer.parseInt(roadsRowItems[j]);
                roads[i][j] = roadsItem;
            }
        }

        int result = kingdomDivision(n, roads);

        System.out.println(result);

        scanner.close();
    }


}

class Graph{
    private boolean[][] adjMatrix;

    Graph(int n, int[][] edges) {
        this.adjMatrix = new boolean[n][n];

        for(int i = 0; i < edges.length; i++){
            for(int j = 0; j < edges.length; j++){
                adjMatrix[i][j] = true;
            }
        }
    }

    public boolean[][] getAdjMatrix() {
        return adjMatrix;
    }
}