package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import context.ConnectionPool;
import dao.SpiderMainDAO;
import vo.MemberVO;
import vo.SpiderMainVO;

public class SpiderMainService {
	private SpiderMainService() {
	}

	private static SpiderMainService instance = new SpiderMainService();

	public static SpiderMainService getInstance() {
		return instance;
	}

	private SpiderMainDAO dao = SpiderMainDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();

	// 목록 조회(SELECT) 메소드
	public ArrayList<SpiderMainVO> getSpiderMainList() {
		Connection conn = cp.getConnection();
		ArrayList<SpiderMainVO> result = new ArrayList<>();
		try {
			result = dao.getSpiderMainList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
		return result;
	}

	public void search() {
		SpiderMainService spiderService = SpiderMainService.getInstance();
		ArrayList<SpiderMainVO> spiderList = spiderService.getSpiderMainList();

		// 거미 객체 데이터 조회
		for (int i = 0; i < spiderList.size(); i++) {
			System.out.println("객체 번호 : "+spiderList.get(i).getSpider_number() + " / "+ "채집 장소 : " + spiderList.get(i).getSpider_place()
					+" / " + "채집 날짜 : " + spiderList.get(i).getSpider_date()+" / " + "관리자 : " + spiderList.get(i).getResponsibility());
		}
	}


	public void mainAdd(SpiderMainVO main) {
		Connection conn = cp.getConnection();

		try {
			dao.addMain(conn, main);
			System.out.println("성공적으로 입력됐습니다.");
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			cp.releaseConnection(conn);
		}

	}
}
