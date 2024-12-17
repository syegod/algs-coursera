package module1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SCTest {
    @Test
    void testSCBasic() {
        SC.Log[] logs = new SC.Log[5];
        logs[0] = new SC.Log(1, 0, 1);
        logs[1] = new SC.Log(2, 1, 2);
        logs[2] = new SC.Log(3, 2, 3);
        logs[3] = new SC.Log(4, 3, 1);
        logs[4] = new SC.Log(5, 2, 0);
        SC sc = new SC(4, logs);
        assertEquals(3, sc.earliest());
    }

    @Test
    void testSCNotFound() {
        SC.Log[] logs = new SC.Log[2];
        logs[0] = new SC.Log(1, 0, 1);
        logs[1] = new SC.Log(2, 1, 2);
        SC sc = new SC(4, logs);
        assertEquals(-1, sc.earliest());
    }
}