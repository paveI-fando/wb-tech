package by.bsuir.fando.ui;

/**
 * stores componentFactory and panelFactory to use lite version of memento pattern
 * @author Fando
 *
 */
public class ObjectSingleton {
	private static ComponentFactory componentFactory;
	private static PanelFactory panelFactory;
	private ObjectSingleton() { 
	}
	
	public static ComponentFactory getComponentFactory() {
		if(componentFactory == null){
			componentFactory = new ComponentFactory();
		}
		return componentFactory;
	}
	public static PanelFactory getFactoryPanel() {
		if(panelFactory == null){
			panelFactory = new PanelFactory();
		}
		return panelFactory;
	}
	
}
