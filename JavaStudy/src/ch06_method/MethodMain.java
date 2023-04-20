package ch06_method;

public class MethodMain {

	public static void main(String[] args) {
		// 메소드 = method = 함수 = function
		// 굳이 나누자면 method는 클래스에 종속된 함수를 말하며,
		// function은 클래스에 독립적인 함수를 말한다.
		
		// 1부터 100까지 다 더하면 결과는?
//		int sum = 0;
//		for(int i = 1; i <= 100; i++) {
//			sum += i;
//		}
//		System.out.println("1부터 100까지 더한 결과는 " + sum + "입니다.");
		printSum(1, 100);
		
		// 30부터 60까지 다 더하면 결과는?
//		sum = 0;
//		for(int i = 30; i <= 60; i++) {
//			sum += i;
//		}
//		System.out.println("30부터 60까지 더한 결과는 " + sum + "입니다.");
		printSum(30, 60);
		
		// 25부터 50까지 다 더하면 결과는?
//		sum = 0;
//		for(int i = 25; i <= 50; i++) {
//			sum += i;
//		}
//		System.out.println("25부터 50까지 더한 결과: " + sum);
		printSum(25, 50);
		
		System.out.println("\n===================================\n");
		
		// 위 작업을 함수로 만들기
		// 메소드 실행
		// 70부터 90까지 더하기
		printSum(70, 90);
		
		// 함수를 쓰면 좋은점
		// 실행부의 코드가 간결해진다. (가독성 증가)
		// 중복된 코드를 함수로 만들어서 사용하면
		// 해당 코드를 한 곳에서 관리할 수 있으므로 수정할때 용이
		
		// 리턴값이 존재하는 함수 만들기
		returnSum(80, 90); // 리턴값을 사용하고 있지 않음
		
		int rst = returnSum(80, 90);
		System.out.println(rst);
		
		System.out.println("\n==============================\n");
		
		// System.out.println(); 를 print()로 만들어쓰기
		print("파이썬 저리가라~");
		System.out.println("파이썬 저리가라~");
		
		System.out.println(55);
		print(55); // 띠용??
		
		System.out.println("\n===============================\n");
		
		// 절댓값 구해주는 메소드 만들기
		int number = Math.abs(-10);
		System.out.println(number);
		
		// 메소드명: absolute
		// 파라미터 타입: int
		// 리턴 타입: int
		number = absolute(-10);
		System.out.println(number);
		
		System.out.println("\n============================\n");
		
		// 이름, 국어 점수, 영어 점수, 수학 점수를 
		// 파라미터로 넣으면
		// 이름: 유정
		// 국어: 90
		// 영어: 85
		// 수학: 87
		// 평균: 87.11
		// 등급: B 
		// (90점 이상 A, 80점 이상 B, 그 외 C)
		makeCard("유정", 90, 90, 89);
		
	} // main 끝
	
	public static void makeCard(String name, int kor, int eng, int math) {
		System.out.println("이름: " + name);
		System.out.println("국어: " + kor);
		System.out.println("영어: " + eng);
		System.out.println("수학: " + math);
		// avg 값 반올림 (몇번째 자리를 기준) 메소드 만들 예정
		double avg = (kor + eng + math) / 3.0;
		System.out.println("평균: " + avg);
		
		String grade = "C";
		if(avg >= 90) {
			grade = "A";
		}else if(avg >= 80) {
			grade = "B";
		}
		System.out.println("등급: " + grade);
	}
	

	
	// 메소드 선언
	// [접근제어자 static] 리턴타입 메소드명(파라미터){   }  
	// void는 리턴타입이 없는 메소드를 의미
	public static void printSum(int from, int to) {
		int sum = 0;
		for(int i = from; i <= to; i++) {
			sum += i;
		}
		System.out.println(from + "부터 " + to 
				+ "까지 더한 결과는 " + sum + "입니다.");
	}
	

	public static int returnSum(int from, int to) {
		int sum = 0;
		for(int i = from; i <= to; i++) {
			sum += i;
		}
		System.out.println(from + "부터 " + to 
				+ "까지 더한 결과는 " + sum + "입니다.");
		// 변수 sum의 값을 리턴
		// 메소드 내에 return이 실행되면
		// 그 즉시 메소드를 종료
		return sum;
	}
	
	
	public static void print(String msg) {
		System.out.println(msg);
	}
	
	// 하나의 클래스 내에 있는 메소드는 기본적으로
	// 메소드명이 중복되면 안된다.
	// 메소드 오버로딩
	// 하나의 클래스 내에 파라미터의 타입, 수를
	// 다르게 지정하는 경우 중복된 메소드명을 사용할 수 있음
	public static void print(int num) {
		System.out.println(num);
	}
	
	
	public static int absolute(int num) {
		// 들어온 num 값이 양수면 그대로 리턴
		// 음수면 양수로 바꿔준 후 리턴 (-1을 곱함)
		if(num < 0) {
			num *= -1;
		}
		return num;
	}
 	
}

