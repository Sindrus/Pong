package sindrn.pong;

import sheep.game.Sprite;
import sheep.graphics.Image;

/*
 * Use of template pattern. Both paddles use most of the same functions, 
 * only a few values are set differently.
 */

abstract class Paddle extends Sprite{
	protected float height;
	
	protected Paddle(Image sprite){
		super(sprite);
	}
	
	public abstract void checkBounderies();
}
