package leejayoung.submit02;

import java.util.Scanner;

public class Submit02 {

	public static void main(String[] args) {
		
		System.out.println("\n============== Q.01 ================");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름을 입력해주세요.");
		System.out.print(">>> ");
		String name = scan.nextLine();
		
		System.out.println("국어 점수를 입력해주세요.");
		System.out.print(">>> ");
		int KScore = Integer.parseInt(scan.nextLine());
		
		
		System.out.println("영어 점수를 입력해주세요.");
		System.out.print(">>> ");
		int EScore = Integer.parseInt(scan.nextLine());
		
		System.out.println("수학 점수를 입력해주세요.");
		System.out.print(">>> ");
		int MScore = Integer.parseInt(scan.nextLine());

		double average = (KScore+EScore+MScore)/3.0000000;
		
		String grade = (average > 90) ? ("A") : ((average > 80) ? ("B") : ("C"));
		
		System.out.println("이름 : " + name);
		System.out.println("국어 : " + KScore);
		System.out.println("이름 : " + EScore);
		System.out.println("이름 : " + MScore);
		System.out.printf("평균 : %.2f", average);
		System.out.println("");
		System.out.printf("등급 : " + grade);
		
		System.out.println("\n============== Q.02 ================");

		String idBack = "1231476";
		String idBackChang = idBack.substring(0, 1);
		int number_one = Integer.parseInt(idBackChang) % 2;

		System.out.println((number_one == 1) ? ("남자") : ("여"));
		
	}
}
