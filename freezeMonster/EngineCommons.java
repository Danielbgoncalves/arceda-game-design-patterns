package freezeMonster;

import spriteframework.Commons;

import java.awt.*;

public class EngineCommons implements Commons {
    @Override
    public int getBoardHeight() {return 600;}

    @Override
    public int getBoardWidth() {return 600;}

    @Override
    public int getBorderBotton() {return 30;}

    @Override
    public int getBorderRight() {return 30;}

    @Override
    public int getBorderLeft() {return 5;}

    @Override
    public int getGround() {return 540;}

    @Override
    public int getTop() {return 0;}

    public int getNumber_bad_sprites_to_destoy() {return 15;}

    @Override
    public int getBad_sprite_width() {return 40;}
    @Override
    public int getBad_sprite_height() {return 40;}

    public int get_Bad_sprite_init_x(){return 150;}

    public int get_Bad_sprite_init_y(){return 5;}

    public int get_Go_down(){return 15;}

    public int getChance(){return 5;}

    public int getPlayerHeight() {return 70;}

    public int getPlayerWidth(){return 50;}

    @Override
    public int getAttackHeight() {return 5;}

    public String getBackgroungPath(){return "/images/darkcloudsbg.png";}

    public int getInitPlayerX(){return 270;}
    public int getInitPlayerY(){return 280;}

    public Color getNewCor() {
        return new Color(84,125,168,255);
    }
}
