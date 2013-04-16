package sindrn.pong;

import java.util.Random;
import sheep.game.Sprite;

public class Ball extends Sprite{
	
	private float speedX, speedY, origSpeedX, origSpeedY;
	private Random rand;
	
//	implementation of singleton pattern, making sure it can only exist one ball	
	private static Ball ball;	
	public static synchronized Ball getBallObject(){
		if (ball == null)
			ball = new Ball(Constants.XSPEED, Constants.YSPEED);
		return ball;
	}
	
	private Ball(float speedX, float speedY){
		super(Constants.BALL);
		super.setSpeed(speedX, speedY);
		super.setPosition(Constants.WINDOW_WIDTH/2, Constants.WINDOW_HEIGHT/2);
		this.speedX = speedX;
		this.speedY = speedY;
		this.origSpeedX = speedX;
		this.origSpeedY = speedY;
		rand = new Random();
	}
	
	public void paddleBounce(){
		speedX*=-1;;
		speedX+=(float)(rand.nextInt(80)-30);
		speedY+=(float)(rand.nextInt(80)-30);
		super.setSpeed(speedX, speedY);
	}
	
	public void resetSpeed(){
		speedX = origSpeedX;
		speedY = origSpeedY;
		
		switch (rand.nextInt(4)) {
		case 0:
			speedX*=-1;
			speedY*=-1;
			break;
		case 1:
			speedY*=-1;
			break;
		case 2:
			speedX*=-1;
			break;
		default:
			break;
		}
		setSpeed(speedX, speedY);
	}
	
	public void resetBall(){
		resetSpeed();
		setPosition(Constants.WINDOW_WIDTH/2, Constants.WINDOW_HEIGHT/2);
	}
	
	public void btBounce(){
		speedY*=-1;
		super.setSpeed(speedX, speedY);
	}

}
