package sindrn.pong;

public class PaddleLeft extends Paddle{
	
	public PaddleLeft(){
		super(Constants.PADDLE_LEFT);
		height = Constants.PADDLE_LEFT.getHeight();
		setOffset(0, 0);
		setSpeed(0, 0);
		setPosition(Constants.WINDOW_WIDTH-30, Constants.WINDOW_HEIGHT/2);
	}
	
	@Override
	public void checkBounderies() {
		if(getY()>Constants.WINDOW_HEIGHT-height)
			setPosition(getX(), Constants.WINDOW_HEIGHT-height);
	}

}
