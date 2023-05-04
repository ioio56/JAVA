package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import vo.SpiderDataVO;

public class SpiderDataDAO {

	private SpiderDataDAO() {
	}

	private static SpiderDataDAO instance = new SpiderDataDAO();

	public static SpiderDataDAO getInstance() {
		return instance;
	}
	// 객체 번호를 통해 기존 데이터 조회
	public ArrayList<SpiderDataVO> getSpiderDateList(Connection conn) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT										");
		query.append("		spider_number						");
		query.append("	, record_date							");
		query.append("	, width_mm								");
		query.append("	, length_mm							");
		query.append("	, weight_mg							");
		query.append("	, age									");
		query.append("	, grow_level							");
		query.append("	, spider_sex							");
		query.append("	, fulfill								");
		query.append("	, etc									");
		query.append("FROM										");
		query.append("	spider_data								"); // 세미콜론이 없음에 주의
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
	
		ResultSet rs = ps.executeQuery();
		ArrayList<SpiderDataVO> result = new ArrayList<>();
		
		while (rs.next()) {
			// 쿼리문 실행 결과에 해당하는 컬럼명과 일치해야 함
			String spider_number = rs.getString("spider_number");
			Date record_date = rs.getDate("record_date"); // as로 컬럼명 수정시 컬럼명에 맞춰줘야한다.
			double width_mm = rs.getDouble("width_mm");
			double length_mm = rs.getDouble("length_mm");
			double weight_mg = rs.getDouble("weight_mg");
			int age = rs.getInt("age");
			String grow_level = rs.getString("grow_level");
			String spider_sex = rs.getString("spider_sex");
			String fulfill = rs.getString("fulfill");
			String etc = rs.getString("etc");

			SpiderDataVO SpiderDateList = new SpiderDataVO(spider_number, record_date, width_mm,
					length_mm,weight_mg,age,grow_level,spider_sex,fulfill,etc);
			result.add(SpiderDateList);

		}
		ps.close();
		rs.close();
		System.out.println();
		return result;
	}
	public SpiderDataVO lastData(Connection conn ,SpiderDataVO date) throws SQLException {
		
		StringBuffer query = new StringBuffer();
		query.append("select 										");
		query.append("	 spider_number							");
		query.append("	, record_date								");
		query.append("	, width_mm									");
		query.append("	, length_mm								");
		query.append("	, weight_mg								");
		query.append("	, age										");
		query.append("	, grow_level								");
		query.append("	, spider_sex								");
		query.append("	, fulfill									");
		query.append("	, etc										");
		query.append("FROM (											");
		query.append("	, spider_number							");
		query.append("	, record_date								");
		query.append("	, width_mm									");
		query.append("	, length_mm								");
		query.append("	, weight_mg								");
		query.append("	, age										");
		query.append("	, grow_level								");
		query.append("	, spider_sex								");
		query.append("	, fulfill									");
		query.append("	, etc										");
		query.append("FROM 											");
		query.append("	spider_data								");
		query.append("	)											");
		query.append("WHERE 1=1										");
		query.append("AND rank = 1									");
		query.append("AND spider_number = ?						");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		ps.setString(1, date.getSpider_number());
		
		ResultSet rs = ps.executeQuery();
		
		SpiderDataVO result = new SpiderDataVO();
		
		while (rs.next()) {
			// 쿼리문 실행 결과에 해당하는 컬럼명과 일치해야 함
			result.setSpider_number(rs.getString("spider_number"));
			result.setRecord_date(rs.getDate("record_date"));
			result.setWidth_mm(rs.getInt("width_mm"));
			result.setLength_mm(rs.getInt("length_mm"));
			result.setWeight_mg(rs.getInt("weight_mg"));
			result.setAge(rs.getInt("age"));
			result.setGrow_level(rs.getString("grow_level"));
			result.setSpider_sex(rs.getString("spider_sex"));
			result.setFulfill(rs.getString("fulfill"));
			result.setEtc(rs.getString("etc"));
		}
		ps.close();
		rs.close();
		System.out.println();
		return result;
	}
	
	
	
	
}
