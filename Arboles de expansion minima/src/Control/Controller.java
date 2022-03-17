package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Management;
import View.Actions;

public class Controller implements ActionListener{
	
	private Actions actions;
	private Management management;
	
	public Controller(Actions actions) {
		this.actions = actions;
		management = new Management();
		actions.showGraph(Actions.GRAPH, management.getGraph());//Mostrar grafo ROJO
		actions.showGraph(Actions.GRAPHMST, management.getGraphMST());//Msotar arbol MST VERDE
		actions.show(Actions.ORIGIN, management.getVertex());
		actions.show(Actions.DESTINY, management.getVertex());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
		
			case Actions.CLOSE:
				System.exit(0);
			break;
			
			case Actions.VERTEX: 
				management.createVertex(actions.capture(Actions.VERTEX)[0]);
				actions.showGraph(Actions.GRAPH, management.getGraph());//Mostrar grafo ROJO
				actions.clear(Actions.VERTEX);
				management.resetMST();
				actions.showGraph(Actions.GRAPHMST, management.getGraphMST());//Msotar arbol MST VERDE
				actions.show(Actions.ORIGIN, management.getVertex());
				actions.show(Actions.DESTINY, management.getVertex());
			break;
			
			case Actions.EDGE: 
				management.createEdge(actions.capture(Actions.EDGE));
				actions.showGraph(Actions.GRAPH, management.getGraph());//Mostrar grafo ROJO
				actions.clear(Actions.EDGE);
				management.resetMST();
				actions.showGraph(Actions.GRAPHMST, management.getGraphMST());//Msotar arbol MST VERDE
			break;
			
			case Actions.PREVIOUS: 
				management.previousIndex();
				actions.showGraph(Actions.GRAPHMST, management.getGraphMST());//Msotar arbol MST VERDE
			break;
				
			case Actions.NEXT: 
				management.nextIndex();
				actions.showGraph(Actions.GRAPHMST, management.getGraphMST());//Msotar arbol MST VERDE
			break;
		}
		
	}
	
	
	
}
