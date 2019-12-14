package by.bsuir.fando.ui;

import by.bsuir.fando.ui.interfaces.Panel;

/**
 * Authorization Panel
 * @author Fando
 *
 */
public class AuthorizationPanel implements Panel {
	
	public AuthorizationPanel(){
		initialize();
	}
	
	public void initialize() {
		var factoryComponent = ObjectSingleton.getComponentFactory();
		var factoryPanel = ObjectSingleton.getFactoryPanel();
		var pnlAuth = factoryPanel.getPanel("pnlAuth");
		
		pnlAuth.add(factoryComponent.getComponent("lblLogin"));
		pnlAuth.add(factoryComponent.getComponent("txtFieldLogin"));
		pnlAuth.add(factoryComponent.getComponent("lblPassword"));
		pnlAuth.add(factoryComponent.getComponent("txtFieldPassword"));
		pnlAuth.add(factoryComponent.getComponent("btnSignIn"));
		pnlAuth.add(factoryComponent.getComponent("btnGoBack"));
	}

	
}
