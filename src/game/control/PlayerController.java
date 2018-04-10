package game.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 玩家控制器，这里就是键盘
 * @author 六花
 *
 */
public class PlayerController extends KeyAdapter implements ActionListener{
	private GameController game;
	public PlayerController(GameController game) {
		this.game = game;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		game.Start();
	}


	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		String[] names = {"Left","Up","Right","Down"};//37,38,39,40
		int code = e.getKeyCode();
		if(code >=37 && code <=40)
			game.turnTo(names[code-37]);
	}
	
	
	
	
}
