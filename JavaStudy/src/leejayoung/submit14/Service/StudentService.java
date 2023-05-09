package leejayoung.submit14.Service;

import java.sql.Connection;

import ch14_jdbc_jsp.context.ConnectionPool;
import leejayoung.submit14.DAO.StudentDAO;

public class StudentService {
	
	private StudentService () {}
	
	private static StudentService instance = new StudentService();
	
	public static StudentService getInstance() {
		return instance;
	}
	
	private StudentDAO dao = StudentDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	
	public void registStudent (StudentVO student) {
		Connection conn = cp.getConnection();
		try {
			dao.registStudent(conn, student);
			System.out.println("회원가입이 완료되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}
	}
	public StudentVO login(StudentVO student) {
		Connection conn = cp.getConnection();
		StudentVO result = new StudentVO();
		try {
			result = dao.login(conn, student);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cp.releaseConnection(conn);
		}
		return result;
	}
	
	
	
	

}
