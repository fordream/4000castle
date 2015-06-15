package Edit.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Data.Game;
import Main.MainFrame;
import Main.MainPanel;
import Play.GUI.StagePanel;

public class MapEditPanel extends JPanel implements ActionListener
{

	private	 EditBolckPanel editBolckPanel;
	private MainPanel mainPanel;
	private JButton editButton;
	private JButton closeButton;
	private JLabel label;
	private MainFrame mainFrame;
	private EditFieldMapPanel editFieldMapPanel;
	private Game gameData;
	
	public Game getGameData() {
		return gameData;
	}


	public void setGameData(Game gameData) {
		this.gameData = gameData;
	}


	public MapEditPanel(MainFrame mainFrame,Game gameData) {
		super();
		
		
		this.setMainFrame(mainFrame);
		this.setBounds(0, 0, 850, 530);
		
		setGameData(gameData);

		
		editButton = new JButton("EDIT");
		editButton.setBounds(635, 440, 100, 30);
		editButton.addActionListener(this);
		this.add(editButton);
		
		
		closeButton = new JButton("BACK");
		closeButton.setBounds(635, 480, 100, 30);
		closeButton.addActionListener(this);
		this.add(closeButton);
		
		editFieldMapPanel = new EditFieldMapPanel();
		this.add(editFieldMapPanel);
		
		editBolckPanel = new EditBolckPanel(getGameData());
		this.add(editBolckPanel);
		
	
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
		
		if(e.getSource() == editButton)
		{
		
		}
		else if(e.getSource() == closeButton)
		{
			getMainFrame().remove(this);
			getMainFrame().repaint();
			mainPanel = new MainPanel(mainFrame,gameData);
			getMainFrame().add(mainPanel);
			return;
		}
		
	}
		
}

