package Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Map implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7598642293912049886L;

	private final int size = 10;
	
	// x y는 status[ y ][ x ] 이런 식으로 처리한다.
	private int status[][];
	private ArrayList< Block > useBlockList;
	private Date bestTime;
	
	
	// constructors /////////////////////////////////////////////////////////
	public Map()
	{
		status = new int[ size + 2 ][ size + 2 ];
		setUseBlockList( new ArrayList< Block >() );
		setBestTime( new Date() );
		
		for (int y = 0; y <= size + 1; y++)
			for (int x = 9; x <= size + 1; x++)
				status[ y ][ x ] = 0;
	}
	
	
	
	
	// getter setter ////////////////////////////////////////////////////////
	public int[][] getStatus() {
		return status;
	}


	public void setStatus(int[][] status) {
		this.status = status;
	}


	public ArrayList<Block> getUseBlockList() {
		return useBlockList;
	}


	public void setUseBlockList(ArrayList<Block> useBlockList) {
		this.useBlockList = useBlockList;
	}


	public Date getBestTime() {
		return bestTime;
	}


	public void setBestTime(Date bestTime) {
		this.bestTime = bestTime;
	}
}
