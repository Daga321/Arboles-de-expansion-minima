package Graph;


public class Edge {
	
	//Edge class with built in functions; used for Graph class
	
	private int weight;
	private Vertex<String> v1;
	private Vertex<String> v2;
	private boolean directed=false;
	
	public Edge(int weight, Vertex<String> value1, Vertex<String> value2){
		this.weight=weight;
		v1= value1;
		v2= value2;
	}
	
	public Edge(int weight, Vertex<String> value1, Vertex<String> value2, boolean directed){
		this.weight=weight;
		v1= value1;
		v2= value2;
		this.directed=directed;
	}
	
	//returns whether or not the edge is incident to the input vertex
	public boolean incident(Vertex<String> vertex){
		return vertex.getInfo()==v1.getInfo() || vertex.getInfo()==v2.getInfo();
	}
	
	public Vertex<String> getVertex1(){
		return v1;
	}
	
	public Vertex<String> getVertex2(){
		return v2;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public boolean getDirected(){
		return directed;
	}
	
	public void makeDirected(){
		directed=true;
	}
	
	public void swap(){
		Vertex<String> temp=v2;
		v2=v1;
		v1=temp;
	}
	
	public String toString(){
		return ""+weight;
	}
}