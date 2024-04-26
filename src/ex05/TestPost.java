package ex05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestPost {

	public static void main(String[] args) throws IOException {
		
		// String path = "D:/dev/java/PrjIO/src/ex05/";
		String path = "D:\\dev\\java\\PrjIO\\src\\ex05\\";
		String filename = path + "zipcode_20130201(1).csv";
		File infile = new File( filename );
		
		if( !infile.exists() ) {	// File class 생성목적
			System.out.println("파일이 존재하지 않습니다");
			// return; -> 함수를 종료해라 : main()이면 프로그램이 종료됨
			System.exit(0);	// 프로그램 강제 종료
		}
		
		FileReader fr = new FileReader( infile );
		BufferedReader br = new BufferedReader( fr );
		
		String dong = "롯데백화점";
		
		int cnt = 0;
		String line = "";
		br.readLine();		// 제목줄 skip <- 안하면 에러
		
		// while( line != null ) {	// line이 null이 아닐 동안 반복
		while( ( line = br.readLine() ) != null ) {
			Post post = new Post( line );
			if( post.getDong().contains(dong) ) {
				// System.out.println(post);  // 수업o
				post.display();  // 내가한거, 수업x
				cnt++;
			}
		}
		
		br.close();
		fr.close();
		
		System.out.println(dong + "이" + cnt + "건 출력되었습니다");

	}

}
