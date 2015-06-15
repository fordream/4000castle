package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Data.Game;
import Edit.GUI.MapEditPanel;
import Play.GUI.StagePanel;


public class MainFrame extends SimpleJFrame 
{

	private MainPanel mainPanel;
	Game gameData;

	
	
	public MainFrame() {
		super("MainFrame", 850, 530);
		
		mainPanel = new MainPanel(this,gameData);
		
		this.add(mainPanel);
		
		
		
		// TODO Auto-generated constructor stub
	}


}
