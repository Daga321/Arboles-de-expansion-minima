package View;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;

import Control.Controller;
import Graph.Edge;
import Graph.Vertex;
import edu.uci.ics.jung.graph.Graph;

public class showOptionsPanel extends JDialog implements Actions{
	
	private OptionsPanel opOptions;
	
	/**
	 * Instantiates a new menu window.
	 *
	 * @param frame the frame
	 */
	public showOptionsPanel(JFrame frame) {
		setLayout(null);
		setSize(300, 561);
		setResizable(false);
		setUndecorated(true);
		initialize();
		insert();
	}
	
	private void initialize() {
		opOptions = new OptionsPanel();
		opOptions.setBounds(0, 0, 300, 561);
		opOptions.setBackground(Color.orange);
	}
	
	private void insert() {
		add(opOptions);
	}
	
	public void assignController(Controller controller) {
		opOptions.assignController(controller);
	}

	@Override
	public String[] capture(String section) {
		switch(section) {
			case Actions.VERTEX:
				String[] dataVertex = {opOptions.getVertexName()};
				return dataVertex;
//			break;
			
			case Actions.EDGE:
				String[] dataEdge = {""+opOptions.getOriginVertexIndex(), opOptions.getWeight(), ""+opOptions.getDestinyVertexIndex()};
				return dataEdge;
//			break;
		}
		return null;
	}

	@Override
	public void show(String section, String[] data) {
		System.out.println(section);
		switch(section) {
			case Actions.ORIGIN:
				opOptions.fillcbOriginVertex(data);
			break;
			
			case Actions.DESTINY:
				opOptions.fillcbDestinyVertex(data);
			break;
		}
		repaint();
	}

	@Override
	public void showGraph(String section, Graph<Vertex<String>, Edge> graph) {}
	
	public void clear(String section) {
		opOptions.clear(section);
	}
	
}
