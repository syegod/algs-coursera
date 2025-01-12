package module7.puzzle8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    public int[][] tiles;
    private int[][] goalBoard;

    public Board(int[][] tiles) {
        this.tiles = tiles;
        createGoalBoard(dimension());
    }

    // string representation of this board
    public String toString() {
        StringBuilder sb = new StringBuilder("3\n");
        for (var i : tiles) {
            sb.append("[");
            for (int j = 0; j < i.length; j++) {
                sb.append(i[j]);
                if (j < i.length - 1) {
                    sb.append(",");
                }
            }
            sb.append("]\n");
        }
        return sb.toString();
    }

    // board dimension n
    public int dimension() {
        return tiles.length;
    }

    // number of tiles out of place
    public int hamming() {
        int numOfWronPos = 0;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                int v = tiles[i][j];
                if (v == 0) {
                    continue;
                }
                int targetRow = (v - 1) / tiles.length;
                int targetCol = (v - 1) % tiles.length;
                if (targetRow != i || targetCol != j) {
                    numOfWronPos++;
                }
            }
        }
        return numOfWronPos;
    }


    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int manhattan = 0;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                int v = tiles[i][j];
                if (v == 0) {
                    continue;
                }
                int targetRow = (v - 1) / tiles.length;
                int targetCol = (v - 1) % tiles.length;
                if (targetRow != i || targetCol != j) {
                    manhattan += Math.abs(targetRow - i) + Math.abs(targetCol - j);
                }
            }
        }
        return manhattan;
    }

    private void createGoalBoard(int n) {
        int[][] arr = new int[n][n];
        arr[n - 1][n - 1] = 0;
        int currNum = 1;
        for (var i = 0; i < arr.length; i++) {
            for (var j = 0; j < arr[i].length; j++) {
                if (i == arr.length - 1 && j == arr[i].length - 1) {
                    break;
                }
                arr[i][j] = currNum++;
            }
        }
        this.goalBoard = arr;
    }

    // is this board the goal board?
    public boolean isGoal() {
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                if (tiles[row][col] != this.goalBoard[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }


    // does this board equal y?
    public boolean equals(Object y) {
        if (!(y instanceof Board board)) {
            return false;
        }
        var arr = board.tiles;
        if (arr.length != tiles.length) {
            return false;
        }

        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                if (tiles[row][col] != arr[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        List<Board> neighbors = new ArrayList<>();

        int[] blankIndex = getBlankIndex();
        int blankRow = blankIndex[0], blankCol = blankIndex[1];
        int[] moves = getPossibleMoves();

        for (int i = 0; i < moves.length; i++) {
            int[][] newArr = deepCopy(tiles);
            if (i < 2) {
                exchange(newArr, blankRow + moves[i], blankCol, blankRow, blankCol);
            } else {
                exchange(newArr, blankRow, blankCol + moves[i], blankRow, blankCol);
            }
            Board newBoard = new Board(newArr);
            if (!newBoard.equals(this)) {
                neighbors.add(new Board(newArr));
            }
        }

        return neighbors;
    }

    private int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length); // Copy each row
        }
        return copy;
    }

    private void exchange(int[][] arr, int row, int col, int blankRow, int blankCol) {
        int temp = arr[row][col];
        arr[row][col] = arr[blankRow][blankCol];
        arr[blankRow][blankCol] = temp;
    }

    private int[] getPossibleMoves() {
        int n = tiles.length;
        int[] blankIndex = getBlankIndex();
        // 0 - where to move to top
        // 1 - where to move to bottom
        // 2 - where to move to left
        // 3 - where to move to right
        return new int[]{
                blankIndex[0] == 0 ? 0 : -1,
                blankIndex[0] == n - 1 ? 0 : 1,
                blankIndex[1] == 0 ? 0 : -1,
                blankIndex[1] == n - 1 ? 0 : 1
        };
    }

    private int[] getBlankIndex() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] == 0) return new int[]{i, j};
            }
        }
        return new int[]{-1};
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        return null;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        int[][] arr = new int[][]{{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
        Board board = new Board(arr);
        System.out.println(board.isGoal());
        System.out.println("real board: \n" + board + "-----------------------------------------------");

    }

}
