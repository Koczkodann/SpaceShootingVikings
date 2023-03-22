package Player;

import Enemy.FodderEnemy;
import Main.Collider;

import java.awt.*;

public class Player {

    public boolean Start;
    int Health = 5;

    Collider collider = new Collider();
    public PlayerAction pa = new PlayerAction();
    ShootingControl sc = new ShootingControl();

        //Player.Player Options
        int playerX = 960;
        int playerY = 900;
        int playerW = 100;
        int playerH = 100;
        int playerSpeed = 10;
        int playerAttackSpeed = 200; //in milliseconds
        long timeOfLastProjectile = 0;

    public void update(){
        DamageHandler();
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
    FodderEnemy TempFodder;
    public void DamageHandler(){
        for(int i = 0; i < FodderEnemy.FodderEnemies.size(); i++) {
            TempFodder = FodderEnemy.FodderEnemies.get(i);
            if (collider.SqrtCollider(playerX, playerY, TempFodder.getX(), TempFodder.getY(),playerW,playerH, TempFodder.getWidth(), TempFodder.getHeight())) {
                TempFodder.removeFodder(TempFodder);
                Health--;
            }
            if(Health == 0) {
                playerSpeed = 0;
            }

        }
    }
    public void render(Graphics g){
        g.setColor(Color.white);
        g.fillRect(playerX,playerY,playerW,playerH);
    }

    public int getPlayerX(){
        return playerX;
    }
    public int getPlayerY(){
        return playerY;
    }
    public int getPlayerW(){
        return playerW;
    }
    public int getPlayerH(){
        return playerH;
    }
}
