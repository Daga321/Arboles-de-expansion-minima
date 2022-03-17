package Graph;


public class Vertex<T> {
	
	//Vertex class
	//probably unnecessary, but already built into Prim's Algorith implementation
	
	private T info;
	
	public Vertex(T info){
		this.info = info;
	}
	
	public T getInfo(){
		return info;
	}

	public void setInfo(T info){
		this.info = info;
	}
	
	@Override
	public String toString() {
		return ""+info;
	}

}