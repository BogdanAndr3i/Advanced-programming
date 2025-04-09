package dotgame;

import javax.swing.*;
import java.awt.event.*;

public class ControlPanel extends JPanel {
    public ControlPanel(JFrame frame) {
        JButton save = new JButton("Save");
        JButton load = new JButton("Load");
        JButton exit = new JButton("Exit");

        save.addActionListener(e -> JOptionPane.showMessageDialog(this, "Save not implemented"));
        load.addActionListener(e -> JOptionPane.showMessageDialog(this, "Load not implemented"));
        exit.addActionListener(e -> frame.dispose());

        add(save);
        add(load);
        add(exit);
    }
}
