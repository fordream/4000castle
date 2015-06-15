package Play.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Data.Game;
import Main.MainFrame;
import Main.MainPanel;

public class StagePanel extends JPanel implements ActionListener
{

	private PlayPanel playPanel;
	private MainPanel mainPanel;
	
	private JButton playButton;
	private JButton backButton;
	private JLabel label;
	
	private MainFrame mainFrame;
	
	public Game getGameData() {
		return gameData;
	}


	public void setGameData(Game gameData) {
		this.gameData = gameData;
	}


	private Game gameData;
	
	public StagePanel(MainFrame mainFrame,Game gameData) {
		super();
		setGameData(gameData);
		this.setMainFrame(mainFrame);
		this.setBounds(0, 0, 500, 500);
	
		label = new JLabel("STAGE");
		label.setBounds(250, 100, 100, 50);
		this.add(label);
		
		playButton = new JButton("시작");
		playButton.setBounds(250, 200, 100, 50);
		playButton.addActionListener(this);
		this.add(playButton);
		
		
		backButton = new JButton("돌아가기");
		backButton.setBounds(250, 400, 100, 50);
		backButton.addActionListener(this);
		this.add(backButton);

	}


	public MainFrame getMainFrame() {
		return mainFrame;
	}


	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == playButton)
		{
			getMainFrame().remove(this);
			getMainFrame().repaint();
			playPanel = new PlayPanel(mainFrame,gameData);
			getMainFrame().add(playPanel);
		}
		else if(e.getSource() == backButton)
		{
			getMainFrame().remove(this);
			getMainFrame().repaint();
			mainPanel = new MainPanel(mainFrame,gameData);
			getMainFrame().add(mainPanel);
		}
	}
		
}
