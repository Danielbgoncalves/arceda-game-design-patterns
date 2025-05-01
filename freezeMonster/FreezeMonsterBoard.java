package freezeMonster;


import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ImageIcon;

import spriteframework.AbstractBoard;
import spriteframework.sprite.BadSprite;
import spriteframework.sprite.FourMoviment;
import spriteframework.sprite.Player;

import freezeMonster.sprite.*;

public class FreezeMonsterBoard extends AbstractBoard{
    //define sprites
    //private List<BadSprite> monsters;
    private Shot shot;    
    
    // define global control vars   
    private int direction = -1;
    private int deaths = 0;


    private String explImg = "images/explosion.png";

    protected void setPlayerMovementStrategy(Player player) {
        player.setMovStrategy(new FourMoviment());
    }

    protected void createBadSprites() {  // create sprites
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                MonsterSprite monster = new MonsterSprite(Commons.MONSTER_INIT_X + 18 * j,
                        Commons.MONSTER_INIT_Y + 18 * i);
                badSprites.add(monster);
            }
        }
    }
    
    protected void createOtherSprites() {
        shot = new Shot();
    }

    private void drawShot(Graphics g) {

        if (shot.isVisible()) {
            g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
        }
    }

    // Override
    protected void drawOtherSprites(Graphics g) {
            drawShot(g);
    }
    
    protected void processOtherSprites(Player player, KeyEvent e) {
		int x = player.getX();
		int y = player.getY();

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_SPACE) {

			if (inGame) {

                System.out.println(shot.isVisible());
				if (!shot.isVisible()) { /// se o tiro já tiver saído da tela pode dar outro

					shot = new Shot(x, y);
                    shot.setDirection(player.getDirection());
				}
			}
		}
	}

    protected void update() {

        if (deaths == Commons.NUMBER_OF_MONSTERS_TO_DESTROY) {

            inGame = false;
            timer.stop();
            message = "Game won!";
        }

        // player
        for (Player player: players) 
        	player.act();

        // shot
        /*
         * Como so tem um tiro por ver só é necessário verificar sua colisão
         * se fosse uma lista de tiros seria necessárioum fors aninhados
         * ia ser mt mais custoso pra cada ciclo de update
         **/
        if (shot.isVisible()) { // colisão de tiro e monster

            shot.updatePosition(); // atualizar cada tiro também

            int shotX = shot.getX();
            int shotY = shot.getY();

            for (BadSprite monster : badSprites) {

                int monsterX = monster.getX();
                int monsterY = monster.getY();

                if (monster.isVisible() && shot.isVisible()) {
                    if (shotX >= (monsterX)
                            && shotX <= (monsterX + Commons.MONSTER_WIDTH)
                            && shotY >= (monsterY)
                            && shotY <= (monsterY + Commons.MONSTER_HEIGHT)) {

                        ImageIcon ii = new ImageIcon(explImg);
                        monster.setImage(ii.getImage());
                        monster.setDying(true);
                        deaths++;
                        shot.die();
                    }
                }
            }

        }

        // monstro
        /*
         * O mesmo para isso aqui
         * A movimentção dos monstros deve ser mudada aqui pra ficar como
         * o PPP quer.
         * Mas não deveria estar na classe do monstro ?
         * */
        for (BadSprite monster : badSprites) {

            int x = monster.getX();

            if (x >= Commons.BOARD_WIDTH - Commons.BORDER_RIGHT && direction != -1) {

                direction = -1;

                Iterator<BadSprite> i1 = badSprites.iterator();

                while (i1.hasNext()) {
                    BadSprite a2 = i1.next();
                    a2.setY(a2.getY() + Commons.GO_DOWN);
                }
            }

            if (x <= Commons.BORDER_LEFT && direction != 1) {

                direction = 1;

                Iterator<BadSprite> i2 = badSprites.iterator();

                while (i2.hasNext()) {

                    BadSprite a = i2.next();
                    a.setY(a.getY() + Commons.GO_DOWN);
                }
            }
        }

        Iterator<BadSprite> it = badSprites.iterator();

        while (it.hasNext()) {

            BadSprite monster = it.next();

            if (monster.isVisible()) {

                int y = monster.getY();

                if (y > Commons.GROUND - Commons.MONSTER_HEIGHT) {
                    inGame = false;
                    message = "Invasion!";
                }

                monster.moveX(direction);
            }
        }

        // bombs
        
        updateOtherSprites();
    }

    protected void updateOtherSprites() {
		Random generator = new Random();

        for (BadSprite monster : badSprites) {

            int shot = generator.nextInt(100); // estava 15, literalmente certeza que todas iam atirar ao memso tempo, agora ta esparçado
            Slime slime = ((MonsterSprite)monster).getSlime(); // pega o slime de cada monstro

            if (shot == Commons.CHANCE && monster.isVisible() && slime.isDestroyed()) {

                slime.setDestroyed(false);
                slime.setX(monster.getX());
                slime.setY(monster.getY());
            }

            int slimeX = slime.getX();
            int slimeY = slime.getY();
            int playerX = players.get(0).getX();
            int playerY = players.get(0).getY();

            if (players.get(0).isVisible() && !slime.isDestroyed()) {

                if (slimeX >= (playerX)
                        && slimeX <= (playerX + Commons.PLAYER_WIDTH)
                        && slimeY >= (playerY)
                        && slimeY <= (playerY + Commons.PLAYER_HEIGHT)) {

                    ImageIcon ii = new ImageIcon(explImg);
                    players.get(0).setImage(ii.getImage());
                    players.get(0).setDying(true);
                    slime.setDestroyed(true);
                }
            }

            if (!slime.isDestroyed()) {

                slime.setY(slime.getY() + 1);

                if (slime.getY() >= Commons.GROUND - Commons.SLIME_HEIGHT) {

                    slime.setDestroyed(true);
                }
            }
        }
	}    
}

