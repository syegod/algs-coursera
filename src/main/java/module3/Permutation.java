package module3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {
    public static void main(String[] args) {
        String arg1 = args[0];
        int k = Integer.parseInt(arg1);
        String str = StdIn.readLine();
        var arr = str.split("\s+");
        StdRandom.shuffle(arr);
        int count = 0;
        while (count < k) {
            System.out.println(arr[count++]);
        }
    }
}
