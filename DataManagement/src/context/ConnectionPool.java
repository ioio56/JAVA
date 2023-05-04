package context;

import java.sql.Connection;
import java.util.Vector;


//ConnectionFactory로 부터 maxConn 개수 만큼
//Connection 객체를 생성하고 보관하고
//쿼리문 실행시, 보관중인 Connection 객체를
//빌려주고, 반납받는 클래스

public class ConnectionPool {
private ConnectionFactory cf = ConnectionFactory.getInstance();
	
	// Vector 는 동기화가 적용된 ArrayList와 같다.
	private Vector<Connection> pool = new Vector<>();
	
	private ConnectionPool() {
		// maxConn 만큼 Connection 객체를 pool에 담
		for(int i = 0; i < cf.getMaxConn(); i++) {
			Connection conn = cf.getConnection();
			pool.add(conn);
		}
		System.out.println("pool의 사이즈: " + pool.size());
		System.out.println("Connection 잘 보관중");
		
	}
	private static ConnectionPool instance = new ConnectionPool();
	
	public static ConnectionPool getInstance() {
		return instance;
	}
	
	// pool에 있는 Connection 객체 빌려주기
	public synchronized Connection getConnection() {
		if(pool.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Connection conn = pool.get(0);
		pool.remove(0);
		return conn;
	}
	
	// 빌려준 Connection 객체 반납받기
	public synchronized void releaseConnection(Connection conn) {
		pool.add(conn);
		notify();
		
	}
}
