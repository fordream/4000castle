package Play;

import java.util.ArrayList;
import java.util.Random;

import Data.*;

public class MapMaker 
{
	private final int size = 10;
	private final Block emptyBlock = new Block(null, 0);
	private final Block wallBlock = new Block(null, 999);
	
	private Map map;
	private Block arrayBlock[][];
	
	
	
	// constructor /////////////////////////////////////////////
	public MapMaker( Map map )
	{
		setMap( map );
		setArrayBlock( new Block[ size + 2 ][ size + 2 ] );
		match();
	}
	
	
	
	// match Blocks and status /////////////////////////////////
	public void match()
	{
		ArrayList< Integer > xContainer = new ArrayList< Integer >();
		ArrayList< Integer > yContainer = new ArrayList< Integer >();
		Random rand = new Random();
		
		for ( int y = 0; y <= size + 1; y++ )
			for ( int x = 0; x <= size + 1; x++ )
				if ( getMap().getStatus()[ y ][ x ] == 0 )
				{
					arrayBlock[ y ][ x ] = emptyBlock;
				}
				else if ( getMap().getStatus()[ y ][ x ] == 999 )
				{
					arrayBlock[ y ][ x ] = wallBlock;
				}
				else 
				{
					xContainer.add( x );
					yContainer.add( y );
				}
		
		
		int cnt = 0;
		while ( xContainer.size() > 0 )
		{
			int index = rand.nextInt( xContainer.size() );
			int x = xContainer.get(index);
			int y = yContainer.get(index);
			xContainer.remove(index);
			yContainer.remove(index);
			arrayBlock[ y ][ x ] = getMap().getUseBlockList().get( cnt );

			
			index = rand.nextInt( xContainer.size() );
			x = xContainer.get(index);
			y = yContainer.get(index);
			xContainer.remove(index);
			yContainer.remove(index);
			arrayBlock[ y ][ x ] = getMap().getUseBlockList().get( cnt );
			cnt++;
			cnt %= getMap().getUseBlockList().size();
		}
	}
	
	public void deletePositionBlock(int x, int y) {
		arrayBlock[y][x] = emptyBlock;
	}
	
	// getter setter ////////////////////////////////////////////
	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Block[][] getArrayBlock() {
		return arrayBlock;
	}

	public void setArrayBlock(Block[][] arrayBlock) {
		this.arrayBlock = arrayBlock;
	}
	
	
}
