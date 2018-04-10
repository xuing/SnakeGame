package game.control;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import game.model.OverListener;
import game.model.ScoreListener;
import game.model.Server;
import game.util.GameConfig;
import game.view.FrameGame;

/**
 * 游戏中控
 * 视图和模型的中介
 * @author 六花
 *
 */
public class GameController {
	private FrameGame view;
	private PlayerController player;
	private Server model;
	private Timer gameTimer;
	private Timer timer;
	private int timeValue = 0;
	
	
	
	public GameController(){
		model = new Server();
		model.addScoreListener(new ScoreHandler());
		model.addOverListner(new Overhandler());
		player = new PlayerController(this);
		view = new FrameGame(model);
		view.addStartListener(player);
		view.addKeyListener(player);
		gameTimer = new Timer(200,new MoveHandler());
		timer = new Timer(1000,new TimeHadler());
	}
	
	public void Start(){
		model.start();
		gameTimer.start();
		timer.start();
		timeValue = 0;
		view.refreshTime(0);
		view.refreshScore(0);
	}
	
	private class Overhandler implements OverListener{

		@Override
		public void report() {
			timer.stop();
			gameTimer.stop();
		}
		
	}
	
	private class ScoreHandler implements ScoreListener{

		@Override
		public void report(int score) {
			view.refreshScore(score);
		}
		
	}
	
	private class TimeHadler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			timeValue++;
			view.refreshTime(timeValue);
		}
		
	}
	
	private class MoveHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			model.move();
			view.repaint();
		}
		
	}

	public void turnTo(String name) {
		model.turnTo(name);
	}
	
	public void show(){
		view.setVisible(true);
		Insets r = view.getInsets();
		view.setSize(GameConfig.getClientWidth()+r.left*2,GameConfig.getClientHeight() + r.top + r.bottom+32);
		view.setLocationRelativeTo(null);
	}
	
}
