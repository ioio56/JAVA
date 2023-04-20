package leejayoung.submit05;

public class Submit05 {

	public static void main(String[] args) {

		System.out.println("\n============== Q.01 ================\n");
		makeTree(7);
		makeTree(12);
		System.out.println("\n============== Q.02 ================\n");
		String example = "로꾸꺼 로꾸꺼";
		String result = reverseStr(example);
		System.out.println(result);
		System.out.println("\n============== Q.03 ================\n");
		String myBinaryStr = makeBinary(23);
		System.out.println(myBinaryStr);
	}// main 끝

	public static String reverseStr(String n) {
		String c = "";
		for (int i = n.length(); i > 0; i--) {

			String a = n.substring(i - 1, i);
			n = n.substring(0, i - 1);
			c = c + a;

		}
		System.out.println("뒤집은 결과 : " + c);
		
		return n;
	} // reverseStr 끝

	public static void makeTree(int n) {
		for (int i = 0; i < n; i++) {
			String space = "";
			// 외부 for문의 변수 i를 이용하여
			// 내부 for문의 반복 횟수를 조정할 수 있다.
			for (int k = 0; k < n - i; k++) {
				space += " ";
			}
			String stars = "";
			for (int k = 0; k < (i * 2) + 1; k++) {
				stars += "*";

			}
			System.out.println(space + stars);
		}

	} // makeTree 끝

	public static String makeBinary(int n) {
		String str = "";

		for (int i = 0; i >= 0  ; i++) {
			if (n > 0) {
				str = (n % 2) + "" + str;
				n = n / 2;
			} else {
				break;
			}
		}
		return str;
	} // makeBinary 끝
	
	
	
	
}
