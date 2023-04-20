package leejayoung.submit03;

public class Submit03 {
	public static void main(String[] args) {
		System.out.println("\n============== Q.01 ================\n");

		int f = 1;
		for (int n = 1; n < 11; n++) {
			f = n * f;
		}
		System.out.println("결과 : " + f);

		long p = 1;
		for (int n = 1; n < 16; n++) {
			p = Long.valueOf(n).intValue() * p;
		}
		System.out.println("결과 : " + p);

		System.out.println("\n============== Q.02 ================\n");

		String findWally = "윌리울리일리울리울리일리월리일리윌리월리울리일리일리월리일리윌리일리윌리일리월리월리윌리울리윌리울리일리울리울리윌리일리";

		int count = 0;
		for (int i = 0; i < findWally.length(); i = i + 2) {
			String change1 = findWally.substring(i, i + 2);
			if (change1.equals("월리")) { // 문자열같음 확인 방법 .equals
				count++;
			}
		}
		System.out.println("결과 : " + count);

		System.out.println("\n============== Q.03 ================\n");
		String stars = "*****";
		for (int i = 5; i > 0; i--) {
			System.out.println(stars);
			stars = stars.substring(0, stars.length() - 1);
		}
		
		System.out.println("\n==============================\n");
		
		for (int i = 0; i < 5; i++) {
			String space = "*";
			// 외부 for문의 변수 i를 이용하여
			// 내부 for문의 반복 횟수를 조정할 수 있다.
			for (int k = 0; k < 4-i; k++) {
				space += "*";
			}
			String stars2 = "";
			for (int k = 0; k < (i*2)+1; k++) {
				stars2 += " ";
			}
			System.out.println(space + stars2);
		}
	}
}
