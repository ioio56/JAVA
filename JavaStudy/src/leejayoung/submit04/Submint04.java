package leejayoung.submit04;

import java.util.Scanner;

public class Submint04 {
	public static void main(String[] args) {
		System.out.println("\n============== Q.01 ================\n");
		Scanner scan = new Scanner(System.in);

		System.out.print("거꾸로 뒤집을 문자열 입력 : ");

		String str = scan.nextLine();
		String c = "";

		for (int i = str.length(); i > 0; i--) {

			String a = str.substring(i - 1, i);
			str = str.substring(0, i - 1);
			c = c + a;

		}
		System.out.println("뒤집은 결과 : " + c);

		System.out.println("\n============== Q.02 ================\n");
		int A = 10;
		int B = 4;
		outer: while (true) {

			System.out.println("================= 희영 빌딩 엘레베이터 =====================");
			System.out.println("승강기 A의 현재 위치 : " + A + "층");
			System.out.println("승강기 B의 현재 위치 : " + B + "층");
			System.out.println("몇층에 계시나요? [종료하시려면 q또는 exit입력]");
			String str1 = scan.nextLine();

			if (str1.equals("q")) {
				System.out.println("프로그램 종료");
				break outer;
			} else if (str1.equals("exit")) {
				System.out.println("프로그램 종료");
				break outer;
			} else {
				int str2 = Integer.parseInt(str1);

				if (Math.abs(A - str2) > Math.abs(B - str2)) {
					System.out.println(str1 + "층에서 엘리베이터를 호출합니다");
					System.out.println("승강기 B가 " + str2 + "층으로 이동하였습니다.");
					B = str2;
				} else if (Math.abs(A - str2) < Math.abs(B - str2)) {
					System.out.println(str1 + "층에서 엘리베이터를 호출합니다");
					System.out.println("승강기 A가 " + str2 + "층으로 이동하였습니다.");
					A = str2;
				} else {
					if (A > B) {
						System.out.println(str1 + "층에서 엘리베이터를 호출합니다");
						System.out.println("승강기 A가 " + str2 + "층으로 이동하였습니다.");
						A = str2;
					} else {
						System.out.println(str1 + "층에서 엘리베이터를 호출합니다");
						System.out.println("승강기 B가 " + str2 + "층으로 이동하였습니다.");
						B = str2;
					}
				}
			}
		}
	}
}
