import java.awt.*;

public class GamePanel extends Canvas implements Runnable {

//Game Settings
double FPS = 60;

//Making Game Class objects
    Player player = new Player();
    ShootingControl sc = new ShootingControl();
    WavePattern fw = new WavePattern(sc,player);
    Thread gameThread;

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

                CurrentTime = System.nanoTime();

                delta += (CurrentTime - lastFrame) / FrameInterval;

                lastFrame = CurrentTime;

                if (delta >= 1) {
                    //update screen information
                    player.update();
                    sc.update();
                    fw.Fodder1(2000);
                    //repaint current screen information
                        repaint();
                    delta--;
            }
        }
    }

    public void paint(Graphics g){
        Graphics2D g2 =(Graphics2D) g;
            sc.render(g2);
            player.render(g2);
            fw.renderwave(g2);
            g2.dispose();
    }

}



