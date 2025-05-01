package freezeMonster.sprite;

import java.util.LinkedList;

import javax.swing.ImageIcon;

import spriteframework.sprite.BadSprite;
import spriteframework.sprite.BadnessBoxSprite;

/// é o alien
public class MonsterSprite extends BadnessBoxSprite {

    private Slime slime;
    // cada alien tem SUA bomba que quando é destruída pode ser reutilizada,
    // por isso lança uma única por vez

    public MonsterSprite(int x, int y) {

        initMonster(x, y);
    }

    private void initMonster(int x, int y) {

        this.x = x;
        this.y = y;

        slime = new Slime(x, y);

        String monsterImg = "images/alien.png";
        ImageIcon ii = new ImageIcon(monsterImg);

        setImage(ii.getImage());
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
}
