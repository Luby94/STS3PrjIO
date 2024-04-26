package ex01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestFileReader {

	//public static void main(String[] args) throws FileNotFoundException, IOException {
	public static void main(String[] args) throws IOException {
		
		// data2.txt를 읽어서 화면에 출력
		// BufferedReader : 입력에 버퍼를 이용하여 속도를 증가
		// BufferedWriter : 출력에 버퍼를 이용하여 속도를 증가
		// ~Reader, ~Writer 로 끝나는 파일 : 결과 String으로 처리한다 : text
		// InputStream, OutputStream : data를 byte로 처리 : binary
		
		String          path      = "D:\\dev\\java\\PrjIO\\src\\ex01\\";
		String          filename  = path + "data2.txt";
		FileReader      fr        = new FileReader( filename );
		// fr.read  -> readLine 생성 x -> BufferedReader 클래스 import
		BufferedReader  br        = new BufferedReader( fr );
		
		
		/*
		String          line      = br.readLine();
		System.out.println( line );  // 1. 민지
		System.out.println( line );  // 1. 민지
		System.out.println( line );  // 1. 민지
		System.out.println( line );  // 1. 민지
		System.out.println( line );  // 1. 민지
		*/
		
		// br.readLine() 은 \n까지를 한줄로 보고 읽어온다
		// 파일 끝 일때는 null을 return
		
		/*
		String          line      = "";
		line                      = br.readLine();  // 1. 민지
		System.out.println( line );
		line                      = br.readLine();  // 2. 하니
		System.out.println( line );
		*/
		
		String line = "";
		while( ( line = br.readLine() ) != null ) {
			System.out.println( line );
		}
		//while( ( line = br.readLine() ) != null ) { 
		// -> line = br.readLine() 먼저 수행한 값이 null이 아니면 line 출력
		
		fr.close();

	}

}
