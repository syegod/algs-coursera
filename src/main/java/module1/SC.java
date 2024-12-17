package module1;

import java.util.Arrays;

public class SC {
    private int[] id;
    private int[] sz;
    private Log[] logs;
    private int groups;

    public SC(int members, Log[] logs) {
        this.logs = logs;
        groups = members;
        id = new int[members];
        sz = new int[members];
        for (int i = 0; i < members; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public long earliest() {
        for (int i = 0; i < logs.length; i++) {
            union(logs[i].id1, logs[i].id2);
            if (groups == 1) {
                return logs[i].timeStamp;
            }
        }
        return -1L;
    }

    private void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i != j) {
            if (sz[i] < sz[j]) {
                id[i] = j;
                sz[j] += sz[i];
            } else {
                id[j] = i;
                sz[i] += sz[j];
            }
            groups--;
        }
    }


    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }


    @Override
    public String toString() {
        return "SC{" +
                "groups=" + groups +
                ", id=" + Arrays.toString(id) +
                ", sz=" + Arrays.toString(sz) +
                '}';
    }

    public static class Log {
        long timeStamp;
        int id1, id2;

        public Log(long timeStamp, int id1, int id2) {
            this.timeStamp = timeStamp;
            this.id1 = id1;
            this.id2 = id2;
        }

        @Override
        public String toString() {
            return "Log{" +
                    "timeStamp=" + timeStamp +
                    ", id1=" + id1 +
                    ", id2=" + id2 +
                    '}';
        }
    }
}
