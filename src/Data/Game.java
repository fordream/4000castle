package Data;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6104045977288676683L;
	private ArrayList< Map > originMapList;
	private ArrayList< Map > editMapList;
	private ArrayList< Block > blockList;
	
	
	// constructor ///////////////////////////////////////////////////
	public Game()
	{
		setOriginMapList( new ArrayList< Map >() );
		setEditMapList( new ArrayList< Map >() );
		setBlockList( new ArrayList< Block >() );
	}
	
	// getter setter /////////////////////////////////////////////////
	public ArrayList<Map> getOriginMapList() {
		return originMapList;
	}


	public void setOriginMapList(ArrayList<Map> originMapList) {
		this.originMapList = originMapList;
	}


	public ArrayList<Map> getEditMapList() {
		return editMapList;
	}


	public void setEditMapList(ArrayList<Map> editMapList) {
		this.editMapList = editMapList;
	}


	public ArrayList<Block> getBlockList() {
		return blockList;
	}


	public void setBlockList(ArrayList<Block> blockList) {
		this.blockList = blockList;
	}
}
