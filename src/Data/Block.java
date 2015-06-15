package Data;

import java.io.Serializable;
import java.nio.file.Path;

import javax.swing.ImageIcon;

public class Block implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2704515220388222793L;
	private ImageIcon imageIcon;
	private int tag;
	
	
	// constructors /////////////////////////////////////////////////////
	public Block( ImageIcon imageIcon, int tag )
	{
		setImageIcon( imageIcon );
		setTag( tag );
	}
	
	
	
	// getter setter ////////////////////////////////////////////////////
	public ImageIcon getImageIcon() {
		return imageIcon;
	}


	public void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}

	
	public int getTag() {
		return tag;
	}


	public void setTag(int tag) {
		this.tag = tag;
	}
	
}
