package br.com.w_and_r.test;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WritingTest {

	public static void main(String[] args) throws FileNotFoundException {
		writeFile("lorem2.txt", "Blin bon bibber bonbys");
	}
	
	static void writeFile(String file, String content) throws FileNotFoundException {
		
		OutputStream fos = new FileOutputStream(file);
		Writer osw = new OutputStreamWriter(fos);
		
		try (BufferedWriter bw = new BufferedWriter(osw)) {
			bw.write(content);
			bw.newLine();
			bw.write("Done!");
			bw.newLine();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
