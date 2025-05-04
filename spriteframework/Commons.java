package spriteframework;

import java.awt.*;

public interface Commons {
    int GROUND = 290;
    int BOARD_WIDTH = 358;
    int BOARD_HEIGHT = 350;
    int INIT_PLAYER_X = 270;
    int INIT_PLAYER_Y = 280;
    int DELAY = 17;

    int getBoardHeight();
    int getBoardWidth();
    int getBorderBotton();
    int getBorderRight();
    int getBorderLeft();
    int getGround();
    int getTop();
    int getNumber_bad_sprites_to_destoy();
    int getBad_sprite_width();
    int getBad_sprite_height();
    int get_Bad_sprite_init_x();
    int get_Bad_sprite_init_y();
    int get_Go_down();
    int getChance();
    int getPlayerHeight();
    int getPlayerWidth();
    int getAttackHeight();
    String getBackgroungPath();
    Color getNewCor();

    int getInitPlayerX();
    int getInitPlayerY();
}
