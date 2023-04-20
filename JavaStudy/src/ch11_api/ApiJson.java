package ch11_api;

public class ApiJson {

	public static void main(String[] args) {
		// 객체지향 프로그리밍(oop)
		//개발 대상, 데이터 등을 객체로 보고
		// 객체로 만들어서 구현
		
		// 학생 이름, 나이, 점수
		// 자바 - 클래스로 선언
		// public class Student
		// 			String name;
		// 			int age;
		// 			int score;
		
		// Student stu = new Student("준호", 30, 80)
		
		// 자바 스크립트 - JSON 객체 사용
		// let stu = { name : "준호", age : 30, score : 80 };
		// JSON 객체 형식이 서버 통신이 데이터 요청 / 응답에
		// 많이 사용되는 형태이다.
		
		// 자바단에서 서버 통신으로 데이터가 넘어왔는데
		// JSON 형태인 경우가 있다.
		// "{ name : "준호", age : 30, score : 80 }" -> JSONString
		
		// JSONString 이 넘어올때, 이를 JSONObject로 변환하여
		// 각 Key값에 접근할 수 있어야 Value를 꺼내올 수 있다.
		
		// JSONObject를 소환해서 사용하기 위해 
		// 외부 라이브러리를 불러 와야 한다.
		// maven repository 사이트에 있다.
		
		// .jar 파일을 (라이브러리 파일)
		// 프로젝트 안에서 쏠수 있도록 하기
		// 프로젝트 마우스 우클릭 - Build Patj
		// - Configure Build Path -library 탭
		// - Add jars클릭 - 프로젝트 내 library 폴더를 찾아
		// 해당 .jar 파일을 선택해준다
		
		
	}

}
