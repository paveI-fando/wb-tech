package by.bsuir.fando.ui;

import by.bsuir.fando.ui.interfaces.Panel;

/**
 * Guest panel
 * @author Fando
 *
 */
public class GuestPanel implements Panel {
	
	public GuestPanel() {
		initialize();
	}

	private void initialize() {
		var factoryComponent = ObjectSingleton.getComponentFactory();
		var factoryPanel = ObjectSingleton.getFactoryPanel();
		var guestPanel = factoryPanel.getPanel("pnlGuest");
		guestPanel.add(factoryComponent.getComponent("txtFieldSearch"));
		guestPanel.add(factoryComponent.getComponent("tblForSearch"));
		guestPanel.add(factoryComponent.getComponent("tblProducts"));
		guestPanel.add(factoryComponent.getComponent("btnSearch"));
		guestPanel.add(factoryComponent.getComponent("btnGoToLogInPage"));
	}
}
