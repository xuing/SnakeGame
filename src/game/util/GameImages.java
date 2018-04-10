package game.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import game.model.NodeType;

//管理游戏中所有图片
public class GameImages {
	private static Image logo;
	private static ImageIcon start;
	private static Image[] nodes;
	private static Image[] numbers;
	
	static {
		String path = GameConfig.getSkinPath();
		logo = new ImageIcon("imgs/"+path+"/logo.jpg").getImage();
		start = new ImageIcon("imgs/"+path+"/start.png");
		numbers = splitImages("imgs/"+path+"/numbers.png",10);
		nodes = new Image[3];
		nodes[0] = new ImageIcon("imgs/"+path+"/snake.bmp").getImage();
		nodes[1] = new ImageIcon("imgs/"+path+"/food.bmp").getImage();
	}
	
	public static Image getnode(int index) {
		//NodeType t = NodeType.valueOf(name);
		return nodes[index];
	}
	
	public static ImageIcon getStart() {
		return start;
	}
	
	public static Image getLogo() {
		return logo;
	}

	public static Image getNumber(int num){
		return numbers[num];
	}
	
	private static Image[] splitImages(String name, int len) {
		Image src = new ImageIcon(name).getImage();
		int iw = src.getWidth(null) / len;
		int ih = src.getHeight(null);
		Image[] imgs = new Image[len];
		
		for(int i = 0; i < len; i++){
			BufferedImage img = new BufferedImage(iw, ih, BufferedImage.TRANSLUCENT);
			Graphics g = img.getGraphics();
			g.drawImage(src, 0, 0, iw, ih, i*iw, 0, (i+1)*iw, ih, null);
			imgs[i] = img;
		}
		
		return imgs;
	}
	
	
}
