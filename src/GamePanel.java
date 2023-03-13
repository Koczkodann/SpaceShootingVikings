import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GamePanel extends Canvas implements Runnable {

//Game Settings
int FPS = 60;

    Player player = new Player();
    ShootingControl sc = new ShootingControl();
    Thread gameThread;
    //ArrayList Projectiles =sc.getProjectiles();

    //Game Panel Options
    int Pwidth = 1000;
    int Pheight = 800;

    public GamePanel() {
        this.setPreferredSize(new Dimension(Pwidth,Pheight));
        this.setBackground(Color.BLACK);
        this.addKeyListener(player.pa);
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
                player.update();
                sc.update();
                //repaint updated information
                repaint();

                delta--;
            }
        }
    }

    public void paint(Graphics g){
        Graphics2D g2 =(Graphics2D) g;
            sc.render(g2);
            player.render(g2);
            g2.dispose();
    }

}



