package by.bsuir.fando.businessLogic;

import by.bsuir.fando.Main;
import by.bsuir.fando.ui.AuthorizationPanel;
import by.bsuir.fando.ui.ObjectSingleton;
import by.bsuir.fando.ui.PanelFactory;

public class Switcher {
	public void switchToLogInPage() {
		PanelFactory panelFactory = ObjectSingleton.getFactoryPanel();
		Main.frame.remove(panelFactory.getPanel("pnlGuest", Main.OLD));
		//TODO rewrite "new AuthorizationPanel" with ClassFactory
		new AuthorizationPanel();
		Main.frame.getContentPane().add(panelFactory.getPanel("pnlAuth", Main.OLD));
		Main.frame.setVisible(true);
        Main.frame.pack();
	}
}
