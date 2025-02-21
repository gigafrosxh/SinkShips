package gigafrosxh.project.cpu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CPUActions {
    public String attack() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        int one = rand.nextInt(3);
        int two = rand.nextInt(3);

        sb.append(one + "!" + two);


        return sb.toString();
    }
}
