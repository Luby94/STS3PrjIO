package ex04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class FoodShop {
	// 업소명,소재지(도로명),소재지전화번호,음식의유형,주된음식
	// shopname, location, phone, foodtype, mainfood
	private String shopname;
	private String location;
	private String phone;
	private String foodtype;
	private String mainfood;
	
	// Getter / Setter
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFoodtype() {
		return foodtype;
	}
	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}
	public String getMainfood() {
		return mainfood;
	}
	public void setMainfood(String mainfood) {
		this.mainfood = mainfood;
	}
	
	// Constructor
	public FoodShop() {}
	public FoodShop(String shopname, String location, String phone, String foodtype, String mainfood) {
		this.shopname = shopname;
		this.location = location;
		this.phone = phone;
		this.foodtype = foodtype;
		this.mainfood = mainfood;
	}
	public FoodShop(String line) {
		line_split( line );
	}
	
	private void line_split(String line) {
		/*
		int pos1 = 0;
		int pos = line.indexOf( "," );
		String li1 = line.substring( pos1, pos );
		if() {
			// "가 있을 때
		} else {
			// "가 없을 때
		}
		*/
		
		// s
		// e
		// 0123456789012345678901234
		// 123,23,332432,42143,52143
		// i
		
		String [] vals = new String[ line.length() ];
		int cnt = 0;
		int startPos = 0;
		int endPos = 0;
		
		for (int i = 0; i < line.length(); i++) {
			if ( i == line.length() - 1 ) {
				vals[cnt] = line.substring( startPos, i + 1 );
				break;
			}
			switch( line.charAt(i) ) {
			case '"' :
				startPos = i + 1;
				endPos = line.indexOf('"', startPos);
				i = endPos + 1;
				break;
			case ',' :
				endPos = i;
				break;
			default :
				continue;  // 다시 반복문으로 이동
			}
			// System.out.println(startPos + "," + endPos);
			vals[cnt] = line.substring( startPos, endPos );
			cnt++;
			startPos = i + 1;
		}
		// System.out.println( Arrays.toString(vals) );
		this.shopname = vals[0];
	    this.location = vals[1];
	    this.phone    = vals[2];
	    this.foodtype = vals[3];
	    this.mainfood = vals[4];

	}
	
	// toString
	@Override
	public String toString() {
		return "FoodShop [shopname=" + shopname + ", location=" + location + ", phone=" + phone + ", foodtype="
				+ foodtype + ", mainfood=" + mainfood + "]";
	}

}

public class TestFoodList2 {

	public static void main(String[] args) throws IOException {

		String path = "D:\\dev\\java\\PrjIO\\src\\ex04\\";
		String filename = path + "부산광역시_수영구_모범음식점 현황_20240108.CSV";
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		// 검색어 입력
		// 검색 : 키보드 입력 , mainfood(주된음식)
		Scanner in = new Scanner(System.in);
		System.out.println("주된음식():");
		System.out.println("낙지볶음,생선회,밀면,삼계탕,탕수육,월남쌈 샤브샤브");
		System.out.println("설렁탕,부대찌개,전골,자장면,양곱창,물회,재첩국");
		String sText = in.nextLine();

		String line = "";
		br.readLine(); // 제목줄 skip -> 여기 밑에서부터 data
		// 데이터를 읽어서 객체에 담는 작업
		while ((line = br.readLine()) != null) {
			// 입력
			FoodShop foodShop = new FoodShop( line );  // line 생성자
			// System.out.println( foodShop );

			String msg = "";
			String fmt = "업소명 : %s\n";
			fmt += "소재지 : %s\n";
			fmt += "전화번호 : %s\n";
			fmt += "음식유형 : %s\n";
			fmt += "주된음식 : %s\n";
			if ( foodShop.getMainfood().contains(sText) ) {
				msg = String.format( fmt, foodShop.getShopname(),
						foodShop.getLocation(), foodShop.getPhone(),
						foodShop.getFoodtype(), foodShop.getMainfood() );
				System.out.println( msg );
			}
			
			// 출력

		}

		br.close();
		fr.close();

	}

}
