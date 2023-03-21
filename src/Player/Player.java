package Player;

import java.awt.*;

public class Player {

    public boolean Start;

    public PlayerAction pa = new PlayerAction();
    ShootingControl sc = new ShootingControl();

        //Player.Player Options
        public int playerX = 960;
        public int playerY = 900;
        public int playerSpeed = 10;
        public int playerAttackSpeed = 200; //in milliseconds
        long timeOfLastProjectile = 0;

    public void update(){
        if(pa.up){
            playerY = playerY - playerSpeed;
        }
        if(pa.down){
            playerY = playerY + playerSpeed;
        }
        if(pa.left){
            playerX = playerX - playerSpeed;
        }
        if(pa.right){
            playerX =playerX + playerSpeed;
        }
        if(pa.shoot){
            long timeNow = System.currentTimeMillis();
            long time = timeNow - timeOfLastProjectile;
            if (time < 0 || time > playerAttackSpeed) {
                timeOfLastProjectile = timeNow;
                sc.addProjectile(new Projectile(playerX, playerY));
            }
        }
        if(pa.ENTER){
            Start = true;
        }
    }
    public void render(Graphics2D g){
        g.setColor(Color.white);
        g.fillRect(playerX,playerY,100,100);
    }
}
