package gigafrosxh.project.cpu;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CPUActionsTest {

    @Test
    void attack() {
        String regex = "^[0-2]![0-2]$";
        String attack = new CPUActions().attack();

        assertTrue(attack.matches(regex));
    }

    @Test
    void checkAttackDuplicates() {
        ArrayList<String> attacks = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            attacks.add(new CPUActions().attack());
        }

        assertFalse(isDup(attacks.toArray(new String[0])));
    }

    private static <T> boolean isDup(@NotNull T[] array) {
        HashSet<T> checked = new HashSet<>();

        for (T element : array) {
            if (checked.contains(element)) {
                return true; // Duplikat gefunden
            }
            checked.add(element);
        }
        return false; // Keine Duplikate
    }

}