package ch15_file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileBasic {

	public static void main(String[] args) {
		// 현재 디렉토리 경로 가져오기
		String path = System.getProperty("user.dir");
		System.out.println(path); // 프로젝트의 풀 경로에 해당

		// 프로젝트에 대해 자바에서 file 객체 생성하기
		// File()의 생성자 안에는 풀경로 입력
		File proj = new File(path);

		// proj 내의 파일 목록 출력
		// .listFiles()
		// 해당 File 객체 폴더의 파일 목록을 배열(Array)로 리턴
		File[] fileArray = proj.listFiles();
		for (int i = 0; i < fileArray.length; i++) {
			// 해당 File 객체의 풀 경로를 리턴(경로 + 파일명)
			System.out.println(fileArray[i]);
		}

		// proj의 src 폴더 내 파일 목록 출력
		File src = new File(path + "/src");

		File[] srcArray = src.listFiles();
		for (int i = 0; i < srcArray.length; i++) {
			// 파일명만 출력
			System.out.println(srcArray[i].getName());
		}
		System.out.println("\n======================================\n");

		// File 객체가 폴더인지 파일인지 확인
		// .isDirectory()
		System.out.println(src.isDirectory());

		// 프로젝트 내부에 Ramen.java 파일을 File 객체로 만들기
		File raman_false = new File(path + "/src/ch10_extends_interface/ramen/Ramena.java");
		File raman = new File(path + "/src/ch10_extends_interface/ramen/Ramen.java");

		System.out.println(raman);
		// File 객체가 실제로 존재하는 파일을 바라보고 있는지 체크
		// .exists()
		System.out.println(raman_false.exists());
		System.out.println(raman.exists());

		// .lastModified()
		// 마지막 수정날짜
		System.out.println(raman.lastModified());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.mm.dd HH:mm:dd");
		System.out.println(sdf.format(raman.lastModified()));

		// 파일 크기 (Byte)
		// .length()
		// 1KB = 1024Byte
		// 1MB = 1024KB = 1024 * 1024 Byte
		// 1GB = 1024MB
		System.out.println(raman.length());

		System.out.println("\n=================================\n");

		// 폴더 만들기
		File today = new File("/home/pc05/today"); // 만들 폴더 경로
		System.out.println(today.exists());
		// 이미 폴더가 존재하면 생성되지 않음
		today.mkdir(); // 폴더 생성
		System.out.println("\n=================================\n");

		// 파일만들기
		// /home/pc05/today 안에 test.txt 파일 만들기
		File test = new File("/home/pc05/today/test.txt");
		System.out.println(test.exists());

		try {
			test.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
//	File test = new File("/home/pc05/today/");
		System.out.println("\n=================================\n");
		String[] stuArray = { "유정", "준호", "동욱", "현진", "민경", "진영", "대일", "창연", "자영", "성복", "민기", "동윤", "지혜", "태윤",
				"준하" };
		// today 폴더 안에 위 학생들의 폴더를 각각 만들어 주세요
		for (int i = 0; i < stuArray.length; i++) {
			File stu = new File("/home/pc05/today/" + stuArray[i]);
			stu.mkdir();
		}
		for (int i = 0; i < stuArray.length; i++) {
			File stu = new File("/home/pc05/today/" + stuArray[i]);
			System.out.println(stu.exists());
		}
	}

}
