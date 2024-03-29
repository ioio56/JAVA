package leejayoung.submit13.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVO {
	private int ROWNUM;
	private String write;
	private String inner;
	private String id;
	private Date board_date;
	
	public BoardVO() {}
	
	public BoardVO(int rOWNUM, String write, String inner, String id, Date board_date) {
		super();
		this.ROWNUM = rOWNUM;
		this.write = write;
		this.inner = inner;
		this.id = id;
		SimpleDateFormat sDate2 = new SimpleDateFormat("yyyy.MM.dd");
		String time = sDate2.format(board_date);
		Date time_im;
		try {
			time_im = sDate2.parse(time);
			this.board_date = time_im;
		} catch (ParseException e) {
			e.printStackTrace();
		}	
	}


	public BoardVO(String write, String inner, String memberId) {
		this.write = write;
		this.inner = inner;
		this.id = memberId;
	}

	@Override
	public String toString() {
		return "[" + ROWNUM + " | " + write +" | " + id + " | "
				+ board_date + "]";
	}
	public int getROWNUM() {
		return ROWNUM;
	}
	public void setROWNUM(int rOWNUM) {
		ROWNUM = rOWNUM;
	}
	public String getWrite() {
		return write;
	}
	public void setWrite(String write) {
		this.write = write;
	}
	public String getInner() {
		return inner;
	}
	public void setInner(String inner) {
		this.inner = inner;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	

}
