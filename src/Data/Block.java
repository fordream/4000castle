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
	private String imageIcon;
	private int tag;
	
	
	// constructors /////////////////////////////////////////////////////
	public Block( String imageIcon, int tag )
	{
		setImageIcon( imageIcon );
		setTag( tag );
	}
	
	
	
	// getter setter ////////////////////////////////////////////////////
	public String getImageIcon() {
		return imageIcon;
	}


	public void setImageIcon(String imageIcon) {
		this.imageIcon = imageIcon;
	}

	
	public int getTag() {
		return tag;
	}


	public void setTag(int tag) {
		this.tag = tag;
	}
	
}
