

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/*
 * This pojo class is designed with variables productLineName and list of productDetails(pojo)
 * 
 * XML annotations are given to each instance variable,which results while binding objects into XML
 */

@XmlRootElement(name="product_set")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
	
	 @XmlElement(name="product_line_name")
	private String productLineName;
	 @XmlElement(name="product")
	private List<ProductDetails> productDetails;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProductLineName() {
		return productLineName;
	}
	public void setProductLineName(String productLineName) {
		this.productLineName = productLineName;
	}
	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}
	@Override
	public String toString() {
		return "Product [productLineName=" + productLineName + ", productDetails=" + productDetails + "]";
	}
	
	
}
