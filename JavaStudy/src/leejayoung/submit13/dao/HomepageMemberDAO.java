package leejayoung.submit13.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import leejayoung.submit13.vo.HomepageMemberVO;

public class HomepageMemberDAO {

	private HomepageMemberDAO() {
	}

	private static HomepageMemberDAO instance = new HomepageMemberDAO();

	public static HomepageMemberDAO getInstance() {
		return instance;
	}

	// 회원 조회(SELECT) 메소드
	public ArrayList<HomepageMemberVO> getMemList(Connection conn) throws SQLException {
		// 3. 쿼리문 작성
		StringBuffer query = new StringBuffer();
		query.append("SELECT								");
		query.append("		mem_id						");
		query.append("	, mem_pw						");
		query.append("	, mem_date						");
		query.append("FROM								");
		query.append("	member							"); // 세미콜론이 없음에 주의

		// 4. 쿼리문을 보유하고 실행 할 수 있는 객체 생성
		// 객체 (PreparedStatement) 생성

		PreparedStatement ps = conn.prepareStatement(query.toString());

		// 5. 쿼리문 실행
		// SELECT문의 경우 executeQuery()
		// 실행결과를 ResultSet에 담는다.
		ResultSet rs = ps.executeQuery();
		ArrayList<HomepageMemberVO> result = new ArrayList<>();
		// 6. ResultSet에 담긴 데이터 조회
		while (rs.next()) {
			// 쿼리문 실행 결과에 해당하는 컬럼명과 일치해야 함
			String memId = rs.getString("mem_id");
			String memPw = rs.getString("mem_pw"); // as로 컬럼명 수정시 컬럼명에 맞춰줘야한다.
			Date memDate = rs.getDate("mem_date");

			HomepageMemberVO member = new HomepageMemberVO(memId, memPw, memDate);
			result.add(member);

		}
		ps.close();
		rs.close();
		return result;
	}

	// 회원가입(INSERT)
	public int registMember(Connection conn, HomepageMemberVO member) throws SQLException {
		// 3. 쿼리문 작성
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO member(		");
		query.append("		 mem_id			");
		query.append("		,mem_pw			");
		query.append("		,mem_date			");
		query.append(")VALUES(					");
		query.append("		 ?					");
		query.append("		,?					");
		query.append("		,sysdate			");
		query.append(")							");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		int idx = 1;
		ps.setString(idx++, member.getMemberId());
		ps.setString(idx++, member.getMemberPw());

		int cnt = ps.executeUpdate();
		ps.close();

		return cnt;
	}

	// 회원 로그인 조회
	public HomepageMemberVO login(Connection conn, HomepageMemberVO member) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT						");
		query.append("		mem_id				");
		query.append("	, mem_pw				");
		query.append("	, mem_date				");
		query.append("FROM						");
		query.append("	member					");
		query.append("WHERE 1=1					");
		query.append("	AND mem_id =?			");
		query.append("	AND mem_pw =?			");

		PreparedStatement ps = conn.prepareStatement(query.toString());
		int idx = 1;
		ps.setString(idx++, member.getMemberId());
		ps.setString(idx++, member.getMemberPw());

		ResultSet rs = ps.executeQuery();

		HomepageMemberVO result = new HomepageMemberVO();
		// rs에 데이터가 1개 담여있으면 while 문 한번만 실행된다.
		while (rs.next()) {
			result.setMemberId(rs.getString("mem_id"));
			result.setMemberPw(rs.getString("mem_pw"));
		}

		rs.close();
		ps.close();

		return result;
	}
}
