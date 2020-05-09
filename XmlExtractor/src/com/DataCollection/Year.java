

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="year")
@XmlAccessorType(XmlAccessType.FIELD)

public class Year {

	@XmlElement(name="start_date")
	private String startDate;
	@XmlElement(name="end_date")
	private String endDate;
	
	public Year() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Year [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
