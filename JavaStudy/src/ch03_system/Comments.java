package ch03_system;

public class Comments {

	// 자바 문서(javadoc)주석
	/**
	 * 이 자바 문서 주석은 banana에 대한 설명 바나나는 노랗다.
	 */
	static String banana = "바나나";

	public static void main(String[] args) {
		// 주석(Comment)

		// 단일 주석(코드 앞에 //)
		// 참고로 프로그래밍 언어마다 다른 주석을 사용하는 경우가
		// 많다. (파이썬은 #, sql은 --, html <!-내용->
		// 단축키 [ ctrl + / ]

		/*
		 * System.out.println(); System.out.println(); System.out.println();
		 */

		/*
		 * <- 입력 후 Enter 다중주석 ex) 작성자 : 정찬웅 작성일 : 2023-03-22
		 */

		// 자바 문서(javadoc) 주석
		String fruits = "Apple";
		fruits.substring(2);

		// 보통은 메소드 사용법에 대해 설명하는 용도로 사
		System.out.println(banana);

		// TODO 주석
		// 개발 중간중간에 이후 구현해야할 부분에 대해
		// 미리 말로라도 작성을 해놓는 경우 사용.
		// Window - Show View - Tesks 에 TODO 주석들의 위치가 다 뜸

		// TODO 바나나를 콘솔창에 출력할 예정 (저장 필수)
		System.out.println(banana);
//내용추가
	}

}
