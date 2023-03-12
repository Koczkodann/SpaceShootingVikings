import java.awt.*;

public class Player {

    PlayerAction pa = new PlayerAction();

        public int playerX = 400;
        public int playerY = 500;
        public int playerSpeed = 10;

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
        }


    }
    public void render(Graphics2D g){

        g.setColor(Color.white);
        g.fillRect(playerX,playerY,100,100);

        g.dispose(); //memory saving
    }
}
