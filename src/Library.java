
public class Library {
	private PeopleManagement peopleManagement;					//class varibles to use from library
	private ItemManagement itemManagement;

	public Library () {
		this.peopleManagement = new PeopleManagement();
		this.itemManagement = new ItemManagement();
	}

	public PeopleManagement getPeopleManagement() {
		return peopleManagement;
	}

	public void setPeopleManagement(PeopleManagement peopleManagement) {
		this.peopleManagement = peopleManagement;
	}

	public ItemManagement getItemManagement() {
		return itemManagement;
	}

	public void setItemManagement(ItemManagement itemManagement) {
		this.itemManagement = itemManagement;
	}
	
	
}
