package leejayoung.submit13.vo;

import java.util.Date;

public class HomepageMemberVO {
	private String memberId;
	private String memberPw;
	private Date memberdate;
	
	public HomepageMemberVO() {}
	
	public HomepageMemberVO(String memberId, String memberPw, Date memDate) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberdate = memDate;
	}

	@Override
	public String toString() {
		return "HomepageMemberService [memberId=" + memberId + ", memberPw=" + memberPw + ", memberdate=" + memberdate + "]";
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public Date getMemberDate() {
		return memberdate;
	}

	public void setMemberDate(Date dat) {
		this.memberdate = dat;
	}
	
	
}
