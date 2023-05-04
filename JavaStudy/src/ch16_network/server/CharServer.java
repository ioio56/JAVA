package ch16_network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import ch16_network.common.ReceiveThread;
import ch16_network.common.SendThread;

public class CharServer {

	public static void main(String[] args) {
		// 소켓 통신
		// 소켓을 통해 서버와 클라이언트간 데이터를 주고 받는
		// 양뱡향성 통신
		try {
			// 서버 소켓 객체 생성
			// 생성자 안 숫자는 서버 소켓의 포트번호
			ServerSocket server = new ServerSocket(5001);
			
			// 클라이언트의 연결 요청 대기 
			// 연결 요청이 들어오면 클라이언트와 통신이 가능한
			// 소켓이 생성되어 리턴된다.
			Socket serverSocket = server.accept();
			System.out.println("클라이언트 요청 수락");
			
			// 클라이언트의 IP주소 확인
			System.out.println(serverSocket.getRemoteSocketAddress());
			
			SendThread send = new SendThread(serverSocket);
			send.start();
			
			ReceiveThread receive = new ReceiveThread(serverSocket);
			receive.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
