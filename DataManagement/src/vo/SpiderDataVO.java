package vo;

import java.sql.Date;

public class SpiderDataVO {
	private String spider_number;
	private Date record_date;
	private double width_mm;
	private double length_mm;
	private double weight_mg;
	private int age;
	private String grow_level;
	private String spider_sex;
	private String fulfill;
	private String etc;
	
	public SpiderDataVO() {}
	
	public SpiderDataVO(String spider_number, Date record_date, double width_mm, double length_mm, double weight_mg,
			int age, String grow_level, String spider_sex, String fulfill, String etc) {
		super();
		this.spider_number = spider_number;
		this.record_date = record_date;
		this.width_mm = width_mm;
		this.length_mm = length_mm;
		this.weight_mg = weight_mg;
		this.age = age;
		this.grow_level = grow_level;
		this.spider_sex = spider_sex;
		this.fulfill = fulfill;
		this.etc = etc;
	}

	public String getSpider_number() {
		return spider_number;
	}

	public void setSpider_number(String spider_number) {
		this.spider_number = spider_number;
	}

	public Date getRecord_date() {
		return record_date;
	}

	public void setRecord_date(Date record_date) {
		this.record_date = record_date;
	}

	public double getWidth_mm() {
		return width_mm;
	}

	public void setWidth_mm(double width_mm) {
		this.width_mm = width_mm;
	}

	public double getLength_mm() {
		return length_mm;
	}

	public void setLength_mm(double length_mm) {
		this.length_mm = length_mm;
	}

	public double getWeight_mg() {
		return weight_mg;
	}

	public void setWeight_mg(double weight_mg) {
		this.weight_mg = weight_mg;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGrow_level() {
		return grow_level;
	}

	public void setGrow_level(String grow_level) {
		this.grow_level = grow_level;
	}

	public String getSpider_sex() {
		return spider_sex;
	}

	public void setSpider_sex(String spider_sex) {
		this.spider_sex = spider_sex;
	}

	public String getFulfill() {
		return fulfill;
	}

	public void setFulfill(String fulfill) {
		this.fulfill = fulfill;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	@Override
	public String toString() {
		return "SpiderDataVO [spider_number=" + spider_number + ", record_date=" + record_date + ", width_mm="
				+ width_mm + ", length_mm=" + length_mm + ", weight_mg=" + weight_mg + ", age=" + age + ", grow_level="
				+ grow_level + ", spider_sex=" + spider_sex + ", fulfill=" + fulfill + ", etc=" + etc + "]";
	}
	
	
	
	
}
