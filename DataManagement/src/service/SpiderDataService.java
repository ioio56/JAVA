package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import context.ConnectionPool;
import dao.SpiderDataDAO;
import vo.MemberVO;
import vo.SpiderDataVO;
import vo.SpiderMainVO;

public class SpiderDataService {

	private SpiderDataService() {
	}

	private static SpiderDataService instance = new SpiderDataService();

	public static SpiderDataService getInstance() {
		return instance;
	}

	private SpiderDataDAO dao = SpiderDataDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();

	// 목록 조회(SELECT) 메소드
	public ArrayList<SpiderDataVO> getSpiderDateList() {
		Connection conn = cp.getConnection();
		ArrayList<SpiderDataVO> result = new ArrayList<>();
		try {
			result = dao.getSpiderDateList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		return result;
	}

//	public SpiderDataVO lastData(SpiderDataVO data) {
//		Connection conn = cp.getConnection();
//		SpiderDataVO result = new SpiderDataVO();
//		try {
//			result = dao.lastData(conn, data);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			cp.releaseConnection(conn);
//		}
//		return result;
//	}
	public void lastData(String data) {
		Connection conn = cp.getConnection();
		SpiderDataVO result;
		try {
			result = dao.lastData(conn, data);
				System.out.println("객체 번호 : " + result.getSpider_number() + " / " + "작성 날짜 : "
						+ result.getRecord_date() + " / " + "가로 : " + result.getWidth_mm() + " / "
						+ "세로 : " + result.getLength_mm() + " / " + "무게 : " + result.getWeight_mg()
						+ " / " + "나이 : " + result.getAge() + " / " + "성장 단계 : " + result.getGrow_level()
						+ " / " + "성별 : " + result.getSpider_sex() + " / " + "기타 : "
						+ result.getEtc());
		} catch (SQLException e) {
			System.out.println("오류");
		}
		
	}

	// 객체 이름으로 선택후 데이터 출력
	public void choiceDate(String name) {
		SpiderDataService dateService = SpiderDataService.getInstance();
		ArrayList<SpiderDataVO> dataList = dateService.getSpiderDateList();
		int count = 0;
		for (int i = 0; i < dataList.size(); i++) {
			if (dataList.get(i).getSpider_number().equals(name)) {
				System.out.println("객체 번호 : " + dataList.get(i).getSpider_number() + " / " + "작성 날짜 : "
						+ dataList.get(i).getRecord_date() + " / " + "가로 : " + dataList.get(i).getWidth_mm() + " / "
						+ "세로 : " + dataList.get(i).getLength_mm() + " / " + "무게 : " + dataList.get(i).getWeight_mg()
						+ " / " + "나이 : " + dataList.get(i).getAge() + " / " + "성장 단계 : "
						+ dataList.get(i).getGrow_level() + " / " + "성별 : " + dataList.get(i).getSpider_sex() + " / "
						+ "기타 : "+ dataList.get(i).getEtc());
				count++;
			}
		}
		if (count == 0) {
			System.out.println("일치하는 데이터가 없습니다");
		}
	}

	public void age() {
		Connection conn = cp.getConnection();
		ArrayList<SpiderDataVO> age;
		try {
			age = dao.age(conn);
			for (int i = 0; i < age.size(); i++) {
				System.out.println("나이 : " + age.get(i).getAge() + " / " + "가로 : " + age.get(i).getWidth_mm() + " / "
						+ "세로 : " + age.get(i).getLength_mm() + " / " + "무게 : " + age.get(i).getWeight_mg());
			}
		} catch (SQLException e) {
			System.out.println("일치하는 데이터가 없습니다.");
		}
	}

	public void sex() {
		Connection conn = cp.getConnection();
		ArrayList<SpiderDataVO> sex;
		try {
			sex = dao.sex(conn);
			for (int i = 0; i < sex.size(); i++) {
				System.out.println("성별 : " + sex.get(i).getSpider_sex() + " / " + "가로 : " + sex.get(i).getWidth_mm()
						+ " / " + "세로 : " + sex.get(i).getLength_mm() + " / " + "무게 : " + sex.get(i).getWeight_mg());
			}
		} catch (SQLException e) {
			System.out.println("일치하는 데이터가 없습니다.");
		}
	}

	public void addData(SpiderDataVO data) {
		Connection conn = cp.getConnection();

		try {
			dao.addData(conn, data);
			System.out.println("입력이 성공적으로 됐습니.");
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			cp.releaseConnection(conn);
		}

	}

	public void spiderDataSearch(String number) {
		SpiderDataService spiderData = SpiderDataService.getInstance();
		ArrayList<SpiderDataVO> spiderDataList = spiderData.getSpiderDateList();

		// 거미 객체 데이터 조회
		int count = 0;
		for (int i = 0; i < spiderDataList.size(); i++) {
			if (spiderDataList.get(i).getSpider_number().equals(number)) {
				System.out.println("객체 번호 : " + spiderDataList.get(i).getSpider_number() + " / " + "작성 날짜 : "
						+ spiderDataList.get(i).getRecord_date() + " / " + "가로 : " + spiderDataList.get(i).getWidth_mm()
						+ " / " + "세로 : " + spiderDataList.get(i).getLength_mm() + " / " + "무게 : "
						+ spiderDataList.get(i).getWeight_mg() + " / " + "나이 : " + spiderDataList.get(i).getAge()
						+ " / " + "성장 단계 : " + spiderDataList.get(i).getGrow_level() + " / " + "성별 : "
						+ spiderDataList.get(i).getSpider_sex() + " / " + "기타 : "
						+ spiderDataList.get(i).getEtc());
				count++;
			}
		}
		if (count <= 0) {
			System.out.println("일치하는 데이터가 없습니다.");
		}
	}
}
