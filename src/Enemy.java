import java.awt.*;

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

    Projectile TempProjectile;

     public void DamageHandler(){
         for(int i = 0; i <sc.Projectiles.size(); i++) {
             TempProjectile = sc.Projectiles.get(i);
             if (TempProjectile.getX() + TempProjectile.getWidth() > x && TempProjectile.getX() < x + width) {
                 if (TempProjectile.getY() <= y + height) {
                     sc.removeProjectile(TempProjectile);
                     Health--;
                     System.out.println("Trafienie!");
                     System.out.println(Health);
                 }
             }
         }
     }

     public void Enemy_render(Graphics2D g){
         g.setColor(Color.red);
         g.fillRect(x, y, width, height);
     }

     public int getHealth() {
         return Health;
     }
}
