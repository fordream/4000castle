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
		this.setBounds(0, 0, 500, 500);
		
		
		label = new JLabel("edit ");
		label.setBounds(250, 50, 100, 50);
		this.add(label);
		
		editButton = new JButton("EDIT");
		editButton.setBounds(350, 400, 100, 50);
		editButton.addActionListener(this);
		this.add(editButton);
		
		
		closeButton = new JButton("BACK");
		closeButton.setBounds(350, 450, 100, 50);
		closeButton.addActionListener(this);
		this.add(closeButton);
		
		editFieldMapPanel = new EditFieldMapPanel();
		this.add(editFieldMapPanel);
		
		editBolckPanel = new EditBolckPanel(gameData);
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

