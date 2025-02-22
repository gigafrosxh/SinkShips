package gigafrosxh.project.cpu;

import gigafrosxh.project.SinkShipsMain;

import java.util.ArrayList;
import java.util.Random;

public class CPUActions {
    private static ArrayList<String> attacks = new ArrayList<>();

    public String attack() {

        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        while (true) {
            int one = rand.nextInt(3);
            int two = rand.nextInt(3);

            sb.setLength(0);
            sb.append(one)
                    .append("!")
                    .append(two);

            if (!attacks.contains(sb.toString())) {
                attacks.add(sb.toString());
                return sb.toString();
            }
        }
    }
}
