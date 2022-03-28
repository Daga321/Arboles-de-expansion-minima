package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import Graph.Edge;
import Graph.Vertex;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

public class GraphPanel extends JPanel{

	
	private Layout<Vertex<String>, Edge> layout;
	private DefaultModalGraphMouse gm;
	private VisualizationViewer<Vertex<String>, Edge> vs;
	private Graph<Vertex<String>, Edge> graph;
	
	private Dimension dimension; 
	
	public GraphPanel(Graph<Vertex<String>, Edge> graph, Color color) {
		setBackground(color);
		this.graph = graph;
		initialice();
		assign();
	}
	
	private void initialice() {
		//Initialize visualization
		dimension = new Dimension();
		layout = new CircleLayout<Vertex<String>, Edge>(graph);//crea margen circular sobre la cual se posicionaran los vertices
        dimension.setSize(Actions.WIDTH*.366,Actions.HEIGHT*.651);//500, 500
		layout.setSize(dimension);//tamaño inicial del layout
        vs = new VisualizationViewer<Vertex<String>, Edge>(layout);//componente que detecta la interaccion con el mouse
        dimension.setSize(Actions.WIDTH*.3587,Actions.HEIGHT*.6640);//490, 510
        vs.setPreferredSize(dimension);//tamaño del "panel" (el area visual)
        
        //Creates GraphMouse and adds to visualization
        gm = new DefaultModalGraphMouse();//Permite el escalado del grafo a medida que este se vea editado
        gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
        vs.setGraphMouse(gm);
        
        vs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());//configuracion renderizado Vertices
        vs.getRenderer().getVertexLabelRenderer().setPosition(Position.AUTO);//los labels se ubican centrados del vertice

        vs.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());//configuracion renderizado Aristas "rutas"
        vs.getRenderContext().getEdgeLabelRenderer().setRotateEdgeLabels(false);//los labels se ubican centrados del Aristas "rutas"
        
	}

	private void assign() {
		add(vs);
	}
	
}
