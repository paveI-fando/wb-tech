package by.bsuir.fando.entity.product;
import java.io.Serializable;
import by.bsuir.fando.entity.product.interfaces.IProduct;
/**
 * current product in table
 * @author Fando
 *
 */
public class Product implements IProduct, Serializable {
	//TODO Override equals(), hashCode() and toString() 
	private static final long serialVersionUID = 1L;
	private String category;
	private String model;
	private String size;
	private String price;
	
	public Product() {
		category = "";
		model = "";
		size = "";
		price = "";
	}
	
	public Product(String category, String model, String size, String price ) {
		setCategory(category);
		setModel(model);
		setSize(size);
		setPrice(price);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}