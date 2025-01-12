package module7;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaxicabNumbersTest {
    @Test
    void testTaxicabNumbers() {
        var expected = List.of(1729, 4104, 13832, 20683, 32832, 39312, 40033, 46683, 64232, 65728);
        var result = TaxicabNumbers.findNumbers(100000);

        assertEquals(result, expected);
    }

}