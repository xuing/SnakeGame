package game.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class GameMenu extends JMenuBar{
	public GameMenu(){
		createGames();
		createViews();
		createHelps();
	}

	//事件处理程序
	private class ExitHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	}
	
	private void createHelps() {
		JMenu mnGames = new JMenu("Help");
		JMenuItem itemHelp = new JMenuItem("Use Help");
		itemHelp.setMnemonic('H');
		itemHelp.setAccelerator(KeyStroke.getKeyStroke("F1"));
		
		JMenuItem itemAbout = new JMenuItem("About");
		itemAbout.setMnemonic('A');
		
		mnGames.add(itemHelp);
		mnGames.add(itemAbout);
		
		this.add(mnGames);
	}

	private void createViews() {
		JMenu mnGames = new JMenu("View");
		mnGames.setMnemonic('V');
		ButtonGroup Ibg = new ButtonGroup();
		JRadioButtonMenuItem itemSmailIcon = new JRadioButtonMenuItem("Smail Icon");
		JRadioButtonMenuItem itemBigIcon = new JRadioButtonMenuItem("Big Icon");
		Ibg.add(itemSmailIcon);
		Ibg.add(itemBigIcon);
		
		JMenu mnSkin = new JMenu("Skin");
		{
			ButtonGroup Sbg = new ButtonGroup();
			JRadioButtonMenuItem itemSkinCartoon = new JRadioButtonMenuItem("itemSkinCartoon");
			JRadioButtonMenuItem itemSkinClassic = new JRadioButtonMenuItem("itemSkinClassic");
			JRadioButtonMenuItem itemSkinNature = new JRadioButtonMenuItem("itemSkinNature");
			Sbg.add(itemSkinCartoon);
			Sbg.add(itemSkinClassic);
			Sbg.add(itemSkinNature);
			mnSkin.add(itemSkinCartoon);
			mnSkin.add(itemSkinClassic);
			mnSkin.add(itemSkinNature);
		}
		JMenu mnLanguage = new JMenu("Language");
		{
			ButtonGroup Lbg = new ButtonGroup();
			JRadioButtonMenuItem itemLgChinese = new JRadioButtonMenuItem("Chinese");
			JRadioButtonMenuItem itemLgEnglish = new JRadioButtonMenuItem("English");
			Lbg.add(itemLgChinese);
			Lbg.add(itemLgEnglish);
			mnLanguage.add(itemLgChinese);
			mnLanguage.add(itemLgEnglish);
		}
		mnGames.add(itemSmailIcon);
		mnGames.add(itemBigIcon);
		mnGames.add(mnSkin);
		mnGames.add(mnLanguage);
		this.add(mnGames);
	}

	private void createGames() {
		JMenu mnGames = new JMenu("Game");
		mnGames.setMnemonic('G');
		JMenuItem itemNew = new JMenuItem("New");
		itemNew.setMnemonic('N');
		itemNew.setAccelerator(KeyStroke.getKeyStroke("F2"));
		
		JMenuItem itemExit = new JMenuItem("Exit");
		itemExit.setMnemonic('X');
		itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
		
		JMenuItem itemPause = new JMenuItem("Pause");
		itemPause.setMnemonic('P');
		itemPause.setAccelerator(KeyStroke.getKeyStroke("F3"));
		
		JCheckBoxMenuItem itemBgmusic = new JCheckBoxMenuItem("Bgmusic");
		itemBgmusic.setMnemonic('M');
		itemBgmusic.setAccelerator(KeyStroke.getKeyStroke("F4"));
		
		
		//JCheckBoxMenuItem
		//JRadioButtonMenuItem
		itemExit.addActionListener(new ExitHandler());
		
		mnGames.add(itemNew);
		mnGames.add(itemPause);
		mnGames.add(itemBgmusic);
		mnGames.add(itemExit);
		this.add(mnGames);
	}
}
