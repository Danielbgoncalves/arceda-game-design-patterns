package spriteframework.sprite;

import javax.swing.ImageIcon;

import spriteframework.Commons;

import java.awt.Image;
import java.awt.event.KeyEvent;

public class Player extends Sprite {

    private int width;
    private int height;
    private String direction;
    private MovStrategy movStrategy;

    public Player() {
        loadImage();
		getImageDimensions();
		resetState();
        movStrategy = new HorizontalMoviment();
    }

    protected void loadImage () {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/images/player.png"));
        width = ii.getImage().getWidth(null);
        height = ii.getImage().getWidth(null);
        setImage(ii.getImage());
    }
    
    public void act() {

        x += dx;
        y += dy;

        if (x <= 2) x = 2;

        if (y <= 2) y = 2;


        if (x >= Commons.BOARD_WIDTH - 2 * width) {
            x = Commons.BOARD_WIDTH - 2 * width;
        }

        if (y >= Commons.BOARD_HEIGHT - 3 * height) {
            y = Commons.BOARD_HEIGHT - 3 * height;
        }

    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        movStrategy.updatePosition(this, e);

        /*if (key == KeyEvent.VK_LEFT) {
            direction = "left";
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            direction = "right";
            dx = 2;
        }

        if (key == KeyEvent.VK_UP) {
            direction = "up";
            dy = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            direction = "down";
            dy = 2;
        }*/
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String dir) { this.direction = dir;}

    public void setMovStrategy(MovStrategy movStrategy) {
        this.movStrategy = movStrategy;
    }

    private void resetState() {

        setX(Commons.INIT_PLAYER_X);
        setY(Commons.INIT_PLAYER_Y);
    }
}
