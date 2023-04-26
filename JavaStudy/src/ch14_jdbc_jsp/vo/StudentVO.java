package ch14_jdbc_jsp.vo;

public class StudentVO {
	private String studId;
	private String stuPassword;
	private String stuName;
	int stuScore;

	public StudentVO() {
	}

	public StudentVO(String studId, String stuPassword, String stuName, int stuScore) {
		super();
		this.studId = studId;
		this.stuPassword = stuPassword;
		this.stuName = stuName;
		this.stuScore = stuScore;
	}

	public String getStudId() {
		return studId;
	}

	public void setStudId(String studId) {
		this.studId = studId;
	}

	public String getStuPassword() {
		return stuPassword;
	}

	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuScore() {
		return stuScore;
	}

	public void setStuScore(int stuScore) {
		this.stuScore = stuScore;
	}

	@Override
	public String toString() {
		return "StudentVO [studId=" + studId + ", stuPassword=" + stuPassword + ", stuName=" + stuName + ", stuScore="
				+ stuScore + "]";
	}

}
