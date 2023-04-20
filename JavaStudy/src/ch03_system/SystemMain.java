package ch03_system;

import java.util.Scanner;

public class SystemMain {

	public static void main(String[] args) {
		// 표준 출력
		// 콘솔창에 텍스트 출력하기
		// println()
		// 콘솔창에 괄호안 내용을 출력 후 줄바꿈(개행문자) 해준다.

		System.out.println("이미 알고 있음");
		System.out.println("Start");
		System.out.println("");
		System.out.println("End");

		// print()
		// 괄호안 내용을 출력하기만 함
		// 안에 내용이 없으면 에러
		System.out.print("줄바꿈 안됨");
		System.out.print("보기 불편..");

		System.out.println("\n=========================================\n");

		// 제어문자
		// 문자열 내에 역슬래시 (\)를 이용해여
		// 특정 기능을 사용할 수 있다.

		// \n 줄바꿈
		System.out.print("println처럼 동작\n");
		System.out.print("중간에 \n을 넣어보자\n");

		// \t 탭
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("1\t2\t3\t4\t5");
		System.out.println("8\t9\t10\t11\t12");

		// 문자열 내에서 기능을 가지는 문자(\,",')
		// 얘네들을 출력하고 싶다면 앞에 \를 붙여 준다.
		System.out.println("개행문자는 \\n");
		System.out.println("소크라테스 왈 \"너 자신을 알라\"");

		// 특수 문자도 출력 가능 하다.
		System.out.println("☆");

		System.out.println("\n==============================================\n");

		// printf()
		// 콘솔 창에 포맷 문자열(format string) 형태로 내용을 출력

		System.out.printf("%d명이 수업을 듣고 있습니다.", 24);
		System.out.printf("%d명이 %s을 듣고 있습니다.", 24, "수업");

		// 예시
		System.out.printf("%03d장 표준 입출력\n", 12); // 숫자로 자리수 표현없으면 0으로 표시한다
		System.out.printf("%3d장 표준 입출력\n", 12); // 숫자로 자리수 표현없으면 0으로 표시한다
		System.out.printf("원주율은 %.02f", 3.141592); // 소수 2자리까지 표현하고 없으면 0으로 표시한다
		System.out.printf("원주율은 %.02f", 3.1); // 소수 2자리까지 표현하고 없으면 0으로 표시한다
		System.out.printf("통장 잔고는 %,d원입니다.", 1000000);
		System.out.println("\n================== 표준입력 ======================\n");

		// Scanner 클래스부터 객체 생성
		Scanner scan = new Scanner(System.in);
		System.out.println("이름을 입력해주세요.");
		System.out.print(">>> "); // 줄바꿈 없음

		// 키보드 입력 받기
		String name = scan.nextLine();
		
		System.out.println(name + ": 좀 덥네요.");

		// scan.next 또는 scan.nextInt() 등은 사용하지 않기
		System.out.println("에어컨 희망 온도를 입력해주세요");
		System.out.println(">>>");

//		int temper = scan.nextInt(); // 사용하지 않기 다음 입력시 오류가 생김

		// nextLine()은 숫자를 입력해도 문자열로 가지고 온다.
		// 문자열 숫자를 정수형 숫자로 바꾼후 int로 저장한다
		int temper = Integer.parseInt(scan.nextLine());
		System.out.print("희망 온도 : " + temper);
		System.out.println("");
		System.out.println("냉방/난방 선택해주세요");
		System.out.println(">>>");
		String mode = scan.nextLine();
		System.out.println("모드:" + mode);

		
		
		
		
		
		
		
		
		
	}

}
