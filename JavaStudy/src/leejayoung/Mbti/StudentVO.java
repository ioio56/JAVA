package leejayoung.Mbti;

public class StudentVO {
	
	private String Id;
	private String passWord;
	private String name;
	private String mbti;
	
	public StudentVO () {}

	public StudentVO(String id, String passWord, String name, String mbti) {
		super();
		this.Id = id;
		this.passWord = passWord;
		this.name = name;
		this.mbti = mbti;
	}

	@Override
	public String toString() {
		return "StudentVO [Id=" + Id + ", passWord=" + passWord + ", name=" + name + ", mbti=" + mbti + "]";
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMbti() {
		return mbti;
	}

	public void setMbti(String mbti) {
		this.mbti = mbti;
	}

	
	
	

}
