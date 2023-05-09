package leejayoung.Mbti;

import java.util.ArrayList;
import java.util.Scanner;


public class MbtiMain {

	public static void main(String[] args) {
		StudentService studService = StudentService.getInstance();

		MbtiService mbtiservice = MbtiService.getInstance();

		ArrayList<String> mbtiList = new ArrayList<>();

		Scanner scan = new Scanner(System.in);
		while (true) {

			System.out.println("Choice");
			System.out.println("1.가입 | 2.login | 3. 종료");
			System.out.print(">>> ");
			int command = 0;
			command = Integer.parseInt(scan.nextLine());
			if (command == 1) {
				System.out.println("아이디를 입력해주세요.");
				String id = scan.nextLine();
				System.out.println("비밀번호를 입력해주세요.");
				String pw = scan.nextLine();
				System.out.println("이름을 입력해주세요.");
				String name = scan.nextLine();

				StudentVO stud = new StudentVO(id, pw, name, "");
				studService.registStudent(stud);
				System.out.println("회원가입이 완료되었습니다.");

				// 로그인
			} else if (command == 2) {
				System.out.println("아이디 :");
				String id = scan.nextLine();
				System.out.println("비밀번호 :");
				String pw = scan.nextLine();

				StudentVO student = new StudentVO(id, pw, "", "");
				student.setId(id);
				student.setPassWord(pw);

				StudentVO login = studService.login(student);

				if (login.getId() != null) {
					// 로그인 성공
					System.out.println(login.getName() + "님 환영합니다.");

					while (true) {
						System.out.println("행동을 선택해주세요");
						System.out.println("1. 나의 정체성은?? | 2. 조회 | 3. 종료 ");
						System.out.print(">>> ");

						int select = Integer.parseInt(scan.nextLine());

						if (select == 1) {
						    System.out.println("MBTI의 세계에 오신걸 환영합니다 ");
						    System.out.println("간단한 설문을 통해 자신의 성향에 대해서 파악할수있습니다.");
						    System.out.println("위 검사는 요약본이기 때문에 보다 정확한 테스트는 각자 알아서 하시기 바랍니다.");
						    System.out.println("그러면 테스트 시작하겠습니다.");
						    
						    mbtiservice.MbtiVOie();
						    String strie;
						    int ie = Integer.parseInt(scan.nextLine());
						    if (ie == 1) {
						        strie = "E";
						    } else {
						    	strie = "I";
						    }
						    
						    mbtiservice.MbtiVOsn();
						    String strsn;
						    int sn = Integer.parseInt(scan.nextLine());
						    if (sn == 1) {
						        strsn = "S";
						    } else {
						    	strsn = "N";
						    }

						    mbtiservice.MbtiVOft();
						    String strft;
						    int ft = Integer.parseInt(scan.nextLine());
						    if (ft == 1) {
						        strft = "F";
						    } else {
						    	strft = "T";
						    }
						    
						    mbtiservice.MbtiVOpj();
						    String strpj;
						    int pj = Integer.parseInt(scan.nextLine());
						    if (pj == 1) {
						        strpj = "P";
						    } else {
						    	strpj = "J";
						    }
						    
						    
						} else if (select == 2) {
						    // do something else
						} else if (select == 3) {
						    break;
						} 
					}
				}
			}
		}
	}
}