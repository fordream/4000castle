package Main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class SimpleJFrame extends JFrame implements MouseListener, MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9127497222893341368L;
	protected int WIDTH;
	protected int HEIGHT;
	protected int x;
	protected int y;
	protected int tempX;
	protected int tempY;
	
	public int getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public SimpleJFrame(String frameName, int width, int height) {
		super(frameName);
		WIDTH = width;
		HEIGHT = height;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLayout(null);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		// 창 기본 설정
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.getRootPane().setBorder(BorderFactory.); // frame에 테두리 적용
		this.getContentPane().setBackground(Color.WHITE);
		this.setSize(WIDTH, HEIGHT);
		this.setLocation(x = screen.width / 2 - WIDTH/2, y = screen.height / 2 - HEIGHT/2);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mouseMoved(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
		tempX = arg0.getX();
		tempY = arg0.getY();
	}

	public void mouseDragged(MouseEvent arg0) {
		x = arg0.getXOnScreen() - tempX;
		y = arg0.getYOnScreen() - tempY;
		
		this.setBounds(x, y, WIDTH, HEIGHT);
	}
	
}
