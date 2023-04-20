package ch09_class.quiz;

import java.util.ArrayList;

public class MovieDB {
	
	private ArrayList<Movie> movieList = new ArrayList<>();
	
	// 싱글톤 패턴
	private MovieDB() {
		movieList.add(new Movie("신세계", "거 죽기 딱 날씨네", "이정재, 황정민, 박성웅", "ㅅㅅㄱ"));
		movieList.add(new Movie("기생충", "넌 계획이 다 있구나", "송강호", "ㄱㅅㅊ"));
		movieList.add(new Movie("명량", "신에게는 아직 12척의 배가 있사옵니다", "최민식", "ㅁㄹ"));
		movieList.add(new Movie("아저씨", "금이빨 빼고 모조리 다 씹어먹어줄게", "원빈", "ㅇㅈㅆ"));
		movieList.add(new Movie("내부자들", "모히또 가서 몰디브나 한잔 하려니까", "조승우, 이병헌", "ㄴㅂㅈㄷ"));
		movieList.add(new Movie("광해", "그깟 사대의 명분이 뭐요?", "이병헌, 류승룡", "ㄱㅎ"));
		movieList.add(new Movie("올드보이", "누구냐, 넌?", "최민식", "ㅇㄷㅂㅇ"));
		movieList.add(new Movie("배테랑", "어이가 없네?", "황정민, 유아인", "ㅂㅌㄹ"));
		movieList.add(new Movie("범죄와의전쟁", "그 어데 최씹니꺼?", "최민식, 하정우", "ㅂㅈㅇㅇㅈㅈ"));
		movieList.add(new Movie("해바라기", "꼭 그렇게 다 가져가야만 속이 후련했냐!!", "김래원", "ㅎㅂㄹㄱ"));
	}
	
	private static MovieDB instance = new MovieDB();
	
	public static MovieDB getInstance() {
		return instance;
	}
	
	public ArrayList<Movie> getMovieList(){
		return movieList;
	}
	
	
	
	
}