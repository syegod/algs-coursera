package module7.puzzle8;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solver {

    private Board initial;
    private MinPQ<ConfigNode> pq;
    private ConfigNode solutionNode;
    private final boolean isSolvable;
    private final boolean isSolvableCalculated;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        this.initial = initial;
        this.isSolvable = isSolvable();
        this.isSolvableCalculated = true;
        if (isSolvable) {
            int moves = 0;
            pq = new MinPQ<>((a, b) -> a.priority - b.priority);
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


    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        if (isSolvableCalculated) {
            return this.isSolvable;
        }
        ArrayList<Integer> tiles = new ArrayList<>();
        for (int i = 0; i < initial.tiles.length; i++) {
            for (int j = 0; j < initial.tiles[i].length; j++) {
                if (initial.tiles[i][j] != 0) {
                    tiles.add(initial.tiles[i][j]);
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
        return inversions % 2 == 0;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return solutionNode.moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        List<Board> boards = new ArrayList<>();
        ConfigNode node = this.solutionNode;
        while (node.previous != null) {
            boards.add(node.board);
            node = node.previous;
        }
        boards.add(initial);
        return boards.reversed();
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
//        Board initial = new Board(tiles);

        int[][] arr = new int[][]{{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
        Board initial = new Board(arr);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

}