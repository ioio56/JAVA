package leejayoung.Mbti;

public class MbtiVO {
	private int num;
	private String Question;
	private int questionnum;
	private String Answer;
	
	
	public MbtiVO() {}


	public MbtiVO(int num, String question, int questionnum, String answer) {
		super();
		this.num = num;
		Question = question;
		this.questionnum = questionnum;
		Answer = answer;
	}


	@Override
	public String toString() {
		return "MbtiVO [num=" + num + ", Question=" + Question + ", questionnum=" + questionnum + ", Answer=" + Answer
				+ "]";
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getQuestion() {
		return Question;
	}


	public void setQuestion(String question) {
		Question = question;
	}


	public int getQuestionnum() {
		return questionnum;
	}


	public void setQuestionnum(int questionnum) {
		this.questionnum = questionnum;
	}


	public String getAnswer() {
		return Answer;
	}


	public void setAnswer(String answer) {
		Answer = answer;
	}


	
	
	
	

	
	

}
