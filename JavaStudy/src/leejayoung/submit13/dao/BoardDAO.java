package leejayoung.submit13.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import leejayoung.submit13.vo.BoardVO;

public class BoardDAO {
	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	public ArrayList<BoardVO> getBoardList(Connection conn) throws SQLException {
		// 3. 쿼리문 작성
		StringBuffer query = new StringBuffer();
		query.append("select ROWNUM						");
		query.append("	,board_write						");
		query.append("	, board_inner						");
		query.append("	, member_id						");
		query.append("	, board_date						");
		query.append("FROM(									");
		query.append("	 select 							"); // 세미콜론이 없음에 주의
		query.append("	board_write					");
		query.append("	,board_inner					");
		query.append("	,member_id					");
		query.append("	,board_date					");
		query.append("	from board					");
		query.append("	order by 4					");
		query.append("	  )					");

		// 4. 쿼리문을 보유하고 실행 할 수 있는 객체 생성
		// 객체 (PreparedStatement) 생성

		PreparedStatement ps = conn.prepareStatement(query.toString());

		// SELECT문의 경우 executeQuery()
		// 실행결과를 ResultSet에 담는다.
		ResultSet rs = ps.executeQuery();
		ArrayList<BoardVO> result = new ArrayList<>();
		// 6. ResultSet에 담긴 데이터 조회
		while (rs.next()) {
			// 쿼리문 실행 결과에 해당하는 컬럼명과 일치해야 함
			int nm = rs.getInt("ROWNUM");
			String write = rs.getString("board_write");
			String inner = rs.getString("board_inner"); // as로 컬럼명 수정시 컬럼명에 맞춰줘야한다.
			String id = rs.getString("member_id");
			Date date = rs.getDate("board_date");
			BoardVO board = new BoardVO(nm, write, inner, id, date);
			result.add(board);
			
		}
		ps.close();
		rs.close();
		return result;
	}

	// 학생 회원가입 (INSERT) 메소드
	public int write(Connection conn, BoardVO board) throws SQLException {

		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO board (			");
		query.append("      board_write				");
		query.append("    , board_inner				");
		query.append("    , member_id				");
		query.append("    , board_date				");
		query.append(") VALUES (						");
		query.append("      ?						");
		query.append("    , ?						");
		query.append("    , ?						");
		query.append("    , sysdate					");
		query.append(")								");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		int idx = 1;
		ps.setString(idx++, board.getWrite());
		ps.setString(idx++, board.getInner());
		ps.setString(idx++, board.getId());

		int cnt = ps.executeUpdate();
		ps.close();

		return cnt;

	}

	// 입력받은 아이디와 비밀번호가 일치하는 하나의 데이터 리턴
	public BoardVO inner(Connection conn, BoardVO board) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT							");
		query.append("		board_write			");
		query.append("	, board_inner				");
		query.append("FROM							");
		query.append("	board						");
		query.append("WHERE 1=1						");
		query.append("	AND board_write =?		");

		PreparedStatement ps = conn.prepareStatement(query.toString());
		int idx = 1;
		ps.setString(idx++, board.getWrite());

		ResultSet rs = ps.executeQuery();

		BoardVO result = new BoardVO();
		// rs에 데이터가 1개 담여있으면 while 문 한번만 실행된다.
		while (rs.next()) {
			result.setWrite(rs.getString("board_write"));
			result.setWrite(rs.getString("board_inner"));
		}

		rs.close();
		ps.close();

		return result;
	}

}
