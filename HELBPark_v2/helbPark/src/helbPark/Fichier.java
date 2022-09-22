package helbPark;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fichier 
{
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyy");
	LocalDateTime now = LocalDateTime.now();
	String dirName = dtf.format(now);
	String stringFichier = "";
	String type = "";
	String plaque = "";
	public Fichier(String stringFichier, String type, String plaque) 
	{
		this.type = type;
		this.plaque = plaque;
		this.stringFichier = stringFichier;
	}
	public void write()
	{
		boolean success = false; 
		success = createDir(success);
		success = createNWriteFile(success);
	}
	private boolean createDir(boolean success)
	{
		String dir = this.dirName; 
		File directory = new File(dir); 
		if (directory.exists()) 
		{ 
			System.out.println("Directory already exists ..."); 
		} else 
		{ 
			System.out.println("Directory not exists, creating now"); 
			success = directory.mkdir(); 
			if (success) 
			{ 
				System.out.printf("Successfully created new directory : %s%n", dir); 
				} else { 
					System.out.printf("Failed to create new directory: %s%n", dir); 
					} 
		}
		return success; 
	}
	private boolean createNWriteFile(boolean success)
	{
		File f = new File(this.dirName,plaque + "_" + type + ".txt"); 
		if (f.exists()) 
		{ System.out.println("File already exists"); 
		} else { 
			System.out.println("No such file exists, creating now"); 
			try {
				success = f.createNewFile();
				FileOutputStream is = new FileOutputStream(f);
	            OutputStreamWriter osw = new OutputStreamWriter(is);    
	            Writer w = new BufferedWriter(osw);
	            w.write(stringFichier);
	            w.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			if (success) 
			{ System.out.printf("Successfully created new file: %s%n", f); 
			} else { 
				System.out.printf("Failed to create new file: %s%n", f); 
				} 
			};
			return success;
	}
}
