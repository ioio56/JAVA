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

	public SpiderDataVO lastData(SpiderDataVO data) {
		Connection conn = cp.getConnection();
		SpiderDataVO result = new SpiderDataVO();
		try {
			result = dao.lastData(conn, data);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		return result;
	}

	// 객체 이름으로 선택후 데이터 출력
	public void choiceDate(String name) {
		SpiderDataService dateService = SpiderDataService.getInstance();
		ArrayList<SpiderDataVO> dataList = dateService.getSpiderDateList();
		for (int i = 0; i < dataList.size(); i++) {
			if (dataList.get(i).getSpider_number().equals(name)) {
				System.out.println(dataList.get(i));
			} else {
				System.out.println("일치하는 데이터가 없습니다.");
			}
		}
	}

	public ArrayList<SpiderDataVO> age() {
		Connection conn = cp.getConnection();
		ArrayList<SpiderDataVO> result = new ArrayList<>();
		try {
			result = dao.age(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		return result;
	}

	public ArrayList<SpiderDataVO> sex() {
		Connection conn = cp.getConnection();
		ArrayList<SpiderDataVO> result = new ArrayList<>();
		try {
			result = dao.sex(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		return result;
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
				System.out.println("객체 번호 : " + spiderDataList.get(i).getSpider_number() + " / " + "작성 날짜 : " + spiderDataList.get(i).getRecord_date()
						+ " / " + "가로 : " + spiderDataList.get(i).getWidth_mm() + " / " + "세로 : " + spiderDataList.get(i).getLength_mm()
						+ " / " + "무게 : " + spiderDataList.get(i).getWeight_mg()+ " / " + "나이 : " + spiderDataList.get(i).getAge()+ " / " + "성장 단계 : " + spiderDataList.get(i).getGrow_level()
						+ " / " + "성별 : " + spiderDataList.get(i).getSpider_sex()+ " / " + "세로 : " + spiderDataList.get(i).getLength_mm());
			count++;
			}
		}
		if(count <= 0) {
			System.out.println("일치하는 데이터가 없습니다.");
		}
	}
}
