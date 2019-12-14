package by.bsuir.fando.entity.client;
import by.bsuir.fando.entity.client.interfaces.IGuest;

public class Guest extends User implements IGuest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Guest() {
		super();
	}
	
	public Guest(String login) {
		super(login);
	}

}
