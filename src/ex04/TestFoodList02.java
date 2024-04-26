package ex04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class FoodList {
	// Fields
	String name;
	String roadname;
	String tel;
	String type;
	String food;

	// Getter / Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoadname() {
		return roadname;
	}

	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	// Constructor
	public FoodList() {
	}

	public FoodList(String name, String roadname, String tel, String type, String food) {
		super();
		this.name = name;
		this.roadname = roadname;
		this.tel = tel;
		this.type = type;
		this.food = food;
	}
	public FoodList(String line) {
		String [] li = line.trim().split(",");
		this.name = li[0];
		this.roadname = li[1];
		this.tel = li[2];
		this.type = li[3];
		this.food = li[4];
	}

	// toString
	@Override
	public String toString() {
		return "FoodList [name=" + name + ", roadname=" + roadname + ", tel=" + tel + ", type=" + type + ", food="
				+ food + "]";
	}

}

public class TestFoodList02 {
	
	static ArrayList<FoodList> fdList = null;

	public static void main(String[] args) throws IOException {
		
		fdList = new ArrayList<>();

		input();
		process();
		output();

	}

	private static void input() throws IOException {

		String path = "D:\\dev\\java\\PrjIO\\src\\ex04\\";
		String filename = path + "부산광역시_수영구_모범음식점 현황_20240108.CSV";
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		// 전체 불러오기
		String line = "";
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

		br.close();
		fr.close();

		// ----------------------------------------------------

		fr = new FileReader(filename);
		br = new BufferedReader(fr);

		Scanner in = new Scanner(System.in);
		System.out.println("검색:음식의유형(한식,중식,양식)");
		String sText = in.nextLine().trim();

		line = "";
		while ((line = br.readLine()) != null) {
			FoodList f = new FoodList( line );
			fdList.add( f );
			if ( line.contains(sText) ) {
				System.out.println( line );
			}
		}

		br.close();
		fr.close();

	}

	private static void process() {
		
		

	}

	private static void output() {
		
		String msg = "";
		String fmt = "%5s %10s %10s %4s %5s\n";
		for (FoodList f : fdList) {
			msg += String.format(fmt, f.getName(), f.getRoadname()
					, f.getTel(), f.getType(), f.getFood());
		}
		
		System.out.println( msg );
		
	}

}
