package Main;//¹®¼· º¯°æ

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.FileController;
import Controller.FileController;
import Data.Game;
import Edit.GUI.MapEditPanel;
import Play.GUI.StagePanel;


public class MainPanel extends JPanel implements ActionListener
{

	private MainFrame mainFrame;
	private StagePanel stagePanel;
	private MapEditPanel mapEditPanel;
	
	private JButton playButton;
	private JButton editButton;
	private JButton closeButton;
	private Game gameData;
	
	
	public MainPanel(MainFrame mainFrame,Game gameData) 
	{
		super();
	
		this.setMainFrame(mainFrame);
		setGameData(gameData);
		
		this.setBounds(0, 0, 850, 530);
		
		
		playButton = new JButton("PLAY");
		playButton.setBounds(320, 270, 275, 80);
		playButton.setBackground(Color.white);
		playButton.setOpaque(false);
		playButton.setBorderPainted(false);
		playButton.setIcon(new ImageIcon("img/start.png"));
		playButton.addActionListener(this);
		this.add(playButton);
		
		editButton = new JButton("EDIT");
		editButton.setBounds(320, 350, 275, 80);
		editButton.setBackground(Color.white);
		editButton.setOpaque(false);
		editButton.setBorderPainted(false);
		editButton.setIcon(new ImageIcon("img/edit.png"));
		editButton.addActionListener(this);
		this.add(editButton);
		
		closeButton = new JButton("CLOSE");
		closeButton.setBounds(320, 430, 275, 80);
		closeButton.setBackground(Color.white);
		closeButton.setOpaque(false);
		closeButton.setBorderPainted(false);
		closeButton.setIcon(new ImageIcon("img/exit.png"));
		closeButton.addActionListener(this);
		this.add(closeButton);
		
		/*
		FileController fileController = new FileController(gameData);
		fileController.readFromFile();
		this.setGameData(fileController.getData());*/
	}
	
	public Game getGameData() 
	{
		return gameData;
	}
	
	public void setGameData(Game gameData) 
	{
		this.gameData = gameData;
	}

	public void paintComponent( Graphics g )
	{
		super.paintComponent(g);
		Image image = new ImageIcon("img/home(background).png").getImage();
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == playButton)
		{
			getMainFrame().remove(this);
			getMainFrame().repaint();
			stagePanel = new StagePanel(mainFrame,gameData);
			getMainFrame().add(stagePanel);
		}
		else if(e.getSource() == editButton)
		{
			getMainFrame().remove(this);
			getMainFrame().repaint();
			mapEditPanel = new MapEditPanel(mainFrame,gameData);
			getMainFrame().add(mapEditPanel);
		}
		else if(e.getSource() == closeButton)
		{
			getMainFrame().dispose();
		}
	}

	public MainFrame getMainFrame() 
	{
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) 
	{
		this.mainFrame = mainFrame;
	}
}
