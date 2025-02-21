package gigafrosxh.project.graphics;

import gigafrosxh.project.SinkShipsMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class playVSCPUUI extends JFrame {
    private JPanel mainPanel;
    private JLabel title;
    private JPanel fields;
    private JLabel fieldsImg;
    private JTextField positions;
    private JButton selectPos;
    private JLabel hitPos;

    public playVSCPUUI() {
        SinkShipsMain.logger.info("Setting up Play Vs CPU at " + playVSCPUUI.class.getName());

        setContentPane(mainPanel);

        setTitle("Home");
        setSize(500, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        selectPos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SinkShipsMain.logger.info("Pressed button " + e.getActionCommand() + " at " + playVSCPUUI.class.getName());
                String attack = positions.getText();

                try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/assets/sinkships/data/shipPos/shipPosCPU.dat"));
                     BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/assets/sinkships/data/shipPos/shipPosCPU.dat", false))) {

                    String[] f = br.readLine().split(";");
                    ArrayList<String> cpuPOS = new ArrayList<>(Arrays.asList(f));

                    System.out.println(cpuPOS);

                    if (cpuPOS.contains(attack)) {
                        hitPos.setText(hitPos.getText().isEmpty() ? attack : hitPos.getText() + "," + attack);
                        cpuPOS.remove(attack);

                        String updatedPos = String.join(";", cpuPOS);
                        bw.write(updatedPos);
                    }

                } catch (Exception ex) {
                    SinkShipsMain.logger.error(ex.getMessage() + " at " + setShipsUI.class.getName());
                }
            }
        });
    }
}
