package dotgame;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("Dot Connect Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        CanvasPanel canvas = new CanvasPanel();
        ConfigPanel config = new ConfigPanel(canvas);
        ControlPanel control = new ControlPanel(this);

        add(config, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(control, BorderLayout.SOUTH);

        setVisible(true);
    }
}
