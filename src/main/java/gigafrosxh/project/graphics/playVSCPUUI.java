package gigafrosxh.project.graphics;

import gigafrosxh.project.SinkShipsMain;
import gigafrosxh.project.cpu.CPUActions;
import gigafrosxh.project.util.MessageBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class playVSCPUUI extends JFrame {
    private JPanel mainPanel;
    private JLabel title;
    private JPanel fields;
    private JTextField positions;
    private JButton selectPos;
    private JLabel hitPos;
    private JButton posNine;
    private JButton posSeven;
    private JButton posEight;
    private JButton posSix;
    private JButton posFive;
    private JButton posFour;
    private JButton posThree;
    private JButton posTwo;
    private JButton posOne;

    public playVSCPUUI() {
        SinkShipsMain.logger.info("Setting up Play Vs CPU at " + playVSCPUUI.class.getName());

        setContentPane(mainPanel);

        setTitle("Home");
        setSize(500, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        selectPos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SinkShipsMain.logger.info("Pressed button " + e.getActionCommand() + " at " + playVSCPUUI.class.getName());
                String attack = positions.getText();

                try (BufferedReader br = new BufferedReader(new FileReader("shipPosCPU.dat"))) {

                    String[] f = br.readLine().split(";");
                    ArrayList<String> cpuPOS = new ArrayList<>(Arrays.asList(f));

                    // SinkShipsMain.logger.warning(cpuPOS.toString());

                    if (cpuPOS.contains(attack)) {
                        MessageBox mb = new MessageBox("Du hast ein Schiff getroffen " + attack, "Getroffen");
                        hitPos.setText(hitPos.getText().isEmpty() ? attack : hitPos.getText() + "," + attack);
                        SinkShipsMain.logger.info("Changed Label " + hitPos.getUIClassID() + " at " + playVSCPUUI.class.getName());
                        cpuPOS.remove(attack);

                        try (BufferedWriter bw = new BufferedWriter(
                                new FileWriter("shipPosCPU.dat", false))) {
                            String updatedPos = String.join(";", cpuPOS);
                            bw.write(updatedPos);
                        } catch (IOException ex) {
                            SinkShipsMain.logger.error(ex.getMessage() + " at " + playVSCPUUI.class.getName());
                        }
                    } else {
                        MessageBox ip = new MessageBox("Kein Schiff getroffen!", "Daneben");
                    }

                    if (cpuPOS.isEmpty()) {
                        MessageBox ip = new MessageBox("You Won!", "Winner");
                        homeUI hu = new homeUI();
                        setVisible(false);
                    } else {


                        Thread.sleep(new Random().nextInt(1000, 5829));

                        CPUActions ca = new CPUActions();
                        String cpuAttack = ca.attack();
                        SinkShipsMain.logger.info("Enemy attack " + cpuAttack + " at " + playVSCPUUI.class.getName() + "/" + CPUActions.class.getName());

                        BufferedReader br1 = new BufferedReader(
                                new FileReader("shipPosUsr.dat"));
                        String[] x = br1.readLine().split(";");
                        ArrayList<String> usrPOS = new ArrayList<>(Arrays.asList(x));
                        SinkShipsMain.logger.info("Usr POS " + usrPOS);
                        SinkShipsMain.logger.info("Attacker hit? " + usrPOS.contains(cpuAttack));

                        if (usrPOS.contains(cpuAttack)) {
                            MessageBox mb = new MessageBox("Der Gegner hat ein Schiff getroffen " + cpuAttack, "Getroffen");
                            usrPOS.remove(cpuAttack);

                            try (BufferedWriter bw = new BufferedWriter(
                                    new FileWriter("shipPosUsr.dat", false))) {
                                String updatedPos = String.join(";", usrPOS);
                                bw.write(updatedPos);
                            } catch (IOException ex) {
                                SinkShipsMain.logger.error(ex.getMessage() + " at " + playVSCPUUI.class.getName());
                            }
                        } else {
                            MessageBox ip = new MessageBox("Der Gegner hat kein Schiff getroffen!", "Daneben");
                        }

                        if (usrPOS.isEmpty()) {
                            MessageBox ip = new MessageBox("Verloren", "Verlierer");
                            homeUI hu = new homeUI();
                            setVisible(false);
                        }
                    }


                } catch (Exception ex) {
                    SinkShipsMain.logger.error(ex.getMessage() + " at " + playVSCPUUI.class.getName());
                }
            }
        });

        posOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                positions.setText("0!0");
            }
        });
        posTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                positions.setText("0!1");
            }
        });
        posThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                positions.setText("0!2");
            }
        });
        posFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                positions.setText("1!0");
            }
        });
        posFive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                positions.setText("1!1");
            }
        });
        posSix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                positions.setText("1!2");
            }
        });
        posSeven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                positions.setText("2!0");
            }
        });
        posEight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                positions.setText("2!1");
            }
        });
        posNine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                positions.setText("2!2");
            }
        });

    }
}


