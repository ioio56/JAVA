package leejayoung.submit08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Submit08 {

	public static void main(String[] args) {
//		ArrayList<Integer> myLotto = makeLotto();
//		System.out.println(myLotto);
//
//		HashMap<String, String> infoMap = new HashMap<>();
//		infoMap.put("a001", "1234a");
//		infoMap.put("b001", "1234b");
//		infoMap.put("c001", "1234c");
//		infoMap.put("d001", "1234d");
//		infoMap.put("e001", "1234e");
//		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("아이디를 입력해주세요");
//		System.out.printf(">>>");
//		String inputId = scan.nextLine();
//		System.out.println("비밀번호를 입력해주세요");
//		System.out.printf(">>>");
//		String inputPasword = scan.nextLine();
//		if(infoMap.containsKey(inputId) == false){
//			System.out.println("존재하지 않는 아이디입니다");
//		}else{
//			if(infoMap.containsValue(inputPasword) == false) {
//				System.out.println("비밀번호가 틀렸습니다");
//			}else {
//				System.out.println("로그인성공");
//			}
//		}
	}

	public static ArrayList<Integer> makeLotto() {
		Set<Integer> lotto = new HashSet<>();

		outer: while (true) {
			int rand = (int) (Math.random() * 45) + 1;
			if (lotto.size() < 6) {
				lotto.add(rand);
			} else {
				break outer;
			}
		}
		// 입력한 id가 key값 중에 존재하면 value 리턴, 없으면 null 리턴
		// 입력한 id가 key값 중에 존재하면 null이 아님, 없으면 null리턴
		/*
		 * if(infoMap.get(id) != null) { // id가 map안에 key값으로 존대
		 * 
		 * //TODO 비밀번호 체크 infoMap.get(id).equals(pw)) {
		 * 
		 * System.out.println("로그인 성공"); }elseP{ // id가 map안에 key값으로 존재하지 않음
		 * System.out.println("존재하지 않는 아이디 입니다"); } }
		 */

		ArrayList<Integer> arrylotto = new ArrayList<>(lotto);
		return arrylotto;
	}

	public static void num() {

		System.out.println("s");
	}

}
