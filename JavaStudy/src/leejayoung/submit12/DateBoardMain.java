package leejayoung.submit12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
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
		System.out.println("\n=============3====================\n");
		// TODO 코드작성 시작 ~!!

		Collections.sort(dbList, new Comparator<DateBoard>(){
			int result = 1;
			@Override
			public int compare(DateBoard dbA, DateBoard dbB) {
				// TODO Auto-generated method stub
				try {
					Date left = sdf.parse(dbA.getDate());
					Date right = sdf.parse(dbB.getDate());
					if(left.getTime() - right.getTime() < 0) {
						result = -1;
					}
				}catch (ParseException e) {
					e.printStackTrace();
				}				
				return 0;
			}			
		});
		System.out.println("날짜별로 정렬 후 출력(최신순)");
		for (int i = 0; i < dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}
		// 버블정렬
		System.out.println("\n=============3-2====================\n");
		for (int i = 0; i < dbList.size(); i++) {
			for (int j = 0; j < dbList.size(); j++) {
				Date oneDate = sdf.parse(dbList.get(i).getDate());
				Date twoDate = sdf.parse(dbList.get(j).getDate());

				if (oneDate.getTime() > twoDate.getTime()) {
					DateBoard temp = dbList.get(j);
					dbList.set(j, dbList.get(i));
					dbList.set(i, temp);
				}
			}
		}
		System.out.println("날짜별로 정렬 후 출력(오래된 순)");
		for (int i = 0; i < dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}
		System.out.println("\n=============4====================\n");
		Date today = new Date();
//
//		for (int i = 0; i < dbList.size(); i++) {
//			Date oneDate = sdf.parse(dbList.get(i).getDate());
//			long diffMillSec = today.getTime() - oneDate.getTime();
//			long diff = diffMillSec / (1000 * 60 * 60 * 24);
//			if (diff < 30) {
//				System.out.println(dbList.get(i));
//
//			}
//
//		}

		Calendar cal = Calendar.getInstance();
		// 한달전 날짜로 세팅
		cal.add(Calendar.MONTH, -1);
//		cal.add(Calendar.DATE, -30);
		
		for(int i = 0; i<dbList.size(); i++) {
			Date temp = sdf.parse(dbList.get(i).getDate());
			// temp를 밀리초로 나타낸것이
			// 한달전 날짜를 밀리초로 나타낸 것보다 크면
			// 최근 한달 내 데이터를 의미한다.
			if(temp.getTime() > cal.getTime().getTime()) {
				System.out.println(dbList.get(i));
			}
			
		}
		
		
		System.out.println("\n=============5====================\n");

		SimpleDateFormat asc = new SimpleDateFormat("yyyyMM");

		String dday1 = asc.format(today);

		for (int i = 0; i < dbList.size(); i++) {
			Date oneDate = sdf.parse(dbList.get(i).getDate());
			String dday2 = asc.format(oneDate);

			if (dday1.equals(dday2)) {

				System.out.println(dbList.get(i));
			}

		}
		System.out.println("\n=============6====================\n");
		asc = new SimpleDateFormat("MM");
		
		for (int i = 0; i < dbList.size(); i++) {
			Date oneDate = sdf.parse(dbList.get(i).getDate());
			String dday2 = asc.format(oneDate);

			if (dday2.equals("02")) {
				System.out.println(dbList.get(i));
			}
		}
		System.out.println("\n=============7====================\n");
		asc = new SimpleDateFormat("yyyyMMdd");
		
		for (int i = 0; i < dbList.size(); i++) {
			Date oneDate = sdf.parse(dbList.get(i).getDate());
			String dday2 = asc.format(oneDate);
			int num =Integer.parseInt(dday2);
			if (20220214<=num && num<=20220321) {
				System.out.println(dbList.get(i));
			}
		}

	}

}
