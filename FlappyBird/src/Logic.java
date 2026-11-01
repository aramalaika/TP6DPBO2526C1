import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Logic implements KeyListener {
    private Player player;

    public Logic(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int speed = 10;

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.setY(player.getY() - speed);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.setY(player.getY() + speed);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.setX(player.getX() - speed);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.setX(player.getX() + speed);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
