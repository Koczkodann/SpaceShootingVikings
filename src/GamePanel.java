import javax.swing.*;
import java.awt.*;


public class GamePanel extends Canvas implements Runnable {
//Game Settings
int FPS = 60;

//Player Options
    Thread gameThread;
    Player player = new Player();


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
                //repaint updated information
                validate();
                repaint();

                delta--;
            }
        }
    }

    public void paint(Graphics g){
        Graphics2D g2 =(Graphics2D) g;
        player.render(g2);
        //System.out.println("Renderowanie");
        //g2.setColor(Color.white);
        //g2.fillRect(player.playerX,player.playerY,100,100);
    }
}


