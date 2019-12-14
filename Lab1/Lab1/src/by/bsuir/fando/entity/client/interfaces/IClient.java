package by.bsuir.fando.entity.client.interfaces;
import java.util.List;
import by.bsuir.fando.entity.product.interfaces.IProduct;
/**
 * registered user
 * @author Fando
 *
 */
public interface IClient extends IUser {
	public List<IProduct> CurrentCart = null;
	
}
