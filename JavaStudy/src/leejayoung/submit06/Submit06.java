package leejayoung.submit06;

import java.util.Arrays;

public class Submit06 {

	public static void main(String[] args) {
		System.out.println("\n======================= Q.01 =======================\n");
		String[] nameList = { "이정재", "김혜수", "이병헌", "송중기", "유아인", "류준열", "공유", "마동석", "이종석", "황정민", "박소담", "이선균", "이성민",
				"최민식", "이동휘", "권상우", "소지섭", "공효진", "조정석", "허성태", "이하늬" };

		int a = 0;
		for (int i = 0; i < nameList.length; i++) {
			String name = nameList[i];

			// equals 문자열 같음 확인 꼭 외우기
			if (name.substring(0, 1).equals("이")) {
				a = a + 1;
			}
		}
		System.out.println("이씨 성을 가진 배우가 총 " + a + "명 있습니다.");

		System.out.println("\n======================= Q.02 =======================\n");

		int[] intArr = { 23, 456, 213, 32, 464, 1, 2, 4 };
		int[] intArr1 = new int[8];
		for (int k = 0; k < intArr.length - 1; k++) {
			for (int i = 0; i < intArr.length - 1; i++) {
				// i > i+1 하면 오름차순
				// i < i+1 하면 내림차순
				if (intArr[i] > intArr[i + 1]) {
					int t = intArr[i];
					intArr[i] = intArr[i + 1];
					intArr[i + 1] = t;
				}
			}
		}

		for (int i = 0; i < intArr.length - 1; i++) {
			System.out.println(intArr[i]);
		}
		System.out.println("최댓값 : " + intArr[intArr.length - 1]);
		System.out.println("최솟값 : " + intArr[0]);

		System.out.println("\n======================= Q.03 =======================\n");
		
		// 로또 시뮬레이션 
		int[] winLotto = {4,24,27,35,37,45,};
		int buyCount = 0; 
		while(true) {
			buyCount++;
			int[] lotto = makeLotto();
			
			int cnt = 0;
			for(int i =0; i < winLotto.length; i++) {
				if(winLotto[i] == lotto[i]) {
					cnt ++;
				}
			}
			
			if(cnt == 6) {
				System.out.println("두배열이 같다");
			}else {
				System.out.println("꽝");
			}

		}
//		for (int i = 0; i < myLotto.length; i++) {
//			System.out.print(myLotto[i] + " ");
//		}

	}

	public static int[] makeLotto() {
		// 로또 번호(1~45 사이의 랜덤 숫자)
		int[]result = new int[6];
		int rand = (int)(Math.random() * 45) + 1;
		// 중복없이 로또 번호 6자리 담기
		int idx = 0;
		outer: while(true) {
			result[0] = (int)(Math.random()*45)+1;
			
			// rand가 result 배열 안에 없는 숫자라면
			// 담기
			for(int i = 0; i < result.length; i++) {
				if(result[i] == rand) {
					continue outer;
				}
			}
			
			result[idx] = rand;
			idx++;
			
			if(idx == 0){
				break;
			}
			// 오름차순 정렬
			Arrays.sort(result);
		}
		return result;
	}
}