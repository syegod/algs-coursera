package module1.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Arrays;

public class Percolation {
    private boolean isPercolates;
    private WeightedQuickUnionUF uf;
    private int openSites = 0;
    private int[][] grid;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        uf = new WeightedQuickUnionUF(n * 2);
        grid = new int[n][n];
        for (var i = 0; i < n; i++) {
            int[] arr = new int[n];
            for (var j = 0; j < n; j++) {
                arr[j] = 0;
            }
            grid[i] = arr;
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            grid[row][col] = 1;
            openSites++;
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return grid[row][col] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return openSites == grid.length* grid.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var i : grid) {
            sb.append(Arrays.toString(i) + "\n");
        }
        return sb.toString();
    }
}
