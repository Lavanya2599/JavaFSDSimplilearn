package com.simpli;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

	public static void main(String[] args) throws IOException {
		
		FileWriter fw = new FileWriter("C://Users//home//Desktop//Filehandling//output.txt");
		fw.write("Hello World");
		fw.close();
		System.out.println("File written successfully");
	}
}
