package ex05;

public class Post {
	// 단축키
	// ctrl + shift + y : 모두 소문자
	// ctrl + shift + x : 모두 대문자
	
	// Fields : 변수들
	private String zipcode;
	private String sido;
	private String gugun;
	private String dong;
	private String bunji;
	private int seq;
	
	// Getter / Setter
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getBunji() {
		return bunji;
	}
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	// Constructor
	public Post() {}
	public Post(String line) {
		String [] li = line.trim().split(",");
		this.zipcode = li[0];
		this.sido = li[1];
		this.gugun = li[2];
		this.dong = li[3];
		this.bunji = li[4];
		this.seq = Integer.parseInt(li[5]);
	}
	
	// 결과 (내가한거, 수업x)
	public void display() {
		String fmt = "%s %s %s %s %s %d";
		String msg = String.format(fmt, getZipcode(), getSido(), getGugun(), getDong(), getBunji(), getSeq());
		System.out.println(msg);
	}
	
	// toString
	@Override
	public String toString() {
		return "Post [zipcode=" + zipcode + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", bunji="
				+ bunji + ", seq=" + seq + "]";
		}
	
	
}
