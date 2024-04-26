package ex01;

import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {

	public static void main(String[] args) throws IOException {
		// 새 파일 생성
		// 경로 : Path + 파일명(Filename)
		// String      filename  = "d:\\data1.txt";
		String      filename  = "data1.txt";  // 어디에?
		// 현재 경로 : Current Path - 실행하는 .class가 있는 곳(인데)
		// D:\dev\java\PrjIO  -> 프로젝트 폴더
		// Project Explorer에서 새로고침하면 보인다
		
		FileWriter  fw        = new FileWriter( filename );
		fw.write("A");
		fw.write(66);     // write : 문자로 출력 -> "B"
		fw.write(48);     // "0"
		fw.write(13);     // \r
		fw.write(48+3);   // "3" -> 51문자 = 3
		fw.write(97);     // "a"
		fw.write(10);     // \n
		fw.write("승준");  // "승준"
		fw.close();
		
		System.out.println("파일이 저장되었습니다");

	}

}
