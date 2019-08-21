package ArtificialIntelligence.Helper;

import java.util.Objects;

public class Pair{
    private int row;
    private int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return row == pair.row &&
                col == pair.col;
    }

    /**
     * Returns a new pair instance that is the subtraction of p1 and p2
     * @param p1 The pair to be subtracted from
     * @param p2 The pair to subtract with
     */
    public static Pair subtract(Pair p1, Pair p2){
        return new Pair(p1.getRow() - p2.getRow(), p1.getCol() - p2.getCol());
    }
}