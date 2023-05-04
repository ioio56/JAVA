package main;

import java.util.ArrayList;
import java.util.Scanner;

import service.MemberService;
import service.SpiderDataService;
import service.SpiderMainService;
import vo.MemberVO;
import vo.SpiderDataVO;
import vo.SpiderMainVO;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		SpiderMainService mainService = SpiderMainService.getInstance();
		SpiderDataService dateService = SpiderDataService.getInstance();
		MemberService memberService = MemberService.getInstance();

		outer: while (true) {
			System.out.println(" 1. 로그인하기 | 2. 회원가입 | 3. 종료 ");
			System.out.print(">>>");
			int comm = 0;
			try {
				comm = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요");

			}
			if (comm == 1) {
				// TODO 로그인하기
				System.out.println("아이디를 입력하세요");
				System.out.print(">>>");
				String id = scan.nextLine();

				System.out.println("비밀번호를 입력하세요");
				System.out.print(">>>");
				String pw = scan.nextLine();

				MemberVO member = new MemberVO();
				member.setMemerId(id);
				member.setMemerPw(pw);

				MemberVO login = memberService.login(member);
				if (login.getMemerName() != null) {
					// 로그인 성공
					inner:while (true) {
						System.out.println(login.getMemerName() + "님 환영합니다");
						System.out.println("1. 데이터 검색 | 2. 데이터 추가 | 3. 전체 데이터 확인 | 4. 종료 ");
						System.out.println(">>>");
						int comm_inner = Integer.parseInt(scan.nextLine());

						if (comm_inner == 1) {
							// TODO 데이터검색
							System.out.println(
									"1. 객체 번호 최근 기록  | 2. 객체 번호 전체 데이터 | 3. 연령별 평균 데이터 조회 | 4. 성별 평균 데이터 조회 | 5. 이전으로");
							System.out.print(">>>");
							int comm_inner_spider = Integer.parseInt(scan.nextLine());
							if (comm_inner_spider == 1) {
								// 객체별 세부 데이터 조회
								System.out.println("객체 번호를 입력해주세요");
								System.out.print(">>>");
								String spiderName = scan.nextLine();
								dateService.lastData(spiderName);
								
							}else if (comm_inner_spider == 2) {
								// 객체별 세부 데이터 조회
								System.out.println("객체 번호를 입력해주세요");
								System.out.print(">>>");
								String spiderName = scan.nextLine();
								dateService.choiceDate(spiderName);
							}
							

							

						} else if (comm_inner == 2) {
							// TODO 데이터 추가

						} else if (comm_inner == 3) {
							// 거미 데이터 출력
							mainService.search();

						}else if(comm_inner == 4) {
							break outer;
						}else {
							System.out.println("다시 입력해주세요");
							continue inner;
						}
					}

				}

			} else if (comm == 2) {
				// TODO 회원가입
				System.out.print("아이디 : ");
				String id = scan.nextLine();

				System.out.print("비밀번호 : ");
				String pw = scan.nextLine();

				System.out.print("이름 : ");
				String name = scan.nextLine();

				MemberVO mem = new MemberVO(id, pw, name);
				memberService.registStudent(mem);
			} else if (comm == 3) {
				// 종료
				break outer;

			} else {
				// 입력 벗어남
				System.out.println("1번과 2번만 입력해주세요");
				continue outer;
			}

		}

	}

}
