package leejayoung.Mbti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class MbtiDAO {
	
	private MbtiDAO() {}
	
	public static MbtiDAO instance = new MbtiDAO();
	
	public static MbtiDAO getInstance() {
		return instance;
	}
	// ie 목록 가져오기 
	public ArrayList<MbtiVO> getmbtiList(Connection conn) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("select a.num as num, a.QUESTION as question, b.num as num2,  b.answer as answer   		      	");
		query.append("from questionie a,answerie b  	    		");
		query.append("where a.num = b.QUESTIONNUM					");

		
		PreparedStatement ps = conn.prepareStatement(query.toString());

		ResultSet rs = ps.executeQuery();
		ArrayList<MbtiVO> result = new ArrayList<>();
		
		while(rs.next()) {
			int num = rs.getInt("num");
			String question = rs.getString("question");
			int questionnum = rs.getInt("num2");
			String answer = rs.getString("answer");
			
			MbtiVO mbti = new MbtiVO(num ,question, questionnum , answer);
			result.add(mbti);
		}
		rs.close();
		ps.close();
		
		return result;
		
		
		
		
		
	}
	// sn 목록 가져오기 
	public ArrayList<MbtiVO> getmbtiList1(Connection conn) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("select a.num as num, a.QUESTION as question, b.num as num2,  b.answer as answer   		      	");
		query.append("from questionsn a,answersn b  	    		");
		query.append("where a.num = b.QUESTIONNUM					");

		
		PreparedStatement ps = conn.prepareStatement(query.toString());

		ResultSet rs = ps.executeQuery();
		ArrayList<MbtiVO> result = new ArrayList<>();
		
		while(rs.next()) {
			int num = rs.getInt("num");
			String question = rs.getString("question");
			int questionnum = rs.getInt("num2");
			String answer = rs.getString("answer");
			
			MbtiVO mbti = new MbtiVO(num ,question, questionnum , answer);
			result.add(mbti);
		}
		rs.close();
		ps.close();
		
		return result;
}
	// ft 목록 가져오기 
	public ArrayList<MbtiVO> getmbtiList2(Connection conn) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("select a.num as num, a.QUESTION as question, b.num as num2,  b.answer as answer   		      	");
		query.append("from questionft a,answerft b  	    		");
		query.append("where a.num = b.QUESTIONNUM					");

		
		PreparedStatement ps = conn.prepareStatement(query.toString());

		ResultSet rs = ps.executeQuery();
		ArrayList<MbtiVO> result = new ArrayList<>();
		
		while(rs.next()) {
			int num = rs.getInt("num");
			String question = rs.getString("question");
			int questionnum = rs.getInt("num2");
			String answer = rs.getString("answer");
			
			MbtiVO mbti = new MbtiVO(num ,question, questionnum , answer);
			result.add(mbti);
		}
		rs.close();
		ps.close();
		
		return result;
	}
	// pj 목록 가져오기 
		public ArrayList<MbtiVO> getmbtiList3(Connection conn) throws SQLException {
			StringBuffer query = new StringBuffer();
			query.append("select a.num as num, a.QUESTION as question, b.num as num2,  b.answer as answer   		      	");
			query.append("from questionpj a,answerpj b  	    		");
			query.append("where a.num = b.QUESTIONNUM					");

			
			PreparedStatement ps = conn.prepareStatement(query.toString());

			ResultSet rs = ps.executeQuery();
			ArrayList<MbtiVO> result = new ArrayList<>();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String question = rs.getString("question");
				int questionnum = rs.getInt("num2");
				String answer = rs.getString("answer");
				
				MbtiVO mbti = new MbtiVO(num ,question, questionnum , answer);
				result.add(mbti);
			}
			rs.close();
			ps.close();
			
			return result;
		}
}