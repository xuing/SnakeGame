package game.view;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import game.control.PlayerController;
import game.util.DigitImage;
import game.util.GameImages;

public class PanelInfo extends JPanel {
	private JButton btnGO;
	private JLabel lbTime;
	private JLabel lbScore;

	public void addStartListener(ActionListener listener){
		btnGO.addActionListener(listener);
	}
	
	public void refreshTime(int value){
		ImageIcon icon = DigitImage.getNumber(value);
		lbTime.setIcon(icon);
	}
	
	public void refreshScore(int value){
		ImageIcon icon = DigitImage.getNumber(value);
		lbScore.setIcon(icon);
	}
	
	public PanelInfo(){
		Box vBox = Box.createVerticalBox();{
			vBox.add(Box.createVerticalStrut(4));
			Box hBox = Box.createHorizontalBox();{
				hBox.add(Box.createHorizontalStrut(4));
				ImageIcon iconScore = DigitImage.getNumber(0);
				lbScore = new JLabel(iconScore);
				hBox.add(lbScore);
				hBox.add(Box.createHorizontalGlue());
				btnGO = new JButton(GameImages.getStart());
				//btnGO.addActionListener(new PlayerController(game));
				btnGO.setFocusable(false);
				btnGO.setContentAreaFilled(false); //±³¾°Í¸Ã÷
				btnGO.setMargin(new Insets(0, 0, 0, 0));
				btnGO.setBorderPainted(false);
				hBox.add(btnGO);
				hBox.add(Box.createHorizontalGlue());
				ImageIcon iconTime = DigitImage.getNumber(0);
				lbTime = new JLabel(iconTime);
				hBox.add(lbTime);
				hBox.add(Box.createHorizontalStrut(4));
			}
			vBox.add(hBox);
			vBox.add(Box.createVerticalStrut(4));
		}
		this.setLayout(new BorderLayout());
		this.add(vBox);
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	}
}
