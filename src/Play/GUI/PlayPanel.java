package Play.GUI;//construct parameter º¯°æ

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Data.Game;
import Main.MainFrame;
import Main.MainPanel;


public class PlayPanel extends JPanel implements ActionListener
{

	private StagePanel stagePanel;

	private JPanel playPanel;
	private JLabel boardLabel;
	private JButton closeButton;
	
	private MainFrame mainFrame;
	
	private Game gameData;
	
	



	public PlayPanel(MainFrame mainFrame, Game gameData, int index) {
		super();
		setGameData(gameData);
		
		this.setMainFrame(mainFrame);
		this.setBounds(0, 0, 850, 530);
		
		playPanel = new JPanel();
		playPanel.setBounds(25, 25, 480, 480);
		
		boardLabel = new JLabel(new ImageIcon("img/board.png"));
		boardLabel.setBounds(0, 0, 480, 480);
		playPanel.add(boardLabel);
		this.add(playPanel);
		
		
		closeButton = new JButton("BACK");
		closeButton.setBounds(650, 450, 180, 55);
		closeButton.setBackground(Color.white);
		closeButton.setOpaque(false);
		closeButton.setBorderPainted(false);
		closeButton.setIcon(new ImageIcon("img/pre.png"));
		closeButton.addActionListener(this);
		this.add(closeButton);

	}

	@Override
	public void paintComponent( Graphics g )
	{
		super.paintComponent(g);
		Image image = new ImageIcon("img/play(background).png").getImage();
		g.drawImage(image, 0, 0, this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == closeButton)
		{
			getMainFrame().remove(this);
			getMainFrame().repaint();
			stagePanel = new StagePanel(mainFrame,gameData);
			getMainFrame().add(stagePanel);
		}
	}
	
	
	
	
	public Game getGameData() {
		return gameData;
	}

	public void setGameData(Game gameData) {
		this.gameData = gameData;
	}
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
}
