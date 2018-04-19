import java.util.ArrayList;

public class People {

	private String forename;
	private String surname;
	private static int counter = 0;
	private int iD;
	private ArrayList<Integer> itemRecords;		
	

	public People (String forename, String surname, int iD, ArrayList<Integer> itemRecords) {
		this.forename = forename;
		this.surname = surname;
		counter++;
		this.iD = counter;
		
		this.itemRecords = new ArrayList<Integer>();    //??
	}
	
	public void addSerialNumber (int serialNumberToAdd) {	
		this.itemRecords.add(serialNumberToAdd);	
	}
	
	public void removeSerialNumber (int serialNumberToRemove) {
		for (int i = 0; i < this.itemRecords.size(); i++) {
			if (this.itemRecords.get(i) == serialNumberToRemove) {
				this.itemRecords.remove(i);
			}
		}
	}
	
	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	
	public ArrayList<Integer> getItemRecords() {
		return itemRecords;
	}

	
	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		People.counter = counter;
	}

	public void setItemRecords(ArrayList<Integer> itemRecords) {
		this.itemRecords = itemRecords;
	}


}
