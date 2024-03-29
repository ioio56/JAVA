package ch13_thread.dance;

public class Teacher extends Thread {

	boolean state = true;
	boolean isRun = true; // 게임 오버시 DanceMain에서 run내 while 문 종료 시키기 위함

	@Override
	public void run() {
		while (true) {
			// 랜덤한 시간만큰 sleep 시키기
			int rand = (int) (Math.random() * 3000) + 500;
			try {
				Thread.sleep(rand);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// 앞. 뒤 상태 바꿔주기
			state = !state;
			
			// 상태 변화 알리기
			if (state == true) {
				System.out.println("앞을 보셨다.");
			} else {
				System.out.println("뒤를 보셨다. ㅋㅋ");
			}

		}

	}
}
