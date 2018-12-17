package highCharts2;

import java.util.ArrayList;

public class ShopData {
	private String age;
	private ArrayList<Integer> data=new ArrayList<>();
	public ShopData(String age, ArrayList<Integer> data) {
		super();
		this.age = age;
		this.data = data;
	}
	public ShopData() {
		super();
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public ArrayList<Integer> getData() {
		return data;
	}
	public void setData(ArrayList<Integer> data) {
		this.data = data;
	}
	
	
}
