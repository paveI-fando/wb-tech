package by.bsuir.fando.businessLogic;

import javax.swing.JTable;

import by.bsuir.fando.Main;
import by.bsuir.fando.Sort;
import by.bsuir.fando.entity.product.Product;
import by.bsuir.fando.ui.ObjectSingleton;

public class ProductSort {
	public void productsSort() {
		var factoryComponent = ObjectSingleton.getComponentFactory();
		int selectedRow = ((JTable) factoryComponent.getComponent("tblProducts", Main.OLD)).rowAtPoint(factoryComponent.getMouseEvent().getPoint());
		int selectedColumn = ((JTable) factoryComponent.getComponent("tblProducts", Main.OLD)).columnAtPoint(factoryComponent.getMouseEvent().getPoint());
    	
        if (factoryComponent.getLastCell()[0] == selectedRow &&
        	factoryComponent.getLastCell()[1] == selectedColumn &&
        	factoryComponent.isSortDoubleClickFlag() == false) {
        	factoryComponent.setSortDoubleClickFlag(true);
        }else 
        	if (factoryComponent.getLastCell()[0] == selectedRow &&
        		factoryComponent.getLastCell()[1] == selectedColumn &&
        		factoryComponent.isSortDoubleClickFlag() == true){
        			factoryComponent.setSortDoubleClickFlag(false);
        }else 
        	if (factoryComponent.getLastCell()[0] != selectedRow || 
        		factoryComponent.getLastCell()[1] != selectedColumn &&
        		factoryComponent.isSortDoubleClickFlag() == false) {
        			factoryComponent.setSortDoubleClickFlag(true);
        }
        
        factoryComponent.setLastCell(new int[] {selectedRow, selectedColumn});
        String[][] item = new String[Main.list.size()+1][4]; 
        String[] columnNames = {"Category", "Model", "Size", "Price"};
        for (int i = 0; i < 4; i++) {
			 item[0][i] = columnNames[i];
		 }
		 
		 int i = 1;
		 for (Product product : Main.list) {
				item[i][0] = product.getCategory();
				item[i][1] = product.getModel();
				item[i][2] = product.getSize();
				item[i][3] = product.getPrice();
				i++;
			}
        
        for (int j = 0; j < 4; j++) {
        	if (selectedRow == 0 && selectedColumn == j) {
        		Sort.bubbleSort(item, j, factoryComponent.isSortDoubleClickFlag());
        		for (i = 1; i < item.length; i++) {
    				((JTable) factoryComponent.getComponent("tblProducts", Main.OLD)).setValueAt(item[i][0], i, 0);
    				((JTable) factoryComponent.getComponent("tblProducts", Main.OLD)).setValueAt(item[i][1], i, 1);
    				((JTable) factoryComponent.getComponent("tblProducts", Main.OLD)).setValueAt(item[i][2], i, 2);
    				((JTable) factoryComponent.getComponent("tblProducts", Main.OLD)).setValueAt(item[i][3], i, 3);
    			}
        		break;
        	}
        }	
        ((JTable) factoryComponent.getComponent("tblProducts", Main.OLD)).clearSelection();
        if (factoryComponent.getLastCell()[0] != selectedRow || 
        	factoryComponent.getLastCell()[1] != selectedColumn &&
        	factoryComponent.isSortDoubleClickFlag()) {
        	factoryComponent.setSortDoubleClickFlag(false);
        }
	}
}
