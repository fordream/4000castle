package Edit.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Controller.FileController;
import Data.Block;
import Data.Game;

public class EditBolckPanel extends JPanel implements ActionListener{

	private ArrayList<JButton> block;
	private Game gameData;
	private JLabel backLabel;
	
	public ArrayList<Block> getChosedBlockList() {
		return chosedBlockList;
	}
	private ArrayList< Block > chosedBlockList;
	private JButton addButton;
	
	
	public Game getGameData() {
		return gameData;
	}
	public void setGameData(Game gameData) {
		this.gameData = gameData;
	}
	
	EditBolckPanel(Game gameData)
	{
		setGameData(gameData);
		
		this.setBounds(515,30,330,350);
		this.setBackground(Color.WHITE);
		this.setOpaque(false);
		
		block = new ArrayList<JButton>();
		chosedBlockList = new ArrayList< Block >();
		
		
		addButton = new JButton(new ImageIcon("img/add.png"));
		addButton.setBackground(Color.WHITE);
		addButton.setBounds(90,270, 165, 50);
		addButton.setBorderPainted(false);
		addButton.setOpaque(false);
		
		addButton.addActionListener(this);
		this.add(addButton);
		
		showBlockList();
		
		
	}
	public void showBlockList()
	{
	
		
		this.repaint();
		block.clear();
		System.out.println("block size:"+gameData.getBlockList().size());
		for(int i=0;i<gameData.getBlockList().size();i++)
		{
			JButton temp = new JButton(new ImageIcon(gameData.getBlockList().get(i).getImageIcon()));
			temp.setBounds(5+40*(i%8),60+40*(i/8), 40, 40);
			temp.setBorder(new LineBorder(Color.WHITE,2));
			
			temp.setOpaque(false);
			temp.addActionListener(this);
			this.add(temp);
			block.add(temp);
			System.out.println(i);
		}
		backLabel = new JLabel(new ImageIcon("img/blocklist.png")); 
		backLabel.setBounds(0,0, 330, 240);
		this.add(backLabel);
		
	}
	public void removeBlockList()
	{
		this.remove(backLabel);
		for(int i=0;i<gameData.getBlockList().size()-1;i++)
		{
			this.remove(block.get(i));
		}
	}
	
	public void addBlock()
	{
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = jFileChooser.showOpenDialog(this);
		if(result == JFileChooser.CANCEL_OPTION)
			return;
		Path path = jFileChooser.getSelectedFile().toPath();
		Block temp = new Block(path+"",gameData.getBlockList().size()+1);
		gameData.getBlockList().add(temp);
		
		FileController fileController = new FileController(gameData);
		fileController.writeToFile();
		
		
		System.out.println(gameData.getBlockList().size());
		removeBlockList();
		showBlockList();
		
		
	}
	
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
		for(int i=0;i<gameData.getBlockList().size();i++)
		{
			if(e.getSource() == block.get(i))
			{
				if(!chosedBlockList.contains(gameData.getBlockList().get(i)))
				{
					
					//block.get(i).setBorderPainted(true);
					block.get(i).setBorder(new LineBorder(Color.GREEN,2));
					chosedBlockList.add(gameData.getBlockList().get(i));
				}
				else
				{
					chosedBlockList.remove(gameData.getBlockList().get(i));
					//block.get(i).setBorderPainted(false);
					block.get(i).setBorder( new LineBorder(Color.WHITE,2));
				}
				System.out.println(gameData.getBlockList().get(i).getTag() +""+ gameData.getBlockList().size()+""+ 
						chosedBlockList);
			}
		}

		
		if(e.getSource() == addButton)
		{
			addBlock();
		}
		
		
	}
	
}
