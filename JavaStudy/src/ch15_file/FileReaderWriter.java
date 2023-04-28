package ch15_file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {

	public static void main(String[] args) {
		// 파일읽기
		String filePath = "/home/pc05/today/test.txt";
		// 파일 쓰기
		String copyPath = "/home/pc05/today/copy.txt";

		// ;으로 여러개 입력가능함
		try (FileReader reader = new FileReader(filePath); FileWriter writer = new FileWriter(copyPath);) {

			char[] box = new char[10];

			while (true) {
				int size = reader.read(box);

				if (size == -1) {
					break;
				}
				// char[] -> String 변환
				String result = new String(box);
				System.out.print(result);

				// char[]로 파일 쓰기 (write)
				writer.write(box);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
