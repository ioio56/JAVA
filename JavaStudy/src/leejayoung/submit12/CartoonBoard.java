package leejayoung.submit12;

public class CartoonBoard extends Board {
	private String img;
	
	public CartoonBoard(int no, String title, String day, String content, String img) {
		super(no, title, day, content);
		this.img = img;
	}

	@Override
	public String toString() {
		return super.toString() + "[img=" + img + "]";
	}



	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}


}
