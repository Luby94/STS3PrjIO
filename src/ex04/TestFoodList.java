package ex04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestFoodList {

	public static void main(String[] args) throws IOException {
		
		String          path      = "D:\\dev\\java\\PrjIO\\src\\ex04\\";
		String          filename  = path +
				"부산광역시_수영구_모범음식점 현황_20240108.CSV";
		FileReader      fr        = new FileReader( filename );
		BufferedReader  br        = new BufferedReader( fr );
		
		// 전체 불러오기
		String  line  = "";
		while( ( line = br.readLine() ) != null ) {  // br.readLine() : 한줄
			System.out.println( line );
		}
		
		br.close();
		fr.close();
		//---------------------------------------------------------------------
		fr  = new FileReader( filename );  // 다시 맨위로 올려보냄 = 다시 읽기
		br  = new BufferedReader( fr );    // 테이프 처음으로 다시 감는 개념
		// 검색 기능 : 음식의유형
		// 검색어 키보드 입력 받아 파일에 있는 정보(line) 출력
		Scanner  in     = new Scanner(System.in);
		System.out.println("검색:음식의유형(한식,중식,양식)");
		String   sText  = in.nextLine().trim();
		
		line = "";
		while ( ( line = br.readLine() ) != null ) {
			if( line.contains(sText) )
				System.out.println( line );
		}
		
		
		br.close();
		fr.close();

	}

}
