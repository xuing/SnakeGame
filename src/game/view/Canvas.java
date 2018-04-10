package game.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import game.model.Node;
import game.model.NodeType;
import game.model.Server;
import game.model.Snake;
import game.util.GameConfig;
import game.util.GameImages;

public class Canvas extends JPanel{
	private Server server;
	public Canvas(Server server){
		this.server = server;
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
//		Image img= GameImages.getnode(1);
//		int size = GameConfig.getCellSize();
//		for(int i = 0; i < GameConfig.getRows(); i++){
//			for(int j = 0; j < GameConfig.getCols(); j++){
//				g.drawImage(img,j*size + 2,i*size + 2,size,size,null);
//			}
//		}
//		Snake s = new Snake();
//		s.draw(g);
//		Node food = new Node(8, 11,NodeType.Food);
//		food.draw(g);
		server.draw(g);
	}
}
