package Play.GUI;//construct parameter 변경

import java.io.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import Data.Game;
import Data.Map;
import Main.MainFrame;
import Main.MainPanel;


public class PlayPanel extends JPanel implements ActionListener
{

	private StagePanel stagePanel;

	private JPanel playPanel;
	private JLabel boardLabel;
	private JLabel timeLabel;
	private JButton closeButton;
	
	
	
	private MainFrame mainFrame;
	
	private Game gameData;
	private Map nowMap;
	
	private int oldSec;
	private int nowSec;
	private Font font;

	public PlayPanel(MainFrame mainFrame, Game gameData, int index) {
		super();
		this.setLayout(null);
		setGameData(gameData);
		setNowMap(gameData.getEditMapList().get(index));
		
		// font set ////
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font/afont.ttf")));
			
		} catch (Exception ex) {
			System.err.println("error: file input stream (font)");
		}
		
		this.setMainFrame(mainFrame);
		this.setBounds(0, 0, 850, 530);
		
		playPanel = new JPanel();
		playPanel.setBounds(25, 25, 480, 480);
		playPanel.setOpaque(false);
		
		boardLabel = new JLabel(new ImageIcon("img/board.png"));
		boardLabel.setBounds(0, 0, 480, 480);
		playPanel.add(boardLabel);
		this.add(playPanel);
		
		timeLabel = new JLabel();
		timeLabel.setBounds(635, 320, 120, 50);
		timeLabel.setText("00:00");
		timeLabel.setFont(new Font("a태백산맥", Font.PLAIN, 40));
		timeLabel.setForeground(Color.WHITE);
		this.add(timeLabel);
		
		// time thread
		nowSec = 0;
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				int min = nowSec / 60;
				int sec = nowSec % 60;
				String minStr;
				String secStr;
				if (min < 10)
					minStr = "0" + min;
				else
					minStr = String.format("%d", min);
				if (sec < 10)
					secStr = "0" + sec;
				else
					secStr = String.format("%d", sec);
				
				timeLabel.setText(minStr + ":" + secStr);
				nowSec++;
			}
			
		};
		timer.schedule(task, 0, 1000);
		
		closeButton = new JButton("BACK");
		closeButton.setBounds(600, 430, 230, 75);
		closeButton.setText("");
		closeButton.setBackground(Color.white);
		closeButton.setOpaque(false);
		closeButton.setBorderPainted(false);
		closeButton.setIcon(new ImageIcon("img/pre (2).png"));
		closeButton.addActionListener(this);
		this.add(closeButton);
		
		
	}

	
	
	@Override
	public void paintComponent( Graphics g )
	{
		super.paintComponent(g);
		Image image = new ImageIcon("img/play(background).png").getImage();
		g.drawImage(image, 0, 0, this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == closeButton)
		{
			getMainFrame().remove(this);
			getMainFrame().repaint();
			stagePanel = new StagePanel(mainFrame,gameData);
			getMainFrame().add(stagePanel);
		}
	}
	
	
	
	
	public Game getGameData() {
		return gameData;
	}

	public void setGameData(Game gameData) {
		this.gameData = gameData;
	}
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public Map getNowMap() {
		return nowMap;
	}

	public void setNowMap(Map nowMap) {
		this.nowMap = nowMap;
	}
	
	
}
