package dotgame;

import java.awt.*;

public class Line {
    Dot a, b;
    Color color;

    public Line(Dot a, Dot b, Color color) {
        this.a = a;
        this.b = b;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(a.x, a.y, b.x, b.y);
    }

    public double length() {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }
}
