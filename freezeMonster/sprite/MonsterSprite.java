package freezeMonster.sprite;

import java.util.LinkedList;

import javax.swing.*;
import java.util.Random;

import freezeMonster.EngineCommons;
import spriteframework.sprite.BadSprite;
import spriteframework.sprite.BadnessBoxSprite;
import spriteframework.sprite.ScaleImage;

/// é o alien
public class MonsterSprite extends BadnessBoxSprite {

    private Slime slime;
    private String froozenPath;

    // cada alien tem SUA bomba que quando é destruída pode ser reutilizada,
    // por isso lança uma única por vez

    public MonsterSprite(String primaryPath, int x, int y, int larg, int alt) {

        initMonster(primaryPath, x, y,larg, alt);
    }

    private void initMonster(String path, int x, int y, int larg, int alt) {

        this.x = x;
        this.y = y;

        slime = new Slime("/images/gosma.png",x, y, 25, 25);

        //String monsterImg = path;
        ScaleImage scaledImage = new ScaleImage(path,  larg, alt);
        ImageIcon ii = scaledImage.getScaledImage();

        setImage(ii.getImage());
    }

    public void setFroozenPath(String path) {
        froozenPath = path;
    }

    public Slime getSlime() {
        return slime;
    }


	@Override
	public LinkedList<BadSprite> getBadnesses() {
		LinkedList<BadSprite> aSlime = new LinkedList<BadSprite>();
		aSlime.add(slime);
		return aSlime;
	}

    public void initMovimentation(){

        Random rand = new Random();

        int directionX = rand.nextInt(11) - 5;
        int directionY = rand.nextInt(11) - 5;

        checkColisionAndMove(directionX, directionY);
    }

    private void checkColisionAndMove(int dX, int dY){

        int newX = getX() + dX;
        int newY = getY() + dY;
        //int direction= 1;
        EngineCommons config = new EngineCommons();

        // Verifica se a nova posição está dentro dos limites
        boolean noLimitesX = newX <= config.getBorderLeft() ||
                newX >= config.getBoardWidth() - config.getBorderRight();

        boolean noLimitesY = newY <= config.getTop() ||
                newY >= config.getGround();

        if (noLimitesX){
            dX *= -1;
        }
        if (noLimitesY){
            dY *= -1;
        }

        moveX(dX);
        moveY(dY);

    }
}
