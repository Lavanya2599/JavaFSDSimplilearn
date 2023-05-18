package com.simpli;

import java.io.IOException;
import java.io.FileReader;

public class ReadFromFile {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("C://Users//home//Desktop//Filehandling//input.txt");
		int i;
		while((i=fr.read()) != -1)
			System.out.print((char) i);
		fr.close();
	}
}
