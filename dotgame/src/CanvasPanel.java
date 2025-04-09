package dotgame;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.Line2D;

public class CanvasPanel extends JPanel {
    private final List<Dot> dots = new ArrayList<>();
    private final List<Line> lines = new ArrayList<>();
    private Dot selected = null;
    private boolean player1Turn = true;

    public CanvasPanel() {
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                for (Dot d : dots) {
                    if (d.contains(e.getPoint())) {
                        if (selected == null) {
                            selected = d;
                        } else if (selected != d) {
                            lines.add(new Line(selected, d, player1Turn ? Color.BLUE : Color.RED));
                            selected = null;
                            player1Turn = !player1Turn;
                            repaint();
                        }
                        return;
                    }
                }
                selected = null;
            }
        });
    }

    public void generateDots(int count) {
        dots.clear();
        lines.clear();
        Random rand = new Random();
        int padding = 30;
        for (int i = 0; i < count; i++) {
            int x = rand.nextInt(getWidth() - 2 * padding) + padding;
            int y = rand.nextInt(getHeight() - 2 * padding) + padding;
            dots.add(new Dot(x, y));
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Line line : lines) {
            line.draw(g);
        }
        for (Dot d : dots) {
            d.draw(g);
        }
    }
}
