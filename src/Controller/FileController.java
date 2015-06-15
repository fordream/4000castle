package Controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Data.Game;


public class FileController {
	private Game data;
	private String saveFileName;
	
	
	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public FileController(Game data)
	{
		setData(data);
		saveFileName = new String("datafile.ser");
	}
	
	public Game getData() {
		return data;
	}

	public void setData(Game data) {
		this.data = data;
	}
	
	public void readFromFile()
	{
		try
		{
			FileInputStream fin = new FileInputStream(saveFileName);
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			Game temp = (Game)oin.readObject();
			
			setData(temp);
			
			oin.close();
			fin.close();
		}
		catch(Exception exception)
		{
			System.out.println(this.getClass() + "cannot open the file!");
		}
		finally
		{
		
		}
	}
	public void appendToFile()
	{
		try
		{
			FileOutputStream fout = new FileOutputStream(saveFileName);
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			
			oout.writeObject(getData());

			oout.close();
			fout.close();
		}
		catch(Exception exception)
		{
			System.out.println(this.getClass()+"cannot open the file!");
		}
		finally
		{
		
		}
		
	}
	public void writeToFile()
	{
		try
		{
			FileOutputStream fout = new FileOutputStream(saveFileName);
			ObjectOutputStream oout = new ObjectOutputStream(fout);

			oout.writeObject(getData());

			oout.close();
			fout.close();
		}
		catch(Exception exception)
		{
			System.out.println(this.getClass()+"cannot open the file!");
		}
		finally
		{
		
		}
	}
}
