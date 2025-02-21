package gigafrosxh.project.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IllegalShipExceptionTest {
    @Test
    void testIllegalShip() {
        assertThrows(IllegalShipException.class, () -> {
            throw new IllegalShipException("Illegal ship");
        });
    }

}