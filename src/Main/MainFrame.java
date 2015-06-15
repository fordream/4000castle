package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.FileController;
import Data.Game;
import Edit.GUI.MapEditPanel;
import Play.GUI.StagePanel;


public class MainFrame extends SimpleJFrame 
{

	private MainPanel mainPanel;
	private Game gameData;

	
	
	public Game getGameData() {
		return gameData;
	}



	public void setGameData(Game gameData) {
		this.gameData = gameData;
	}



	public MainFrame() {
		super("MainFrame", 850, 530);
		gameData = new Game();
		
		FileController fileController = new FileController(gameData);
		fileController.readFromFile();
		this.setGameData(fileController.getData());
		
		mainPanel = new MainPanel(this,gameData);
		this.add(mainPanel);
		this.repaint();
		
		
		
		// TODO Auto-generated constructor stub
	}


}
