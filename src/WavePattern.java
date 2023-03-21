import java.awt.*;
import java.util.Random;

public class WavePattern {
    ShootingControl sc;
    Player player;
    public WavePattern(ShootingControl sc, Player player){
       this.sc = sc;
       this.player = player;
    }
    Random rand = new Random();
long LastSpawn=0;


    public FodderEnemy Fodderwave = new FodderEnemy(0,0,0,0,0,0,sc);
    public void Fodder1(int SpawnTime) {
        int randomx = rand.nextInt(1000);
        Fodderwave.update(player.playerY, player.playerX);
        long timeNow = System.currentTimeMillis();
        long time = timeNow - LastSpawn;
        if (time > SpawnTime) {
            LastSpawn = timeNow;
            Fodderwave.addFodder(new FodderEnemy(randomx, 100, 4, 5, 75, 75, sc));
        }
    }
    public void renderwave(Graphics2D g){
        Fodderwave.render(g);
    }
}
