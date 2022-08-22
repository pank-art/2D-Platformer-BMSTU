package playing.entities.statics;

import playing.entities.Entity;
import playing.entities.player.playerModules.PlayerHitBox;
import utilz.Constants;

import java.awt.geom.Rectangle2D;

public abstract class StaticEntity extends Entity {
    protected int width, height;
    protected Rectangle2D.Float hitBox;
    protected float Distance = Constants.GameWindowConstants.TILE_SIZE_DEFAULT;

    public StaticEntity(double x, double y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
        hitBox = new Rectangle2D.Float((float) x,(float) y, width, height);
    }

    public Rectangle2D.Float getHitBox() {
        return hitBox;
    }

    protected boolean isPlayerCloseForInteraction(PlayerHitBox playerHitBox) {
        int absValue = (int) Math.abs(playerHitBox.getHitBox().x - hitBox.x);
        return absValue <= Distance;
    }
}