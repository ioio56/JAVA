package leejayoung.submit12;

import java.util.ArrayList;

public class BoardDB {
	ArrayList<Board> boardList = new ArrayList<>();
	
	public BoardDB() {}
	public BoardDB(ArrayList<Board> boardList) {
		this.boardList = boardList;
	}
	public void addBoardDB(Board board) {
		boardList.add(board);
		
	}
	@Override
	public String toString() {
		return boardList + "";
	}
	
}
