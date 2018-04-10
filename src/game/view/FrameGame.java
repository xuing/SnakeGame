package game.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import game.model.Server;
import game.util.DigitImage;
import game.util.GameImages;


public class FrameGame extends JFrame{
	private PanelInfo info;

	public void addStartListener(ActionListener listener){
		info.addStartListener(listener);
	}
	
	public void refreshTime(int value){
		info.refreshTime(value);
	}
	
	public void refreshScore(int value){
		info.refreshScore(value);
	}
	
	public FrameGame(Server server) {
		info = new PanelInfo();
		Canvas canvas = new Canvas(server);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0,4));
		panel.add(info,BorderLayout.NORTH);
		panel.add(canvas);
		
		Box vBox = Box.createVerticalBox();{
			vBox.add(Box.createVerticalStrut(4));
			Box hBox = Box.createHorizontalBox();{
				hBox.add(Box.createHorizontalStrut(4));
				hBox.add(panel);
				hBox.add(Box.createHorizontalStrut(4));
			}
			vBox.add(hBox);
			vBox.add(Box.createVerticalStrut(4));
		}
		
		this.add(vBox);
		this.setJMenuBar(new GameMenu());
		this.setLocationRelativeTo(null);
		this.setIconImage(GameImages.getLogo());
		//this.setSize(400,300);
		this.setResizable(false);
		this.setTitle("SnakeGame");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

/**
	Box vBox = Box.createVerticalBox();{
			vBox.add(Box.createVerticalStrut(4));
			Box hBox = Box.createHorizontalBox();{
				hBox.add(Box.createHorizontalStrut(4));
				JLabel lbScore = new JLabel("000");
				hBox.add(lbScore);
				hBox.add(Box.createHorizontalGlue());
				JButton btnGO = new JButton("GO");
				hBox.add(btnGO);
				hBox.add(Box.createHorizontalGlue());
				JLabel lbTime = new JLabel("000");
				hBox.add(lbTime);
				hBox.add(Box.createHorizontalStrut(4));
			}
			vBox.add(hBox);
			vBox.add(Box.createVerticalStrut(4));
		}
		this.setLayout(new BorderLayout());
		this.add(vBox);
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
 */
