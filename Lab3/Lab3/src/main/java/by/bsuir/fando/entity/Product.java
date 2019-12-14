package by.bsuir.fando.entity;

public class Product {
	private String attribute;
	private String title;
	private String manufacturer;
	private String model;
	private double price;
	private int amount;

	public Product(String attribute, String title, String manufacturer, String model, double price, int amount) {
		setAttribute(attribute);
		setTitle(title);
		setManufacturer(manufacturer);
		setModel(model);
		setPrice(price);
		setAmount(amount);
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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
		return attribute + " " + title + " " + manufacturer + " "
				+ model + " " + price + " " + amount;
	}

}