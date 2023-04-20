package note;

import java.util.HashMap;

public class je {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("a001", "1234a");
		map.put("b001", "1234b");
		map.put("c001", "1234c");
		map.put("a001", "1234c");
		System.out.println(map.size());
		System.out.println(map);

		int[] arr = {21,80,12,35,7,42,5};
		int cont = 0;
		for(int i =0; i < arr.length;  i++) {
			if(arr[i] % 2 == 0) {
				cont++;
			}
		}System.out.println(cont);
	}
}
