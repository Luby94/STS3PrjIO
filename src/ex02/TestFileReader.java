package ex02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Student2 {
	// Fields
	int num;
	String name;
	int kor;
	int eng;
	int mat;
	
	// Constructors
	public Student2() {}
	public Student2(int num, String name, int kor, int eng, int mat) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	// Methods
	
	// toString
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + "]";
	}

}

public class TestFileReader {
	
	Student2 stud = new Student2();

	public static void main(String[] args) throws IOException {
		
		String          path      = "D:\\dev\\java\\PrjIO\\src\\ex02\\";
		String          filename  = path + "data3.txt";
		FileReader      fr        = new FileReader( filename );
		BufferedReader  br        = new BufferedReader( fr );
		
		String line = "";
		while( ( line = br.readLine() ) != null ) {
			String [] li = line.split(",");
		    // = Integer.parseInt( li[0] );
			System.out.println( li.toString() );
		}
		
		fr.close();
		
		input();
		process();
		output();
		
	}

	private static void input() {
		
		
		
		
	}
	
	private static void process() {
		
		
	}

	private static void output() {
		
		
	}


}
