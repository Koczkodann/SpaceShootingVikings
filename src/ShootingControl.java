import java.awt.*;
import java.util.ArrayList;

public class ShootingControl {
    public static ArrayList<Projectile> Projectiles = new ArrayList<>();
    Projectile TempProjectile;

    public void update(){
        for(int i = 0; i <Projectiles.size(); i++){
            TempProjectile = Projectiles.get(i);
            TempProjectile.Projectile_movement();
            if(TempProjectile.getY() < 0){
                removeProjectile(TempProjectile);
            }
        }
        }
    public void render(Graphics g){
        for(int i = 0; i <Projectiles.size(); i++){
            TempProjectile = Projectiles.get(i);
            TempProjectile.render(g);
        }
    }
    public void addProjectile(Projectile block){
        Projectiles.add(block);
    }
    public void removeProjectile(Projectile block){

        Projectiles.remove(block);
    }
}
