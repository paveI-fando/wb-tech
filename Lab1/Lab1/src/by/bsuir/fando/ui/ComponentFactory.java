//TODO should throw new exception if can't find Component 
/**
 * This class give Components to ui forms and store data about last state 
 * @author Fando
 * 
 */
package by.bsuir.fando.ui;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import by.bsuir.fando.Main;
import by.bsuir.fando.businessLogic.ProductSort;
import by.bsuir.fando.businessLogic.Search;
import by.bsuir.fando.businessLogic.Switcher;
import by.bsuir.fando.entity.product.Product;

public class ComponentFactory {
	
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JTextField txtFieldLogin;
	private JTextField txtFieldPassword;
	private JButton btnSignIn;
	private JButton btnGoBack;
	//-------------------------------------------
	private JTextField txtFieldSearch;
	private JButton btnSearch;
	private JButton btnGoToLogInPage;
	private JTable tblProducts;
	private JTable tblForSearch;
	private int [] lastCell = new int[2];
	private boolean sortDoubleClickFlag = false;
	private String[] columnNames = {"Category", "Model", "Size", "Price"};
	private MouseEvent mouseEvent;


	/**
	 * 
	 * @param component : to create Component
	 * @return new Component
	 */
	public Component getComponent(String component) {
		if (component.equals("lblLogin")) {
				lblLogin = new JLabel("Login");
				return lblLogin;
			}
		if (component.equals("btnGoBack")) {
			btnGoBack = new JButton("Go Back");
			btnGoBack.addActionListener(e->{
				PanelFactory panelFactory = ObjectSingleton.getFactoryPanel();
				Main.frame.remove(panelFactory.getPanel("pnlAuth", Main.OLD));
				Main.frame.getContentPane().add(panelFactory.getPanel("pnlGuest", Main.OLD));
				Main.frame.setVisible(true);
		        Main.frame.pack();
		        
		});
			return btnGoBack;
		}
		if (component.equals("lblPassword")) {
			lblPassword = new JLabel("Password");
			return lblPassword;
		}
		if (component.equals("txtFieldLogin")) {
			txtFieldLogin = new JTextField("");
			txtFieldLogin.setColumns(10);
			txtFieldPassword = new JTextField("");
			txtFieldPassword.setColumns(10);
			return txtFieldLogin;
		}
		if (component.equals("txtFieldPassword")) {
			txtFieldPassword = new JTextField("");
			txtFieldPassword.setColumns(10);
			return txtFieldPassword;
		}
		if (component.equals("btnSignIn")) {
			btnSignIn = new JButton("Sign In");
			btnSignIn.addActionListener(e->{
				//TODO Autorization
		        if (!txtFieldLogin.getText().equals("") && txtFieldPassword.getText().equals("")) {
		        	Main.frame.setVisible(true);
			        Main.frame.pack();
		        }
		});
		return btnSignIn;
		}
		//GuestPanel------------------------------------------------
		if (component.equals("txtFieldSearch")) {
			txtFieldSearch = new JTextField();
			txtFieldSearch.setColumns(30);
			return txtFieldSearch;
		}
		
		if (component.equals("btnSearch")) {
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(e->{
				Search search = new Search();
				search.productSearch();
			});
			return btnSearch;
		}
		if (component.equals("btnGoToLogInPage")) {
			btnGoToLogInPage = new JButton("Log in page");
			btnGoToLogInPage.addActionListener(e->{
				Switcher switcher = new Switcher();
				switcher.switchToLogInPage();
			});
			return btnGoToLogInPage;
		}
		
		if (component.equals("tblForSearch")) {
			String[] columnNames = {"Category", "Model", "Size", "Price"};
			tblForSearch = new JTable(new String[Main.list.size()+1][columnNames.length], columnNames);
			for (int i = 0; i < 4; i++) {
				 tblForSearch.setValueAt(columnNames[i], 0, i);
			 }
			
			/*TODO Add to cart
			tblForSearch.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent evt) {
					
				}
			}*/
			return tblForSearch;
		}
		//TODO find out how to create normal architecture
		if (component.equals("tblProducts")) {
			/*
			 * TODO array "item" just to define tblProducts; rewrite this part with list
			 */
			String[][] item = new String[Main.list.size()+1][4]; 
			
			 
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
			
			tblProducts = new JTable(item, columnNames);
			for (i = 1; i < item.length; i++) {
				tblProducts.setValueAt(item[i][0], i, 0);
				tblProducts.setValueAt(item[i][1], i, 1);
				tblProducts.setValueAt(item[i][2], i, 2);
				tblProducts.setValueAt(item[i][3], i, 3);
			}
			tblProducts.setCellSelectionEnabled(true);
			tblProducts.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent event) {
					mouseEvent = event;
					ProductSort productSort = new ProductSort();
					productSort.productsSort();
					mouseEvent = null;
				}
			}
		);
			return tblProducts;
		}
		// TODO ComponentFactory.java : create new exception "Can't find component : "+ component;
		return null;
	}
	
	/**
	 * 
	 * @param isOld : if you want to get last state
	 * @return
	 */
	
	public Component getComponent(String component, boolean isOld) {
		if (component.equals("lblLogin")) return lblLogin;
		if (component.equals("lblPassword")) return lblPassword;
		if (component.equals("btnSignIn")) return btnSignIn;
		if (component.equals("btnGoBack")) return btnGoBack;
		if (component.equals("txtFieldLogin")) return txtFieldLogin;
		if (component.equals("txtFieldPassword")) return txtFieldPassword;
		if (component.equals("txtFieldSearch")) return txtFieldSearch;
		if (component.equals("btnSearch")) return btnSearch;
		if (component.equals("btnGoToLogInPage")) return btnGoToLogInPage;
		if (component.equals("tblProducts")) return tblProducts;
		if (component.equals("tblForSearch")) return tblForSearch;
		// TODO ComponentFactory.java : create new exception "Can't find component : "+ component;
		return null;
	}

	public MouseEvent getMouseEvent() {
		return mouseEvent;
	}

	public int [] getLastCell() {
		return lastCell;
	}

	public void setLastCell(int [] lastCell) {
		this.lastCell = lastCell;
	}

	public boolean isSortDoubleClickFlag() {
		return sortDoubleClickFlag;
	}

	public void setSortDoubleClickFlag(boolean sortDoubleClickFlag) {
		this.sortDoubleClickFlag = sortDoubleClickFlag;
	}
}
