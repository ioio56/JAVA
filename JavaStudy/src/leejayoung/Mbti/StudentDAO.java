package leejayoung.Mbti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class StudentDAO {
	
	private StudentDAO () {}
	
	private static StudentDAO instance = new StudentDAO();
	
	public static StudentDAO getInstance() {
		return instance;
	}
	public int registStudent(Connection conn, StudentVO student) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("insert into	student (			");
		query.append("	id				");
		query.append("	,password		");
		query.append("	,name			");
		query.append("	,mbti 			");
		query.append(")	values	(		");
		query.append("	?				");
		query.append("	,?				");
		query.append("	,?				");
		query.append("	,?				");
		query.append(")					");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
		ps.setString(idx++, student.getId());
		ps.setString(idx++, student.getPassWord());
		ps.setString(idx++, student.getName());
		ps.setString(idx++, student.getMbti());
		
		int cnt = ps.executeUpdate();
		
		ps.close();
		
		return cnt;
		
		
	}
	
	// login 메소드
	public StudentVO login(Connection conn,StudentVO student) throws SQLException { 
		StringBuffer query = new StringBuffer();
		query.append("select				");
		query.append("		id				");
		query.append("		,password		");
		query.append("		,name			");
		query.append("		,mbti			");
		query.append("from					");
		query.append("		student		");
		query.append("		where	1=1		");
		query.append("and 	id	= ?			");
		query.append("and 	password = ?				");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		
		int idx = 1;
			ps.setString(idx++,student.getId());
			ps.setString(idx++,student.getPassWord());
		
		ResultSet rs = ps.executeQuery();
		
		StudentVO result = new StudentVO();
		
		while(rs.next())
		{
			result.setId(rs.getString("id"));
			result.setPassWord(rs.getString("password"));
			result.setName(rs.getString("name"));
			result.setMbti(rs.getString("mbti"));
		}
		
		rs.close();
		ps.close();
		return result;
	}
	
	
	
	
	
	

		
		
		
	
	
	
	
	
	

}
