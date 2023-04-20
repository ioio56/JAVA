package leejayoung.submit09;

import java.util.ArrayList;

public class Cafe {
	String name;
	private Coffee coffee;
	ArrayList<Coffee> cofList = new ArrayList<>();
	
	public Coffee getCof(Cafe conte) {
		return coffee;
	}


	public Cafe(String string) {
		this.name = string;
		
	}

// 커피 메뉴를 추가한다
	public void addCoffee(Coffee coffee2) {
		cofList.add(coffee2);
		this.coffee	= coffee2;
		
	}

	// 메뉴판을 출력하는 메소드
	public void menu(Cafe starBucks) {
		
		for(int i =0; i < starBucks.cofList.size();  i++)
			System.out.println((i+1)+". " + starBucks.cofList.get(i).name + starBucks.cofList.get(i).price);
		
	}

	@Override
	public String toString() {
		return "[name=" + name + ", list=" + cofList + "]";
	}




}
