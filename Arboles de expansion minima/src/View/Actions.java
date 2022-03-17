package View;

import Graph.Edge;
import Graph.Vertex;
import edu.uci.ics.jung.graph.Graph;

public interface Actions {

	public static final String CLOSE = "close";
	
	public static final String VERTEX = "vertex";
	public static final String EDGE = "edge";
	public static final String ORIGIN = "origin";
	public static final String DESTINY = "destiny";
	
	public static final String PREVIOUS = "previous";
	public static final String NEXT = "next";
	
	public static final String GRAPH = "graph";
	public static final String GRAPHMST = "graphmst";
	
	public String[] capture(String section);
	public void show(String section, String[] data);
	public void showGraph(String section, Graph<Vertex<String>,Edge> graph);
	public void clear(String section);
}
