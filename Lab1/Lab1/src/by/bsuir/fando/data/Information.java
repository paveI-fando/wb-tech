package by.bsuir.fando.data;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import by.bsuir.fando.Main;
import by.bsuir.fando.entity.product.Product;
/**
 * Read from file
 * @author Fando
 *
 */

public final class Information {
	
	public static List<Product> readFromFile() {	
		List<Product> list = new ArrayList<>();
		Scanner scanner = null;а
		try {
			scanner = new Scanner(Main.FILE);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		if (scanner == null) return list;
		
		scanner.useDelimiter("\n");
		while(scanner.hasNext()) {
			String product = scanner.next();
			String temp = "";
			boolean currentField = false;
			String category = "";
			String model = "";
			String size = "";
			String price = "";
			    
			for (int i = 0; i < 4; i++) {    	
				for (int j = 0; j < product.length(); j++) {
					if (product.charAt(j) == '"' && currentField == false) {
						currentField = true;
			    		continue;
			    	} else
			    	if (product.charAt(j) == '"' && currentField == true) {
			    		product = product.substring(j+1);
			    		currentField = false;
			    		break;
			    	}
			    	temp += product.charAt(j);
			    }
			    if (i == 0) {
			    	category = temp;
			    	temp = "";
			    } else if(i == 1) {
			    	model = temp;
			    	temp = "";
			    }else if(i == 2) {
			    	size = temp;
			    	temp = "";
			    }else if(i == 3) {
			    	price = temp;
			    	temp = "";
			    	list.add(new Product(category, model, size, price));
			    }
			   }  
			}
		return list;
	}
}
