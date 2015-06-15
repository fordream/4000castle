
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
				{999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,999},
				{999, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0,999},
				{999, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0,999},
				{999, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0,999},
				{999, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0,999},
				{999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,999},
				{999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,999},
				{999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,999},
				{999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,999},
				{999, 999, 999, 999, 999, 999, 999, 999, 999, 999, 999, 999}
			};
		ArrayList< Block > useBlockList = new ArrayList< Block >();
		useBlockList.add( new Block("", 11) );
		useBlockList.add( new Block("", 22) );
		useBlockList.add( new Block("", 33) );
		
		map.setStatus(status);
		map.setUseBlockList(useBlockList);
		
		MapMaker maker = new MapMaker( map );
		Block arrayBlock[][] = maker.getArrayBlock();
		
		for (int yy = 0; yy <= 11; yy++) {
			for (int xx = 0; xx <= 11; xx++)
				System.out.printf("%5d ", arrayBlock[ yy ][ xx ].getTag());
			System.out.println();
		}
	}
}
