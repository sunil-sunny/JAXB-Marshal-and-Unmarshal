

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * This pojo class is designed with variables street address,city,postal code,country
 * 
 * XML annotations are given to each instance variable,which results while binding objects into XML
 */
@XmlRootElement(name="address")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
	
	@XmlElement(name="street_address")
	private String addressLine1;
	@XmlElement
	private String city;
	@XmlElement(name="postal_code")
	private String postalCode;
	@XmlElement
	String country;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", city=" + city + ", postalCode=" + postalCode + ", country="
				+ country + "]";
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	

}
