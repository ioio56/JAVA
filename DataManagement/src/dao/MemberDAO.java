package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import vo.MemberVO;


public class MemberDAO {
	
	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}
	// 회원가입
	public int registStudent(Connection conn, MemberVO member) throws SQLException {

		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO member_spider (	");
		query.append("      member_id				");
		query.append("    , memeber_pw		");
		query.append("    , member_name			");
		query.append(") VALUES (					");
		query.append("      ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append(")							");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		int idx = 1;
		ps.setString(idx++, member.getMemerId());
		ps.setString(idx++, member.getMemerPw());
		ps.setString(idx++, member.getMemerName());

		int cnt = ps.executeUpdate();
		ps.close();

		return cnt;

	}
	// 로그인
	public MemberVO login(Connection conn, MemberVO member) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT						");
		query.append("		member_id				");
		query.append("	, memeber_pw			");
		query.append("	, member_name				");
		query.append("FROM						");
		query.append("	member_spider				");
		query.append("WHERE 1=1					");
		query.append("	AND member_id =?			");
		query.append("	AND memeber_pw =?	");

		PreparedStatement ps = conn.prepareStatement(query.toString());
		int idx = 1;
		
		ps.setString(idx++, member.getMemerId());
		ps.setString(idx++, member.getMemerPw());

		ResultSet rs = ps.executeQuery();

		MemberVO result = new MemberVO();
		
		// rs에 데이터가 1개 담여있으면 while 문 한번만 실행된다.
		while (rs.next()) {
			result.setMemerId(rs.getString("member_id"));
			result.setMemerPw(rs.getString("memeber_pw"));
			result.setMemerName(rs.getString("member_name"));
		}

		rs.close();
		ps.close();

		return result;
	}
	public ArrayList<MemberVO> getMemList(Connection conn) throws SQLException {
		// 3. 쿼리문 작성
		StringBuffer query = new StringBuffer();
		query.append("SELECT								");
		query.append("		member_id						");
		query.append("	, memeber_pw						");
		query.append("FROM								");
		query.append("	member_spider							"); // 세미콜론이 없음에 주의

		// 4. 쿼리문을 보유하고 실행 할 수 있는 객체 생성
		// 객체 (PreparedStatement) 생성

		PreparedStatement ps = conn.prepareStatement(query.toString());

		// 5. 쿼리문 실행
		// SELECT문의 경우 executeQuery()
		// 실행결과를 ResultSet에 담는다.
		ResultSet rs = ps.executeQuery();
		ArrayList<MemberVO> result = new ArrayList<>();
		// 6. ResultSet에 담긴 데이터 조회
		while (rs.next()) {
			// 쿼리문 실행 결과에 해당하는 컬럼명과 일치해야 함
			String memId = rs.getString("member_id");
			String memPw = rs.getString("memeber_pw"); // as로 컬럼명 수정시 컬럼명에 맞춰줘야한다.

			MemberVO member = new MemberVO(memId, memPw, null);
			result.add(member);

		}
		ps.close();
		rs.close();
		return result;
	}
}
