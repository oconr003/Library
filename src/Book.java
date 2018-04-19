
public class Book extends Item {
	private String author;
	
	public String getAuthor() {
		return author;
	}


	public Book (String author, String nameOfItem, int serialNumber, boolean isAvalible) {
		super (nameOfItem, serialNumber, isAvalible);
		this.author = author;
	}
}
