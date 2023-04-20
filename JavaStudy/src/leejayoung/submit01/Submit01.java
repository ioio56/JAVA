package leejayoung.submit01;

public class Submit01 {
	public static void main(String[] args) {

//		Q.01
		System.out.println("======================= Q.01 ======================= ");

		String name = "홍길동";
		int age = 26;
		double height = 177.9;
		String phone = "010-7398-7332";
		String email = "gildong@gmail.com";

		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("키 : " + height);
		System.out.println("연락처 : " + phone);
		System.out.println("이메일 : " + email);
//		Q.02
		System.out.println("======================= Q.02 ======================= ");

		String enigma = "너오구늘뭐너먹구지리";
		String one = enigma.replace("너", "");
		String two = one.replace("구", "");
		String three = two.replace("리", "");
		
		System.out.println("1차 암호 해독 [너 제거] : " + one);

		System.out.println("1차 암호 해독 [너 제거] : " + one);
		System.out.println("2차 암호 해독 [구 제거] : " + two);
		System.out.println("3차 암호 해독 [리 제거] : " + three);
//		System.out.println(enigma.replace("너", "").replace("구", "").replace("리", ""));
		
		System.out.println("해독완료!! ->" + three);
		System.out.println(three);

//		Q.03
		System.out.println("======================= Q.03 ======================= ");

		int example = 278;
		// 숫자를 문자열로 변환
		String change = "" + example; //"278"
		// 문자열을 각 자리수마다 자른다.
		// substring 추천
		String change_one = change.substring(0, 1); // "2"
		String change_two = change.substring(1, 2); // "7"
		String change_three = change.substring(2); // "8"

		int number_one = Integer.parseInt(change_one);
		int number_two = Integer.parseInt(change_two);
		int number_three = Integer.parseInt(change_three);
			
		System.out.println("실행결과");
		System.out.println("결과는 : " + (number_one + number_two + number_three));

//		 한줄로 끝내기 도전!
//		System.out.println("결과는 : " + (Integer.parseInt(change.substring(0, 1)) + Integer.parseInt(change.substring(1, 2)) + Integer.parseInt(change.substring(2))));		
		
	}
}
