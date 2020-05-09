

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * This pojo class is designed with variables productname,product vendor,unitsSold,total_sales
 * 
 * XML annotations are given to each instance variable,which results while binding objects into XML
 */

@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDetails {
	
	
	@XmlElement
	private String product_name;
	@XmlElement
	private String product_vendor;
	@XmlElement
	private int units_sold;
	@XmlElement
	private float total_sales;
	

	
	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_vendor() {
		return product_vendor;
	}
	public void setProduct_vendor(String product_vendor) {
		this.product_vendor = product_vendor;
	}
	public int getUnits_sold() {
		return units_sold;
	}
	public void setUnits_sold(int units_sold) {
		this.units_sold = units_sold;
	}
	public float getTotal_sales() {
		return total_sales;
	}
	public void setTotal_sales(float total_sales) {
		this.total_sales = total_sales;
	}
	

	@Override
	public String toString() {
		return "Productdetails [product_name=" + product_name + ", product_vendor=" + product_vendor + ", units_sold="
				+ units_sold + ", total_sales=" + total_sales + "]";
	}
}
