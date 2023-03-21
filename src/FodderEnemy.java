import java.awt.*;
import java.util.ArrayList;

public class FodderEnemy extends Enemy{
    public FodderEnemy(int x, int y,int Health, int Speed,int width, int height,ShootingControl sc) {
        super(x, y,Health, Speed,width,height,sc);
    }
    public static ArrayList<FodderEnemy> FodderEnemies = new ArrayList<>();
    FodderEnemy TempFodder;

    void movementY(int Ycord){
        if(y+Speed<Ycord || y-Speed>Ycord) {
            if (y < Ycord) {
                y += Speed;
            } else if (y > Ycord) {
                y -= Speed;
            }
        }
    }
    void movementX(int Xcord){
        if(x+Speed<Xcord || x-Speed>Xcord) {
            if (x < Xcord) {
                x += Speed;
            } else if (x > Xcord) {
                x -= Speed;
            }
        }
    }

    void update(int Ycord,int Xcord)
    {
        for(int i = 0; i <FodderEnemies.size(); i++) {
            TempFodder = FodderEnemies.get(i);
            TempFodder.movementY(Ycord);
            TempFodder.movementX(Xcord);
            TempFodder.DamageHandler();
            if(TempFodder.getHealth() < 0)
            {
                removeFodder(TempFodder);
            }
        }
    }
    public void render(Graphics2D g)
    {
        for(int i = 0; i <FodderEnemies.size(); i++){
            TempFodder = FodderEnemies.get(i);
            TempFodder.Enemy_render(g);
        }
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void addFodder(FodderEnemy block){
        FodderEnemies.add(block);
    }
    public void removeFodder(FodderEnemy block){
        FodderEnemies.remove(block);
    }
}
