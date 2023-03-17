package br.com.javaio.test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class UnicodeAndEncodingTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "Hello World";
		
		Charset charset = Charset.defaultCharset();
		System.out.println(charset.displayName());
		
		Charset cIso = StandardCharsets.ISO_8859_1;
		byte[] sBytes = s.getBytes(cIso);
		System.out.println(sBytes.length + " - " + cIso);
		
		String s2 = new String(sBytes, cIso);
		System.out.println(s2); // Hello World
		
		Charset utf16 = StandardCharsets.UTF_16;
		String s3 = new String(sBytes, utf16);
		System.out.println(s3.getBytes().length + " - " + utf16);
		System.out.println(s3); // 䡥汬漠坯牬�
	}
}
