package Play;

import Data.Block;

public class MapPlay {
	
	private final int size = 10;
	private final Block emptyBlock = new Block(null, 0);
	private final int[] dirX = {-1, 0, 1, 0};
	private final int[] dirY = {0, -1, 0, 1};
	
	private MapMaker maker;
	private Block[][] arrayBlock;
	private int blockCnt;
	private int connectableCnt;
	private boolean[][] checkBlock;
	
	public MapPlay( MapMaker maker )
	{
		setMaker( maker );
		setArrayBlock( maker.getArrayBlock() );
		setBlockCnt( 0 );
		setConnectableCnt( 0 );
		checkBlock = new boolean[size + 2][size + 2];
		countBlock();
		countConnectableBlock();
	}
	
	public void countBlock() {
		int cnt = 0;
		
		for (int y = 1; y <= size; y++) 
			for (int x = 1; x <= size; x++)
				if (arrayBlock[ y ][ x ].getTag() != 999 &&
						arrayBlock[ y ][ x ].getTag() != 0)
					cnt++;
		
		setBlockCnt( cnt );
	}
	
	public void countConnectableBlock() 
	{
		setConnectableCnt( 0 );
		resetCheckBlock();
		int cnt = 0;
		
		for (int y = 1; y <= size; y++)
			for (int x = 1; x <= size; x++)
				if (arrayBlock[y][x].getTag() != 0 && arrayBlock[y][x].getTag() != 999 && checkBlock[y][x] == false)
				{
					for (int yy = y; yy <= size; yy++)
					{
						int startX;
						if (y == yy) 	startX = x + 1;
						else 			startX = 1;
						
						for (int xx = startX; xx <= size; xx++)
							if (arrayBlock[y][x].getTag() == arrayBlock[yy][xx].getTag() && 
									checkBlock[yy][xx] == false && checkBlock[y][x] == false)
								if (checkConnectable(x, y, xx, yy, -1, -1))
								{
									cnt += 2;
									checkBlock[y][x] = true;
									checkBlock[yy][xx] = true;
									System.out.printf("%d %d %d %d\n", y, x, yy, xx);
								}
					}
				}
		
		setConnectableCnt( cnt );
	}
	
	public boolean checkConnectable(int nowX, int nowY, int targetX, int targetY, int nowDir, int cntDir) 
	{
		if (nowX == targetX && nowY == targetY)
			return true;
		
		if (nowX < 0 || nowY < 0 || nowX > size + 1 || nowY > size + 1)
			return false;
		if ( nowDir != -1 && arrayBlock[ nowY ][ nowX ].getTag() != 0  )
			return false;
		if (cntDir > 2)
			return false;
		
		boolean flag = false;
		
		for (int dir = 0; dir < 4; dir++)
		{
			if (nowDir == dir)
				flag = checkConnectable(nowX + dirX[ dir ], nowY + dirY[ dir ], targetX, targetY, dir, cntDir);
			else
				flag = checkConnectable(nowX + dirX[ dir ], nowY + dirY[ dir ], targetX, targetY, dir, cntDir + 1);
			
			if (flag == true)
				return true;
		}
		
		return false;
	}
	
	public void deletePositionBlock(int x, int y) {
		arrayBlock[ y ][ x ] = emptyBlock;
	}
	
	public void resetCheckBlock() {
		for (int y = 0; y <= size + 1; y++)
			for (int x = 0; x <= size + 1; x++)
				checkBlock[y][x] = false;
	}
	
	// getter setter //////////////////////////////////////////////////////////////////////////////////////
	public MapMaker getMaker() {
		return maker;
	}

	public void setMaker(MapMaker maker) {
		this.maker = maker;
	}

	public int getBlockCnt() {
		return blockCnt;
	}

	public Block[][] getArrayBlock() {
		return arrayBlock;
	}

	public void setArrayBlock(Block[][] arrayBlock) {
		this.arrayBlock = arrayBlock;
	}

	public void setBlockCnt(int blockCnt) {
		this.blockCnt = blockCnt;
	}

	public int getConnectableCnt() {
		return connectableCnt;
	}

	public void setConnectableCnt(int connectableCnt) {
		this.connectableCnt = connectableCnt;
	}
}
