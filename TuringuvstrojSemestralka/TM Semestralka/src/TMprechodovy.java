import javax.swing.*;

//TM prechodovy
public class TMprechodovy extends JPanel implements java.io.Serializable{	
	// atributy
	private JList<String> prechodovyList;		   
	private JScrollPane    prechodovypanelek;	
	private JButton ukladacicudlik, editcudlik, pokracovacicudlik, predchozicudlik, cudlikzpet, cudliknext;
	private JLabel vcilstav, vcilabeceda, comadelat;
	private JComboBox<String> stateComboBox, symbolComboBox, directionCombBox;
	private DefaultListModel<String> prechod = new DefaultListModel<String>();
	private DefaultComboBoxModel<String> stavecky = new DefaultComboBoxModel<String>(), symbols = new DefaultComboBoxModel<String>(), directions = new DefaultComboBoxModel<String>();
	// metody
	public JList<String>getTransitionList() { return prechodovyList;}
	public JScrollPane 		getTransitionScrollPane() { return prechodovypanelek; }
	public JButton	getSaveButton() { return ukladacicudlik; }
	public JButton 	getEditButton() { return editcudlik; }
	public JButton getContinueButton() { return pokracovacicudlik; }
	public JButton	getPreviousButton() { return predchozicudlik; }
	public JButton	getBackButton() { return cudlikzpet; }
	public JButton	getNextButton() { return cudliknext; }
	public JLabel getCurrentState(){ return vcilstav; }
	public JLabel	getCurrentAlphabet() { return vcilabeceda; }
	public JLabel 	getInstruction() { return comadelat; }
	public JComboBox<String>	getStateComboBox() { return stateComboBox; }
	public JComboBox<String> getSymbolComboBox() { return symbolComboBox; }
	public JComboBox<String> getDirectionComboBox() { return directionCombBox; }
	public DefaultListModel<String>  getTransitionItems() { return prechod; }
	public DefaultComboBoxModel<String> getStateItems() { return stavecky; }
	public DefaultComboBoxModel<String> getSymbolItems() { return symbols; }
	public DefaultComboBoxModel<String> getDirectionItems() { return directions; }
		// konstruktor
    public TMprechodovy() {

    	setLayout(null);    	
    	//popisky
    	comadelat = new JLabel("Pro každé 'písmenko' nastav přechod");
    	comadelat.setLocation(30,30);
    	comadelat.setSize(800, 40);
    	add(comadelat);    	
    	JLabel label = new JLabel("prechod:");
  		label.setLocation(30,60);
		label.setSize(90, 40);
    	add(label);    	
    	label = new JLabel("stav:");
  		label.setLocation(440,80);
		label.setSize(50, 40);
    	add(label);    	
    	label = new JLabel("nacti symbol:");
		label.setLocation(440,110);
		label.setSize(90, 40);
    	add(label);    	
    	label = new JLabel("prechod do stavu:");
		label.setLocation(440,140);
		label.setSize(90, 40);
    	add(label);    	
    	label = new JLabel("zapis symbol:");
		label.setLocation(590,140);
		label.setSize(90, 40);
    	add(label);    	
    	label = new JLabel("posun:");
		label.setLocation(740,140);
		label.setSize(50, 40);
    	add(label);    	
    	vcilstav = new JLabel("");
    	vcilstav.setLocation(500,80);
		vcilstav.setSize(100, 40);
    	add(vcilstav);    	
    	vcilabeceda = new JLabel("");
    	vcilabeceda.setLocation(530,110);
		vcilabeceda.setSize(100, 40);
    	add(vcilabeceda);    	
    	
		stateComboBox = new JComboBox<String>(stavecky);
		stateComboBox.setLocation(440,170);
		stateComboBox.setSize(130, 30);
  	  	add(stateComboBox);    	
    	symbolComboBox = new JComboBox<String>(symbols);
		symbolComboBox.setLocation(590,170);
		symbolComboBox.setSize(130, 30);
    	add(symbolComboBox);    	
        directions.addElement("neutral");
        directions.addElement("vlevo");
        directions.addElement("vpravo");        
    	directionCombBox = new JComboBox<String>(directions);
		directionCombBox.setLocation(740,170);
		directionCombBox.setSize(100, 30);
    	add(directionCombBox);    	
    	//list
 		prechodovyList = new JList<String>(prechod);
    	prechodovypanelek = new JScrollPane(prechodovyList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		prechodovypanelek.setLocation(30,90);
		prechodovypanelek.setSize(400, 485);
    	add(prechodovypanelek);
    	
    	//čudlíky
    	ukladacicudlik = new JButton("nastav");
    	ukladacicudlik.setLocation(860,165);
		ukladacicudlik.setSize(100, 40);
    	add(ukladacicudlik);
    	    	   	
    	cudlikzpet = new JButton("zpet");
    	cudlikzpet.setLocation(30,600);
		cudlikzpet.setSize(100, 40);
    	add(cudlikzpet);
    	
    	cudliknext = new JButton("dalsi");
    	cudliknext.setLocation(860,600);
		cudliknext.setSize(100, 40);
    	add(cudliknext);
    }    
}