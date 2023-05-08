package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
					System.out.println(login.getMemerName() + "님 환영합니다");
					inner: while (true) {

						System.out.println("1. 데이터 검색 | 2. 데이터 추가 | 3. 전체 데이터 확인 | 4. 종료 ");
						System.out.print(">>>");

						int comm_inner = Integer.parseInt(scan.nextLine());

						if (comm_inner == 1) {
							inner_inner: while (true) {
								// TODO 데이터검색
								System.out.println("1. 객체 번호 최근 기록  | 2. 객체 번호 전체 데이터 | "
										+ "3. 연령별 평균 데이터 조회 | 4. 성별 평균 데이터 조회 | 5. 이전으로");
								System.out.print(">>>");
								int comm_inner_spider = Integer.parseInt(scan.nextLine());
								if (comm_inner_spider == 1) {
									// 객체별 세부 데이터 조회
									System.out.println("객체 번호를 입력해주세요");
									System.out.print(">>>");
									String spiderName = scan.nextLine();
									dateService.spiderDataSearch(spiderName);

								} else if (comm_inner_spider == 2) {
									// 객체별 세부 데이터 조회
									System.out.println("객체 번호를 입력해주세요");
									System.out.print(">>>");
									String spiderName = scan.nextLine();
									dateService.choiceDate(spiderName);

								} else if (comm_inner_spider == 3) {
									// 연령별 평균 데이터 조회
									if (dateService.age() != null) {
										System.out.println(dateService.age());
									} else {
										System.out.println("입력하신 객체는 존재하지 않습니다");
									}

								} else if (comm_inner_spider == 4) {
									// 성별 평균 데이터 조회
									if (dateService.sex() != null) {
										System.out.println(dateService.sex());
									} else {
										System.out.println("입력하신 객체는 존재하지 않습니다");
									}
								} else if (comm_inner_spider == 5) {
									// 이전으로
									continue inner;

								} else {
									continue inner_inner;
								}
							}
						} else if (comm_inner == 2) {
							// TODO 데이터 추가
							System.out.println("1. 객체 추가 | 2. 데이터 추가");
							System.out.print(">>>");
							int add = Integer.parseInt(scan.nextLine());

							if (add == 1) {
								data: while (true) {
									SpiderMainVO spiderMain = new SpiderMainVO();
									System.out.print("객체 번호: ");
									String number = scan.nextLine();

									ArrayList<SpiderMainVO> dataList = mainService.getSpiderMainList();
									for (int i = 0; i < dataList.size(); i++) {
										if (dataList.get(i).getSpider_number().equals(number)) {
											System.out.println("일치하는 객체가 있습니다.");
											continue data;
										}
									}
									System.out.print("객체 이름: ");
									String name = scan.nextLine();

									System.out.print("채집 장소: ");
									String place = scan.nextLine();

									System.out.print("채집 날짜 (입력형식: YYYY/MM/DD): ");
									String date_input = scan.nextLine();
									SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

									Date date;
									try {
										date = simpleDateFormat.parse(date_input);
										long timeInMilliSeconds = date.getTime();
										java.sql.Date sqlDate = new java.sql.Date(timeInMilliSeconds);

										System.out.print("관리자 이름: ");
										String responsibilty = scan.nextLine();

										spiderMain = new SpiderMainVO(number, name, place, sqlDate, responsibilty);
										mainService.mainAdd(spiderMain);

									} catch (ParseException e) {
										System.out.println("날짜 형식이 맞지 않습니다.");
									}
									break;
								}

							} else if (add == 2) {
								System.out.print("객체 번호: ");
								String number = scan.nextLine();

								System.out.print("기록 날짜: ");
								String recordDate = scan.nextLine();

								SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
								Date date;
								try {
									date = simpleDateFormat.parse(recordDate);

									long timeInMilliSeconds = date.getTime();
									java.sql.Date sqlDate = new java.sql.Date(timeInMilliSeconds);

									System.out.print("가로: ");
									double width = scan.nextDouble();

									System.out.print("세로: ");
									double length = scan.nextDouble();

									System.out.print("무게: ");
									double weight = scan.nextDouble();

									System.out.print("나이: ");
									int age = scan.nextInt();

									System.out.println("성장 단계: ");
									String level = scan.nextLine();

									System.out.print("성별: ");
									String sex = scan.nextLine();

									System.out.print("수행항목: ");
									String fulfill = scan.nextLine();

									System.out.print("기타내용: ");
									String etc = scan.nextLine();

									SpiderDataVO spiderdata = new SpiderDataVO(number, sqlDate, width, length, weight,
											age, level, sex, fulfill, etc);
									dateService.addData(spiderdata);
								} catch (ParseException e) {
									e.printStackTrace();
								}

							}

						} else if (comm_inner == 3) {
							// 거미 데이터 출력
							mainService.search();

						} else if (comm_inner == 4) {
							continue outer;
						} else {
							System.out.println("다시 입력해주세요");
							continue inner;
						}
					}

				} else {
					System.out.println("없는 아이디 비밀번호입니다.");
				}

			} else if (comm == 2) {
				// TODO 회원가입
				MemberVO mem = new MemberVO();
				String id;
				ArrayList<MemberVO> memList = memberService.getMemList();
				id: while (true) {
					System.out.print("아이디 : ");
					id = scan.nextLine();

					for (int i = 0; i < memList.size(); i++) {
						if (memList.get(i).getMemerId().equals(id)) {
							System.out.println("아이디가 일치합니다.");
							continue id;
						}
					}
					System.out.print("비밀번호 : ");
					String pw = scan.nextLine();

					System.out.print("이름 : ");
					String name = scan.nextLine();

					mem = new MemberVO(id, pw, name);
					memberService.registMember(mem);
					break id;
				}

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
