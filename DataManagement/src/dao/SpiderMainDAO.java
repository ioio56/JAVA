package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import vo.SpiderDataVO;
import vo.SpiderMainVO;

public class SpiderMainDAO {
	private SpiderMainDAO() {
	}

	private static SpiderMainDAO instance = new SpiderMainDAO();

	public static SpiderMainDAO getInstance() {
		return instance;
	}
	// 객체 번호를 통해 기존 데이터 조회
	public ArrayList<SpiderMainVO> getSpiderMainList(Connection conn) throws SQLException{
		StringBuffer query = new StringBuffer();
		query.append("SELECT								");
		query.append("		spider_number						");
		query.append("	, spider_name			");
		query.append("	, spider_place						");
		query.append("	, spider_date					");
		query.append("	, responsibility					");
		query.append("FROM								");
		query.append("	spider_main						"); // 세미콜론이 없음에 주의
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
	
		ResultSet rs = ps.executeQuery();
		ArrayList<SpiderMainVO> result = new ArrayList<>();
		
		while (rs.next()) {
			// 쿼리문 실행 결과에 해당하는 컬럼명과 일치해야 함
			String spider_number = rs.getString("spider_number");
			String spider_name = rs.getString("spider_name"); // as로 컬럼명 수정시 컬럼명에 맞춰줘야한다.
			String spider_place = rs.getString("spider_place");
			Date spider_date = rs.getDate("spider_date");
			String responsibility = rs.getString("responsibility");

			SpiderMainVO SpiderMainLinst = new SpiderMainVO(spider_number, spider_name, spider_place,
					spider_date,responsibility);
			result.add(SpiderMainLinst);

		}
		ps.close();
		rs.close();
		return result;
	}
	
	public int addMain(Connection conn, SpiderMainVO main) throws SQLException {

		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO spider_main (	");
		query.append("      spider_number				");
		query.append("    , spider_name		");
		query.append("    , spider_place			");
		query.append("    , spider_date			");
		query.append("    , responsibility			");
		query.append(") VALUES (					");
		query.append("      ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append(")							");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		int idx = 1;
		ps.setString(idx++, main.getSpider_number());
		ps.setString(idx++, main.getSpider_name());
		ps.setString(idx++, main.getSpider_place());
		ps.setDate(idx++,  main.getSpider_date());
		ps.setString(idx++, main.getResponsibility());

		int cnt = ps.executeUpdate();
		ps.close();

		return cnt;

	}
	
}
