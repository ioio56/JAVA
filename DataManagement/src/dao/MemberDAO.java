package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
