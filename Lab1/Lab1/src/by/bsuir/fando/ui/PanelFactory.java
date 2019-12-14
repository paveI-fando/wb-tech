package by.bsuir.fando.ui;

import javax.swing.JPanel;

//TODO PanelFactory.java : divide factory from lite memento
/**
 * factory to create panels and store last state
 * @author Fando
 *
 */
public class PanelFactory {
	
	private JPanel pnlAuth;
	private JPanel pnlGuest;
	
	
	public JPanel getPanel(String panel){
		if (panel.equals("pnlAuth")) {

			pnlAuth = new JPanel();
			pnlAuth.setVisible(true);
			return pnlAuth;
		}else if (panel.equals("pnlGuest")) {
		
			pnlGuest = new JPanel();
			pnlGuest.setVisible(true);
			return pnlGuest;
		}
		// TODO PanelFactory.java : create new exception "Can't find component : "+ component;
		return null;
	}
	
	public JPanel getPanel(String panel, boolean isOld) {
		if (panel.equals("pnlAuth")) return pnlAuth;
		if (panel.equals("pnlGuest")) return pnlGuest;
		// TODO PanelFactory.java : create new exception "Can't find component : "+ component;
		return null;
	}
}
