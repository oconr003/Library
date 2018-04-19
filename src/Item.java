
public abstract class Item {
	private String nameOfItem;
	private int serialNumber;
	boolean isAvalible;

	public Item (String nameOfItem, int serialNumber, boolean isAvalible) {
		this.nameOfItem = nameOfItem;
		this.serialNumber = serialNumber;
		this.isAvalible = isAvalible;
	}

	public String getNameOfItem() {
		return nameOfItem;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public boolean isAvalible() {
		return isAvalible;
	}

	public void setNameOfItem(String nameOfItem) {
		this.nameOfItem = nameOfItem;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setAvalible(boolean isAvalible) {
		this.isAvalible = isAvalible;
	}
}