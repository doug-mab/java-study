package br.com.javaio.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class EncodingFiles {

	public static void main(String[] args) throws IOException {
		// Charsets are appliable to Readers, PrintWriters/Streams
		InputStream fis = new FileInputStream("file.txt");
		Reader isr = new InputStreamReader(fis, StandardCharsets.UTF_16);
		BufferedReader br = new BufferedReader(isr);

		System.out.println(br.readLine());

		isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

		System.out.println(br.readLine());
		
		br.close();
	}

}
