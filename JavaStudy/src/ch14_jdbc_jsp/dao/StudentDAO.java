package ch14_jdbc_jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import ch09_class.school.Student;
import ch14_jdbc_jsp.vo.StudentVO;

public class StudentDAO {
	private StudentDAO() {
	}

	private static StudentDAO instance = new StudentDAO();

	public static StudentDAO getInstance() {
		return instance;
	}

	// 학생 조회(SELECT) 메소드
	public ArrayList<StudentVO> getStuList(Connection conn) throws SQLException {
		// 3. 쿼리문 작성
		StringBuffer query = new StringBuffer();
		query.append("SELECT						");
		query.append("		stu_id				");
		query.append("	, stu_password AS pw	");
		query.append("	, stu_name				");
		query.append("	, stu_score			");
		query.append("FROM						");
		query.append("	students				"); // 세미콜론이 없음에 주의

		// 4. 쿼리문을 보유하고 실행 할 수 있는 객체 생성
		// 객체 (PreparedStatement) 생성

		PreparedStatement ps = conn.prepareStatement(query.toString());

		// 5. 쿼리문 실행
		// SELECT문의 경우 executeQuery()
		// 실행결과를 ResultSet에 담는다.
		ResultSet rs = ps.executeQuery();
		ArrayList<StudentVO> result = new ArrayList<>();
		// 6. ResultSet에 담긴 데이터 조회
		while (rs.next()) {
			// 쿼리문 실행 결과에 해당하는 컬럼명과 일치해야 함
			String stuId = rs.getString("stu_id");
			String stuPw = rs.getString("pw"); // as로 컬럼명 수정시 컬럼명에 맞춰줘야한다.
			String stuName = rs.getString("stu_name");
			int stuScore = rs.getInt("stu_score");

			StudentVO stu = new StudentVO(stuId, stuPw, stuName, stuScore);
			result.add(stu);

//			StudentVO temp =  new StudentVO();
//			temp.setStudId(rs.getString("stu_id"));
//			temp.setStuName(rs.getString("stu_name"));
//			temp.setStuPassword(rs.getString("stu_pw"));
//			temp.setStuScore(rs.getInt("stu_score"));

		}
		ps.close();
		rs.close();
		return result;
	}

	// 학생 회원가입 (INSERT) 메소드
	public int registStudent(Connection conn, StudentVO student) throws SQLException {

		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO students (	");
		query.append("      stu_id				");
		query.append("    , stu_password		");
		query.append("    , stu_name			");
		query.append("    , stu_score			");
		query.append(") VALUES (					");
		query.append("      ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append("    , ?					");
		query.append(")							");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		int idx = 1;
		ps.setString(idx++, student.getStudId());
		ps.setString(idx++, student.getStuPassword());
		ps.setString(idx++, student.getStuName());
		ps.setInt(idx++, 0);

		int cnt = ps.executeUpdate();
		ps.close();
		
		return cnt;

	}
	
	// 로그인(SELECT) 메소드
	// 입력받은 아이디와 비밀번호가 일치하는 하나의 데이터 리턴
	public StudentVO login(Connection conn, StudentVO student) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT						");
		query.append("		stu_id				");
		query.append("	, stu_password AS pw	");
		query.append("	, stu_name				");
		query.append("	, stu_score			");
		query.append("FROM						");
		query.append("	students				"); 
		query.append("WHERE 1=1					"); 
		query.append("	AND stu_id =?			"); 
		query.append("	AND stu_password =?	"); 

		PreparedStatement ps = conn.prepareStatement(query.toString());
		int idx = 1;
		ps.setString(idx++, student.getStudId());
		ps.setString(idx++, student.getStuPassword());
		
		ResultSet rs = ps.executeQuery();
		
		StudentVO result = new StudentVO();
		// rs에 데이터가 1개 담여있으면 while 문 한번만 실행된다.
		while(rs.next()) {
			result.setStudId(rs.getString("stu_id"));
			result.setStuPassword(rs.getString("pw"));
			result.setStuName(rs.getString("stu_name"));
			result.setStuScore(rs.getInt("stu_score"));
		}
		
		rs.close();
		ps.close();
		
		
		return result;
	}
	
}
