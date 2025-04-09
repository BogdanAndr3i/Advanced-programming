package dotgame;

import java.awt.*;

public class Dot {
    int x, y, radius = 10;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(x - radius / 2, y - radius / 2, radius, radius);
    }

    public boolean contains(Point p) {
        return p.distance(x, y) < radius;
    }
}
