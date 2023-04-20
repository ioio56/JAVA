package ch09_class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Submit09 {
	public static void main(String[] args) {

		Product ic = new Product("냉장고", 2000000);
		Product tv = new Product("TV", 1000000);
		Product air = new Product("에어컨", 800000);
		Product pc = new Product("컴퓨터", 1300000);
		Product fly = new Product("선풍기", 100000);

		ArrayList<Product> proList = new ArrayList<>();
		proList.add(ic);
		proList.add(tv);
		proList.add(air);
		proList.add(pc);
		proList.add(fly);

		Collections.sort(proList, (prodA, prodB) -> prodA.getPrice() - prodA.getPrice());
	
		
		for (int i = 0; i < proList.size(); i++) {
			System.out.println(proList.get(i));
		}
		// indexOf()
		// ArrayList<String> ramen = ["신라면" , "안성탕면" , "진라면"]
		// ArrayList<Integer> number= [ 10 , 20 , 30]
		// ramen.indexOf("안성탕면") = 1
		
		// ArrayList<Product> prodList = [Product객체(냉장고), Product(TV)]
		// prodList.indexOf("TV")
		
		for (int i = 0; i < proList.size(); i++) {
			if (proList.get(i).getName().equals("TV")) {
				System.out.println(proList.get(i));
			}
		}
		System.out.println("\n==============================================================\n");
		
		for (int k = 0; k < proList.size(); k++) {
			for (int i = 0; i < proList.size() - 1; i++) {

				if (proList.get(i).getPrice() < proList.get(i + 1).getPrice()) {
					Product temps = proList.get(i);
					proList.set(i, proList.get(i + 1));
					proList.set(i + 1, temps);
				}
			}

		}
		for (int i = 0; i < proList.size(); i++) {
			System.out.println(proList.get(i));
		}
		System.out.println("\n==========================================\n");

		for (int i = 0; i < proList.size(); i++) {
			if (proList.get(i).getName() == "TV") {
				System.out.println(proList.indexOf(proList.get(i)));
			}
		}
		System.out.println("\n==========================================\n");

		Cafe starBucks = new Cafe("스타벅스");
		starBucks.addCoffee(new Coffee("아메리카노", 5000));
		starBucks.addCoffee(new Coffee("카푸치노", 6000));
		starBucks.addCoffee(new Coffee("오곡라떼", 7000));

		Cafe conte = new Cafe("꽁떼");
		conte.addCoffee(new Coffee("아메리카노", 2500));
		conte.addCoffee(new Coffee("바닐라라떼", 3000));
		conte.addCoffee(new Coffee("아이스티", 3500));

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 스타벅스 방문 | 2. 꽁떼 방문 | 3. 사무실 복귀..");
			System.out.print(">>> ");
			int select = Integer.parseInt(sc.nextLine());

			// 코드 작성 시작
			if (select == 1) {
				System.out.println("어서오세요 " + starBucks.name + " 입니다");
				System.out.println("메뉴판");
				starBucks.menu(starBucks);

				System.out.println("메뉴를 선택해주세요");
				System.out.print(">>> ");
				int ch = Integer.parseInt(sc.nextLine());
				if (ch == 1) {
					System.out.println(starBucks.cofList.get(0).name + " 한잔 " + starBucks.cofList.get(0).price + "원에 "
							+ "구매하였습니다");
				} else if (ch == 2) {
					System.out.println(starBucks.cofList.get(1).name + " 한잔 " + starBucks.cofList.get(1).price + "원에 "
							+ "구매하였습니다");
				} else {
					System.out.println(starBucks.cofList.get(2).name + " 한잔 " + starBucks.cofList.get(2).price + "원에 "
							+ "구매하였습니다");
				}
			} else if (select == 2) {
				System.out.println("어서오세요 " + conte.name + " 입니다");
				System.out.println("메뉴판");
				for(int i = 0; i <conte.cofList.size(); i++)
				System.out.println( (i+1) +". " + conte.cofList.get(i).name + conte.cofList.get(i).price);
				
				System.out.println("메뉴를 선택해주세요");
				System.out.print(">>> ");
				int ch = Integer.parseInt(sc.nextLine());
				if (ch == 1) {
					System.out.println(
							conte.cofList.get(0).name + " 한잔 " + conte.cofList.get(0).price + "원에 " + "구매하였습니다");
				} else if (ch == 2) {
					System.out.println(
							conte.cofList.get(1).name + " 한잔 " + conte.cofList.get(1).price + "원에 " + "구매하였습니다");
				} else {
					System.out.println(
							conte.cofList.get(2).name + " 한잔 " + conte.cofList.get(2).price + "원에 " + "구매하였습니다");
				}

			} else {
				System.out.println("일하러 갑시다.");
				break;
			}
		}
	}

}
