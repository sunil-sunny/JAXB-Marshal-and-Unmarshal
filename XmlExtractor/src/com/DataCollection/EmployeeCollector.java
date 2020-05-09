

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * This class collects EmployeeCollector data from MySQL DB and stores in to the Employee bean list
 */
public class EmployeeCollector {
List<Employee> employeeList=null;
	
	List<Employee> getCollectorList(String startDate, String endDate) throws SQLException {
		DbConnector connector=new DbConnector();
		Connection con=connector.getConnection(); //getConnection method returnd the connection object after establising connection with DB
		employeeList=new ArrayList<Employee>(); //instantiatind employeeList
		
		try {
			Statement statement=con.createStatement();
			/*
			 * Below query gathers all the information of staff 
			 */
			String sql="select o.orderNumber,e.firstName,e.lastName,off.city,count(distinct(c.customerNumber)) as active_customer,sum(od.quantityOrdered*priceEach) as total_sales \r\n" + 
					"					from orders as o \r\n" + 
					"					inner join customers as c on o.customerNumber=c.customerNumber\r\n" + 
					"					inner join orderdetails as od on o.orderNumber=od.orderNumber \r\n" + 
					"					inner join  employees as e on c.salesRepEmployeeNumber=e.employeeNumber\r\n" + 
					"					inner join offices as off on e.officeCode=off.officeCode\r\n" + 
					"					where o.status!='Cancelled' and o.orderDate between '"+startDate+"' and '"+endDate+"'\r\n" + 
					"					group by o.orderNumber;";
			statement.execute("use csci3901;");
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				/*
				 * Resultset date is stores in the emplyee bean classes and stores into a list
				 */
				Employee employee=new Employee();
				employee.setFirst_name(rs.getString("firstName"));
				employee.setLast_name(rs.getString("lastName"));
				employee.setOffice_city(rs.getString("city"));
				employee.setActive_customers(rs.getInt("active_customer"));
				employee.setTotal_sales(rs.getFloat("total_sales"));
				employeeList.add(employee);
				
				
			}			
			
		} 
		catch (SQLException e) {
			System.out.println("SQL error");
		}
		finally {
			//closing connection
			
			con.close();
		}
		
		return employeeList;
		
		
	}


}
