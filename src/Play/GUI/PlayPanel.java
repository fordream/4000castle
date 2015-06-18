package Play.GUI;//construct parameter º¯°æ

import java.io.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.border.Border;

import Controller.FileController;
import Data.Block;
import Data.Game;
import Data.Map;
import Main.MainFrame;
import Main.MainPanel;
import Play.MapMaker;
import Play.MapPlay;


public class PlayPanel extends JPanel implements ActionListener
{
	
	private final int size = 10;
	private final int blockSize = 40;
	
	private StagePanel stagePanel;
	private ClearPanel clearPanel;
	
	private JPanel playPanel;
	private JLabel boardLabel;
	private JLabel timeLabel;
	private JLabel countLabel;
	private JLabel connectLabel;
	private JButton blockButton[][];
	private JButton closeButton;
	
	private MainFrame mainFrame;
	
	private Game gameData;
	private Map nowMap;
	private Block[][] arrayBlock;
	private MapMaker maker;
	private MapPlay play;
	private int index;
	
	private Timer timer;
	private int nowSec;
	
	private int beforeX, beforeY;
	
	public PlayPanel(MainFrame mainFrame, Game gameData, int index) {
		super();
		this.setLayout(null);
		setGameData(gameData);
		this.nowMap = gameData.getEditMapList().get(index);
		this.index = index;
		maker = new MapMaker(getNowMap());
		play = new MapPlay(maker);
		beforeX = 0;
		beforeY = 0;
		
		System.out.println("play data besttime index " + index + " : " + nowMap.getBestTime());
		
		// font set /////////////
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
		playPanel.setLayout(null);
		
		arrayBlock = maker.getArrayBlock();
		blockButton = new JButton[ size + 2 ][ size + 2 ];
		for (int yy = 0; yy <= size + 1; yy++)
		{
			for (int xx = 0; xx <= size + 1; xx++)
			{
				System.out.printf("%d ", arrayBlock[yy][xx].getTag());
				if (arrayBlock[ yy ][ xx ].getTag() == 0xff)
				{
					blockButton[yy][xx] = new JButton();
					blockButton[yy][xx].setBounds(blockSize * xx, blockSize * yy, blockSize, blockSize);
					blockButton[yy][xx].setText("");
					blockButton[yy][xx].setBackground(Color.RED);
					blockButton[yy][xx].setBorderPainted(false);
					playPanel.add(blockButton[yy][xx]);
				}
				else if (arrayBlock[yy][xx].getTag() != 0)
				{
					blockButton[yy][xx] = new JButton();
					blockButton[yy][xx].setBounds(blockSize * xx, blockSize * yy, blockSize, blockSize);
					blockButton[yy][xx].setText("");
					blockButton[yy][xx].setIcon(new ImageIcon(arrayBlock[yy][xx].getImageIcon()));
					blockButton[yy][xx].setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
					blockButton[yy][xx].setBorderPainted(false);
					blockButton[yy][xx].addActionListener(this);
					playPanel.add(blockButton[yy][xx]);
				}
				else
				{
					blockButton[yy][xx] = new JButton();
					blockButton[yy][xx].setBounds(blockSize * xx, blockSize * yy, blockSize, blockSize);
					blockButton[yy][xx].setText("");
					blockButton[yy][xx].setBorderPainted(false);
					blockButton[yy][xx].setOpaque(false);
				}
			}
			System.out.println();
		}
		boardLabel = new JLabel(new ImageIcon("img/board.png"));
		boardLabel.setBounds(0, 0, 480, 480);
		playPanel.add(boardLabel);
		this.add(playPanel);
		
		timeLabel = new JLabel();
		timeLabel.setBounds(635, 320, 120, 50);
		timeLabel.setText("00:00");
		timeLabel.setFont(new Font("aÅÂ¹é»ê¸Æ", Font.PLAIN, 40));
		timeLabel.setForeground(Color.WHITE);
		this.add(timeLabel);
		
		// time thread
		nowSec = 0;
		timer = new Timer();
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
		
		countLabel = new JLabel();
		countLabel.setBounds(700, 110, 70, 50);
		countLabel.setText( String.format( "%d", play.getBlockCnt() ) );
		countLabel.setFont(new Font("aÅÂ¹é»ê¸Æ", Font.PLAIN, 40));
		countLabel.setForeground(Color.WHITE);
		this.add(countLabel);
		
		connectLabel = new JLabel();
		connectLabel.setBounds(700, 173, 70, 50);
		connectLabel.setText( String.format( "%d", play.getConnectableCnt() ) );
		connectLabel.setFont(new Font("aÅÂ¹é»ê¸Æ", Font.PLAIN, 40));
		connectLabel.setForeground(Color.WHITE);
		this.add(connectLabel); 
		
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
		
		for (int yy = 1; yy <= size; yy++)
			for (int xx = 1; xx <= size; xx++)
				if (e.getSource() == blockButton[yy][xx])
				{
					if (xx == beforeX && yy == beforeY)
						continue;
					
					blockButton[beforeY][beforeX].setBorderPainted(false);
					blockButton[yy][xx].setBorderPainted(true);
					
					if (arrayBlock[beforeY][beforeX].getTag() == arrayBlock[yy][xx].getTag())
					{
						if (play.checkConnectable(xx, yy, beforeX, beforeY, -1, 0))
						{
							blockButton[yy][xx].removeActionListener(this);
							blockButton[yy][xx].setBackground(Color.WHITE);
							blockButton[yy][xx].setIcon(null);
							blockButton[yy][xx].setBorderPainted(false);
							blockButton[yy][xx].setOpaque(false);
							blockButton[yy][xx].removeAll();
							blockButton[beforeY][beforeX].removeActionListener(this);
							blockButton[beforeY][beforeX].setBackground(Color.WHITE);
							blockButton[beforeY][beforeX].setIcon(null);
							blockButton[beforeY][beforeX].setBorderPainted(false);
							blockButton[beforeY][beforeX].setOpaque(false);
							blockButton[beforeY][beforeX].removeAll();
							
							play.printStack();
							play.stackClear();
							
							play.deletePositionBlock(xx, yy);
							play.deletePositionBlock(beforeX, beforeY);
							play.countBlock();
							play.countConnectableBlock();
							
							countLabel.setText( String.format("%d", play.getBlockCnt()) );
							connectLabel.setText( String.format("%d", play.getConnectableCnt()) );
							
							
							
							beforeX = 0;
							beforeY = 0;
							playPanel.repaint();
						}
						else 
						{
							beforeX = xx;
							beforeY = yy;
						}
					}
					else
					{
						beforeX = xx;
						beforeY = yy;
					}
				}
		
		if(e.getSource() == closeButton)
		{
			getMainFrame().remove(this);
			getMainFrame().repaint();
			stagePanel = new StagePanel(mainFrame,gameData);
			getMainFrame().add(stagePanel);
		}
		
		if (play.getBlockCnt() == 0)
		{
			getMainFrame().repaint();
			timer.cancel();
			closeButton.removeActionListener(this);
			setNowMap(nowMap);
			clearPanel = new ClearPanel(mainFrame, this, stagePanel, gameData, nowMap, nowSec);
			
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
		if (nowMap.getBestTime() == 0 || nowMap.getBestTime() > nowSec)
		{
			System.out.println("11111111111 " + nowMap.getBestTime() + " " + nowSec);
			nowMap.setBestTime(nowSec);
			ArrayList<Map> temp = gameData.getEditMapList();
			Map tempMap = temp.get(index);
			tempMap.setBestTime(nowSec);
			temp.set(index, tempMap);
			gameData.setEditMapList(temp);
			System.out.println(nowMap.getBestTime());
		}
		FileController file = new FileController(gameData);
		System.out.println("data besttime : " + gameData.getEditMapList().get(index).getBestTime());
		file.writeToFile();
	}
	
	
}
