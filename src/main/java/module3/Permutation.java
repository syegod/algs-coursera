package module3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;


public class Permutation {
    public static void main(String[] args) {
        String arg1 = args[0];
        int k = Integer.parseInt(arg1);
        var randQ = new RandomizedQueue<String>();
        String str;
        while ((str = StdIn.readString()) != null) {
            randQ.enqueue(str);
        }
        var iter = randQ.iterator();
        int count = 0;
        while (iter.hasNext() && count < k) {
            System.out.println(iter.next());
        }

    }
}
