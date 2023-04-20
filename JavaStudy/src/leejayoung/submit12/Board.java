package leejayoung.submit12;

public class Board {
	int no = 0;
	String title;
	String day;
	String content;
	
	public Board() {}
	public Board(int no, String title, String day, String content) {
		this.no = no + 1;
		this.title = title;
		this.day = day;
		this.content = content;
	}

	@Override
	public String toString() {
		return "[ " + no +". | " + title + " | " + day+ " ]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
