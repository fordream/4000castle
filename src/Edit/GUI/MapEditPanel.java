package Edit.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Controller.FileController;
import Data.Game;
import Data.Map;
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

	
		
		
		
		
		closeButton = new JButton(new ImageIcon("img/pre.png"));
		closeButton.setBounds(610, 440, 165, 50);
		closeButton.setBackground(Color.WHITE);
		closeButton.setOpaque(false);
		closeButton.setBorderPainted(false);
		closeButton.addActionListener(this);
		this.add(closeButton);
		
		editFieldMapPanel = new EditFieldMapPanel();
		this.add(editFieldMapPanel);
		
		editBolckPanel = new EditBolckPanel(getGameData());
		this.add(editBolckPanel);
		
	editButton = new JButton(new ImageIcon("img/save.png"));
		editButton.setBounds(610, 370, 160, 50);
		editButton.setBackground(Color.WHITE);
		editButton.setOpaque(false);
		editButton.setBorderPainted(false);
		editButton.addActionListener(this);
		this.add(editButton);
		
		JLabel picLabel = new JLabel(new ImageIcon("img/edit(background).png")); 
		picLabel.setBounds(0, 0, 850, 530);
		this.add(picLabel);
		
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
			Map map = new Map();
			map.setStatus(editFieldMapPanel.getStatus());
			map.setUseBlockList(editBolckPanel.getChosedBlockList());
			
			this.getGameData().getEditMapList().add(map);
		
			System.out.println("mapSize:"+getGameData().getEditMapList().size());
			
		
			
			FileController fileController = new FileController(gameData);
			fileController.writeToFile();
			
			

			getMainFrame().remove(this);
			getMainFrame().repaint();
			mainPanel = new MainPanel(mainFrame,gameData);
			getMainFrame().add(mainPanel);
			return;
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

