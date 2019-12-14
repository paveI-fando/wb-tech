package by.bsuir.fando.businessLogic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;

import by.bsuir.fando.Main;
import by.bsuir.fando.entity.product.Product;
import by.bsuir.fando.ui.ComponentFactory;
import by.bsuir.fando.ui.ObjectSingleton;

public class Search {
	public List<Product> productSearch() {
		//TODO divide to different methods
		ComponentFactory componentFactory = ObjectSingleton.getComponentFactory();
		//How to make it without cast?
		JTextField txtFieldSearch = (JTextField)componentFactory.getComponent("txtFieldSearch", Main.OLD);
		String request = txtFieldSearch.getText();

		List<Product> foundProducts = new ArrayList<>();
		
		for (Product product : Main.list) {
			if (request.equals(product.getCategory()) ||
				request.equals(product.getModel()) ||
				request.equals(product.getSize()) ||
				request.equals(product.getPrice())) {
					foundProducts.add(product);
			}
		}
		//How to make it without cast?
		JTable tblForSearch = (JTable)componentFactory.getComponent("tblForSearch", true);
		int rowCount = tblForSearch.getRowCount() ;
		for (int i = 1; i < rowCount; i++)
			for (int j = 0; j < 4; j++)
				tblForSearch.setValueAt("", i, j);
		
		int i = 1;
		for (Product product : foundProducts) {
			tblForSearch.setValueAt(product.getCategory(), i, 0);
			tblForSearch.setValueAt(product.getModel(), i, 1);
			tblForSearch.setValueAt(product.getSize(), i, 2);
			tblForSearch.setValueAt(product.getPrice(), i, 3);
			i++;
		}
		return foundProducts;
	}
}
