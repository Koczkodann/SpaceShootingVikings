import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerAction implements KeyListener {

    public boolean up,down,left,right,shoot,R;

    @Override
    public void keyTyped(KeyEvent e) {
        int press =e.getKeyCode();

        if(press == KeyEvent.VK_R){
            R = true;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int press =e.getKeyCode();
       // System.out.println(press + " been Pressed");

        if(press == KeyEvent.VK_W){
            up = true;
        }
        if(press == KeyEvent.VK_S){
            down = true;
        }
        if(press == KeyEvent.VK_D){
            right = true;
        }
        if(press == KeyEvent.VK_A){
            left = true;
        }
        if(press == KeyEvent.VK_SPACE){
            shoot = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int release =e.getKeyCode();
       // System.out.println(release + " been Released");
        if(release == KeyEvent.VK_W){
            up = false;
        }
        if(release == KeyEvent.VK_S){
            down = false;
        }
        if(release == KeyEvent.VK_D){
            right = false;
        }
        if(release == KeyEvent.VK_A){
            left = false;
        }
        if(release == KeyEvent.VK_SPACE){
            shoot = false;
        }
    }
}
