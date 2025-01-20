package module7.puzzle8;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayDeque;
import java.util.ArrayList;


public class Solver {

    private Board initial;
    private ConfigNode solutionNode;
    private boolean isSolvable;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }
        this.initial = initial;
        this.isSolvable = isSolvable();
        if (isSolvable) {

            int moves = 0;
            MinPQ<ConfigNode> pq = new MinPQ<>((a, b) -> a.priority - b.priority);
            ConfigNode initialNode = new ConfigNode(initial, moves, initial.manhattan(), null);
            pq.insert(initialNode);

            while (!pq.isEmpty()) {
                ConfigNode node = pq.delMin();

                if (node.board.isGoal()) {
                    this.solutionNode = node;
                    break;
                }

                moves = node.moves + 1;

                var neighbors = node.board.neighbors();
                for (var neighbor : neighbors) {
                    if (node.previous == null || !node.previous.board.equals(neighbor)) {
                        ConfigNode newNode = new ConfigNode(neighbor, moves, moves + neighbor.manhattan(), node);
                        pq.insert(newNode);
                    }
                }
            }
        }
    }


    public boolean isSolvable() {
        if (this.initial.isGoal()) {
            return true;
        }
        return isSolvableHelper(this.initial);
    }

    private boolean isSolvableHelper(Board board) {
        // Parse the string representation of the puzzle
        String puzzleString = board.toString();
        String[] lines = puzzleString.split("\n");

        int dimension = Integer.parseInt(lines[0].trim());

        ArrayList<Integer> tiles = new ArrayList<>();
        int blankRow = 0;

        for (int i = 1; i < lines.length; i++) {
            String[] numbers = lines[i].trim().split("\\s+");
            for (int j = 0; j < numbers.length; j++) {
                int value = Integer.parseInt(numbers[j]);
                if (value == 0) {
                    blankRow = i - 1;
                } else {
                    tiles.add(value);
                }
            }
        }

        int inversions = 0;
        for (int i = 0; i < tiles.size() - 1; i++) {
            for (int j = i + 1; j < tiles.size(); j++) {
                if (tiles.get(i) > tiles.get(j)) {
                    inversions++;
                }
            }
        }

        if (dimension % 2 != 0) {
            return inversions % 2 == 0;
        } else {

            if ((dimension - blankRow) % 2 == 0) {
                return inversions % 2 != 0;
            } else {
                return inversions % 2 == 0;
            }
        }
    }



    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (solutionNode == null) {
            return -1;
        }
        return solutionNode.moves;
    }

    // sequence of boards in the shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (solutionNode == null) {
            return null;
        }
        var boards = new ArrayDeque<Board>();
        ConfigNode node = this.solutionNode;
        while (node.previous != null) {
            boards.addFirst(node.board);
            node = node.previous;
        }
        boards.addFirst(initial);
        return boards;
    }

    private static class ConfigNode {
        private Board board;
        private int moves;
        private int priority;
        private ConfigNode previous;

        public ConfigNode(Board board, int moves, int priority, ConfigNode previous) {
            this.board = board;
            this.moves = moves;
            this.priority = priority;
            this.previous = previous;
        }
    }

    // test client (see below)
    public static void main(String[] args) {
        // create initial board from file
//        In in = new In(args[0]);
//        int n = in.readInt();
//        int[][] tiles = new int[n][n];
//        for (int i = 0; i < n; i++)
//            for (int j = 0; j < n; j++)
//                tiles[i][j] = in.readInt();

        int[][] tiles = new int[][]{{8,1,3},{4,0,2},{7,6,5}};
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

}