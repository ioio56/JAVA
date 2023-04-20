package leejayoung.submit10;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryMain {

	public static void main(String[] args) {

		Library libDB = Library.getInstance();
		Scanner scan = new Scanner(System.in);

		String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수,해리포터와 불사조 기사단, 해리포터와 혼혈왕자, 해리포터와 죽음의 성물,어린왕자, 나의 라임 오렌지나무, 이것이 자바다, 좋은생각, 반지의 제왕: 반지 원정대, 반지의 제왕: 두 개의 탑, 반지의 제왕: 왕의 귀환, 토익보카, 개미";

		String[] array = strBooks.split(",");
		for(int i = 0; i < array.length; i++) {
			array[i] = array[i].trim(); // trim() <--양쪽 끝에 있는 공백 제거
		}
		
		for (int i = 0; i < array.length; i++) {

			Book bo = new Book(Library.makeStuId(), array[i]);
			libDB.addLibrary(bo);
		}

		while (true) {
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 책 입고 | 2. 책 대여 | 3. 책 목록 | 4. 책 검색 | 5. 종료");
			System.out.print(">>>");
			int commend = Integer.parseInt(scan.nextLine());

			if (commend == 1) {
				System.out.println("책번호를 입력해주세요");
				System.out.print(">>>");
				String no = scan.nextLine();
				Book find = libDB.find_no(no);
				System.out.println(find.title + "이(가) 입고되었습니다.");
				find.yn = false;

			} else if (commend == 2) {
				System.out.println("책이름을 입력해주세요");
				System.out.print(">>>");
				String title = scan.nextLine();
				ArrayList<Book> find = libDB.find_title(title);

				if (find.size() > 1) {
					for (int i = 0; i < find.size(); i++) {
						System.out.println(find.get(i));
					}
					System.out.println("책번호를 입력해주세요");
					System.out.print(">>>");
					String no = scan.nextLine();
					Book find2 = libDB.find_no(no);
					System.out.println(find2.title + "을(를) 대여하셨습니다.");
					find2.yn = true;
				} else {

					System.out.println(find.get(0).title + "을(를) 대여하셨습니다.");
					find.get(0).yn = true;
				}

			} else if (commend == 3) {
				libDB.showLibrary();
			} else if (commend == 4) {

				System.out.println("책이름을 입력해주세요");
				System.out.print(">>>");
				String title = scan.nextLine();
				ArrayList<Book> find = libDB.find_title(title);
				for (int i = 0; i < find.size(); i++) {
					System.out.println(find.get(i));
				}

			} else {
				break;
			}

		}

		
	}

}
