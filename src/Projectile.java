import java.awt.*;

public class Projectile {
    private int x;
    private int y;
    int projectile_speed= 5;
    public Projectile(int x, int y, GamePanel gamePanel)
    {
        this.x = x;
        this.x = y;
    }
    public void Projectile_movement(){
        y -= projectile_speed;
    }
    public void render(Graphics g){
        g.fillRect((int)x, (int)y,20,30);
    }
}
