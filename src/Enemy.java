import java.awt.*;

public abstract class Enemy {
    int Health, ShootSpeed,x,y,width,height;
    ShootingControl sc;
    public Enemy(int x, int y,int Health, int ShootSpeed, int width,int height, ShootingControl sc) {
       this.Health=Health;
       this.ShootSpeed=ShootSpeed;
       this.x=x;
       this.y=y;
       this.width=width;
       this.height=height;
       this.sc = sc;
    }


    Projectile TempProjectile;

    void Enemy_movement(){

     }

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
             } else if (Health < 0) {
                 //remove from enemy array
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
