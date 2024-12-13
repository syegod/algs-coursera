package unionfind.percolation;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class PercolationStats {
    private int[] allSims;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        allSims = new int[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            int count = 0;
//            while (!percolation.percolates()) {
            while (count < 10000) {
                count++;
//                int randomIndex = 1;
                int randomIndex = StdRandom.uniformInt(1, n * n) - 1;
                int row = randomIndex / n;
                int col = randomIndex % n;
                percolation.open(row, col);
            }
            allSims[i] = percolation.numberOfOpenSites();
            System.out.println(percolation);
        }
    }
//
//    // sample mean of percolation threshold
//    public double mean() {}
//
//    // sample standard deviation of percolation threshold
//    public double stddev() {}
//
//    // low endpoint of 95% confidence interval
//    public double confidenceLo() {}
//
//    // high endpoint of 95% confidence interval
//    public double confidenceHi() {}

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats stats = new PercolationStats(5, 1);

    }

}