package leejayoung.submit07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Submit07 {

	public static void main(String[] args) {

		int rand = 0;
		rand = makeRandom(10, 20);
		System.out.println(rand);
		System.out.println("\n======================= Q.02 =======================\n");
		ArrayList<String> mom = new ArrayList<String>(Arrays.asList("냉장고", "로봇청소기", "세탁기", "에어컨"));
		ArrayList<String> dad = new ArrayList<String>(Arrays.asList("노트북", "TV", "에어컨", "플레이스테이션", "로봇청소기"));
		ArrayList<String> result = new ArrayList<>();
		for (int n = 0; n < mom.size(); n++) {
			for (int i = 0; i < dad.size(); i++) {
				if (mom.get(n).contains(dad.get(i))) {
					result.add(dad.get(i));
				}
			}
		}
		System.out.println(result);
		result = new ArrayList<>();

		for (int i = 0; i < mom.size(); i++) {
			result.add(mom.get(i));
		}
		System.out.println(result);
			for (int i = 0; i < dad.size(); i++) {
				if (mom.contains(dad.get(i))) {
					continue;
				}else {result.add(dad.get(i));}
		}
		System.out.println(result);

	}

	public static int makeRandom(int num, int num2) {
		ArrayList<Integer> arr = new ArrayList<>();
		int ran = (int) (Math.random() * (num2 - num) + 1) + (num);
		arr.add(ran);
		int c = 0;

		outer: while (true) {
			ran = (int) (Math.random() * (num2 - num) + 1) + (num);
			for (int n = 0; n < arr.size(); n++) {
				if (arr.get(n) == ran) {
					continue outer;
				}
			}
			arr.add(ran);
			c++;
			if (c == (num2 - num - 1)) {
				break outer;
			}
		}
		System.out.println("\n======================= Q.01 =======================\n");
		System.out.println(arr);
		Collections.sort(arr);
		System.out.println(arr);
		Collections.sort(arr, Collections.reverseOrder());
		System.out.println(arr);

		ran = (int) (Math.random() * arr.size());
		int ret = arr.get(ran);
		return ret;
	}
	
	// 중복 제거 remove 사용가능 
	
	// 전체 구매 목록(합집합)
	
	

}
