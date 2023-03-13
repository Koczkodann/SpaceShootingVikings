import java.awt.*;

public class Projectile {
    private int x;
    private int y;
    int projectile_speed= 20;
    public Projectile(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void Projectile_movement(){

        y -= projectile_speed;
    }
    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x, y,50,90);
    }
    public int getY(){
        return y;
    }
}
