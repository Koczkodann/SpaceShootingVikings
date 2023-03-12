import java.awt.*;
import java.util.LinkedList;

public class ShootingControl {
    private LinkedList<Projectile> p = new LinkedList<Projectile>();

    Projectile TempProjectile;

    public void tick(){
        for(int i = 0; i <p.size(); i++){
            TempProjectile = p.get(i);
            TempProjectile.Projectile_movement();
        }
        }
    public void render(Graphics g){
        for(int i = 0; i <p.size(); i++){
            TempProjectile = p.get(i);
            TempProjectile.render(g);
        }
    }
    public void addProjectile(Projectile a){
        p.add(a);
    }
    public void removeProjectile(Projectile a){
        p.remove(a);
    }
}
