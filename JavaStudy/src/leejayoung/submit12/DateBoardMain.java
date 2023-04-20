package leejayoung.submit12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateBoardMain {

	public static void main(String[] args) throws ParseException {
		// dbList에 랜덤 날짜를 가지는 DateBoard 객체 100개 삽입
		ArrayList<DateBoard> dbList = new ArrayList<DateBoard>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

		for (int i = 0; i < 100; i++) {
			int randDay = (int) (Math.random() * 365) + 1; // 1~365
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, randDay * -1);

			String strDate = sdf.format(cal.getTime());
			// System.out.println("strDate: "+ strDate);//strDate: 2022.08.21 18:15:43
			dbList.add(new DateBoard((i + 1) + "번째 생성된 글", strDate));
		}

		for (int i = 0; i < dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}
		System.out.println("\n=================================\n");
		// TODO 코드작성 시작 ~!!

		for (int i = 0; i < dbList.size(); i++) {
			for (int j = i + 1; j < dbList.size(); j++) {
				Date oneDate = sdf.parse(dbList.get(i).getDate());
				Date twoDate = sdf.parse(dbList.get(j).getDate());

				if (oneDate.getTime() < twoDate.getTime()) {
					System.out.println(oneDate.getTime());
					System.out.println(twoDate.getTime());
				}else {	
//					ArrayList<String> arr = new ArrayList<DateBoard>();
//					dbList.get(i)arr.add();
				}
			}
//		}System.out.println(arr);

//		for (int i = 0; i < dbList.size(); i++) {
//			System.out.print(dbList.get(i));
//			if (i + 1 != dbList.size()) {
//				System.out.print(", ");
//			}
		}
	}
		
}
