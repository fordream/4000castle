
import java.util.ArrayList;

import Data.*;
import Play.*;

public class TestMain {
	
	public static void main( String[] args )
	{
		Map map = new Map();
		int status[][] = 
			{ 
				{999, 999, 999, 999, 999, 999, 999, 999, 999, 999, 999, 999},
				{999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,999},
				{999, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0,999},
				{999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,999},
				{999, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0,999},
				{999, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1,999},
				{999, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0,999},
				{999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,999},
				{999, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0,999},
				{999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,999},
				{999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,999},
				{999, 999, 999, 999, 999, 999, 999, 999, 999, 999, 999, 999}
			};
		ArrayList< Block > useBlockList = new ArrayList< Block >();
		useBlockList.add( new Block(null, 11) );
		useBlockList.add( new Block(null, 22) );
		useBlockList.add( new Block(null, 33) );
		useBlockList.add( new Block(null, 44) );
		
		map.setStatus(status);
		map.setUseBlockList(useBlockList);
		
		MapMaker maker = new MapMaker( map );
		Block arrayBlock[][] = maker.getArrayBlock();
		
		for (int yy = 0; yy <= 11; yy++) {
			for (int xx = 0; xx <= 11; xx++)
				System.out.printf("%5d ", arrayBlock[ yy ][ xx ].getTag());
			System.out.println();
		}
		
		MapPlay play = new MapPlay( maker );
		
		System.out.println( "Block cnt : " + play.getBlockCnt() );
		System.out.println( "Connectable Cnt : " + play.getConnectableCnt());
		
	}
}
