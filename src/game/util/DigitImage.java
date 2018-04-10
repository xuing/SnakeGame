package game.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class DigitImage {
	private static int bits = 3;
	public static ImageIcon getNumber(int value){
		int iw = GameImages.getNumber(0).getWidth(null);
		int ih = GameImages.getNumber(0).getHeight(null);
		
		BufferedImage img = new BufferedImage(iw*bits, ih, BufferedImage.TRANSLUCENT);
		Graphics g = img.getGraphics();
		int c = 0;
		while( c < bits){
			Image num = GameImages.getNumber(value % 10);
			g.drawImage(num, (bits - c - 1)*iw, 0, null);
			value /= 10;
			c++;
		}
		return new ImageIcon(img);
	}
}
