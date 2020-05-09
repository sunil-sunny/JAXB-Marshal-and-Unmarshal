

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * This pojo class is the main head class designed with variables to store all the customer list,staff list and product list.
 * 
 * XML annotations are given to each instance variable,which results while binding objects into XML
 */

@XmlRootElement(name = "year_end_summary")
@XmlAccessorType(XmlAccessType.FIELD)
public class SummaryList {

	@XmlElement(name = "year")
	private Year year;

	@XmlElementWrapper(name = "customer_list")
	@XmlElement(name = "customer")
	private List<Customer> customer_list;

	@XmlElementWrapper(name = "product_list")
	@XmlElement(name = "product_set")
	private List<Product> product_list;

	@XmlElementWrapper(name = "staff_list")
	@XmlElement(name = "employee")
	private List<Employee> staff_list;

	/**
	 * 
	 */
	public SummaryList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param year
	 * @param customer_list
	 * @param product_list
	 * @param staff_list
	 */
	public SummaryList(Year year, List<Customer> customer_list, List<Product> product_list, List<Employee> staff_list) {
		super();
		this.year = year;
		this.customer_list = customer_list;
		this.product_list = product_list;
		this.staff_list = staff_list;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public List<Customer> getCustomer_list() {
		return customer_list;
	}

	public void setCustomer_list(List<Customer> customer_list) {
		this.customer_list = customer_list;
	}

	public List<Product> getProduct_list() {
		return product_list;
	}

	public void setProduct_list(List<Product> product_list) {
		this.product_list = product_list;
	}

	public List<Employee> getStaff_list() {
		return staff_list;
	}

	public void setStaff_list(List<Employee> staff_list) {
		this.staff_list = staff_list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer_list == null) ? 0 : customer_list.hashCode());
		result = prime * result + ((product_list == null) ? 0 : product_list.hashCode());
		result = prime * result + ((staff_list == null) ? 0 : staff_list.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SummaryList other = (SummaryList) obj;
		if (customer_list == null) {
			if (other.customer_list != null)
				return false;
		} else if (!customer_list.equals(other.customer_list))
			return false;
		if (product_list == null) {
			if (other.product_list != null)
				return false;
		} else if (!product_list.equals(other.product_list))
			return false;
		if (staff_list == null) {
			if (other.staff_list != null)
				return false;
		} else if (!staff_list.equals(other.staff_list))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SummaryList [year=" + year + ", customer_list=" + customer_list + ", product_list=" + product_list
				+ ", staff_list=" + staff_list + "]";
	}

}
