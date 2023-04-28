package leejayoung.submit13.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.context.ConnectionPool;
import leejayoung.submit13.dao.HomepageMemberDAO;
import leejayoung.submit13.vo.HomepageMemberVO;

public class HomepageMemberService {

	private HomepageMemberService() {
	}

	private static HomepageMemberService instance = new HomepageMemberService();

	public static HomepageMemberService getInstance() {
		return instance;
	}
	private HomepageMemberDAO dao = HomepageMemberDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	public ArrayList<HomepageMemberVO> getMemList(){
		Connection conn = cp.getConnection();
		ArrayList<HomepageMemberVO> result = new ArrayList<>();
		try {
			result = dao.getMemList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	public void registStudent(HomepageMemberVO member) {
		Connection conn = cp.getConnection();
		
		try {
			dao.registMember(conn, member);
			System.out.println("회원가입에 성공하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();

		}finally {
			cp.releaseConnection(conn);
		}
		
	}
	
	// 로그인(SELECT) 메소드
	public HomepageMemberVO login(HomepageMemberVO member) {
		Connection conn = cp.getConnection();
		HomepageMemberVO result = new HomepageMemberVO();
		
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
