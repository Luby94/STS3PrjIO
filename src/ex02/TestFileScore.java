package ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
	
	// 입력, 출력
	private int     num;
	private String  name;
	private int     kor;
	private int     eng;
	private int     mat;
	
	// only 출력
	private int     tot;
	private double  avg;
	private String  grade;
	private int     rank;
	
	// Getter / Setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	// Constructor
	public Student() {}
	public Student(int num, String name, int kor, int eng, int mat) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	public Student(String line) {
		String [] li = line.trim().split(",");
		this.num  = Integer.parseInt( li[0] );
		this.name = li[1];
		this.kor  = Integer.parseInt( li[2] );
		this.eng  = Integer.parseInt( li[3] );
		this.mat  = Integer.parseInt( li[4] );
	}
	
	// toString
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot="
				+ tot + ", avg=" + avg + ", grade=" + grade + ", rank=" + rank + "]";
	}
	
}

public class TestFileScore {
	
	static ArrayList<Student> studList = null;

	public static void main(String[] args) throws IOException {
		
		studList = new ArrayList<>();
		
		input();
		process();
		output();

	}

	private static void input() throws IOException {
		// 입력 : 번호,이름,국어,영어,수학
		// datat3.txt 파일
		String      path      = "D:\\dev\\java\\PrjIO\\src\\ex02\\";
		// String path = TestFileScore.class.getResource("").getPath(); -> bin에 생성
		System.out.println( "path= " + path );  
		System.out.println("---------------------------");
		
		String          filename  = path + "data3.txt";
		FileReader      fr        = new FileReader( filename );
		BufferedReader  br        = new BufferedReader( fr );
		
		/*
		String          line      = br.readLine();
		System.out.println( "line1= " + line );
		
		line = br.readLine();
		System.out.println( "line2= " + line );
		
		line = br.readLine();
		System.out.println( "line3= " + line );
		
		line = br.readLine();
		System.out.println( "line4= " + line );
		
		line = br.readLine();
		System.out.println( "line5= " + line );
		
		line = br.readLine();
		System.out.println( "line6= " + line );
		*/
		
		// 첫번째 제목줄 skip -> data가 아님
		String title = br.readLine();
		System.out.println( title );
		System.out.println("---------------------------");
		
		String line  = "";
		while ( ( line = br.readLine() ) != null ) {  // 파일 끝이 아닐 동안
			// System.out.println( line );  // 파일 원본 출력
			
			Student s = new Student( line );  // line 생성자 만듦
			// System.out.println( s );
			studList.add( s );
			
		}
		
		br.close();  // br : fr을 연결해주는 역할 -> br 먼저 닫고 fr을 닫아야함 : 중요
		fr.close();
		
	}

	private static void process() {
		// 입력된 데이터들 바탕으로 총점, 평균, 학점, 석차 계산
		// 총점
		getTot();
		// 평균
		getAvg();
		// 학점
		getGrade();
		// 석차
		getRank();
		
	}
	
	// 총점 - 모든 학생의 총점
	private static void getTot() {

		for (int i = 0; i < studList.size(); i++) {
			Student s = studList.get(i);
			// s.setTot( s.getKor() + s.getEng() + s.getMat() );
			int tot = s.getKor() + s.getEng() + s.getMat();
			s.setTot( tot );
		}
		
	}

	// 평균
	private static void getAvg() {
		
		for ( Student s : studList ) {  // foreach
			// int avg = ( s.getTot() / 3 );  -> 합(tot) 값이 0이 나오는 오류 발생할수도有
			double avg = (double) ( (s.getKor() + s.getEng() + s.getMat()) / 3.0 );
			s.setAvg(avg);
		}
		
	}

	// 학점
	private static void getGrade() {
		//               0   1   2   3   4   5   6   7   8   9   10  11
		String [] g = { "F","F","F","F","F","F","D","C","B","A","A","A" };
		
		for (Student s : studList) {  // foreach
			double avg = s.getAvg();  // 원래 평균처럼 .getKor()+.getEng()+... 해야함
			int pos = (int) (avg / 10);
			s.setGrade( g[pos] );
		}
	}

	// 석차
	private static void getRank() {

		// 내림차순 정렬
		Collections.sort( studList, new Comparator<Student>() { // Student:generic

			@Override
			public int compare(Student o1, Student o2) {				
				return o2.getTot() - o1.getTot();
			}
			
		});
		
		// 정렬 후 석차 매기기
		
		studList.get( 0 ).setRank( 1 );  // for (int i = 1 부터 -> 아래 2등부터 계산
		                                 // 1등은 이렇게 따로 입력해주어야
		for (int i = 1; i < studList.size(); i++) {
			boolean result
			= studList.get(i).getTot() == studList.get( i - 1 ).getTot();
					
			if( result ) {
				int prevRank = studList.get( i - 1 ).getRank();  // 이전 석차 가져오기
				studList.get(i).setRank( prevRank );
			} else {
				studList.get(i).setRank( i + 1 );
			}
		}
		
	}


	private static void output() throws IOException {
		// 출력 : 번호,이름,국어,영어,수학,총점,평균,학점,석차
			
		String title  = "번호 이름 국어 영어 수학 총점 평균 학점 석차\n";
		String msg    = title;  // 한번만 들어갈거니 for문 안에 넣지 않음
		String fmt    = "%3d %3s %3d %3d %3d %3d %6.2f %s %2d\n";
		for (Student s : studList) {
			// System.out.println( s );
			msg += String.format(fmt, 
					s.getNum(), s.getName(), s.getKor(),
					s.getEng(), s.getMat(), s.getTot(),
					s.getAvg(), s.getGrade(), s.getRank()
					);
		}
		
		// 출력 : 화면
		System.out.println( msg );
		
		// (출력 위한) 파일 준비
		String          path       = "D:\\dev\\java\\PrjIO\\src\\ex02\\";
		String          ofilename  = path + "result3.txt";
		FileWriter      fw         = new FileWriter( ofilename );
		BufferedWriter  bw         = new BufferedWriter( fw );
		
		// 출력 : 파일
		bw.write( msg );
		
		// 파일 닫기
		bw.close();
		fw.close();
		
	}

}
