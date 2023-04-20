package ch09_class;

import java.util.ArrayList;

public class Coffee {

	String name;
	int price;

	
	public Coffee(String name, int price) {

		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		
		return "[name=" + name + ", price=" + price + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
