package leejayoung.submit12;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String day = format.format(date);
		Board board = new Board();
		BoardDB boardDB = new BoardDB();
		
		while (true) {
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 글 목록 | 2. 글쓰기 | 3. 종료");
			System.out.print(">>>");
			int num = Integer.parseInt(scan.nextLine());
			if (num == 1) {
				// 글목록
				System.out.println(boardDB.toString());

			} else if (num == 2) {
				// 글쓰기
				System.out.println("글 제목을 입력해주세요");
				String title = scan.nextLine();
				System.out.println("글 내용을 입력해주세요");
				String content = scan.nextLine();
				board = new Board(board.getNo(), title, day, content);
				boardDB.addBoardDB(board);
			} else if (num == 3) {
				// 종료
				System.out.println("종료합니다");
				break;
			}
		}

	}

}
