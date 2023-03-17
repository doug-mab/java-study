package br.com.w_and_r.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadingTest {

	public static void main(String[] args) throws IOException {
		
		readAndPrintFile("lorem.txt");
	}
	
	static void readAndPrintFile(String file) throws FileNotFoundException {

//		InputStream fis = new FileInputStream();
		Reader isr = new InputStreamReader(System.in);
		
		try (BufferedReader br = new BufferedReader(isr)) {
			
				String line = br.readLine();
				
				while(line != null) {
					System.out.println(line);
					line = br.readLine();
				}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}
