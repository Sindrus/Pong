package sindrn.pong;

import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import sheep.game.Game;

public class MainMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
	//remove titlebar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
	//remove statusbar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		Game game = new Game(this, null);
		
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		
		Constants.WINDOW_HEIGHT = dm.heightPixels;
		Constants.WINDOW_WIDTH = dm.widthPixels;
		
		game.pushState(new MenuLayout(this));
		setContentView(game);
	}
}