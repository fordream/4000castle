package Edit.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Data.Block;
import Data.Game;

public class EditBolckPanel extends JPanel implements ActionListener{

	private ArrayList<JButton> block;
	private Game gameData;
	
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
		
		this.setBounds(600, 40 ,160,320);
		this.setBackground(Color.WHITE);
		
		block = new ArrayList<JButton>();
		chosedBlockList = new ArrayList< Block >();
		
		
		addButton = new JButton("+");
		addButton.setBounds(120, 280, 40, 40);
		addButton.addActionListener(this);
		this.add(addButton);
		
		showBlockList();
		
		
	}
	public void showBlockList()
	{
	
		
		this.repaint();
		block.clear();
		
		for(int i=0;i<gameData.getBlockList().size();i++)
		{
			
			System.out.println(gameData.getBlockList().get(i).getImageIcon());
			JButton temp = new JButton(gameData.getBlockList().get(i).getImageIcon());
			temp.setBounds(0+40*(i%4),0+40*(i/4), 40, 40);
			temp.setBorder(new LineBorder(Color.WHITE,2));
			temp.addActionListener(this);
			this.add(temp);
			block.add(temp);
			System.out.println(i);
		}
	}
	public void removeBlockList()
	{
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
		ImageIcon imageIcon = new ImageIcon(path+"");
		Block temp = new Block(imageIcon,gameData.getBlockList().size()+1);
		gameData.getBlockList().add(temp);
		
		
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
					block.get(i).setBorder( new LineBorder(Color.GREEN,2));
					chosedBlockList.add(gameData.getBlockList().get(i));
				}
				else
				{
					chosedBlockList.remove(gameData.getBlockList().get(i));
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
