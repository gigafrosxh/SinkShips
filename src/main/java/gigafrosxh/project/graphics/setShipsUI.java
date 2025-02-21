package gigafrosxh.project.graphics;

import gigafrosxh.project.SinkShipsMain;
import gigafrosxh.project.util.MessageBox;
import gigafrosxh.project.util.IllegalShipException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

public class setShipsUI extends JFrame {
    private JPanel mainPanel;
    private JLabel title;
    private JButton btnSubmit;
    private JTextField boatPos;
    private JPanel field;
    private JLabel fieldImg;

    public setShipsUI() {
        SinkShipsMain.logger.info("Setting up set Ships UI at " + setShipsUI.class.getName());

        setContentPane(mainPanel);

        setTitle("Home");
        setSize(500, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SinkShipsMain.logger.info("Pressed button " + e.getActionCommand() + " at " + setShipsUI.class.getName());
                String fields = boatPos.getText();

                String[] fieldsArr;
                try {
                    fieldsArr = fields.split(";");

                    if (fieldsArr.length != 3) {
                        throw new IllegalShipException("Invalid amount of chosen sips: " + fields);
                    } else {
                        try (BufferedWriter bw = new BufferedWriter(
                                new FileWriter("shipPosUsr.dat", false))) {
                            int checkVal = 0;
                            for (String s : fieldsArr) {
                                if (s.matches("^[0-2]![0-2]$")) {
                                    bw.write(s + ";");
                                    checkVal++;
                                    if (checkVal == 3) {
                                        playVSCPUUI pvc = new playVSCPUUI();
                                        setVisible(false);
                                    }
                                } else {
                                    throw new IllegalShipException("Invalid ship position: " + s);
                                }
                            }
                        } catch (IllegalShipException ex) {
                            SinkShipsMain.logger.error(ex.getMessage() + " at " + setShipsUI.class.getName());
                            MessageBox ip = new MessageBox(ex.getMessage(), "Illegal Ship Placement");

                        }

                    }
                } catch (Exception ex) {
                    SinkShipsMain.logger.error(ex.getMessage() + " at " + setShipsUI.class.getName());
                    MessageBox ip = new MessageBox(ex.getMessage(), "Illegal Ship Placement");

                }



                try (BufferedWriter bw = new BufferedWriter(new FileWriter(
                        "shipPosCPU.dat", false))) {

                    Set<String> uniqueStrings = new HashSet<>();
                    Random random = new Random();

                    while (uniqueStrings.size() < 3) {
                        int firstNum = random.nextInt(3);
                        int secondNum = random.nextInt(3);
                        uniqueStrings.add(firstNum + "!" + secondNum);
                    }

                    String[] strings = uniqueStrings.toArray(new String[0]);

                    for (String s : strings) {
                        bw.write(s + ";");
                    }

                } catch (Exception ex) {
                    SinkShipsMain.logger.error(ex.getMessage() + " at " + setShipsUI.class.getName());
                }

            }
        });
    }
}
