import java.awt.*;
import java.util.ArrayList;

public class Player {

    PlayerAction pa = new PlayerAction();
    ShootingControl sc = new ShootingControl();


        public int playerX = 400;
        public int playerY = 500;
        public int playerSpeed = 10;

    public void update(){
        //sc.update();
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
            sc.addProjectile(new Projectile(playerX, playerY));
        }


    }
    public void render(Graphics2D g){

        g.setColor(Color.white);
        g.fillRect(playerX,playerY,100,100);
        //g.dispose(); //memory saving
    }
}
