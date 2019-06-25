package main;

import java.util.Arrays;

public class IsingModel {

    // Check if a board constellation is valid
    public static boolean isValid(boolean[] board, int n) {
        // Iterate over all positions on the board
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                // If a position is occupied: check for its neighbors
                if (board[x * n + y] == true) {
                    // If the up-field exists, check if occupied
                    if (x != 0) {
                        if (board[(x - 1) * n + y] == true) {
                            return false;
                        }
                    }
                    // If the down-field exists, check if occupied
                    if (x != n - 1) {
                        if (board[(x + 1) * n + y] == true) {
                            return false;
                        }
                    }
                    // If the left-field exists, check if occupied
                    if (y != 0) {
                        if (board[x * n + (y - 1)] == true) {
                            return false;
                        }
                    }
                    // If the right-field exists, check if occupied
                    if (y != n - 1) {
                        if (board[x * n + (y + 1)] == true) {
                            return false;
                        }
                    }
                }
            }
        }

        // The board does not contain any neighboring stones and is therefore valid
        return true;
    }

    private static int numStones(boolean[] board) {
        int i = 0;
        for (boolean b : board
        ) {
            i += (b)? 1 : 0 ;
        }
        return i;
    }

    // TODO 8.4.a) Implement the method countPossibilities()
    public static int countPossibilities(int stoneCount, int n, int startX, boolean[] boardLast) {
        int poss = 0;
        boolean[] board = Arrays.copyOf(boardLast, boardLast.length);
        if (startX == board.length ) {
            System.out.println(Arrays.toString(board));
            return (numStones(boardLast) == stoneCount && isValid(board, n)) ? 1 : 0;
        }

        boardLast[startX] = false;
        poss += countPossibilities(stoneCount, n, startX + 1, boardLast);


        boardLast[startX] = true;
        poss += countPossibilities(stoneCount, n, startX + 1, boardLast);

        return poss;
    }

    // TODO 8.4.b) Implment the method possibleConstellations()
    // Compute the number of valid possible constellations for a board of size n x n
    public static int possibleConstellations(int n) {
        int counter = 0;
        for ( int i = 0 ; i <= n*n ; i++){
            counter += countPossibilities(i, n , 0, new boolean[n * n]);
        }
        return counter;
    }

    public static void main(String[] args) {
        boolean[] example1 = {false, false, false, false, true, true, true, false, false};
        boolean[] example2 = {true, false, true, false, true, false, true, false, false};

        System.out.println(isValid(example1, 3));
        System.out.println(isValid(example2, 3));

        int n = 2; // Size of the board
        // results: 0 => 0; 1 => 2; 2 => 7; 3 => 63; 4 => 1234; 5 => 55447

        System.out.println(
                "Valid constellations for a board of size " + n + " x " + n + ": " + possibleConstellations(n));
    }
}
