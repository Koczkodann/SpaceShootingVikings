package Enemy;

import Main.*;
import Player.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class FodderEnemy extends Enemy {
    public FodderEnemy(int x, int y, int Health, int Speed, int width, int height, ShootingControl sc) {
        super(x, y,Health, Speed,width,height,sc);
    }

    BufferedImage FodderSprite = new BufferedImage(75,75,BufferedImage.TYPE_INT_RGB);
    ImageLoad Loader = new ImageLoad();
    public static ArrayList<FodderEnemy> FodderEnemies = new ArrayList<>();
    FodderEnemy TempFodder;

    public void ImageInit() {
        try {
            FodderSprite = Loader.Load("/EnemySprite/FodderShip.png");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

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
    public void render(Graphics2D g) {
        for(int i = 0; i <FodderEnemies.size(); i++){
            TempFodder = FodderEnemies.get(i);
            TempFodder.Enemy_render(g,FodderSprite);
        }
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public void addFodder(FodderEnemy block){
        FodderEnemies.add(block);
    }
    public void removeFodder(FodderEnemy block){
        FodderEnemies.remove(block);
    }
}
