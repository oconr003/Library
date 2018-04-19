
public class Map extends Item {
	private String typeOfMap;
	
	public String getTypeOfMap() {
		return typeOfMap;
	}

	public Map (String typeOfMap, String nameOfItem, int serialNumber, boolean isAvalible) {
		super (nameOfItem, serialNumber, isAvalible);
		this.typeOfMap = typeOfMap;
	}
}
