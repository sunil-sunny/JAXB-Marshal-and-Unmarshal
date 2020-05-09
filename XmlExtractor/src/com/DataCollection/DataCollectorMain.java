

import java.io.File;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/*
 * This is the main class which converts the data collected from DB to XML file
 */

public class DataCollectorMain {
	
	public static void main(String args[]) {
		
		Scanner sc=new Scanner(System.in);
		String startDate=null;
		String endDate=null;
		String fileName= null;
		String regexFileName="^[a-z A-Z]*[0-9]*[-_]*{1}";
		boolean flag;
		SummaryList summary=new SummaryList();
		CustomerCollector customerCollector=new CustomerCollector(); //intsance to get customer list from db
		ProductCollector productCollector=new ProductCollector(); //instance to get product list from db
		EmployeeCollector employeeCollector=new EmployeeCollector(); //instance to get staff list from db
		do {
			flag=false;
		try {
			System.out.println("Enter starting date in yyyy-mm-dd fomrat:");
			startDate=sc.next();//reading startDate from user
			DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(startDate); //Checking if date is in correct format or not
			System.out.println("Enter ending date in yyyy-mm-dd format:");
			endDate=sc.next(); //reading endDate from user
			DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(endDate); //Checking if date is in correct format or not
			boolean nameValidationFalg=true;
			do{
				System.out.println("Enter name of the output file:");
				fileName=sc.next();
				nameValidationFalg=Pattern.compile(regexFileName).matcher(fileName).matches();
				if(nameValidationFalg==false) {
					
					System.out.println("Enter Valid file name");
					
				}
			}while(nameValidationFalg==false);
			
			fileName=fileName+".xml";//reading filename to store the xml content
			/*
			 * All the below lists are the results of method getCollectorList in EmployeeColletor,ProductCollector,
			 * EmployeeCollector classes
			 */
			List<Customer> customerList=customerCollector.getCollectorList(startDate, endDate);
			List<Product> productList=productCollector.getCollectorList(startDate, endDate);
			List<Employee> employeeList=employeeCollector.getCollectorList(startDate, endDate);
			summary.setCustomer_list(customerList);
			summary.setProduct_list(productList);
			summary.setStaff_list(employeeList);
			//Marshalling the object into XML using jaxb
			JAXBContext context=JAXBContext.newInstance(SummaryList.class);
			Marshaller m = context.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); //This line makes the XML in good readable format
	        m.marshal(summary, new File(fileName));
		} catch (SQLException e) {
		
			System.out.println("Error in SQL");
		}
		catch(JAXBException e) {
			
			System.out.println("Error in creating jaxb instance");
		}
		catch(DateTimeParseException e) {
			//Handling the ecception when user enters wrong formar of date and let user enter the date again in correct format
			flag=true;
			System.out.println("Invalid date..Go again !!");
		}
	
		} while(flag);
		sc.close();
	}

}
