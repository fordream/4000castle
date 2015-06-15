package Edit.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Data.Game;

public class EditFieldMapPanel extends JPanel implements ActionListener
{

	
	private final int size = 10;
	private JLabel picLabel;
	private int status[][];
	private JButton mapButton[][];



	EditFieldMapPanel()
	{
		this.setBounds(30, 30, 480, 480);
		this.setBackground(Color.BLACK);
		mapButton = new JButton[size+2][size+2];
		status = new int[size+2][size+2];
		for(int i=0;i<size+2;i++)
		{
			for(int j=0;j<size+2;j++)
			{

				status[i][j] =0;
				if(i == 0||i ==size+1||j == 0||j ==size+1)
				{
					status[i][j] =0xff;
				}
			}

		}
		showMap();
		

		
		
	}
	public void showMap()
	{
		
		
		for(int i=0;i<size+2;i++)
		{
			for(int j=0;j<size+2;j++)
			{
				mapButton[i][j] = new JButton();
				mapButton[i][j].setBackground(Color.WHITE);
				
				if(status[i][j] ==1)
				{
					mapButton[i][j].setBackground(Color.BLACK);
					
				}
				else if(status[i][j] == 0xff)
				{
					mapButton[i][j].setBackground(Color.GRAY);
				}
				else
					mapButton[i][j].setOpaque(false);
				mapButton[i][j].setBorderPainted(false);
				mapButton[i][j].setBounds(i*40,j*40,40,40);
				mapButton[i][j].addActionListener(this);

				this.add(mapButton[i][j]);

			}
		}
		picLabel = new JLabel(new ImageIcon("img/board.png")); 
		picLabel.setBounds(0, 0, 480, 480);
		this.add(picLabel);
		
	}
	public void removeMap()
	{
		
		this.remove(picLabel);
		for(int i=0;i<size+2;i++)
		{
			for(int j=0;j<size+2;j++)
			{
				this.remove(mapButton[i][j]);
			}
		}
		this.repaint();
	}
	

	public int checkMapOdd()
	{
		int sum=0;
		for(int i=0;i<size+2;i++)
		{
			for(int j=0;j<size+2;j++)
			{
				 sum+=status[i][j];
			}

		}
		if((sum/=2) ==0)
			return 1;
		return 0;
			
	}
	public int[][] getStatus() {
		return status;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<size+2;i++)
		{
			for(int j=0;j<size+2;j++)
			{
				if(e.getSource() == mapButton[i][j])
				{
					if(status[i][j]==1)
						status[i][j] =0;
					else if(status[i][j]==0)
						status[i][j] =1;
					removeMap();
					showMap();
				}
			}
		}
	}
	public void setStatus(int[][] status) {
		this.status = status;
	}
	
	
}
