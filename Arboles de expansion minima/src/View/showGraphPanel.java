package View;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;

import Graph.Edge;
import Graph.Vertex;
import edu.uci.ics.jung.graph.Graph;

public class showGraphPanel extends JDialog implements Actions{
	
	private GraphPanel gpGraph;
	private TreePanel tpTreeMST;
	
	/**
	 * Instantiates a new menu window.
	 *
	 * @param frame the frame
	 */
	public showGraphPanel(JFrame frame) {
//		super(frame, true);
		setLayout(null);
		setSize(500, 561);
		setResizable(false);
		setUndecorated(true);
	}
	
	
	private void initialize(String section, Graph<Vertex<String>, Edge> graph) {
		switch(section) {
		case Actions.GRAPH:
			gpGraph = new GraphPanel(graph, Color.RED);
			gpGraph.setBounds(0, 0, 500, 561);
		break;
		
		case Actions.GRAPHMST:
			tpTreeMST = new TreePanel(graph, Color.GREEN);
			tpTreeMST.setBounds(0, 0, 500, 561);
		break;
	}
	}
	
	private void insert(String section) {
		switch(section) {
		case Actions.GRAPH:
			add(gpGraph);
		break;
		
		case Actions.GRAPHMST:
			add(tpTreeMST);
		break;
	}
	}

	@Override
	public String[] capture(String section) {return null;}

	@Override
	public void show(String section, String[] data) {}

	@Override
	public void showGraph(String section, Graph<Vertex<String>, Edge> graph) {
		initialize(section, graph);
		insert(section);
	}
	
	public void clear(String section) {}
	
}
