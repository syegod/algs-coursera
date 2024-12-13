package unionfind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UFTest {

    @Test
    void testUFConnected() {
        UF uf = new UF(10);
        uf.union(0,1);
        uf.union(1,2);
        uf.union(1,3);
        uf.union(1,4);
        uf.union(1,5);
        uf.union(4,6);
        uf.union(7,3);
        uf.union(8,9);
        uf.union(9,1);

        assertTrue(uf.connected(0, 9));
    }

    @Test
    void testUFFind() {
        UF uf = new UF(10);
        uf.union(1,2);
        uf.union(2,6);
        uf.union(6,9);
        assertEquals(9, uf.find(6));
    }

}