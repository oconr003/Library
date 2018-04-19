import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;							
import java.util.Date;
import java.util.Scanner;

public class LibUser {

	public static void main(String[] args) {
		Library library = new Library();	
	    Scanner scanner = new Scanner(System.in);
	    
	    // add user ID to be printed to screen after register new user
	    boolean hasUserQuit = false;
		do {
	    		System.out.println("Welcome to the library. You have 12 options to choose from:");
	    		System.out.println("Please enter 1 to register a new user.");
	    		System.out.println("Please enter 2 to remove a user.");
	    		System.out.println("Please enter 3 to update a user.");
	    		System.out.println("Please enter 4 to add a new item.");
	    		System.out.println("Please enter 5 to remove an item.");
	    		System.out.println("Please enter 6 to update an item.");
	    		System.out.println("Please enter 7 to check in an item.");
	    		System.out.println("Please enter 8 to check out an item.");
	    		System.out.println("Please enter 9 to print library and user records.");
	    		System.out.println("Please enter 10 to print library records to file");
	    		System.out.println("Please enter 11 to load library records from file");
	    		System.out.println("Please enter Q to exit.");
	    		System.out.print("Please enter your menu option: ");
	    		
	    		String menuOption = scanner.next();
	    		
	    		switch(menuOption) {
				case "1":
					library.getPeopleManagement().registerNewUser();
					break;
				case "2":
					library.getPeopleManagement().removeUserFromMain();
					break;
				case "3":
					library.getPeopleManagement().updateUserFromMain();
					break;
				case "4":
					System.out.println("What type of item would you like to add to records? Book, Map or Newspaper?");
					String itemToAdd = scanner.next();
					if (itemToAdd.equals("Book")) {
						library.getItemManagement().addBook();
					}
					if (itemToAdd.equals("Map")) {
						library.getItemManagement().addMap();
					}
					if (itemToAdd.equals("Newspaper")) {
						library.getItemManagement().addNewspaper();
					}
					System.out.println(library.getItemManagement().getLibraryRecords().size());
					break;
				case "5":
					library.getItemManagement().removeItem();
					System.out.println(library.getItemManagement().getLibraryRecords().size());
					break;
				case "6":
					System.out.println("What type of item would you like to update? Book, Map or Newspaper?");
					String itemToUpdate = scanner.next();
					if (itemToUpdate == "Book") {
						library.getItemManagement().updateBook();
					}
					if (itemToUpdate == "Map") {
						library.getItemManagement().updateMap();
					}
					if  (itemToUpdate == "Newspaper") {
						library.getItemManagement().updateNewspaper();
													
					} else {
						System.out.println("Make sure to capslock first letter of Item.");
					}
					break;
				case "7":
					System.out.println("Please enter ID of user checking in item: ");
					int userIDofRecord = Integer.parseInt(scanner.next());
					System.out.println("Please enter serial number of item to check in: ");
					int serialNumber = Integer.parseInt(scanner.next());
					
					library.getPeopleManagement().checkInUserRecords(userIDofRecord, serialNumber);
					library.getItemManagement().checkInAvailability(serialNumber);
					System.out.println(library.getPeopleManagement().getUserRecords().get(0).getItemRecords().size());
					System.out.println(library.getItemManagement().getLibraryRecords().get(0).isAvalible);
					break;
				case "8":
					System.out.println("Please enter ID of user checking out item: ");
					int userIDofRecord1 = Integer.parseInt(scanner.next());
					System.out.println("Please enter serial number of item to check out: ");
					int serialNumber1 = Integer.parseInt(scanner.next());
					
					library.getPeopleManagement().checkOutUserRecords(userIDofRecord1, serialNumber1);
					library.getItemManagement().checkOutAvailability(serialNumber1);
					System.out.println(library.getPeopleManagement().getUserRecords().get(0).getItemRecords().get(0));
					System.out.println(library.getItemManagement().getLibraryRecords().get(0).isAvalible);
					break;
// Currently printing out items as 1233@hsafhaskhf	... toString()			
				case "9":
					System.out.println("Library Records of Items:");
					library.getItemManagement().printLibraryRecords();
					System.out.println("User Records: ");
					library.getPeopleManagement().printUserRecords();
					break;
				case "10":
					library.getItemManagement().libraryRecordsAsFile();
					break;
				case "Q":
					hasUserQuit = true;
					System.out.println("You have quit!");
					break;
				default:
					System.out.println("You have entered an incorrect menu option.");
			}
	    		 	    		 
	     } while(!hasUserQuit);
	    
	}
}


		

