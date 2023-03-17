package br.com.w_and_r.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class ReadAndWriteTest {
	public static void main(String[] args) throws FileNotFoundException {
		copyFileToAnother("lorem.txt", "test.txt");
	}
	
	static void copyFileToAnother(String target, String newFile) throws FileNotFoundException {
		InputStream fis = new FileInputStream(target);
		Reader isr = new InputStreamReader(fis);
		
		try (BufferedReader br = new BufferedReader(isr)) {

			OutputStream fos = new FileOutputStream(newFile);
			Writer osw = new OutputStreamWriter(fos);
			
			BufferedWriter bw = new BufferedWriter(osw);
			
			String currentLine = br.readLine();
			
			while (currentLine != null) {
				bw.write(currentLine);
				bw.newLine();
				currentLine = br.readLine();
			}
			
			bw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
