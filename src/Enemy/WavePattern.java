package Enemy;

import Main.ImageLoad;
import Player.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class WavePattern {
    ShootingControl sc;
    Player player;
    public WavePattern(ShootingControl sc, Player player){
       this.sc = sc;
       this.player = player;

       ImageInit();
    }
    Random rand = new Random();
    long LastSpawn=0;
    ImageLoad Loader = new ImageLoad();

    public FodderEnemy Fodderwave = new FodderEnemy(0, 0, 4, 5, 75, 75, sc);
    public void ImageInit() {
        Fodderwave.ImageInit();
    }

    public void Fodder1(int SpawnTime) {
        int randomx = rand.nextInt(1920);
        Fodderwave.update(player.getPlayerY(), player.getPlayerX());
        long timeNow = System.currentTimeMillis();
        long time = timeNow - LastSpawn;
        if (time > SpawnTime) {
            LastSpawn = timeNow;
            Fodderwave.addFodder(new FodderEnemy(randomx, 0, 4, 5, 75, 75, sc));
        }
    }
    public void renderwave(Graphics2D g){
        Fodderwave.render(g);
    }
}
