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
			String comm = scan.nextLine();

			if (comm.equals("1")) {
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

						String comm_inner = scan.nextLine();

						if (comm_inner.equals("1")) {
							inner_inner: while (true) {
								// TODO 데이터검색
								System.out.println("1. 객체 번호 최근 기록  | 2. 객체 번호 전체 데이터 | "
										+ "3. 연령별 평균 데이터 조회 | 4. 성별 평균 데이터 조회 | 5. 이전으로");
								System.out.print(">>>");
								String comm_inner_spider = scan.nextLine();
								if (comm_inner_spider.equals("1")) {
									// 객체별 최근 기록
									System.out.println("객체 번호를 입력해주세요");
									System.out.print(">>>");
									String spiderName = scan.nextLine();
									dateService.lastData(spiderName);

								} else if (comm_inner_spider.equals("2")) {
									// 객체별 세부 데이터 조회
									System.out.println("객체 번호를 입력해주세요");
									System.out.print(">>>");
									String spiderName = scan.nextLine();
									dateService.choiceDate(spiderName);

								} else if (comm_inner_spider.equals("3")) {
									// 연령별 평균 데이터 조회
									dateService.age();

								} else if (comm_inner_spider.equals("4")) {
									// 성별 평균 데이터 조회
									dateService.sex();

								} else if (comm_inner_spider.equals("5")) {
									// 이전으로

									continue inner;

								} else {
									System.out.println("다시입력해주세요");
									continue inner_inner;
								}
							}
						} else if (comm_inner.equals("2")) {
							// TODO 데이터 추가
							System.out.println("1. 객체 추가 | 2. 데이터 추가");
							System.out.print(">>>");
							String add = scan.nextLine();

							if (add.equals("1")) {
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

										spiderMain = new SpiderMainVO(number, name, place, sqlDate,
												login.getMemerName());
										mainService.mainAdd(spiderMain);

									} catch (ParseException e) {
										System.out.println("날짜 형식이 맞지 않습니다.");
									}
									break;
								}

							} else if (add.equals("2")) {
								System.out.print("객체 번호: ");
								String number = scan.nextLine();

								System.out.print("기록 날짜: ");
								String recordDate = scan.nextLine();
								
								System.out.print("성별: ");
								String sex = scan.nextLine();

								System.out.print("수행항목: ");
								String fulfill = scan.nextLine();

								System.out.print("기타내용: ");
								String etc = scan.nextLine();
								
								System.out.print("성장 단계: ");
								String levele = scan.nextLine();

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

									SpiderDataVO spiderdata = new SpiderDataVO(number, sqlDate, width, 
											length, weight, age, levele, sex, fulfill, etc);
									dateService.addData(spiderdata);
								} catch (ParseException e) {
									e.printStackTrace();
								}

							}

						} else if (comm_inner.equals("3")) {
							// 거미 데이터 출력
							mainService.search();

						} else if (comm_inner.equals("4")) {
							continue outer;
						} else {
							System.out.println("다시 입력해주세요");
							continue inner;
						}
					}

				} else {
					System.out.println("없는 아이디 비밀번호입니다.");
				}

			} else if (comm.equals("2")) {
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

			} else if (comm.equals("3")) {
				// 종료
				break outer;

			} else {
				// 입력 벗어남
				System.out.println("다시입력해주세요");
				continue outer;
			}
		}

	}

}
