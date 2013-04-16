package sindrn.pong;

public class PaddleRight extends Paddle{
	
	public PaddleRight(){
		super(Constants.PADDLE_RIGHT);
		height = Constants.PADDLE_RIGHT.getHeight();
		setOffset(0, 0);
		setSpeed(0, 0);
		setPosition(30, Constants.WINDOW_HEIGHT/2);
	}

	@Override
	public void checkBounderies() {
		if(getY()>Constants.WINDOW_HEIGHT-height)
			setPosition(getX(), Constants.WINDOW_HEIGHT-height);
	}

}
