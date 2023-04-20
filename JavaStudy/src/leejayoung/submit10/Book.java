package leejayoung.submit10;

public class Book {
	String no;
	String title;
	boolean yn = false;

	public Book(String no, String strings) {
		this.no = no;
		this.title = strings;
	}

	@Override
	public String toString() {
		if (yn == false) {
			return "[책 번호 : " + no + ", 책 제목 : " + title + ", 대여상태 : " + "입고중" + "]";
		} else {
			return "[책 번호 : " + no + ", 책 제목 : " + title + ", 대여상태 : " + "대여중"  + "]";
		}
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isYn() {
		return yn;
	}

	public void setYn(boolean yn) {
		this.yn = yn;
	}

}
