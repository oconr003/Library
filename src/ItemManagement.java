import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ItemManagement {
	
//	Library library = new Library();
	Scanner scanner = new Scanner(System.in);
	
	private ArrayList<Item> libraryRecords;
	public ItemManagement () {
		this.libraryRecords = new ArrayList<Item>();
	}
	public ArrayList<Item> getLibraryRecords() {
		return libraryRecords;
	}
	public void setLibraryRecords(ArrayList<Item> libraryRecords) {
		this.libraryRecords = libraryRecords;
	}
	
	public void addItem(Item itemToAdd) {
		this.libraryRecords.add(itemToAdd);
	}
	public void removeItem(int serialNumber) {
		for(int i=0; i<this.libraryRecords.size(); i++) {
			if (this.libraryRecords.get(i).getSerialNumber() == serialNumber) {
				this.libraryRecords.remove(i);
			}
		}
	}
	public void updatedItem(int serialNumber, String updatedName) {
		for(int i=0; i<this.libraryRecords.size(); i++) {
			if (this.libraryRecords.get(i).getSerialNumber() == serialNumber) {
				this.libraryRecords.get(i).setNameOfItem(updatedName);
			}
		}
	}

	public void checkOutAvailability (int serialNumber) {
		for (int i = 0; i<libraryRecords.size(); i++) {
			if (libraryRecords.get(i).getSerialNumber() == serialNumber) {
				libraryRecords.get(i).isAvalible = false;
			}
		}
	}
	
	public void checkInAvailability (int serialNumber) {
		for (int i = 0; i <libraryRecords.size(); i++) {
			if (libraryRecords.get(i).getSerialNumber() == serialNumber) {
				libraryRecords.get(i).isAvalible = true;
			}
		}
	}

	public void addBook () {
		{
			System.out.println("Please enter author name: ");
			String author = scanner.nextLine();
			System.out.println("Please enter title: ");
			String nameOfItem = scanner.nextLine();
			System.out.println("Please enter serial number: ");
			String userInput = scanner.next();
			int serialNumber = Integer.parseInt(userInput);
			System.out.println("Is book currently avalible? True/Fasle: ");
			Boolean isAvalible = Boolean.parseBoolean(scanner.next());
			Book newBook = new Book (author, nameOfItem, serialNumber, isAvalible);
			addItem(newBook);
			System.out.println(nameOfItem + " has been added to library records. (Author: " + author + ", Serial Number: " + serialNumber + ", Avalible? " + isAvalible + ")");
		}
	}

	public void addMap () {
		System.out.println("Please enter type of map: ");
		String typeOfMap = scanner.nextLine();
		System.out.println("Please enter title: ");
		String nameOfItem = scanner.nextLine();
		System.out.println("Please enter serial number: ");
		String userInput = scanner.next();
		int serialNumber = Integer.parseInt(userInput);
		System.out.println("Is map currently avalible? True/Fasle: ");
		Boolean isAvalible = Boolean.parseBoolean(scanner.next());
		Map newMap = new Map (typeOfMap, nameOfItem, serialNumber, isAvalible);
		addItem(newMap);
		System.out.println(nameOfItem + " has been added to library records. (Type: " + typeOfMap + ", Serial Number: " + serialNumber + ", Avalible? " + isAvalible + ")");
	}
	
	public void addNewspaper () {
		System.out.println("Please enter date of paper (dd/mm/yyyy): ");
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		boolean isDateFormatWrong = true;
		Date date = new Date();
		while (isDateFormatWrong) {
			try {
				String userInput = scanner.next();
				date = dateformat.parse(userInput);
				isDateFormatWrong = false;
			} 
			catch (ParseException e) {
				System.out.println("Please enter date in dd/mm/yyyy format.");
				e.printStackTrace();
			}	
		}		
		System.out.println("Please enter Newspaper tile: ");
		String nameOfItem = scanner.nextLine();
		System.out.println("Please enter serial number: ");
		String userInput = scanner.next();
		int serialNumber = Integer.parseInt(userInput);
		System.out.println("Is newspaper currently avalible? True/Fasle: ");
		Boolean isAvalible = Boolean.parseBoolean(scanner.next());
		Newspaper newNewspaper = new Newspaper (date, nameOfItem, serialNumber, isAvalible);
		addItem(newNewspaper);
		System.out.println(nameOfItem + " has been added to library records. (Date: " + date + ", Serial Number: " + serialNumber + ", Avalible? " + isAvalible + ")");

	}


	public void removeItem () {
		System.out.print("Enter serial number of item to remove: ");
		int serialNumber = Integer.parseInt(scanner.next());
		for(int i=0; i<getLibraryRecords().size(); i++) {
			if (getLibraryRecords().get(i).getSerialNumber() == serialNumber) {
				removeItem(serialNumber);
			}
		}
		System.out.println("Item " + serialNumber + " removed.");
	}
	
	public void updateBook () {
		System.out.println("Please enter serial number: ");
		int serialNumber1 = Integer.parseInt(scanner.next());
		System.out.println("Please enter updated title: ");
		String updatedName = scanner.nextLine();
		updatedItem(serialNumber1, updatedName);
		System.out.println("Item " + serialNumber1 + " updated to: " + updatedName);
	}

	public void updateMap () {
		System.out.println("Please enter serial number: ");
		int serialNumber1 = Integer.parseInt(scanner.next());
		System.out.println("Please enter updated title: ");
		String updatedName = scanner.nextLine();
		updatedItem(serialNumber1, updatedName);
		System.out.println("Item " + serialNumber1 + " updated to: " + updatedName);
	}
	public void updateNewspaper () {
		System.out.println("Please enter serial number: ");
		int serialNumber1 = Integer.parseInt(scanner.next());
		System.out.print("Please enter updated title: ");
		String updatedName = scanner.nextLine();
		updatedItem(serialNumber1, updatedName);
		System.out.println("Item " + serialNumber1 + " updated to: " + updatedName);
	}

	public void libraryRecordsAsFile() {
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileOutputStream("LibraryRecordsFile.txt"));
			for (Item item : libraryRecords) {
				pw.println(item);
				pw.close();
				System.out.println("Library Records printed to File: LibraryRecordsFile.txt");
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found.");
		}
	}

	public void printLibraryRecords() {
		System.out.println(libraryRecords);

	}
}





