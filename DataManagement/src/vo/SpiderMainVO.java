package vo;

import java.sql.Date;

public class SpiderMainVO {
private String spider_number;
private String spider_name;
private String spider_place;
private Date spider_date;
private String responsibility;

public SpiderMainVO() {}

public SpiderMainVO(String spider_number, String spider_name, String spider_place, Date spider_date,
		String responsibility) {
	super();
	this.spider_number = spider_number;
	this.spider_name = spider_name;
	this.spider_place = spider_place;
	this.spider_date = spider_date;
	this.responsibility = responsibility;
}

@Override
public String toString() {
	return "SpiderMainVO [spider_number=" + spider_number + ", spider_name=" + spider_name + ", spider_place="
			+ spider_place + ", spider_date=" + spider_date + ", responsibility=" + responsibility + "]";
}

public String getSpider_number() {
	return spider_number;
}

public void setSpider_number(String spider_number) {
	this.spider_number = spider_number;
}

public String getSpider_name() {
	return spider_name;
}

public void setSpider_name(String spider_name) {
	this.spider_name = spider_name;
}

public String getSpider_place() {
	return spider_place;
}

public void setSpider_place(String spider_place) {
	this.spider_place = spider_place;
}

public Date getSpider_date() {
	return spider_date;
}

public void setSpider_date(Date spider_date) {
	this.spider_date = spider_date;
}

public String getResponsibility() {
	return responsibility;
}

public void setResponsibility(String responsibility) {
	this.responsibility = responsibility;
}




}
