package gigafrosxh.project.graphics;

import gigafrosxh.project.SinkShipsMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homeUI extends JFrame {
    private JButton btStart;
    private JPanel mainPanel;
    private JButton exit;

    public homeUI() {
        SinkShipsMain.logger.info("Setting up Home Menu UI at " + homeUI.class.getName());

        setContentPane(mainPanel);


        setTitle("Home");
        setSize(500, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);


        btStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SinkShipsMain.logger.info("Pressed button " + e.getActionCommand() + " at " + homeUI.class.getName());

                setShipsUI ssui = new setShipsUI();
                setVisible(false);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SinkShipsMain.logger.info("Pressed button " + e.getActionCommand() + " at " + homeUI.class.getName());
                try {Thread.sleep(2000);} catch (InterruptedException ex) {throw new RuntimeException(ex);}
                SinkShipsMain.logger.info("Quitting Game. Goodbye :`(");
                dispose();
                System.exit(0);
            }
        });
    }
}
