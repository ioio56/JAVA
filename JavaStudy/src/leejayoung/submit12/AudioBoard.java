package leejayoung.submit12;

public class AudioBoard extends Board {
	private String audio;
	
	public AudioBoard(int no, String title, String day, String content, String audio) {
		super(no, title, day, content);
		this.audio = audio;
	}

	@Override
	public String toString() {
		return super.toString() + "[audio=" + audio + "]";
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}


	
}
