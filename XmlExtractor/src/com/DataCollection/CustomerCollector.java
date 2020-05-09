

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * This class collects the customer details from data base as Java List for given start and end date
 */
public class CustomerCollector {
List<Customer> customerList=null;
	
	List<Customer> getCollectorList(String startDate, String endDate) throws SQLException {
		
		DbConnector connector=new DbConnector(); 
		Connection con=connector.getConnection(); //getConnection method returnd the connection object after establishing contact with MySql DB
		customerList=new ArrayList<Customer>();
		
		try {
			Statement statement=con.createStatement();
			
			/*
			 * Below Query gets the details of every customer from given MySql Database
			 */
			String sql="select customers.customerNumber,customers.customerName,customers.addressLine1,\r\n" + 
					"					customers.city,customers.postalCode,customers.country, \r\n" + 
					"					sum(orderdetails.priceEach*orderdetails.quantityOrdered) as order_value,count(distinct(orders.orderNumber)) as num_orders\r\n" + 
					"					from csci3901.orderdetails \r\n" + 
					"					inner join orders on orders.orderNumber=orderdetails.orderNumber\r\n" + 
					"					inner join customers on orders.customerNumber=customers.customerNumber\r\n" + 
					"					where orders.status!='Cancelled' and orders.orderDate between '"+startDate+"' and '"+endDate+"'\r\n" + 
					"					group by orders.customerNumber;";
			statement.execute("use csci3901;");
			ResultSet rs=statement.executeQuery(sql); //Resultset reads each tuple of the returned table for above query
			
			while(rs.next()) {
				
				/*
				 * ResultSet data is setted to bean class of customer and address
				 */
				
				Customer customer=new Customer();
				Address address=new Address();
				customer.setName(rs.getString("customerName"));
				customer.setOrderCount(rs.getInt("num_orders"));
				customer.setOrderValue(rs.getInt("order_value"));
				address.setAddressLine1(rs.getString("addressLine1"));
				address.setCity(rs.getString("city"));
				address.setCountry(rs.getString("country"));
				address.setPostalCode(rs.getString("postalCode"));
				customer.setAddress(address);
				customerList.add(customer);
				
			}			
			
		} 
		catch (SQLException e) {
			System.out.println("SQL Query Error!");
		}
		finally {
			
			//Closing the connection
			con.close();
		}
		
		return customerList;
		
		
	}

}
