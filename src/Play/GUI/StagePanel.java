package Play.GUI;//문섭 변경

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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
	private JButton stageButton;
	private ArrayList<JButton> stageButtonList = new ArrayList<JButton>();
	
	private JLabel stageNum;
	
	static final int StageMax = 12;
	
	private MainFrame mainFrame;
	private Game gameData;
	

	public StagePanel(MainFrame mainFrame,Game gameData) 
	{
		super();
		setGameData(gameData);
		this.setMainFrame(mainFrame);
		this.setBounds(0, 0, 850, 531);
	
		playButton = new JButton("시작");
		playButton.setBounds(620, 390, 230, 70);
		playButton.setBackground(Color.white);
		playButton.setOpaque(false);
		playButton.setBorderPainted(false);
		playButton.setIcon(new ImageIcon("img/start (2).png"));
		playButton.addActionListener(this);
		this.add(playButton);
		
		
		backButton = new JButton("돌아가기");
		backButton.setBounds(620, 460, 230, 70);
		backButton.setBackground(Color.white);
		backButton.setOpaque(false);
		backButton.setBorderPainted(false);
		backButton.setIcon(new ImageIcon("img/pre (2).png"));
		backButton.addActionListener(this);
		this.add(backButton);
		
		stageButtonMake();
		stageButtonPrint(1);
		
		
	}
	
	public Game getGameData() 
	{
		return gameData;
	}

	public void setGameData(Game gameData) 
	{
		this.gameData = gameData;
	}

	public MainFrame getMainFrame() 
	{
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) 
	{
		this.mainFrame = mainFrame;
	}
	
	public void paintComponent( Graphics g )
	{
		super.paintComponent(g);
		Image image = new ImageIcon("img/start(background).png").getImage();
		g.drawImage(image, 0, 0, this);
	}
	
	public void stageButtonPrint(int page)
	{
		int conunt = (page - 1)  * StageMax;
		
		for(int i = conunt; i < this.getGameData().getEditMapList().size(); i++)
		{
			if(i < page * StageMax)
			{
				stageButtonList.get(i).setBounds(getX(i), getY(i % StageMax), 110, 100);
				stageButtonList.get(i).addActionListener(
						new ActionListener()
						{
							public void actionPerformed(ActionEvent event)
							{
								
							}
						});
				this.add(stageButtonList.get(i));
			}
		}
	}
	
	public void stageButtonMake()
	{
		if(this.getGameData().getEditMapList().size() > 0)
		{
			for(int i = 0; i < this.getGameData().getEditMapList().size(); i++)
			{
				stageButton = new JButton();
				stageButton.setBackground(Color.white);
				stageButton.setOpaque(false);
				stageButton.setBorderPainted(false);
				stageButton.setIcon(new ImageIcon("img/stagebutton.png"));
				stageButtonList.add(stageButton);
			}
		}
	}
	
	public int getX(int i)
	{
		i = i%4;
		
		return 40 + 100*i + 30*i;
	}
	
	public int getY(int i)
	{
		if(i < 4)
		{
			return 110;
		}
		else if(i >= 4 && i < 8)
		{
			return 240;
		}
		else
		{
			return 370;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		if(e.getSource() == playButton)
		{
			getMainFrame().remove(this);
			getMainFrame().repaint();
			playPanel = new PlayPanel(mainFrame,gameData,0);
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
