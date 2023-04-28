package ch15_file;

import java.io.File;

public class TreasureHunter {

	public static void main(String[] args) {

		// treasure 폴더 내 파일을 먼저 찾기

		String path = "/home/pc05/today/treasure";
		File src = new File(path);
		File[] srcArray = src.listFiles();

		findFile(src);
	}

	

	public static void findFile(File folder) {
		File[] inner = folder.listFiles();
		for (int i = 0; i < inner.length; i++) {
			if (inner[i].isDirectory()) {
				findFile(inner[i]);
			} else {
				System.out.println(inner[i]);
			}
		}
	}

}
