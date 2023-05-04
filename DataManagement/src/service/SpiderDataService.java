package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import context.ConnectionPool;
import dao.SpiderDataDAO;
import vo.MemberVO;
import vo.SpiderDataVO;

public class SpiderDataService {
	private SpiderDataService() {
	}

	private static SpiderDataService instance = new SpiderDataService();

	public static SpiderDataService getInstance() {
		return instance;
	}
	private SpiderDataDAO dao = SpiderDataDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();

	//목록 조회(SELECT) 메소드
	public ArrayList<SpiderDataVO> getSpiderDateList(){
		Connection conn = cp.getConnection();
		ArrayList<SpiderDataVO> result = new ArrayList<>();
		try {
			result = dao.getSpiderDateList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	public SpiderDataVO lastData(SpiderDataVO data){
		Connection conn = cp.getConnection();
		SpiderDataVO result = new SpiderDataVO();
		try {
			result = dao.lastData(conn, data);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	
	// 객체 이름으로 선택후 데이터 출력
	public void choiceDate(String name) {
		SpiderDataService dateService = SpiderDataService.getInstance();
		ArrayList<SpiderDataVO> dateList = dateService.getSpiderDateList();
		for (int i = 0; i < dateList.size(); i++) {
			if (dateList.get(i).getSpider_number().equals(name)) {
				System.out.println(dateList.get(i));
			}
		}
	}


}
