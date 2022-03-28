package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Graph.Edge;
import Graph.Vertex;
import edu.uci.ics.jung.graph.Graph;

public class showGraphPanel extends JDialog implements Actions{
	
	private GraphPanel gpGraph;
	private TreePanel tpTreeMST;
	
	private JScrollPane spPanel;
	private JTextArea taData;
	
	private Dimension dimension;
	
	/**
	 * Instantiates a new menu window.
	 *
	 * @param frame the frame
	 */
	public showGraphPanel(JFrame frame) {
//		super(frame, true);
		setLayout(null);
		dimension = new Dimension();
		dimension.setSize(Actions.WIDTH*.366, Actions.HEIGHT*.8606);//500, 661
		setResizable(false);
		setUndecorated(true);
	}
	
	
	private void initialize(String section, Graph<Vertex<String>, Edge> graph) {
		switch(section) {
			case Actions.GRAPH:
				gpGraph = new GraphPanel(graph, Color.RED);
				dimension.setSize(Actions.WIDTH*.366, Actions.HEIGHT*.6783);//500, 521
				gpGraph.setSize(dimension);
				gpGraph.setLocation(new Point(0, 0));//0, 0
			break;
			
			case Actions.GRAPHMST:
				tpTreeMST = new TreePanel(graph, Color.GREEN);
				dimension.setSize(Actions.WIDTH*.366, Actions.HEIGHT*.6783);//500, 521
				tpTreeMST.setSize(dimension);
				tpTreeMST.setLocation(new Point(0, 0));//0, 0
			break;
		}
		taData = new JTextArea();
		taData.setEditable(false);
		spPanel = new JScrollPane(taData);
		dimension.setSize(Actions.WIDTH*.366, Actions.HEIGHT*.3125);//500, 240
		spPanel.setSize(dimension);
		spPanel.setLocation(new Point(0, (int) (Actions.HEIGHT*.6783)));//0, 521
		
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
		add(spPanel);
	}

	@Override
	public String[] capture(String section) {return null;}

	@Override
	public void show(String section, String[] data) {}
	
	@Override
	public void showData(String section, String data) {
		taData.setText(data);
	}

	@Override
	public void showGraph(String section, Graph<Vertex<String>, Edge> graph) {
		initialize(section, graph);
		insert(section);
	}
	
	public void clear(String section) {}
	
}
