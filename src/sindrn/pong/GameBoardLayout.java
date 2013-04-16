package sindrn.pong;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import sheep.game.State;
import sheep.gui.TextButton;
import sheep.input.TouchListener;

public class GameBoardLayout extends State implements TouchListener{
	
	private Ball ball;
	private PaddleLeft paddleLeft;
	private PaddleRight paddleRight;
	private int leftPoint, rightPoint;
	private TextButton printLeftPoint, printRightPoint;
	
	public GameBoardLayout(MainMenu main){
		leftPoint=0;
		rightPoint=0;

		printLeftPoint = new TextButton(Constants.WINDOW_WIDTH-30, 30, Integer.toString(leftPoint));
		printRightPoint = new TextButton(30, 30, Integer.toString(rightPoint));

//	get the singleton ballobject.
		ball = Ball.getBallObject();
//	Initiate left paddle
		paddleLeft = new PaddleLeft();
//	Initiate right paddle
		paddleRight = new PaddleRight();
	}
	
	@Override
	public void update(float dt){
//	Ball bounces off paddles
		if (ball.collides(paddleLeft)){
			ball.paddleBounce();
			ball.setPosition(ball.getX()-5, ball.getY());
		}
		if (ball.collides(paddleRight)){
			ball.paddleBounce();
			ball.setPosition(ball.getX()+5, ball.getY());
		}
		
//	Player misses ball
		if (ball.getX()<(Constants.BALL.getWidth()/2) ){
			ball.resetBall();
			leftPoint++;
			printLeftPoint.setLabel(Integer.toString(leftPoint));
		}
		if (ball.getX()>Constants.WINDOW_WIDTH-(Constants.BALL.getWidth()/2)){
			ball.resetBall();
			rightPoint++;
			printRightPoint.setLabel(Integer.toString(rightPoint));
		}
		
//	Ball bounces off bottom or top
		if (ball.getY()<(Constants.BALL.getHeight()/2) ){
			ball.btBounce();
			ball.setPosition(ball.getX(), ball.getY()+5);
		}
		if (ball.getY()>Constants.WINDOW_HEIGHT-(Constants.BALL.getHeight()/2)){
			ball.btBounce();
			ball.setPosition(ball.getX(), ball.getY()-5);
		}
		ball.update(dt);
		
//	Preventing paddles from leaving the screen
		paddleLeft.checkBounderies();
		paddleRight.checkBounderies();
		paddleLeft.update(dt);
		paddleRight.update(dt);

//	If there is a winner, pop the state from the stack.
		if(leftPoint==Constants.WINSCORE || rightPoint==Constants.WINSCORE)
			getGame().popState();
	}
	
	@Override
	public void draw(Canvas canvas){
		super.draw(canvas);
		canvas.drawColor(Color.BLACK);
		ball.draw(canvas);
		paddleLeft.draw(canvas);
		paddleRight.draw(canvas);
		printLeftPoint.draw(canvas);
		printRightPoint.draw(canvas);
	}
	
	@Override
	public boolean onTouchMove(MotionEvent e){
		float y = e.getY();
		if(e.getX()>Constants.WINDOW_WIDTH/2)
			paddleLeft.setPosition(paddleLeft.getX(), y);
		else
			paddleRight.setPosition(paddleRight.getX(), y);
		return true;
	}
}