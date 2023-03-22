package Main;

public class Collider {

    public boolean SqrtCollider(int x, int y, int x2, int y2, int w, int h, int w2, int h2){
        if (x <= x2 + w2 && x + w >= x2) {
            if( y <= y2 + h2 && y2 <= y + h) {
                return true;
            }
        }
        return false;
    }
    public boolean RoundCollider(){
        return true;
    }
}
