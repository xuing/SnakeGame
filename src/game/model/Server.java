package game.model;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;
import javax.xml.bind.Marshaller.Listener;

import game.util.GameConfig;

public class Server {
	private Snake snake;
	private Node food;
	private int score = 0;
	private ScoreListener sorcelistener;
	private OverListener overListener;
	public void addScoreListener(ScoreListener listener){
		this.sorcelistener = listener;
	}	
	
	public void addOverListner(OverListener listener){
		this.overListener = listener;
	}
	
	public Server() {
		snake = new Snake();
		
	}
	
	public void start(){
		score = 0;
		snake.init();
		createFood();
	}

	public void move(){
		if (snake.isEat(food)){
			snake.grow(food);
			createFood();
			calcScore();
			if(sorcelistener !=null) sorcelistener.report(score);
		}else 
			CheckAndMove();
	}
	
	private void CheckAndMove() {
		if (snake.validate())
			snake.move();
		else if (overListener !=null) {
			overListener.report();
		}
	}

	private void calcScore() {
		score++;
	}

	public void turnTo(String name) {
		Direction d = Direction.valueOf(name);
		snake.turnTo(d);
	}
	
	public void draw(Graphics g){
		snake.draw(g);
		if(food != null)food.draw(g);
	//	snake.move();
	}
	
	private void createFood() {
		Random ran = new Random();
		while(true){
		int r = ran.nextInt(GameConfig.getRows());
		int c = ran.nextInt(GameConfig.getCols());
		Node n = new Node(r, c,NodeType.Food);
		if (!snake.overlap(n)){
			food = n;
			break;
		}
		}
	}
}

