package Graph;

import java.util.ArrayList;

public class Graphs {
	
	//Graph class with certain built in algorithms

	private ArrayList<Edge> edge;
	private ArrayList<Vertex<String>> vertex;
	
	
	public Graphs(){
		this.vertex= new ArrayList<Vertex<String>>();;
		this.edge= new ArrayList<Edge>();
	}
	
	public Graphs(ArrayList<Vertex<String>> vertex, ArrayList<Edge> edge){
		this.vertex=vertex;
		this.edge=edge;
	}
	
	//Returns whether or not graph contains input vertex
	public boolean hasVertex(Vertex<String> v){
		for(Vertex<String> vertex:vertex){
			if(vertex.getInfo().equals(v.getInfo())){
				return true;
			}
		}
		return false;
	}
	
	//returns sum of edge weights in graph
	public int getCost(){
		int sum=0;
		for(Edge e:edge){
			sum+=e.getWeight();
		}
		return sum;
	}
	
	public ArrayList<Vertex<String>> getVertex() {
		return vertex;
	}

	public void addVertex(Vertex<String> vertex) {
		this.vertex.add(vertex);
	}
	
	public void setVertex(ArrayList<Vertex<String>> vertex) {
		this.vertex = vertex;
	}

	public void setEdge(ArrayList<Edge> edge) {
		this.edge = edge;
	}
	
	public void addEdge(Edge edge) {
		this.edge.add(edge);
	}

	public ArrayList<Edge> getEdges(){
		return edge;
	}
	
	public String[] vertex(){
		String[] v= new String[vertex.size()];
		for(int i=0;i<vertex.size();i++){
			v[i]=vertex.get(i).toString();
		}
		return v;
	}
	
	public String toString(){
		String ver="";
		for(Vertex<String> v:vertex){
			ver+=v.toString()+",";
		}
		String edg="";
		for(Edge e:edge){
			edg+=e.toString()+" ";
		}
		return "Vertices: "+ver+"\nEdges: "+edg+"\n";
	}
	
	
	
	
}