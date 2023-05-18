package com.simpli;

import java.io.FileWriter;
import java.io.IOException;

public class AppendToFile {

	public static void main(String[] args) throws IOException{
		FileWriter fw = new FileWriter("C://Users//home//Desktop//Filehandling//output.txt", true);
		fw.write("Appending to a file");
		fw.close();
		System.out.println("File appended successfully");
	}
}
