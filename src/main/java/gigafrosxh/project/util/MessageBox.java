package gigafrosxh.project.util;

import javax.swing.*;

public class MessageBox {
    public MessageBox(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.PLAIN_MESSAGE);
    }
}
