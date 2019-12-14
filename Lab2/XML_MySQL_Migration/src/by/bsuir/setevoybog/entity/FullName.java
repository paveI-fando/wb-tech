package by.bsuir.fando.entity;

public class FullName {
	private String manufacturer;
	private String model;
	
	public FullName(String manufacturer, String model) {
		setManufacturer(manufacturer);
		setModel(model);
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "FullName [manufacturer=" + manufacturer + ", model=" + model + "]";
	}
	
	
	
}
