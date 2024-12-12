package unionfind;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            SC.Log[] logs = new SC.Log[5];
            logs[0] = new SC.Log(1, 0, 1);
            Thread.sleep(5);
            logs[1] = new SC.Log(2, 1, 2);
            Thread.sleep(5);
            logs[2] = new SC.Log(3, 2, 3);
            Thread.sleep(5);
            logs[3] = new SC.Log(4, 3, 1);
            Thread.sleep(5);
            logs[4] = new SC.Log(5, 2, 0);
            System.out.println(Arrays.toString(logs));
            SC sc = new SC(4, logs);
            System.out.println(sc.earliest());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
