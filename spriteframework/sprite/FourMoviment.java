package spriteframework.sprite;

import java.awt.event.KeyEvent;

public class FourMoviment implements MovStrategy {

    @Override
    public void updatePosition(Player player, KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            player.setDirection("left");
            player.dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            player.setDirection("right");
            player.dx = 2;
        }

        if (key == KeyEvent.VK_UP) {
            player.setDirection("up");
            player.dy = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            player.setDirection( "down");
            player.dy = 2;
        }
    }

}
