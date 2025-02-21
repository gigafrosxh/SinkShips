package gigafrosxh.project.cpu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPUActionsTest {

    @Test
    void attack() {
        String regex = "^[0-2]![0-2]$";
        String attack = new CPUActions().attack();

        assertTrue(attack.matches(regex));
    }
}