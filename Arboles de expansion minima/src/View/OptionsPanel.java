package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.net.URL;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Control.Controller;

public class OptionsPanel extends JPanel{
	private URL url;
	private JLabel lblLogo;
	
	private Dimension dimension;
	
	private JButton btnClose;
	private JButton btnReset;
	
	private JLabel txtVertex;
	private JLabel txtVertexName;
	private JTextField tfVertexName;
	private JButton btnVertexName;
	
	private JLabel txtEdge;
	private JLabel txtOriginVertex;
	private JComboBox<String> cbOriginVertex;
	private JLabel txtWeight;
	private JTextField tfWeight;
	private JLabel txtDestinyVertex;
	private JComboBox<String> cbDestinyVertex;
	private JButton btnEdge;
	
	private JLabel txtMST;
	private JButton btnPreviousMST;
	private JButton btnNextMST;

	public OptionsPanel() {
		setLayout(null);
		initialize();
		assign();
	}
	
	private void initialize() {
		dimension = new Dimension();
		
		btnReset = new JButton("Reset");
		btnReset.setForeground(Color.RED);
		dimension.setSize(Actions.WIDTH*.0585, Actions.HEIGHT*.039);//80, 30
		btnReset.setSize(dimension);
		btnReset.setLocation(new Point(0, 0));//0, 0
		
		btnClose = new JButton("X");
		btnClose.setForeground(Color.RED);
		dimension.setSize(Actions.WIDTH*.0373, Actions.HEIGHT*.039);//50, 30
		btnClose.setSize(dimension);
		btnClose.setLocation(new Point((int) (Actions.WIDTH*.183), 0));//250, 0
		
		txtVertex = new JLabel("Agregar un nuevo vertice");
		dimension.setSize(Actions.WIDTH*.1756, Actions.HEIGHT*.039);//240, 30
		txtVertex.setSize(dimension);
		txtVertex.setLocation(new Point((int) (Actions.WIDTH*.0219), (int) (Actions.HEIGHT*.052)));//30, 40
		
		txtVertexName = new JLabel("Ingrese el nombre del vertice");
		dimension.setSize(Actions.WIDTH*.1756, Actions.HEIGHT*.039);//240, 30
		txtVertexName.setSize(dimension);
		txtVertexName.setLocation(new Point((int) (Actions.WIDTH*.0219), (int) (Actions.HEIGHT*.0911)));//30, 70
		
		
		tfVertexName = new JTextField();
		dimension.setSize(Actions.WIDTH*.1756, Actions.HEIGHT*.039);//240, 30
		tfVertexName.setSize(dimension);
		tfVertexName.setLocation(new Point((int) (Actions.WIDTH*.0219), (int) (Actions.HEIGHT*.1302)));//30, 100
		
		btnVertexName = new JButton("Agregar vertice");
		dimension.setSize(Actions.WIDTH*.1756, Actions.HEIGHT*.039);//240, 30
		btnVertexName.setSize(dimension);
		btnVertexName.setLocation(new Point((int) (Actions.WIDTH*.0219), (int) (Actions.HEIGHT*.1822)));//30, 140
		
		txtEdge = new JLabel("Conectar 2 vertices mediante una arista");
		dimension.setSize(Actions.WIDTH*.1756, Actions.HEIGHT*.039);//240, 30
		txtEdge.setSize(dimension);
		txtEdge.setLocation(new Point((int) (Actions.WIDTH*.0219), (int) (Actions.HEIGHT*.2213)));//30, 170
		
		txtOriginVertex = new JLabel("Seleccione el vertice de origen");
		dimension.setSize(Actions.WIDTH*.1756, Actions.HEIGHT*.039);//240, 30
		txtOriginVertex.setSize(dimension);
		txtOriginVertex.setLocation(new Point((int) (Actions.WIDTH*.0219), (int) (Actions.HEIGHT*.2604)));//30, 200
		
		cbOriginVertex = new JComboBox<>();
		cbOriginVertex.setModel(new DefaultComboBoxModel());
		dimension.setSize(Actions.WIDTH*.1756, Actions.HEIGHT*.039);//240, 30
		cbOriginVertex.setSize(dimension);
		cbOriginVertex.setLocation(new Point((int) (Actions.WIDTH*.0219), (int) (Actions.HEIGHT*.2994)));//30, 230
		
		txtWeight = new JLabel("Ingrese el peso de la arista");
		dimension.setSize(Actions.WIDTH*.1756, Actions.HEIGHT*.039);//240, 30
		txtWeight.setSize(dimension);
		txtWeight.setLocation(new Point((int) (Actions.WIDTH*.0219), (int) (Actions.HEIGHT*.3385)));//30, 260
		
		tfWeight = new JTextField();
		dimension.setSize(Actions.WIDTH*.1756, Actions.HEIGHT*.039);//240, 30
		tfWeight.setSize(dimension);
		tfWeight.setLocation(new Point((int) (Actions.WIDTH*.0219), (int) (Actions.HEIGHT*.3776)));//30, 290
		
		txtDestinyVertex = new JLabel("Seleccione el vertice de destino");
		dimension.setSize(Actions.WIDTH*.1756, Actions.HEIGHT*.039);//240, 30
		txtDestinyVertex.setSize(dimension);
		txtDestinyVertex.setLocation(new Point((int) (Actions.WIDTH*.0219), (int) (Actions.HEIGHT*.4166)));//30, 320
		
		cbDestinyVertex = new JComboBox<>();
		cbOriginVertex.setModel(new DefaultComboBoxModel());
		dimension.setSize(Actions.WIDTH*.1756, Actions.HEIGHT*.039);//240, 30
		cbDestinyVertex.setSize(dimension);
		cbDestinyVertex.setLocation(new Point((int) (Actions.WIDTH*.0219), (int) (Actions.HEIGHT*.4557)));//30, 350
		
		btnEdge = new JButton("Agregar conexion mediante arista");
		dimension.setSize(Actions.WIDTH*.1756, Actions.HEIGHT*.039);//240, 30
		btnEdge.setSize(dimension);
		btnEdge.setLocation(new Point((int) (Actions.WIDTH*.0219), (int) (Actions.HEIGHT*.5078)));//30, 390
		
		txtMST = new JLabel("Arboles de expancion minima");
		dimension.setSize(Actions.WIDTH*.1756, Actions.HEIGHT*.039);//240, 30
		txtMST.setSize(dimension);
		txtMST.setLocation(new Point((int) (Actions.WIDTH*.0219), (int) (Actions.HEIGHT*.5729)));//30, 440
		
		btnPreviousMST = new JButton("Paso anterior");
		dimension.setSize(Actions.WIDTH*.1756, Actions.HEIGHT*.039);//240, 30
		btnPreviousMST.setSize(dimension);
		btnPreviousMST.setLocation(new Point((int) (Actions.WIDTH*.0219), (int) (Actions.HEIGHT*.6119)));//30, 470
		
		btnNextMST = new JButton("Siguiente paso");
		dimension.setSize(Actions.WIDTH*.1756, Actions.HEIGHT*.039);//240, 30
		btnNextMST.setSize(dimension);
		btnNextMST.setLocation(new Point((int) (Actions.WIDTH*.0219), (int) (Actions.HEIGHT*.664)));//30, 510
		
		lblLogo = new JLabel();
		dimension.setSize(Actions.WIDTH*.1756, Actions.HEIGHT*.0976);//240, 75
		lblLogo.setSize(dimension);
		lblLogo.setLocation(new Point((int) (Actions.WIDTH*.0219), (int) (Actions.HEIGHT*.7291)));//30, 560
		url = OptionsPanel.class.getResource("/logoUPTC.png");
		System.out.println(url);
		ImageIcon imgIcon = new ImageIcon(url);
	    Image imgEscalada = imgIcon.getImage().getScaledInstance(lblLogo.getWidth(),lblLogo.getHeight(), Image.SCALE_SMOOTH);
	    Icon iconoEscalado = new ImageIcon(imgEscalada);
	    lblLogo.setIcon(iconoEscalado);
		
	}
	
	private void assign() {
		add(btnReset);
		add(btnClose);
		
		add(txtVertex);
		add(txtVertexName);
		add(tfVertexName);
		add(btnVertexName);
		
		add(txtEdge);
		add(txtOriginVertex);
		add(cbOriginVertex);
		add(txtWeight);
		add(tfWeight);
		add(txtDestinyVertex);
		add(cbDestinyVertex);
		add(btnEdge);
		
		add(txtMST);
		add(btnPreviousMST);
		add(btnNextMST);
		
		add(lblLogo);
	}
	
	public void assignController(Controller controller) {
		btnReset.setActionCommand(Actions.RESET);
		btnReset.addActionListener(controller);
		
		btnClose.setActionCommand(Actions.CLOSE);
		btnClose.addActionListener(controller);
		
		btnVertexName.setActionCommand(Actions.VERTEX);
		btnVertexName.addActionListener(controller);
		
		btnEdge.setActionCommand(Actions.EDGE);
		btnEdge.addActionListener(controller);
		
		btnPreviousMST.setActionCommand(Actions.PREVIOUS);
		btnPreviousMST.addActionListener(controller);
		
		btnNextMST.setActionCommand(Actions.NEXT);
		btnNextMST.addActionListener(controller);
	}
	
	public String getVertexName() {
		return tfVertexName.getText();
	}
	
	public void fillcbOriginVertex(String[] data) {
		cbOriginVertex.removeAllItems();
		for (int i = 0; i < data.length; i++) {
			cbOriginVertex.addItem(data[i]);		
		}
	}
	
	public int getOriginVertexIndex() {
		return cbOriginVertex.getSelectedIndex();
	}
	
	public void fillcbDestinyVertex(String[] data) {
		cbDestinyVertex.removeAllItems();
		for (int i = 0; i < data.length; i++) {
			cbDestinyVertex.addItem(data[i]);		
		}
	}
	
	public int getDestinyVertexIndex() {
		return cbDestinyVertex.getSelectedIndex();
	}
	
	public String getWeight() {
		return tfWeight.getText();
	}
	
	public void clear(String section) {
		switch(section){
			case Actions.VERTEX:
				tfVertexName.setText("");
			break;
			
			case Actions.EDGE:
				tfWeight.setText("");
			break;
		}
	}
	
}
