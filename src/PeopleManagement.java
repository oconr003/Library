import java.util.ArrayList;
import java.util.Scanner;

public class PeopleManagement {
	
//	Library library = new Library();
	Scanner scanner = new Scanner(System.in);
	
	private ArrayList<People> userRecords;								
	public PeopleManagement () {								// constructor for the array		
		this.userRecords = new ArrayList<People>();
	}
	
	public ArrayList<People> getUserRecords() {
		return userRecords;
	}
	
	public void setUserRecords(ArrayList<People> userRecords) {
		this.userRecords = userRecords;
	}
	
	public void addUser (People newUser) {
		this.userRecords.add(newUser);						// use this. as referring to class variable 
	}
	
	public void removeUser (int iDToRemove) {
		 for (int i = 0; i < userRecords.size(); i++) {
			 if (userRecords.get(i).getiD() == iDToRemove) {
				 userRecords.remove(i);
			 }
		 }
	}
	
	public void updateUser (int iDToUpdate, String updatedForename, String updatedSurname) {
		for (int i = 0; i < userRecords.size(); i++) {
			if (userRecords.get(i).getiD() == iDToUpdate) {
				userRecords.get(i).setForename(updatedForename);
				userRecords.get(i).setSurname(updatedSurname);
			}
		}
	}
	
	public void checkOutUserRecords (int userIDofRecord, int serialNumber) {

		for (int i = 0; i<userRecords.size(); i++) {
			if (userRecords.get(i).getiD() == userIDofRecord) {
				userRecords.get(i).addSerialNumber(serialNumber);						//uses addSerialNumer in People to add serial number to itemRecords
			} 	
		}
	}
	
	public void checkInUserRecords (int userIDofRecord, int serialNumber) {
		
		for (int i = 0; i<userRecords.size(); i++) {
			if (userRecords.get(i).getiD() == userIDofRecord) {
				userRecords.get(i).removeSerialNumber(serialNumber);
			}
		}
	}
	

	public void registerNewUser() {
		System.out.print("Enter forename: ");
		String forename = scanner.next();
		System.out.print("Enter surname: ");
		String surname = scanner.next();
		ArrayList<Integer> itemRecords = new ArrayList<Integer>();
		int iD = People.getCounter();
		People newPerson = new People(forename, surname, iD, itemRecords);	
		addUser(newPerson);
		System.out.println("Registered: " + newPerson);
		// newPerson returns as People@7a79be86
	}

	public void removeUserFromMain () {
		System.out.print("Enter User's ID: ");
		int iDToRemove = Integer.parseInt(scanner.next());
		boolean isIdInvalid = true;
		for(int i=0; i<getUserRecords().size(); i++) {
			if (getUserRecords().get(i).getiD() == iDToRemove) {
				removeUser(iDToRemove);
				isIdInvalid = false;
				System.out.println("User removed from Records");
			}
		}	
		if (isIdInvalid) {		
			System.out.println("Invalid id");
		}
	}

	public void updateUserFromMain () {
		System.out.println("Enter current user ID: ");
		int iDToUpdate = Integer.parseInt(scanner.next());
		System.out.print("Enter new forename: ");
		String updatedForename = scanner.next();
		System.out.print("Enter new surname: ");
		String updatedSurname = scanner.next();
		for(int i=0; i<getUserRecords().size(); i++) {
			if (getUserRecords().get(i).getiD() == iDToUpdate) {
				updateUser(iDToUpdate, updatedForename, updatedSurname);
			}
		}
		System.out.println("User "+ iDToUpdate + " has been updated: " + updatedForename + " " + updatedSurname);
	}
	public void printUserRecords() {
		System.out.println(userRecords);
	}

}

