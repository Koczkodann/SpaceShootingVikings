package Main;
import Enemy.*;
import LevelDesign.Levels;
import Player.*;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {

    //Game Settings
    double FPS = 60;

    //Making Game Class objects
    Levels level = new Levels();
    Player player = new Player();
    ShootingControl sc = new ShootingControl();
    WavePattern fw = new WavePattern(sc,player);
    Thread gameThread;

    //Game Panel Options
    int Pwidth = 1920;
    int Pheight = 1080;
    boolean mainmenu = true;


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

                CurrentTime = System.nanoTime();

                delta += (CurrentTime - lastFrame) / FrameInterval;

                lastFrame = CurrentTime;

                if (delta >= 1) {
                    //update screen information
                    updateinfo();
                    //repaint current screen information
                    repaint();
                    delta--;
            }
        }
    }

    public void updateinfo(){
        player.update();
        sc.update();
        fw.Fodder1(2000);
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
            Graphics2D g2D =(Graphics2D)g;
            if(mainmenu = true)
            {

            }
            level.render(g2D);
            sc.render(g2D);
            player.render(g2D);
            fw.renderwave(g2D);
            g2D.dispose();

    }

}



