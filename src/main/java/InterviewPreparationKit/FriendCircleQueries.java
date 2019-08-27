package InterviewPreparationKit;

import java.util.*;

// TODO: fix issues
public class FriendCircleQueries {

    /**
     * Finds the biggest circle of frands.
     *
     * @param queries queries [i][j] where i represents query Number and j represents handshaker index
     * @return The biggest friend circle.
     */
    private static int[] maxCircle(int[][] queries) {
        ArrayList<Set<Integer>> friendCircles = new ArrayList<>();
        int[] largestCirclesize = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            handshake(friendCircles, queries[i][0], queries[i][1]);
            if (friendCircles.size() == 1) {
                largestCirclesize[i] = friendCircles.get(0).size();
            } else {
                largestCirclesize[i] = Collections.max(friendCircles, new FriendCircleComparator()).size();
            }
        }

        return largestCirclesize;
    }

    private static void handshake(ArrayList<Set<Integer>> friendCircles, int handshaker, int handshook) {
        Set<Integer> friendCircle1 = getFriendCircleWithIndividual(friendCircles, handshaker);
        Set<Integer> friendCircle2 = getFriendCircleWithIndividual(friendCircles, handshook);

        friendCircle1.addAll(friendCircle2);
        friendCircles.remove(friendCircle2);
    }

    /**
     * Checks if there is a friend circle including indiv, if there is none, a new one is created with indiv in it.
     *
     * @param indiv The individual to look for
     * @return The friend circle with indiv in it.
     */
    private static Set<Integer> getFriendCircleWithIndividual(ArrayList<Set<Integer>> friendCircles, int indiv) {
        // Check if a friend circle exists for both handshakers
        Set<Integer> indivCircle = null;
        for (Set<Integer> friendCircle : friendCircles) {
            if (friendCircle.contains(indiv)) {
                indivCircle = friendCircle;
            }
        }

        if (indivCircle == null) {
            indivCircle = new HashSet<>();
            indivCircle.add(indiv);
            friendCircles.add(indivCircle);
        }

        return indivCircle;
    }

    private static class FriendCircleComparator implements Comparator<Set> {
        @Override
        public int compare(Set o1, Set o2) {
            return o1.size() - o2.size();
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] queries = new int[q][2];

        for (int i = 0; i < q; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        int[] ans = maxCircle(queries);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);

            if (i != ans.length - 1) {
                System.out.println();
            }
        }

        System.out.println();

        scanner.close();
    }
}
