package ch07_array;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ArrayMain {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// 배열 (Array
		String samjang = "삼장";
		String woogong = "오공";
		String saojeong = "사오정";
		String palgye = "저팔계";

		// 문자열의 배열
		// 배열의 선언
		// 숫자 4는 첨자를 의미하며, 배열의 크기를 정한다.
		// 배열의 크기는 바뀌지 않는다. (핵트롤)
		String[] seoyugi = new String[4];

		System.out.println(saojeong.length());
		// .length가 길이를 리턴 (메소드는 아님)
		System.out.println(seoyugi.length);
		// 배열 내 요소 확인
		// 인덱스 사용(= 인덱싱)
		System.out.println(seoyugi[0]);

		// 처음 생성된 배열 내에는 기본 값(default)이 들어있다.
		// 참조타입: null
		// 기본타입: 숫자면 0, boolean면 false
		int[] numbers = new int[3];
		System.out.println(numbers[0]);

		boolean[] bools = new boolean[5]; // false, false ...
		System.out.println(bools[0]);
		System.out.println("\n============================\n");

		// 배열에 값 넣기
		seoyugi[0] = samjang;
		seoyugi[1] = woogong;
		seoyugi[2] = saojeong;
		seoyugi[3] = palgye;
		System.out.println(seoyugi);

		// for 문을 이용해서 0부터 array.length 미만까지
		// 인덱스를 순회하면 배열의 모든 요소에 접근이 가은하다.
		for (int i = 0; i < seoyugi.length; i++) {
			System.out.println(seoyugi[i]);
		}
		System.out.println("\n============================\n");
		// 배열의 단점
		// 크기가 고정됨(핵토파스칼 트롤)
		// 늘어나지도, 줄어들지도 않으며
		// 값을 추가하거나, 제거하지도 못한다.

		// 실행했을대 발생하는 에러는 런타입 에러
		// seoyugi[4] = "크리링";

		// 배열의 장점
		// for 문을 이용하여 배열에 담긴 모든 요소들을
		// 한번 처리할 수 있다. (데이터 처리)
		for (int i = 0; i < seoyugi.length; i++) {
			seoyugi[i] = "서유기" + seoyugi[i];
		}
		printArray(seoyugi);
		System.out.println("\n============================\n");
		// 배열 내 특정 요소에 접근하여 처리를 할 수 있다.
		// 서유기 오공 -> 드래곤볼 오공
		for (int i = 0; i < seoyugi.length; i++) {
			// 오공이 포함되어 있으면 true
			if (seoyugi[i].contains("오공")) {
				seoyugi[i].replace("서유기", "드래곤볼");
			}

		}
		printArray(seoyugi);
		System.out.println("\n============================\n");
		// 배열 요소를 조회하는 메소드 만들기
		// 삼장, 오공 ...

		System.out.println("\n============================\n");
		int[] intArray = new int[6];

		// 기존 값 넣는 방식
		intArray[0] = 1;
		intArray[1] = 2;
		intArray[2] = 3;
		intArray[3] = 4;
		intArray[4] = 5;
		intArray[5] = 6;
		printArray(intArray);

		for (int i = 0; i < intArray.length; i++) {
			// 로또 번호
			// 1~45 사이의 핸덤 숫자
			// Math.random() -> 0~1사이의 랜덤 소수
			// 0 0.1 0.9
			// Math.random() * 5 -> 0~5 미만의 랜덤 소수
			// 0 0.5 4.5
			// (int)(Math.random() * 5) ->
			// 0 0 4
			// (int)(Math.random() * 45) -> 0~44 사이의 랜덤 정수
			// (int)(Math.random() * 45)+1 -> 1~45 사이의 랜덤 정수

			intArray[i] = (int) (Math.random() * 45);

		}
		printArray(intArray);
		System.out.println("\n============1================\n");
		// 값을 넣으면서 배열을 선언

		String[] students = { "홍민경", "유동윤", "박진영", "김대일" };

		printArray(students);

		System.out.println("\n============================\n");
		// 문자열 나누기
		String myInfo = " ";
		String subjects = "자바, sql,자바스크립트,jsp";

		// .split(문자열)
		// 괄호안 문자열을 기준으로 해당 문자열을 나누어
		// 문자열 배열로 리턴한다.
		String[] subjectArray = subjects.split(",");
		System.out.println(subjectArray.length);
		System.out.println(subjectArray[1]);
		// 데이터가 잘 정돈되어 있지 않다면
		// ,로 일단 나누고 양쪽 공백을 제거해주면 도니다 (trim)
		for (int i = 0; i < subjectArray.length; i++) {
			subjectArray[i] = subjectArray[i].trim();
		}
		printArray(subjectArray);
		System.out.println("\n============================\n");
		// 배열의 복수
		String[] sinSeoyugi = seoyugi;
		printArray(sinSeoyugi);

		sinSeoyugi[0] = "강호동";
		sinSeoyugi[1] = "이수근";

		printArray(sinSeoyugi);
		printArray(seoyugi);

		// @ 앞은 객체의 타입
		// @뒤에 붙은건 hashCode를 16진수로 나타낸것
		System.out.println(seoyugi);
		System.out.println(sinSeoyugi);

		System.out.println(seoyugi.hashCode());
		System.out.println(sinSeoyugi.hashCode());
		// 숫자를 16진수로 변환
		System.out.println(Integer.toHexString(seoyugi.hashCode()));

		// 해쉬코드(hashCode)
		// 객체의 메모리 주소 값을 이용해서
		// 해쉬를 적용한 코드

		// 해쉬(hash)
		// 해쉬함수 (암호화 알고리즘)를 이용해서
		// 데이터를 암호와하는 기법(대표 SHA-256)

		String password = "1q2w3e4";
		String encryptPw = encrypt(password);
		System.out.println(encryptPw);
		System.out.println("\n============================\n");

		// 올바른 배열 복사
		String[] newSeoyugi = seoyugi.clone();
		printArray(seoyugi);
		printArray(newSeoyugi);

		// .clone을 까먹었다.
		String[] copy = new String[seoyugi.length];
		// copy의 각 인덱스에 , seoyugi의 각 인덱스 값을 넣어준다.
		for (int i = 0; i < seoyugi.length; i++) {
			copy[i] = seoyugi[i];

		}
		System.out.println("\n============================\n");
		int[] numArray = { 23, 456, 213, 32, 464, 1, 2 };
		System.out.println(numArray[0]);
		System.out.println(numArray[1]);

		// 인덱스 0번 값과 인덱스 1번 값의 위치를 바꿔보세요
		int tmp = numArray[5];
		numArray[5] = numArray[2];
		numArray[2] = tmp;
		printArray(numArray);
		System.out.println("\n============================\n");

		swp(0, 1, numArray);
		printArray(numArray);

		// 가끔 면접에서 물어보는 문제
		// call by value 와 call by reference 구분
		// 기본타입 변수에 대해서는 call by value로 동작
		// 참조 타입 변수에 ㅐ해서는 call by reference로 동작

		int a = 10;
		int b = a;
		System.out.println(a);
		a = 20;
		System.out.println(b);

		sawp(a, b);
		System.out.println(a);
		System.out.println(b);

		// 다차원 배열
		// 1D -> x축
		// 2D -> x축 , y축
		// 3D -> x축 , y축 , z축
		// 4D -> x축 , y축 , z축 , t

		int[] oneDir = { 1, 2, 3 };
		// 2D는 1차원 배열 내에 1차원 배열들이 존재하는 경우
		// 헹렬로 나타낸다면
		// 1 2 3
		// 4 5 6
		// 7 8 9
		int[][] twoDir = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// twoDir으로 부터 {7,8,9} 배열을 꺼내고 싶다
		int[] tempArray = twoDir[2];
		printArray(tempArray);

		// twoDir으로 부터 6 배열을 꺼내고 싶다
		int six = twoDir[1][2];
		System.out.println(six);

		// 3차원 배열은 일차원 배열 내 2차원 배열들이 존재
		int[][][] threeDir = { { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
				{ { 10, 11, 12 }, { 13, 14, 15 }, { 16, 17, 18 } },
				{ { 19, 20, 21 }, { 22, 23, 24 }, { 25, 25, 26 } } };
		// 0층의 행렬
		// 1 2 3
		// 4 5 6
		// 7 8 9
		// 1층의 행렬
		// 10 11 12
		System.out.println(threeDir[2][0][2]);

		System.out.println("\n============================\n");

		// 정렬
		int[] numberArray = { 23, 452, 13, 1, 67, 54 };

		// Array.sort(배열)
		// 해당 배열을 오름차순 정렬
		Arrays.sort(numberArray);

		printArray(numberArray);

		// 내림차순 정렬
		// 이방법은 참조타입 객체를 담은 배열일 경우에만 가능
//		Arrays.sort(numberArray, collection,reverseOrder());

		// 현제 1, 13, 23, 54, 67, 452
		// 내림차순이면 452, 67, 54, 23, 13, 1

		// numberArray에 모든 요소에 -1 을 곱하고
		// -1, -13, -23, -54, -67, -452
		// Array.sort(numberArray) 적용
		// -452, -67, -54, -23, -13, -1
		// numberArray에 모든 요소에 -1 을 곱하고
		// 452, 67, 54, 23, 13, 1

		for (int i = 0; i < numberArray.length; i++) {
			numberArray[i] = numberArray[i] * -1;

		}
		Arrays.parallelSort(numberArray);
		for (int i = 0; i < numberArray.length; i++) {
			numberArray[i] = numberArray[i] * -1;

		}
		printArray(numberArray);

		System.out.println("\n============================\n");

		// 알고리즘으로 정렬
		// 버블정렬

		for (int k = 0; k < numberArray.length - 1; k++) {
			for (int i = 0; i < numberArray.length - 1; i++) {
				// i > i+1 하면 오름차순
				// i < i+1 하면 내림차순
				if (numberArray[i] > numberArray[i + 1]) {
					int t = numberArray[i];
					numberArray[i] = numberArray[i + 1];
					numberArray[i + 1] = t;
				}
			}
		}

		printArray(numberArray);

	}

	public static void sawp(int p_a, int p_b) {
		int tmp = p_a;
		p_a = p_b;
		p_b = tmp;
	}

	public static void swp(int idxA, int idxB, int[] numArray) {
		int tmp = numArray[idxA];
		numArray[idxA] = numArray[idxB];
		numArray[idxB] = tmp;
	}

	public static void printArray(String[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			// i가 마지막일때에는 뒤에 콤마(,)를
			// 붙이지 않고, 개행 문자도 넣는다.
			if (i == intArray.length - 1) {
				System.out.println(intArray[i]);

			} else {// break;
			}
			System.out.printf(intArray[i] + ",");
		}

	}

	public static void printArray(int[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			// i가 마지막일때에는 뒤에 콤마(,)를
			// 붙이지 않고, 개행 문자도 넣는다.
			if (i == intArray.length - 1) {
				// System.out.println(intArray[i]);

			}
			System.out.printf(intArray[i] + ",");
		}
		System.out.println("");
	}

	public static String encrypt(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(text.getBytes());

		return bytesToHex(md.digest());
	}

	private static String bytesToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}
}
