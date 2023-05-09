package leejayoung.submit14.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ch14_jdbc_jsp.context.ConnectionPool;
import leejayoung.submit14.DAO.MbtiDAO;
import leejayoung.submit14.VO.MbtiVO;

public class MbtiService {

	private MbtiService () {}
	
	private static MbtiService instance = new MbtiService();
	
	public static MbtiService getInstance() {
		return instance;
	}
	
	private MbtiDAO dao = MbtiDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	
	// 목록 조회 
	public ArrayList<MbtiVO> getmbtiList() {
	    Connection conn = cp.getConnection();
	    ArrayList<MbtiVO> result = new ArrayList<>();

	    try {
	        result = dao.getmbtiList(conn);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        cp.releaseConnection(conn);
	    }
	    return result;
	    
	} 
	public void MbtiVOie() {
		MbtiService mtservice = MbtiService.getInstance();
		ArrayList<MbtiVO> mtvo = mtservice.getmbtiList();
		ArrayList<String> str = new ArrayList<>();  
		int rand = (int)(Math.random() * 3);
		for(int i = 0; i < mtvo.size(); i++ ) {
			if(mtvo.get(i).getNum() == rand) {
			 str.add(mtvo.get(i).getQuestion());
			}
		}
		System.out.println(str.get(0));
		int count = 1;
		for(int a =0; a < mtvo.size(); a++) {
			if(mtvo.get(a).getNum() == rand) {
				System.out.println(count + ". "+ mtvo.get(a).getAnswer());
				count++;
			}
		}
	}
	public ArrayList<MbtiVO> getmbtiListsn() {
	    Connection conn = cp.getConnection();
	    ArrayList<MbtiVO> result = new ArrayList<>();

	    try {
	        result = dao.getmbtiList1(conn);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        cp.releaseConnection(conn);
	    }
	    return result;
	    
	} 
	public void MbtiVOsn () {
		MbtiService mtservice = MbtiService.getInstance();
		ArrayList<MbtiVO> mtvo = mtservice.getmbtiListsn();
		ArrayList<String> str = new ArrayList<>();

		int rand = (int)(Math.random() * 3);
		for(int i = 0; i < mtvo.size(); i++ ) {
			if(mtvo.get(i).getNum() == rand) {
			 str.add(mtvo.get(i).getQuestion());
			}
		}
		System.out.println(str.get(0));
		int count = 1;
		for(int a =0; a < mtvo.size(); a++) {
			if(mtvo.get(a).getNum() == rand) {
				System.out.println(count + ". "+ mtvo.get(a).getAnswer());
				count++;
			}
		}
	}
	public ArrayList<MbtiVO> getmbtiListft() {
	    Connection conn = cp.getConnection();
	    ArrayList<MbtiVO> result = new ArrayList<>();

	    try {
	        result = dao.getmbtiList2(conn);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        cp.releaseConnection(conn);
	    }
	    return result;
	    
	} 
	public void MbtiVOft() {
		MbtiService mtservice = MbtiService.getInstance();
		ArrayList<MbtiVO> mtvo = mtservice.getmbtiListft();
		ArrayList<String> str = new ArrayList<>();  
		int rand = (int)(Math.random() * 3);
		for(int i = 0; i < mtvo.size(); i++ ) {
			if(mtvo.get(i).getNum() == rand) {
			 str.add(mtvo.get(i).getQuestion());
			}
		}
		System.out.println(str.get(0));
		int count = 1;
		for(int a =0; a < mtvo.size(); a++) {
			if(mtvo.get(a).getNum() == rand) {
				System.out.println(count + ". "+ mtvo.get(a).getAnswer());
				count++;
			}
		}
	}
	public ArrayList<MbtiVO> getmbtiListpj() {
	    Connection conn = cp.getConnection();
	    ArrayList<MbtiVO> result = new ArrayList<>();

	    try {
	        result = dao.getmbtiList3(conn);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        cp.releaseConnection(conn);
	    }
	    return result;
	    
	} 
	public void MbtiVOpj() {
		MbtiService mtservice = MbtiService.getInstance();
		ArrayList<MbtiVO> mtvo = mtservice.getmbtiListpj();
		ArrayList<String> str = new ArrayList<>();  
		int rand = (int)(Math.random() * 3);
		for(int i = 0; i < mtvo.size(); i++ ) {
			if(mtvo.get(i).getNum() == rand) {
			 str.add(mtvo.get(i).getQuestion());
			}
		}
		System.out.println(str.get(0));
		int count = 1;
		for(int a =0; a < mtvo.size(); a++) {
			if(mtvo.get(a).getNum() == rand) {
				System.out.println(count + ". "+ mtvo.get(a).getAnswer());
				count++;
			}
		}
	}
	
}
