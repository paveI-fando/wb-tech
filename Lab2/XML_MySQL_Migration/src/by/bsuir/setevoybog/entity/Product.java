package by.bsuir.fando.entity;

public class Product {
	private String attribute;
	private String title;
	private FullName fullName;
	private double price;
	private int amount;
	
	public Product(String attribute, String title, FullName fullName, double price, int amount) {
		setAttribute(attribute);
		setTitle(title);
		setFullName(fullName);
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

	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
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

	@Override
	public String toString() {
		return "Product [attribute=" + attribute + ", title=" + title + ", fullName=" + fullName.toString() + ", price=" + price
				+ ", amount=" + amount + "]";
	}
	
	
	
	
}