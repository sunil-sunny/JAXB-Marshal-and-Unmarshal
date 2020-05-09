

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * This pojo class is designed with variables name,address(pojo),ordercount.
 *
 * XML annotations are given to each instance variable,which results while binding objects into XML
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
	
	@XmlElement(name="customer_name")
	private String name;
	@XmlElement
    private Address address;
	@XmlElement(name="num_orders")
	private int orderCount;
	@XmlElement(name="order_value")
	private float orderValue;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", orderCount=" + orderCount + ", orderValue="
				+ orderValue + "]";
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public float getOrderValue() {
		return orderValue;
	}
	public void setOrderValue(float orderValue) {
		this.orderValue = orderValue;
	}
	
	

}
