package ch10_extends_interface;

import java.util.ArrayList;

public class Library {

	private static ArrayList<Book> bookList = new ArrayList<>();

	private Library() {
	}

	private static Library instance = new Library();

	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public static Library getInstance() {
		return instance;
	}

	public static String makeStuId() {
		return (bookList.size() + 1) + "";
	}

	public void addLibrary(Book bo) {
		bookList.add(bo);
	}

	public void showLibrary() {
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i));
		}
	}

	public Book find_no(String no) {
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getNo().equals(no)) {
				return bookList.get(i);
			} else {
			}
		}
		return null;
	}

	public ArrayList<Book> find_title(String title) {
		ArrayList<Book> bList = new ArrayList<>();
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getTitle().contains(title)) {
				bList.add(bookList.get(i));
			}
		}
		return bList;
	}

}
