package leejayoung.submit13.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import ch14_jdbc_jsp.vo.StudentVO;
import leejayoung.submit13.service.BoardService;
import leejayoung.submit13.service.HomepageMemberService;
import leejayoung.submit13.vo.BoardVO;
import leejayoung.submit13.vo.HomepageMemberVO;

public class HomepageMain {

	public static void main(String[] args) {
		Date now = new Date();
		HomepageMemberVO member = new HomepageMemberVO();
		BoardService boardService = BoardService.getInstance();
		HomepageMemberService memService = HomepageMemberService.getInstance();

		Scanner scan = new Scanner(System.in);

		outer: while (true) {
			System.out.println("행동을 선택해 주세요");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 종료");
			System.out.print(">>>");

			int command = 0;
			try {
				command = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요");
				continue;
			}
			if (command == 1) {
				// TODO 회원가입
				System.out.print("아이디 : ");
				String id = scan.nextLine();

				System.out.print("비밀번호 : ");
				String pw = scan.nextLine();

				ArrayList<HomepageMemberVO> memList = memService.getMemList();
				for (int i = 0; i < memList.size(); i++) {
					if (memList.get(i).getMemberId().equals(id)) {
						System.out.println("아이디가 중복됩니다.");
						continue outer;
					}
				}

				HomepageMemberVO mem = new HomepageMemberVO(id, pw, now);
				memService.registStudent(mem);

			} else if (command == 2) {
				// TODO 로그인
				System.out.print("아이디 : ");
				String id = scan.nextLine();

				System.out.print("비밀번호 : ");
				String pw = scan.nextLine();

				member.setMemberId(id);
				member.setMemberPw(pw);
				HomepageMemberVO login = memService.login(member);
				
				if (login.getMemberId() != null) {
					// 로그인 성공
					System.out.println(login.getMemberId() + "님 환영합니다");
					System.out.println("로그인 되었습니다");
					while (true) {

						System.out.println("1. 글쓰기 | 2. 글조회 | 3.로그아웃");
						System.out.print(">>>");
						int commed_write = 0;
						try {
							commed_write = Integer.parseInt(scan.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("다시입력해주세요");
							continue;
						}

						if (commed_write == 1) {
							// TODO 글쓰기
							System.out.print("글제목을 입력해주세요 : ");
							String write = scan.nextLine();

							System.out.print("글 내용을 입력해주세요 : ");
							String inner = scan.nextLine();

							BoardVO board = new BoardVO(write, inner, login.getMemberId());
							boardService.write(board);

							for (int i = 0; i < boardService.getBoardList().size(); i++) {
								System.out.println(boardService.getBoardList().get(i));
							}
						} else if (commed_write == 2) {
							// TODO 글조회
							

							while (true) {
								for (int i = 0; i < boardService.getBoardList().size(); i++) {
									System.out.println(boardService.getBoardList().get(i));
								}
								System.out.print("글 번호를 입력해주세요 : ");
								int commed_num;
								try {
									commed_num = Integer.parseInt(scan.nextLine());
									System.out.println("\n===================\n");
									System.out.println("제목: "+boardService.getBoardList().get(commed_num-1).getWrite());
									System.out.println("작성자: "+boardService.getBoardList().get(commed_num-1).getId());
									System.out.println("작성일: "+boardService.getBoardList().get(commed_num-1).getBoard_date());
									System.out.println("글내용: "+boardService.getBoardList().get(commed_num-1).getInner());
									System.out.println("\n===================\n");
									break;
								} catch (NumberFormatException e) {
									System.out.println("숫자를 입력해주세요");
								continue;
								}
							}

						} else if (commed_write == 3) {

							continue outer;
						} else {
							System.out.println("번호를 다시입력해주세요");
						}

					}

				} else {
					System.out.println("아이디 혹은 비밀번호가 틀립니다.");
				}
			} else if (command == 3) {
				break;
			} else {
				System.out.println("1,2,3중에 선택해주세요");
				continue outer;
			}
		}
	}
}
