package note;

import java.util.Scanner;

public class work {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = "*";
		String nulls = "     ";
		for (int i = 0; i < 4; i++) {
			System.out.printf(nulls);
			nulls = nulls.substring(0, nulls.length() - 1);
			System.out.println(str);
			str = str + "**";
		}
		str = "***********";
		nulls = " ";
		for (int i = 5; i > 0; i--) {
			System.out.printf(nulls);
			nulls = nulls + " ";
			str = str.substring(0, str.length() - 2);
			System.out.println(str);
		}

		String strg = "";
		
//		for (int i = 0; i < 7; i++) {
//			
//			String number1 = scan.nextLine();
//			int a = Integer.parseInt(number1.substring(0,1));
//			int b = Integer.parseInt(number1.substring(2,3));
//			String ab = a+b+"";
//			if (a+b == 0) {
//				break;
//			} 
//		}
		System.out.println("숫자를 입력하세요(띄어쓰기로 구분)");
		String ch = scan.nextLine();		
		int one = Integer.valueOf(ch.substring(0,1)) - 1;
		int two = Integer.valueOf(ch.substring(2,3)) - 1;
		int three = Integer.valueOf(ch.substring(4,5)) -2;
		int four = Integer.valueOf(ch.substring(6,7))-2;
		int five = Integer.valueOf(ch.substring(8,9))-2;
		int six = Integer.valueOf(ch.substring(10,11))-8;
				
		String result = one + " " + two + " " + three + " " + four+ " " +five+ " "+ six;
		System.out.println(result);
		
		
		
		
		
		
	}
}
