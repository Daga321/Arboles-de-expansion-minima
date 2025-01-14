package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import Control.Controller;
import Graph.Edge;
import Graph.Vertex;
import edu.uci.ics.jung.graph.Graph;

public class PrincipalWindow extends JFrame implements Actions{
	
	private showGraphPanel gpGraph;
	private showGraphPanel gpMST;
	private showOptionsPanel opOptions;
	
	private Dimension dimension;

	public PrincipalWindow() {
		super("Arboles de expancion minima");
		dimension = new Dimension();
		dimension.setSize(Actions.WIDTH*.9626, Actions.HEIGHT*9114);//1315, 700
		setSize(dimension);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		insert();
	}
	
	private void insert() {
		opOptions = new showOptionsPanel(this);
		dimension.setSize(Actions.WIDTH*.2196, Actions.HEIGHT*.8606);//300, 661
		opOptions.setSize(dimension);
		
	}
	
	
	public void assignController(Controller controller) {
		opOptions.assignController(controller);
//		setVisible(true);
		showPanels();
	}

	@Override
	public String[] capture(String section) {
		
		return opOptions.capture(section);
	}

	@Override
	public void show(String section, String[] data) {
		opOptions.show(section, data);
	}
	
	@Override
	public void showData(String section, String data) {
		switch (section) {
			case Actions.GRAPH:
				gpGraph.showData(section, data);
			break;
			
			case Actions.GRAPHMST:
				gpMST.showData(section, data);
			break;
		}
	}

	@Override
	public void showGraph(String section, Graph<Vertex<String>, Edge> graph) {
		
		
		
		switch(section) {
			case Actions.GRAPH:
//				if(gpGraph!=null) {
//					gpGraph.dispose();
//				}
				gpGraph = new showGraphPanel(this);
				dimension.setSize(Actions.WIDTH*.366, Actions.HEIGHT*.8606);//500, 661
				gpGraph.setSize(dimension);
				gpGraph.setBackground(Color.red);
				gpGraph.showGraph(section, graph);
				if(gpGraph!=null) {
					gpGraph.setLocation((int)(getLocation().getX()+Actions.WIDTH*.0058), (int)(getLocation().getY()+Actions.HEIGHT*.0403));//getLocation().getX()+8, getLocation().getY()+31
					gpGraph.setVisible(true);
				}
			break;
			
			case Actions.GRAPHMST:
//				if(gpMST!=null) {
//					gpMST.dispose();
//				}
				gpMST = new showGraphPanel(this);
				dimension.setSize(Actions.WIDTH*.366, Actions.HEIGHT*.8606);//500, 661
				gpMST.setSize(dimension);
				gpMST.setBackground(Color.GREEN);
				gpMST.showGraph(section, graph);
				if(gpMST!=null) {
					gpMST.setLocation((int)(getLocation().getX()+Actions.WIDTH*.3718), (int)(getLocation().getY()+Actions.HEIGHT*.0403));//getLocation().getX()+508, getLocation().getY()+31
					gpMST.setVisible(true);
				}
				
			break;
		}
		
	}
	
	@Override
	public void clear(String section) {
		opOptions.clear(section);
	}
	
	private void showPanels() {
		opOptions.setLocation((int)(getLocation().getX()+Actions.WIDTH*.7379), (int)(getLocation().getY()+Actions.HEIGHT*.0403));//getLocation().getX()+1008, getLocation().getY()+31
		opOptions.setVisible(true);
		
		gpGraph.setLocation((int)(getLocation().getX()+Actions.WIDTH*.0058), (int)(getLocation().getY()+Actions.HEIGHT*.0403));//getLocation().getX()+8, getLocation().getY()+31
		gpGraph.setVisible(true);
		
		gpMST.setLocation((int)(getLocation().getX()+Actions.WIDTH*.3718), (int)(getLocation().getY()+Actions.HEIGHT*.0403));//getLocation().getX()+508, getLocation().getY()+31
		gpMST.setVisible(true);
	}
	
}
