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
		saveFileName = new String("datafile.dat");
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
			setData((Game)oin.readObject());
			
			oin.close();
			fin.close();
		}
		catch(Exception exception)
		{
			System.out.println(this.getClass() + "cannot open the file!");
		}
		finally
		{
			System.out.println("read"+"block:map"+getData().getBlockList().size()+":"+getData().getEditMapList().size());
			for(int i =0;i<getData().getBlockList().size();i++)
				System.out.println(getData().getBlockList().get(i).getImageIcon());
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
			System.out.println("write"+getData().getBlockList().size()+":"+getData().getEditMapList().size());
		}
	}
}
