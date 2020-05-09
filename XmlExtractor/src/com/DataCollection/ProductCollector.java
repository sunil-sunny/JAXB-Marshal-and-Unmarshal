

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * This class collects ProductCollector data from MySQL DB and stores in to the product bean list
 */
public class ProductCollector {
	
List<Product> productList=null;
	
	List<Product> getCollectorList(String startDate, String endDate) throws SQLException {
		DbConnector connector=new DbConnector();
		Connection con=connector.getConnection();//gets connection object after establising connection with DB
		productList=new ArrayList<Product>();
		
		try {
			Statement statement=con.createStatement();
			/*
			 * Below query collects all the prdoct details from DB
			 */
			String sql="  select p.productCode,p.productLine,p.productName,p.productVendor,sum(distinct(od.quantityOrdered)) as units_sold,\r\n" + 
					"					(od.quantityOrdered*od.priceEach) as total_price\r\n" + 
					"					from orders as o\r\n" + 
					"					inner join orderdetails as od on o.orderNumber=od.orderNumber \r\n" + 
					"					inner join products as p on od.productCode=p.productCode\r\n" + 
					"                    where o.status!='Cancelled' and o.orderDate between '"+startDate+"' and '"+endDate+"'\r\n" + 
					"					group by p.productCode;";
			statement.execute("use csci3901;");
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				
				//The data from result set is read and loaded into product bean class
				
				Product p=checkProductLine(rs.getString("productLine"));//checkProductLine method checks if the same productLine exists or not
				
				if(p!=null) {
					//if the product line exists,the add the product details and add it to the corresponding list
					ProductDetails productDetails=new ProductDetails();
					List<ProductDetails> listProductDetails=p.getProductDetails();
					productDetails.setProduct_name(rs.getString("productName"));
					productDetails.setProduct_vendor(rs.getString("productVendor"));
					productDetails.setTotal_sales(rs.getFloat("total_price"));
					productDetails.setUnits_sold(rs.getInt("units_sold"));
					listProductDetails.add(productDetails);
					p.setProductDetails(listProductDetails);
					
					
				}
				else {
					//if product is null,create new instance and add the product lines
					Product product=new Product();
					ProductDetails productDetails=new ProductDetails();
					List<ProductDetails> listProductDetails=new ArrayList<ProductDetails>();
					product.setProductLineName(rs.getString("productLine"));
					productDetails.setProduct_name(rs.getString("productName"));
					productDetails.setProduct_vendor(rs.getString("productVendor"));
					productDetails.setTotal_sales(rs.getFloat("total_price"));
					productDetails.setUnits_sold(rs.getInt("units_sold"));
					listProductDetails.add(productDetails);
					product.setProductDetails(listProductDetails);
					productList.add(product);
				}
				
				
				
				
			}			
			
		} 
		catch (SQLException e) {
			System.out.println("SQL Error");
		}
		finally {
			
			con.close();
		}
		
		return productList;
		
		
	}
	

	private Product checkProductLine(String string) {
		
		for(Product product:productList) {
			
			if(product.getProductLineName().equals(string)) {
				return product;
			}
			
		}
		return null;
		
	}

}
