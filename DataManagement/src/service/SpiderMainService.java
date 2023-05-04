package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import context.ConnectionPool;
import dao.SpiderMainDAO;
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
			System.out.println(spiderList.get(i).getSpider_number());
		}
	}
}
