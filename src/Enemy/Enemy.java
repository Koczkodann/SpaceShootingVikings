package Enemy;

import Main.Collider;
import Player.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Enemy {
    int Health, Speed,x,y,width,height;
    ShootingControl sc;
    public Enemy(int x, int y, int Health, int Speed, int width,int height, ShootingControl sc) {
        this.x = x;
        this.y =y;
        this.Health=Health;
        this.Speed=Speed;
        this.width=width;
        this.height=height;
        this.sc = sc;
    }

    Collider collider = new Collider();
    Projectile TempProjectile;

     public void DamageHandler(){
         for(int i = 0; i < ShootingControl.Projectiles.size(); i++) {
             TempProjectile = ShootingControl.Projectiles.get(i);
                if(collider.SqrtCollider(x, y,TempProjectile.getX(), TempProjectile.getY(),width,height, TempProjectile.getWidth(), TempProjectile.getHeight())==true) {
                    sc.removeProjectile(TempProjectile);
                    Health--;
                    System.out.println("Trafienie!");
                    System.out.println(Health);
                }
                 }
             }

     public void Enemy_render(Graphics2D g, BufferedImage Sprite){
         g.drawImage(Sprite, x, y,width,height,null);
     }

     public int getHealth() {
         return Health;
     }
}
