

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/*
 * This pojo class is designed with variables firstName,lastName,officeCity,active_customers,total_Sales
 * 
 * XML annotations are given to each instance variable,which results while binding objects into XML
 */

@XmlRootElement(name="employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
	
	@XmlElement
	String first_name;
	@XmlElement
	String last_name;
	@XmlElement
	String office_city;
	@XmlElement
	int active_customers;
	@XmlElement
	float total_sales;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getOffice_city() {
		return office_city;
	}
	public void setOffice_city(String office_city) {
		this.office_city = office_city;
	}
	public int getActive_customers() {
		return active_customers;
	}
	public void setActive_customers(int active_customers) {
		this.active_customers = active_customers;
	}
	public float getTotal_sales() {
		return total_sales;
	}
	public void setTotal_sales(float total_sales) {
		this.total_sales = total_sales;
	}
	

	@Override
	public String toString() {
		return "Employee [first_name=" + first_name + ", last_name=" + last_name + ", office_city=" + office_city
				+ ", active_customers=" + active_customers + ", total_sales=" + total_sales + "]";
	}
}
