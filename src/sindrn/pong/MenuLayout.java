package sindrn.pong;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import sheep.game.State;
import sheep.gui.TextButton;
import sheep.input.TouchListener;

public class MenuLayout extends State implements TouchListener{

	private TextButton start;
	private MainMenu main;
	
	
	public MenuLayout(MainMenu main){
		start = new TextButton((Constants.WINDOW_WIDTH/2)-20, Constants.WINDOW_HEIGHT/2, "Start Game!");
		this.main = main;
	}
	
	public void update(float dt){
		
	}
	
	public void draw(Canvas canvas){
		canvas.drawColor(Color.BLACK);
		start.draw(canvas);
	}
	
	public boolean onTouchDown(MotionEvent e){
		if (start.onTouchDown(e))
			getGame().pushState(new GameBoardLayout(main));
		return true;
	}
}