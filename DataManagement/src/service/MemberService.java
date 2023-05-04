package service;

import java.sql.Connection;
import java.sql.SQLException;

import context.ConnectionPool;
import dao.MemberDAO;
import vo.MemberVO;


public class MemberService {
	private MemberService() {
	}

	private static MemberService instance = new MemberService();

	public static MemberService getInstance() {
		return instance;
	}
	private MemberDAO dao = MemberDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();

	// 학생 회원가입(INSERT) 메소드 
	public void registStudent(MemberVO member) {
		Connection conn = cp.getConnection();
		
		try {
			dao.registStudent(conn,member);
			System.out.println("회원가입에 성공하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();

		}finally {
			cp.releaseConnection(conn);
		}
		
	}
	
	// 로그인(SELECT) 메소드
	public MemberVO login(MemberVO member) {
		Connection conn = cp.getConnection();
		MemberVO result = new MemberVO();
		
		try {
			result = dao.login(conn, member);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		
		return result;
		
		
	}
	
}
