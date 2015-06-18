package Play.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.FileController;
import Data.Game;
import Data.Map;
import Main.MainFrame;

public class ClearPanel extends JPanel implements ActionListener
{
	private MainFrame mainFrame;
	private PlayPanel playPanel;
	private StagePanel stagePanel;
	private Game gameData;
	private Map nowMap;
	
	private JLabel clearLabel;
	private JLabel bestLabel;
	private JButton clearButton;
	
	public ClearPanel(MainFrame mainFrame, PlayPanel playPanel, StagePanel stagePanel,
			Game gameData, Map nowMap, int clearSec)
	{
		super();
		this.setLayout(null);
		this.setBounds(0, 0, 850, 530);
		this.setBackground(Color.WHITE);
		
		this.mainFrame = mainFrame;
		this.playPanel = playPanel;
		this.stagePanel = stagePanel;
		this.gameData = gameData;
		this.nowMap = nowMap;
		
		System.out.println(nowMap.getBestTime());
		mainFrame.remove(playPanel);
		mainFrame.repaint();
		mainFrame.add(this);
		
		System.out.println(clearSec);
		System.out.println(nowMap.getBestTime());
		
		int min = clearSec / 60;
		int sec = clearSec % 60;
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
		
		clearLabel = new JLabel();
		clearLabel.setBounds(375, 220, 120, 50);
		clearLabel.setText( minStr + ":" + secStr );
		clearLabel.setFont(new Font("aÅÂ¹é»ê¸Æ", Font.PLAIN, 40));
		clearLabel.setForeground(Color.WHITE);
		this.add(clearLabel);
		
		if (nowMap.getBestTime() < clearSec || nowMap.getBestTime() != 0) {
			min = nowMap.getBestTime() / 60;
			sec = nowMap.getBestTime() % 60;
			if (min < 10)
				minStr = "0" + min;
			else
				minStr = String.format("%d", min);
			if (sec < 10)
				secStr = "0" + sec;
			else
				secStr = String.format("%d", sec);
		}
		
		bestLabel = new JLabel();
		bestLabel.setBounds(375, 310, 120, 50);
		bestLabel.setText( minStr + ":" + secStr );
		bestLabel.setFont(new Font("aÅÂ¹é»ê¸Æ", Font.PLAIN, 40));
		bestLabel.setForeground(Color.WHITE);
		this.add(bestLabel);
		
		clearButton = new JButton();
		clearButton.setBounds(850 / 2 - 90, 530 / 2 + 100, 200, 70);
		clearButton.setIcon(new ImageIcon("img/ok.png"));
		clearButton.setOpaque(false);
		clearButton.setBackground(Color.WHITE);
		clearButton.setBorderPainted(false);
		clearButton.addActionListener(this);
		this.add(clearButton);
		
	}
	
	@Override
	public void paintComponent( Graphics g )
	{
		super.paintComponent(g);
		Image image = new ImageIcon("img/clear(background).png").getImage();
		g.drawImage(image, 425 - 266,  265 - 173, this);
	}
	
	@Override
	public void actionPerformed( ActionEvent e )
	{
		mainFrame.remove(this);
		mainFrame.repaint();
		stagePanel = new StagePanel(mainFrame, gameData);
		mainFrame.add(stagePanel);
	}
}
