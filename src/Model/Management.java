package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import Graph.Edge;
import Graph.Graphs;
import Graph.Vertex;
import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;

public class Management{

	private Graph<Vertex<String>, Edge> graph;
	private ArrayList<Vertex<String>> vertexList;
	private ArrayList<Edge> edgeList;
	private ArrayList<Graph<Vertex<String>, Edge>> listMST;
	private int index;
	private Prim prim;
	
	public Management() {
		index = 0;
		prim = new Prim();
		vertexList = new ArrayList<Vertex<String>>();
		edgeList = new ArrayList<Edge>();
		graph = new SparseMultigraph<Vertex<String>,Edge>();
		genesis();
		resetMST();
	}
	
	public void reset() {
		vertexList = new ArrayList<Vertex<String>>();
		edgeList = new ArrayList<Edge>();
		graph = new SparseMultigraph<Vertex<String>,Edge>();
		
		resetMST();
	}
	
	private void genesis() {
		
		// 24 sectores(Vertices)
		vertexList.add(new Vertex<String>("Barrio Magadalena"));
		vertexList.add(new Vertex<String>("Barrio Monquira"));
		vertexList.add(new Vertex<String>("Barrio Villa del Sol"));
		vertexList.add(new Vertex<String>("Barrio Colombia"));
		vertexList.add(new Vertex<String>("Barrio Santa Barbara "));
		vertexList.add(new Vertex<String>("Barrio el Rincon del Cacique"));
		vertexList.add(new Vertex<String>("Barrio el Bosque"));
		vertexList.add(new Vertex<String>("Barrio la florida"));
		vertexList.add(new Vertex<String>("Barrio Benjamin Herrera"));
		vertexList.add(new Vertex<String>("Barrio Sugamuxi"));
		vertexList.add(new Vertex<String>("Barrio Santa Catalina"));
		vertexList.add(new Vertex<String>("Barrio Villa Esperanza del Sol"));
		vertexList.add(new Vertex<String>("Barrio El Lago"));
		vertexList.add(new Vertex<String>("Hospital regional Sogamoso"));
		vertexList.add(new Vertex<String>("Exito"));
		vertexList.add(new Vertex<String>("Iwoka"));
		vertexList.add(new Vertex<String>("Camara de comercio"));
		vertexList.add(new Vertex<String>("Metro"));
		vertexList.add(new Vertex<String>("Cementerio de sogamoso"));
		vertexList.add(new Vertex<String>("UPTC"));
		vertexList.add(new Vertex<String>("Plaza la Villa"));
		vertexList.add(new Vertex<String>("UniBoyaca"));
		vertexList.add(new Vertex<String>("Museo Arqueologico Suamox"));
		vertexList.add(new Vertex<String>("Teatro Sogamoso"));
		
		//51 conecciones(Aristas) minimo 1 arista por vertice
 		edgeList.add(new Edge(19723, vertexList.get(0), vertexList.get(18)));
		edgeList.add(new Edge(47434, vertexList.get(0), vertexList.get(11)));
		edgeList.add(new Edge(20711, vertexList.get(1), vertexList.get(4)));
		edgeList.add(new Edge(7814, vertexList.get(1), vertexList.get(8)));
		edgeList.add(new Edge(54658, vertexList.get(2), vertexList.get(10)));
		edgeList.add(new Edge(43245, vertexList.get(3), vertexList.get(0)));
		edgeList.add(new Edge(37097, vertexList.get(3), vertexList.get(3)));
		edgeList.add(new Edge(14287, vertexList.get(4), vertexList.get(8)));
		edgeList.add(new Edge(23784, vertexList.get(5), vertexList.get(16)));
		edgeList.add(new Edge(22615, vertexList.get(5), vertexList.get(16)));
		edgeList.add(new Edge(37724, vertexList.get(5), vertexList.get(10)));
		edgeList.add(new Edge(9430, vertexList.get(6), vertexList.get(4)));
		edgeList.add(new Edge(22352, vertexList.get(7), vertexList.get(14)));
		edgeList.add(new Edge(54200, vertexList.get(7), vertexList.get(6)));
		edgeList.add(new Edge(10158, vertexList.get(7), vertexList.get(2)));
		edgeList.add(new Edge(33054, vertexList.get(8), vertexList.get(19)));
		edgeList.add(new Edge(29591, vertexList.get(8), vertexList.get(14)));
		edgeList.add(new Edge(42499, vertexList.get(9), vertexList.get(10)));
		edgeList.add(new Edge(15211, vertexList.get(9), vertexList.get(3)));
		edgeList.add(new Edge(50591, vertexList.get(9), vertexList.get(4)));
		edgeList.add(new Edge(32201, vertexList.get(10), vertexList.get(11)));
		edgeList.add(new Edge(36752, vertexList.get(10), vertexList.get(4)));
		edgeList.add(new Edge(16347, vertexList.get(10), vertexList.get(20)));
		edgeList.add(new Edge(23834, vertexList.get(11), vertexList.get(14)));
		edgeList.add(new Edge(21567, vertexList.get(11), vertexList.get(11)));
		edgeList.add(new Edge(34928, vertexList.get(12), vertexList.get(1)));
		edgeList.add(new Edge(40843, vertexList.get(13), vertexList.get(4)));
		edgeList.add(new Edge(13454, vertexList.get(13), vertexList.get(20)));
		edgeList.add(new Edge(37779, vertexList.get(13), vertexList.get(8)));
		edgeList.add(new Edge(15241, vertexList.get(14), vertexList.get(13)));
		edgeList.add(new Edge(39915, vertexList.get(14), vertexList.get(17)));
		edgeList.add(new Edge(24725, vertexList.get(14), vertexList.get(0)));
		edgeList.add(new Edge(18182, vertexList.get(15), vertexList.get(20)));
		edgeList.add(new Edge(48728, vertexList.get(15), vertexList.get(13)));
		edgeList.add(new Edge(29696, vertexList.get(15), vertexList.get(2)));
		edgeList.add(new Edge(3085, vertexList.get(16), vertexList.get(20)));
		edgeList.add(new Edge(53340, vertexList.get(16), vertexList.get(11)));
		edgeList.add(new Edge(25708, vertexList.get(17), vertexList.get(18)));
		edgeList.add(new Edge(18564, vertexList.get(17), vertexList.get(22)));
		edgeList.add(new Edge(5676, vertexList.get(18), vertexList.get(19)));
		edgeList.add(new Edge(42656, vertexList.get(19), vertexList.get(23)));
		edgeList.add(new Edge(45290, vertexList.get(19), vertexList.get(2)));
		edgeList.add(new Edge(42628, vertexList.get(19), vertexList.get(8)));
		edgeList.add(new Edge(36037, vertexList.get(20), vertexList.get(20)));
		edgeList.add(new Edge(12290, vertexList.get(20), vertexList.get(12)));
		edgeList.add(new Edge(51565, vertexList.get(21), vertexList.get(9)));
		edgeList.add(new Edge(40915, vertexList.get(22), vertexList.get(1)));
		edgeList.add(new Edge(41495, vertexList.get(22), vertexList.get(5)));
		edgeList.add(new Edge(8617, vertexList.get(22), vertexList.get(13)));
		edgeList.add(new Edge(21155, vertexList.get(23), vertexList.get(17)));
		edgeList.add(new Edge(21354, vertexList.get(23), vertexList.get(2)));
		
		for(int i = 0; i<vertexList.size(); i++){
			graph.addVertex(vertexList.get(i));
		}
		
		for(int i = 0; i<edgeList.size(); i++){
			if(edgeList.get(i).getDirected()){
				graph.addEdge(edgeList.get(i), edgeList.get(i).getVertex1(), edgeList.get(i).getVertex2(), EdgeType.DIRECTED);
			}
			else{
				graph.addEdge(edgeList.get(i), edgeList.get(i).getVertex1(), edgeList.get(i).getVertex2());
			}
		}
	}
	
	public void createEdge(String[] data) {
		try {
			edgeList.add(new Edge(Integer.parseInt(data[1]), vertexList.get(Integer.parseInt(data[0])), vertexList.get(Integer.parseInt(data[2]))));
			graph.addEdge(edgeList.get(edgeList.size()-1), edgeList.get(edgeList.size()-1).getVertex1(), edgeList.get(edgeList.size()-1).getVertex2());
		} catch (Exception e) {}
	}
	
	public void createVertex(String data) {
		vertexList.add(new Vertex<String>(data));
		graph.addVertex(vertexList.get(vertexList.size()-1));
		
	}
	
	public String[] getVertex() {
		String[] data = new String[vertexList.size()]; 
		for (int i = 0; i < data.length; i++) {
			data[i] = vertexList.get(i).getInfo();
		}
		return data;
	}
	
	public void resetMST() {
		index=0;
		listMST = prim.getGraphMST(new Graphs(vertexList, edgeList), vertexList.toArray(new Vertex[vertexList.size()]), edgeList.toArray(new Edge[edgeList.size()]));
	}
	
	public Graph<Vertex<String>, Edge> getGraph() {
		return graph;
	}
	
	public void nextIndex() {
		if(index<listMST.size()-1) {
			index++;
		}
	}
	
	public void previousIndex() {
		if(index>0) {
			index--;
		}
	}

	public DelegateForest<Vertex<String>, Edge> getGraphMST() {
		DelegateForest<Vertex<String>, Edge> gMST = new DelegateForest<>();
		if (listMST.size()>0) {
			Graph<Vertex<String>, Edge> graph = listMST.get(index);
//			System.out.println("Index::"+index);
			Collection<Vertex<String>> vertexCollection = graph.getVertices();
			for (Iterator<Vertex<String>> iterator = vertexCollection.iterator(); iterator.hasNext();) {
				Vertex<String> vertex = (Vertex<String>) iterator.next();
				gMST.addVertex(vertex);
			}
			Collection<Edge> edgeCollection = graph.getEdges();
			for (Iterator<Edge> iterator = edgeCollection.iterator(); iterator.hasNext();) {
				Edge edge = (Edge) iterator.next();
				gMST.addEdge(edge, edge.getVertex1(), edge.getVertex2());
			}
		}
		return gMST ;
	}
	
	public String getGraphData() {
		String data = "GRAFO:\n";
		if (vertexList.size()>0) {
			data += "Numero de aristas: "+graph.getEdgeCount()+"\n";
			Collection<Edge> collctionEdge = graph.getEdges();
			if (collctionEdge.size()>0) {
				int min = 99999999;
				int max = 0;
				int total = 0;
				for (Iterator<Edge> iterator = collctionEdge.iterator(); iterator.hasNext();) {
					Edge edge = (Edge) iterator.next();
					total += edge.getWeight();
					if (edge.getWeight()<min) {
						min = edge.getWeight();
					}
					if (edge.getWeight()>max) {
						max = edge.getWeight();
					}
				}
				data += "-Peso menor en arista: "+min+"\n";
				data += "-Peso mayor en arista: "+max+"\n";
				data += "-Peso total en aristas: "+total+"\n";
			}
			data += "Numero de vertices: "+graph.getVertexCount()+"\n";
			Collection<Vertex<String>> collectionVertex = graph.getVertices();
			for (Iterator<Vertex<String>> iterator = collectionVertex.iterator(); iterator.hasNext();) {
				Vertex<String> vertex = (Vertex<String>) iterator.next();
				data += "-"+vertex.getInfo()+"\n";
			}
		}
		return data;
	}
	
	public String getMSTData() {
		String data = "ARBOL DE EXPANCION MINIMA:\n";
		if (vertexList.size()>1 && edgeList.size()>0) {
			DelegateForest<Vertex<String>, Edge> gMST = getGraphMST();
			data += "Iteracion: "+(index+1)+"\n";
			data += "Numero de aristas: "+gMST.getEdgeCount()+"\n";
			data += "Vertice raiz: "+vertexList.get(0)+"\n";
			data += "Altura del arbol: "+gMST.getHeight()+"\n";
			Collection<Edge> collctionEdge = gMST.getEdges();
			int total = 0;
			for (Iterator<Edge> iterator = collctionEdge.iterator(); iterator.hasNext();) {
				Edge edge = (Edge) iterator.next();
				total += edge.getWeight();
			}
			data += "Peso total del arbol: "+total+"\n";
//			int weight = 0;
//			Collection<Vertex<String>> collection1 = gMST.getChildren(gMST.getRoot());
//			for (Iterator<Vertex<String>> iterator = collection1.iterator(); iterator.hasNext();) {
//				Vertex<String> vertex = (Vertex<String>) iterator.next();
//				if (weight<gMST.getDepth(vertex)) {
//					weight = gMST.getDepth(vertex);
//				}
//			}
			data += "Numero de vertices: "+gMST.getVertexCount()+"\n";
			Collection<Vertex<String>> collection2 = gMST.getVertices();
			for (Iterator<Vertex<String>> iterator = collection2.iterator(); iterator.hasNext();) {
				Vertex<String> vertex = (Vertex<String>) iterator.next();
				data += "-"+vertex.getInfo()+"\n";
			}
		}
		return data;
	}
	
}
