import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
//Game Settings
int FPS = 60;

//Player Options
int playerX = 400;
int playerY = 500;
int playerSpeed = 10;

    KeyHandler keyHand = new KeyHandler();
    Thread gameThread;

    //Game Panel Options
    int Pwidth = 1000;
    int Pheight = 800;
    public GamePanel() {
        this.setPreferredSize(new Dimension(Pwidth,Pheight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHand);
        this.setFocusable(true);
    }

    public void startgameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double FrameInterval = 1000000000/FPS;
        double delta = 0;
        long lastFrame = System.nanoTime();
        long CurrentTime;

        while(gameThread != null) {

            CurrentTime =System.nanoTime();

            delta += (CurrentTime - lastFrame) / FrameInterval;

            lastFrame = CurrentTime;

            if(delta >= 1) {

                //update screen information
                update();
                //repaint updated information
                repaint();

                delta--;
            }
        }
    }
    public void update(){

        if(keyHand.up){
            playerY = playerY - playerSpeed;
        }
        if(keyHand.down){
            playerY = playerY + playerSpeed;
        }
        if(keyHand.left){
            playerX = playerX - playerSpeed;
        }
        if(keyHand.right){
            playerX =playerX + playerSpeed;
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);

        g2.fillRect(playerX,playerY,100,100);

        g2.dispose(); //memory saving
    }
}
