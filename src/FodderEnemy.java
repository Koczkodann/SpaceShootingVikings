import java.awt.*;
import java.util.ArrayList;

public class FodderEnemy extends Enemy{
    public FodderEnemy(int x, int y, int Health, int ShootSpeed,int width, int height,ShootingControl sc) {
        super(x, y, Health, ShootSpeed,width,height,sc);
    }
    public static ArrayList<FodderEnemy> FodderEnemies = new ArrayList<>();
    FodderEnemy TempFodder;

    void update()
    {
        for(int i = 0; i <FodderEnemies.size(); i++) {
            TempFodder = FodderEnemies.get(i);
            if(TempFodder.getHealth() < 0)
            {
                removeFodder(TempFodder);
            }
        }
    }
    void render(Graphics2D g)
    {
        for(int i = 0; i <FodderEnemies.size(); i++){
            TempFodder = FodderEnemies.get(i);
            TempFodder.render(g);
        }
    }
    public void addFodder(FodderEnemy block){
        FodderEnemies.add(block);
    }
    public void removeFodder(FodderEnemy block){
        FodderEnemies.remove(block);
    }
}
