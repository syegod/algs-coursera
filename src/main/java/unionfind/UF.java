package unionfind;

import java.util.Arrays;

public class UF {
    private int[] lg;
    private int[] sz;
    private int[] id;

    public UF(int length) {
        sz = new int[length];
        id = new int[length];
        lg = new int[length];
        for (var i = 0; i < length; i++) {
            id[i] = i;
            sz[i] = 1;
            lg[i] = i;
        }
    }

    public int root(int i) {

        while (id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if (rootp == rootq) {
            return;
        }
        if (p > q) {
            lg[q] = p;
        } else {
            lg[p] = q;
        }
        if (sz[rootp] < sz[rootq]) {
            id[rootp] = rootq;
            sz[rootq] += sz[rootp];
        } else {
            id[rootq] = rootp;
            sz[rootp] += sz[rootq];
        }
    }

    public int find(int i) {
        while (i != lg[i]) {
            i = lg[lg[i]];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public String toString() {
        return Arrays.toString(id);
    }
}
