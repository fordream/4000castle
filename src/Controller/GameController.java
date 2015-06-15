package Controller;

import java.util.ArrayList;

import Data.*;

public class GameController
{
	private Game game;

	
	// constructor /////////////////////////////////////////////////
	public GameController( Game game )
	{
		setGame( game );
	}
	
	
	
	// adder remover ///////////////////////////////////////////////
	public void addOrginMap( Map map ) 
	{
		Game game = getGame();
		ArrayList< Map > originMapList = game.getOriginMapList();
		originMapList.add( map );
		game.setOriginMapList( originMapList );
		setGame( game );
	}
	
	public void removeOrginMap( int index ) 
	{
		Game game = getGame();
		ArrayList< Map > originMapList = game.getOriginMapList();
		if ( index < originMapList.size() && index >= 0 )
			originMapList.remove( index );
		game.setOriginMapList( originMapList );
		setGame( game );
	}
	
	public void addEditMap( Map map ) 
	{
		Game game = getGame();
		ArrayList< Map > editMapList = game.getEditMapList();
		editMapList.add( map );
		game.setEditMapList( editMapList );
		setGame( game );
	}
	
	public void removeEditMap( int index ) 
	{
		Game game = getGame();
		ArrayList< Map > editMapList = game.getEditMapList();
		if ( index < editMapList.size() && index >= 0 )
			editMapList.remove( index );
		game.setEditMapList( editMapList );
		setGame( game );
	}
	
	public void addBlock( Block block ) 
	{
		Game game = getGame();
		ArrayList< Block > blockList = game.getBlockList();
		blockList.add( block );
		game.setBlockList( blockList );
		setGame( game );
	}
	
	public void removeBlock( int index ) 
	{
		Game game = getGame();
		ArrayList< Block > blockList = game.getBlockList();
		if ( index < blockList.size() && index >= 0 )
			blockList.remove( index );
		game.setBlockList( blockList );
		setGame( game );
	}
	
	
	
	// getter setter ///////////////////////////////////////////////
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
