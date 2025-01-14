package Model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.util.*;
import javax.swing.*;

import org.apache.commons.collections15.Transformer;

import Graph.Edge;
import Graph.Graphs;
import Graph.Vertex;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
//Uses Java Universal Network/Graph (JUNG) Framework for conveniently displaying graphs
import edu.uci.ics.jung.graph.*;
import edu.uci.ics.jung.graph.util.*;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;


//Implementation of Prim's Algorithm to Determine Minimum Spanning Tree of Undirected Sparse Multigraph

public class Prim extends JPanel{
	
	/*Prim's Algorithm

	 Problem (informal): Given graph, finding spanning tree with minimally weighted edges (MST)
	 
	 Algorithm: Add least weighted edge incident to vertices in current MST at each iteration until all vertices added
	 
	 Complexity:
	 	* Time - O(|V|^2) searching adjacency matrix (effectively)
	 	* Space - O(|V|+|E|) to store arrays of vertices and edges
	 	
	 Functions Defined:
	 	* adjacentEdges() - Returns all edges adjacent to subgraph
	 	* contains() - Returns whether or not input vertex exists in input array
	 	* minEdge() - Given edge array, returns minimally weighted edge
	 	* addVertex() - Adds input vertex to input graph
	 	* addEdge() - Returns input Graph with added edge
	 	* convertVertices() - Given array of values, returns array of Vertex type values
	 	* convertEdge() - Given array of values with weight and vertices, returns array of Edge type values
	 	* display() - Takes adjacency matrix input and displays GUI graph visualization (*Requires JUNG Library*)
	 
	 Notes:
	 	* Greedy!
	 	* Should have used AdjacencyList for better performance; Fibonacci heap is optimal DS
	 	
	 */
	

	public ArrayList<Graph<Vertex<String>, Edge>> getGraphMST(Graphs graph, Vertex[] vertex, Edge[] edge){
		
		ArrayList<Graph<Vertex<String>, Edge>> graphMST = new ArrayList<Graph<Vertex<String>,Edge>>();
		
		Graphs mst = new Graphs();

		try {
			mst.addVertex(graph.getVertex().get(0));
			
			//convertGraph(mst).getEdgeCount()+1<convertGraph(graph).getVertexCount()
			
			while(convertGraph(mst).getVertexCount()<convertGraph(graph).getVertexCount()){
				
				//Find minimally weighted adjacent edge
				Edge[] adjacentEdges=adjacentEdges(mst, graph);
				Edge minEdge=minEdge(adjacentEdges);
				
				Vertex<String> v1=minEdge.getVertex1();
				Vertex<String> v2=minEdge.getVertex2();
				
				//Add vertex then edge to Minimum Spanning Tree
				if(mst.hasVertex(v1)){
					mst.addVertex(v2);
				}
				else{
					mst.addVertex(v1);
					minEdge.swap();
				}
				minEdge.makeDirected();
				mst.addEdge(minEdge);
//				display(mst, "green", "mst");
				graphMST.add(convertGraph(mst));
			}
		}catch(Exception e) {}
		
		return graphMST;
	}
	
	
	
	public void display(Graphs graph, String color, String name){
		
		Graph<Vertex<String>, Edge> g = convertGraph(graph);
		 
		//VisualizationImageServer vs = new VisualizationImageServer(new CircleLayout(g), new Dimension(650, 650));
		
		//Initialize visualization
        Layout<Integer, String> layout = new CircleLayout(g);
		layout.setSize(new Dimension(620,620));
        VisualizationViewer<Integer,String> vs = new VisualizationViewer<Integer,String>(layout);
        vs.setPreferredSize(new Dimension(650,650));
        
        //Creates GraphMouse and adds to visualization
        DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
        gm.setMode(ModalGraphMouse.Mode.PICKING);
        vs.setGraphMouse(gm);
		
		//Initialize JFrames
		JFrame frame = new JFrame(name);
	    frame.getContentPane().setBackground(Color.RED);
	    frame.getContentPane().add(vs);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	 
	    
	    //Colors Vertices
        Transformer<Integer,Paint> vertexPaint = new Transformer<Integer,Paint>() {
           public Paint transform(Integer i) {
        	   if(color=="green"){
        		   return Color.GREEN;
        	   }
        	   else{
        		   return Color.RED;
        	   }
           } 
       };
		
	    //Labels Edges
	    float dash[] = {10.0f};
        final Stroke edgeStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
        Transformer<String, Stroke> edgeStrokeTransformer =new Transformer<String, Stroke>(){
            public Stroke transform(String s) {
                return edgeStroke;
            }
        };
        
        //Renders Vertex colors/labels
//        vs.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
        vs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vs.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
        
        //Renders Edge labels
        vs.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());

	}
	
	
	//Returns all edges in Graph adjacent to (but not included in) vertices of subgraph
	public Edge[] adjacentEdges(Graphs mst, Graphs g){
		ArrayList<Edge> adjacentEdges=new ArrayList<Edge>();
		ArrayList<Edge> superEdges = g.getEdges();
		ArrayList<Vertex<String>> subVertices = mst.getVertex();
//		System.out.println(superEdges.size());
//		System.out.println(subVertices.size());
		for(int i = 0; i<superEdges.size(); i++){
			if(contains(subVertices, superEdges.get(i).getVertex1()) != contains(subVertices, superEdges.get(i).getVertex2())){
				adjacentEdges.add(superEdges.get(i));
			}
		}
		return adjacentEdges.toArray(new Edge[adjacentEdges.size()]);
		
	}
	
	//Returns whether or not input Vertex is included in array of vertices
	public boolean contains(ArrayList<Vertex<String>> vertices, Vertex<String> v){
		for(Vertex<String> vertex:vertices){
			if(vertex.getInfo()==v.getInfo()){
				return true;
			}
		}
		return false;
	}
	
	//Returns minmally weighted edge in array
	public Edge minEdge(Edge[] edges){
		Edge minEdge=edges[0];
		for(Edge e:edges){
			if(e.getWeight()<minEdge.getWeight()){
				minEdge=e;
			}	
		}
		return minEdge;
	}
	
	//Converts Graphs into JUNG compatible form Graph<Integer, Integer> for visualization
	public Graph<Vertex<String>, Edge> convertGraph(Graphs g){
		Graph<Vertex<String>,Edge> graph=new SparseMultigraph<Vertex<String>,Edge>();
		for(Vertex<String> v:g.getVertex()){
			graph.addVertex(v);
		}
		
		for(Edge e:g.getEdges()){
			if(e.getDirected()){
				graph.addEdge(e, e.getVertex1(), e.getVertex2(), EdgeType.DIRECTED);
			}
			else{
				graph.addEdge(e, e.getVertex1(), e.getVertex2());
			}
		}
		return graph;
	}
	
}