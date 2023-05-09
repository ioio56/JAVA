package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
	public SpiderDataVO lastData(Connection conn ,String data) throws SQLException {
		
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
		query.append("select spider_number								");
		query.append(", RANK() OVER (ORDER BY record_date DESC) as RANK   		");
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
		query.append("WHERE spider_number = ?						");
		query.append("	)											");
		query.append("WHERE 1=1										");
		query.append("AND rank = 1									");

		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		ps.setString(1, data);
		
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
	
	public ArrayList<SpiderDataVO> age(Connection conn) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT										");
		query.append("	ROUND(avg(WIDTH_MM),2) as WIDTH_MM					");
		query.append("	,ROUND(avg(LENGTH_MM),2) as LENGTH_MM							");
		query.append("	,ROUND(avg(WEIGHT_MG),2) as WEIGHT_MG						");
		query.append("	,age						");
		query.append("from spider_data										");
		query.append("group by age							"); // 세미콜론이 없음에 주의
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
	
		ResultSet rs = ps.executeQuery();
		ArrayList<SpiderDataVO> result = new ArrayList<>();
		
		while (rs.next()) {
			// 쿼리문 실행 결과에 해당하는 컬럼명과 일치해야 함
			double width_mm = rs.getDouble("width_mm");
			double length_mm = rs.getDouble("length_mm");
			double weight_mg = rs.getDouble("weight_mg");
			int age = rs.getInt("age");

			SpiderDataVO SpiderDateList = new SpiderDataVO(null, null, width_mm,length_mm,weight_mg,age, null, null, null, null);
			result.add(SpiderDateList);

		}
		ps.close();
		rs.close();
		System.out.println();
		return result;
	}
	
	public ArrayList<SpiderDataVO> sex(Connection conn) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT													");
		query.append("	ROUND(avg(WIDTH_MM),2) as width_mm				");
		query.append("	,ROUND(avg(LENGTH_MM),2) as length_mm			");
		query.append("	,ROUND(avg(WEIGHT_MG),2) as weight_mg			");
		query.append("	,SPIDER_SEX										");
		query.append("from spider_data										");
		query.append("group by SPIDER_SEX									"); // 세미콜론이 없음에 주의
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
	
		ResultSet rs = ps.executeQuery();
		ArrayList<SpiderDataVO> result = new ArrayList<>();
		
		while (rs.next()) {
			// 쿼리문 실행 결과에 해당하는 컬럼명과 일치해야 함
			double width_mm = rs.getDouble("width_mm");
			double length_mm = rs.getDouble("length_mm");
			double weight_mg = rs.getDouble("weight_mg");
			String sex = rs.getString("SPIDER_SEX");

			SpiderDataVO SpiderDateList = new SpiderDataVO(null, null, width_mm,length_mm,weight_mg,0, null, sex, null, null);
			result.add(SpiderDateList);

		}
		ps.close();
		rs.close();
		System.out.println();
		return result;
	}
	
	
	public int addData(Connection conn, SpiderDataVO data) throws SQLException {

		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO spider_data (	");
		query.append("      spider_number				");
		query.append("    , record_date		");
		query.append("    , width_mm			");
		query.append("    , length_mm			");
		query.append("    , weight_mg			");
		query.append("    , age			");
		query.append("    , grow_level			");
		query.append("    , spider_sex			");
		query.append("    , fulfill			");
		query.append("    , etc			");
		query.append(") VALUES (					");
		query.append("      ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append(")							");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		int idx = 1;
		ps.setString(idx++, data.getSpider_number());
		ps.setDate(idx++, (java.sql.Date) data.getRecord_date());
		ps.setDouble(idx++, data.getWidth_mm());
		ps.setDouble(idx++, data.getLength_mm());
		ps.setDouble(idx++, data.getWeight_mg());
		ps.setDouble(idx++, data.getAge());
		ps.setString(idx++, data.getGrow_level());
		ps.setString(idx++, data.getSpider_sex());
		ps.setString(idx++, data.getFulfill());
		ps.setString(idx++, data.getEtc());

		int cnt = ps.executeUpdate();
		ps.close();

		return cnt;

	}
	
	
	
	
	
}
