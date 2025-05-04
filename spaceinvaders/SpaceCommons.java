package spaceinvaders;
import spriteframework.Commons;

import java.awt.*;

public class SpaceCommons implements Commons{
    public int getBoardHeight(){return 350;}
    public int getBoardWidth(){return 358;}
    public int getBorderBotton(){return 40;}
    public int getBorderRight(){return 30;}
    public int getBorderLeft(){return 5;}
    public int getGround(){return 290;}
    public int getTop(){return 0;}
    public int getNumber_bad_sprites_to_destoy(){return 24;}

    @Override
    public int getBad_sprite_width() {return 12;}

    @Override
    public int getBad_sprite_height() {return 12;}

    public int get_Bad_sprite_init_x(){return 150;}
    public int get_Bad_sprite_init_y(){return 5;}
    public int get_Go_down(){return 15;}
    public int getChance(){return 5;}
    public int getPlayerHeight() {return 10;}
    public int getPlayerWidth(){return 15;}

    @Override
    public int getAttackHeight() {return 5;}
    public String getBackgroungPath(){return "/images/universebg.png";}

    public int getInitPlayerX(){return 270;}
    public int getInitPlayerY(){return 280;}

    @Override
    public Color getNewCor() {
        return new Color(0,0,0,0);
    }
}
