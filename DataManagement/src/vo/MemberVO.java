package vo;

public class MemberVO {
	private String memerId;
	private String memerPw;
	private String memerName;
	
	public MemberVO() {}
	
	public MemberVO(String memerId, String memerPw, String memerName) {
		super();
		this.memerId = memerId;
		this.memerPw = memerPw;
		this.memerName = memerName;
	}
	public String getMemerId() {
		return memerId;
	}
	public void setMemerId(String memerId) {
		this.memerId = memerId;
	}
	public String getMemerPw() {
		return memerPw;
	}
	public void setMemerPw(String memerPw) {
		this.memerPw = memerPw;
	}
	public String getMemerName() {
		return memerName;
	}
	public void setMemerName(String memerName) {
		this.memerName = memerName;
	}
	@Override
	public String toString() {
		return "MemberVO [memerId=" + memerId + ", memerPw=" + memerPw + ", memerName=" + memerName + "]";
	}
	
}
