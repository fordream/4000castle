package Play.GUI;//문섭 변경

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Data.Game;
import Main.MainFrame;
import Main.MainPanel;

public class StagePanel extends JPanel implements ActionListener
{

	private PlayPanel playPanel;
	private MainPanel mainPanel;
	
	private JButton playButton, backButton;
	private JButton stageButton;
	private JButton nextButton, preButton;
	private ArrayList<JButton> stageButtonList = new ArrayList<JButton>();
	
	private JTextField bestTime = new JTextField();
	private JTextField stageNum;
	
	private Font font;
	
	static final int StageMax = 12;
	private int index;
	private int time;
	private int page = 1;
	
	private MainFrame mainFrame;
	private Game gameData;
	

	public StagePanel(MainFrame mainFrame,Game gameData) 
	{
		super();
		setGameData(gameData);
		this.setMainFrame(mainFrame);
		this.setBounds(0, 0, 850, 531);
		
		try 
		{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font/afont.ttf")));
	         
	    } 
		catch (Exception ex) 
		{
			System.err.println("error: file input stream (font)");
	    }
	
		font.getFont("afont");
		
		playButton = new JButton();
		playButton.setBounds(610, 390, 230, 70);
		playButton.setBackground(Color.white);
		playButton.setOpaque(false);
		playButton.setBorderPainted(false);
		playButton.setIcon(new ImageIcon("img/start (2).png"));
		playButton.addActionListener(this);
		this.add(playButton);
		
		
		backButton = new JButton();
		backButton.setBounds(610, 460, 230, 70);
		backButton.setBackground(Color.white);
		backButton.setOpaque(false);
		backButton.setBorderPainted(false);
		backButton.setIcon(new ImageIcon("img/pre (2).png"));
		backButton.addActionListener(this);
		this.add(backButton);
		
		
		stageButtonMake();
		stageButtonPrint(1);
		
		
		nextButton = new JButton();
		nextButton.setBounds(535, 470, 45, 45);
		nextButton.setBackground(Color.white);
		nextButton.setOpaque(false);
		nextButton.setBorderPainted(false);
		nextButton.setIcon(new ImageIcon("img/right.png"));
		nextButton.addActionListener(this);
		this.add(nextButton);
		
		
		preButton = new JButton();
		preButton.setBounds(10, 470, 45, 45);
		preButton.setBackground(Color.white);
		preButton.setOpaque(false);
		preButton.setBorderPainted(false);
		preButton.setIcon(new ImageIcon("img/left.png"));
		preButton.addActionListener(this);
		this.add(preButton);
		
		
		stageNum = new JTextField();
		stageNum.setText(page+" 페이지 ");
		stageNum.setFont(font);
		stageNum.setBounds(240, 470, 200, 50);
		stageNum.setForeground(Color.WHITE);
		stageNum.setOpaque(false);
		stageNum.setEditable(false);
		stageNum.setBorder(null);
		this.add(stageNum);
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
	
	public int getX(int i)
	{
		i = i%4;
		
		return 40 + 100*i + 30*i;
	}
	
	public int getY(int i)
	{
		i = i%StageMax;
		
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
	
	public void setImg(int i)
	{
		i = i%StageMax + 1;
		
		if(i == 0 && i > 1)
		{
			stageButton.setIcon(new ImageIcon("img/stagebutton12.png"));
		}
		else
		{
			stageButton.setIcon(new ImageIcon("img/stagebutton"+i+".png"));
		}
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
				setImg(i);
				stageButton.setBounds(getX(i), getY(i), 110, 100);
				stageButton.addActionListener(this);
				stageButtonList.add(stageButton);
			}
		}
	}
	
	
	
	public void bestTimePrint(int index)
	{
		time = this.getGameData().getEditMapList().get(index).getBestTime();
		
		if(time >= 60)
		{
			bestTime.setText(String.format("%02d:%02d",time/60,time%60));
		}
		else
		{
			bestTime.setText(String.format("00:%02d",time));
		}
		
		bestTime.setFont(font);
		bestTime.setBounds(680, 320, 100, 50);
		bestTime.setForeground(Color.WHITE);
		bestTime.setOpaque(false);
		bestTime.setEditable(false);
		bestTime.setBorder(null);
		this.add(bestTime);
	}
	
	public void buttonRemove(int page)
	{
		int conunt = (page - 1)  * StageMax;
		
		for(int i = conunt; i < this.getGameData().getEditMapList().size(); i++)
		{
			if(i < page * StageMax)
			{
				this.remove(stageButtonList.get(i));
				this.repaint();
			}
		}
	}
	
	public void setFont()
	{
		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for(int i = 0; i < this.getGameData().getEditMapList().size(); i++)
		{
			if(e.getSource() == stageButtonList.get(i))
			{
				bestTimePrint(i);
				index = i;
			}
		}
		
		if(e.getSource() == playButton)
		{
			getMainFrame().remove(this);
			getMainFrame().repaint();
			playPanel = new PlayPanel(mainFrame,gameData,index);//index는 stageButtonPrint에서 사용
			getMainFrame().add(playPanel);
		}
		else if(e.getSource() == backButton)
		{
			getMainFrame().remove(this);
			getMainFrame().repaint();
			mainPanel = new MainPanel(mainFrame,gameData);
			getMainFrame().add(mainPanel);
		}
		else if(e.getSource() == nextButton)
		{
			int stageSize;
			
			if(stageButtonList.size()%StageMax != 0)
			{
				stageSize = stageButtonList.size()/StageMax + 1;
			}
			else
			{
				stageSize = (stageButtonList.size()-1)/StageMax + 1;
			}
			
			if(page < stageSize)
			{
				buttonRemove(page);
				page++;
				stageNum.setText(page+" 페이지");
				stageButtonPrint(page);
			}
			else
			{
				stageNum.setText(stageSize+" 페이지");	
			}
			
		}
		else if(e.getSource() == preButton)
		{
			if(page > 1)
			{
				buttonRemove(page);
				page--;
				stageNum.setText(page+" 페이지");
				stageButtonPrint(page);
			}
			else
			{
				stageNum.setText("1 페이지");
			}
		}
	}	
}
