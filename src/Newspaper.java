import java.util.Date;

public class Newspaper extends Item {
	private Date date;
	
	public Date getDate() {
		return date;
	}

	public Newspaper (Date date, String nameOfItem, int serialNumber, boolean isAvalible) {
		super (nameOfItem, serialNumber, isAvalible);
		this.date = date; 										// class variable equals the parameter variable as p variable only exists within scope
																// this.date exists for the whole object
	}
}
