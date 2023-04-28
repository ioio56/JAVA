package leejayoung.submit13.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.context.ConnectionPool;
import leejayoung.submit13.dao.BoardDAO;
import leejayoung.submit13.vo.BoardVO;

public class BoardService {
	private BoardService() {
	}

	private static BoardService instance = new BoardService();

	public static BoardService getInstance() {
		return instance;
	}
	private BoardDAO dao = BoardDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();

	//회원목록 조회(SELECT) 메소드
	public ArrayList<BoardVO> getBoardList(){
		Connection conn = cp.getConnection();
		ArrayList<BoardVO> result = new ArrayList<>();
		try {
			result = dao.getBoardList(conn);
			for (int i = 0; i < result.size(); i++) {
				for (int k = 0; k < result.size() - 1; k++) {
					if (result.get(k).getROWNUM() > result.get(k + 1).getROWNUM()) {
						BoardVO temp = result.get(k);
						result.set(k, result.get(k + 1));
						result.set(k + 1, temp);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	// 학생 회원가입(INSERT) 메소드 
	public void write(BoardVO board) {
		Connection conn = cp.getConnection();
		
		try {
			dao.write(conn, board);
			System.out.println("입력이 완료됐습니다.");
		} catch (SQLException e) {
			e.printStackTrace();

		}finally {
			cp.releaseConnection(conn);
		}
		
	}
	
	// 로그인(SELECT) 메소드
	public BoardVO inner(BoardVO board) {
		Connection conn = cp.getConnection();
		BoardVO result = new BoardVO();
		
		try {
			result = dao.inner(conn, board);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		
		return result;
		
		
	}
	
	
}
