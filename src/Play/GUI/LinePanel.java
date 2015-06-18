package Play.GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class LinePanel extends JPanel {

	private int startX;
	private int startY;
	
	private int curve1X;
	private int curve1Y;
	
	private int curve2X;
	private int curve2Y;
	
	private int reachX;
	private int reachY;
	 

	public LinePanel(ArrayList<Integer> X,ArrayList<Integer> Y) 
	{
		super();
		this.setBounds(0, 0, 480, 480);
		
		if(X.size()>=2)
		{
		startX = X.get(0);
		startY = Y.get(0);
		}
		if(X.size()>=3)
		{
			curve1X = X.get(1);
			curve1Y = Y.get(1);
		}
		if(X.size()>=4)
		{
			curve2X = X.get(2);
			curve2Y = Y.get(2);
		}
		reachX = X.get(X.size()-1);
		reachY = Y.get(Y.size()-1);

		

		
		/*
		for(int i=1;X.get(i)!= reachX;i++)
		{
			if((X.get(i) - X.get(i-1) != X.get(i+1) - X.get(i))||(Y.get(i) - Y.get(i-1) != Y.get(i+1) - Y.get(i)))
			{
				if(curve1X ==0)
				{
					curve1X = X.get(i);
					curve1Y = Y.get(i);
				}
				else if(curve2X ==0)
				{
					curve2X = X.get(i);
					curve2Y = Y.get(i);
				}
			}
		}
		*/
	}

	public void paintComponent(Graphics g2) 
	{
		
		Graphics2D g = (Graphics2D)g2;
		g.setColor(Color.RED);
		g.setStroke(new BasicStroke(4));
		
		if(curve1X ==0)
		{
			g.drawLine(20+startX*40, 20+startY*40, 20+reachX*40, 20+reachY*40);
		}
		else if(curve2X ==0)
		{
			g.drawLine(20+startX*40, 20+startY*40, 20+curve1X*40, 20+curve1Y*40);
			g.drawLine(20+curve1X*40, 20+curve1Y*40, 20+reachX*40, 20+reachY*40);
		}
		else
		{
			g.drawLine(20+startX*40, 20+startY*40, 20+curve1X*40, 20+curve1Y*40);
			g.drawLine(20+curve1X*40, 20+curve1Y*40, 20+curve2X*40, 20+curve2Y*40);
			g.drawLine(20+curve2X*40, 20+curve2Y*40, 20+reachX*40, 20+reachY*40);
		}
	}
}
