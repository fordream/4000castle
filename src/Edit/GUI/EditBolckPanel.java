package Edit.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import Data.Game;

public class EditBolckPanel extends JPanel implements ActionListener{

	private ArrayList<JButton> block;
	private Game gameData;
	
	public Game getGameData() {
		return gameData;
	}
	public void setGameData(Game gameData) {
		this.gameData = gameData;
	}
	
	EditBolckPanel(Game gameData)
	{
		setGameData(gameData);
		
		this.setBounds(300, 60,150,300);
		this.setBackground(Color.WHITE);
		
		block = new ArrayList<JButton>();
		
		
	}
	public void showBlockList()
	{
	
		
	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
