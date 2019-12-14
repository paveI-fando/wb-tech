package by.bsuir.fando;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import by.bsuir.fando.data.Information;
import by.bsuir.fando.entity.client.User;
import by.bsuir.fando.entity.product.Product;
import by.bsuir.fando.ui.GuestPanel;
import by.bsuir.fando.ui.ObjectSingleton;

public class Main {
	
	public static final boolean OLD = true;
	public static final JFrame frame = new JFrame("�������");
	public final static File FILE = new File("src/by/bsuir/fando/resources/products.txt");
	public static List<Product> list = Information.readFromFile();
	public User user;
	
	public static void main(String[] args) {
		var factoryComponent = ObjectSingleton.getComponentFactory();
		var factoryPanel = ObjectSingleton.getFactoryPanel();
		new GuestPanel();
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(factoryPanel.getPanel("pnlGuest",  OLD));
        frame.setVisible(true);
        frame.pack();
	}
}
