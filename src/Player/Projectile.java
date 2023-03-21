package Player;

import java.awt.*;

public class Projectile {
    private final int x;
    private int y;
    private final int width=50;
    private final int height=50;
    int projectile_speed = 20;

    public Projectile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void Projectile_movement() {

        y -= projectile_speed;
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
