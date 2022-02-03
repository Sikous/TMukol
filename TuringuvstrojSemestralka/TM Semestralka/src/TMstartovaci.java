import javax.swing.*;

//TM startovaci
public class TMstartovaci extends JPanel implements java.io.Serializable{
	
	// atributy
	private JTextField paskaabecedytext, vstupabecedytext, stavovytext;
	private JList<String>    paskaabecedylist, vstupniabecedalist, listeckystavu;	   
	private JScrollPane  paskaabecedyscrolovaci, vstupabecedyscrolovaci, stavyscrolovaci;
	private JButton      addcudlikavecednipasky, removecudlikabecedypasky, cudliknaabecedu, odstranovacicudlikabecedu, cudliknastavy, cudliknaodstranenistavu, cudliknext, startbackcudlik;
	private JLabel       instruction;
    private JComboBox<String>    startComboBox;
	private DefaultListModel<String> 	 abeceda = new DefaultListModel<String>(), input = new DefaultListModel<String>(), states = new DefaultListModel<String>();
    private DefaultComboBoxModel<String> start = new DefaultComboBoxModel<String>();

	// metody
	public JTextField	getTapeAlphabetTextField() { return paskaabecedytext; }
    public JTextField	getInputAlphabetTextField() { return vstupabecedytext; }
	public JTextField   getStateTextField() { return stavovytext; }
	public JList<String>getTapeAlphabetList() { return paskaabecedylist; }
    public JList<String>	getInputAlphabetList() { return vstupniabecedalist; }
	public JList<String>getStateList() { return listeckystavu;}
	public JScrollPane  getTapeAlphabetScrollPane() { return paskaabecedyscrolovaci; }
	public JScrollPane  getStateScrollPane() { return stavyscrolovaci; }
    public JComboBox<String>getStartComboBox() { return startComboBox; }
	public JButton    getAddTapeAlphabetButton() { return addcudlikavecednipasky; }
	public JButton	getRemoveTapeAlphabetButton() { return removecudlikabecedypasky; }
    public JButton   getAddInputAlphabetButton() { return cudliknaabecedu; }
	public JButton	getRemoveInputAlphabetButton() { return odstranovacicudlikabecedu; }
	public JButton	getAddStateButton() { return cudliknastavy; }
	public JButton	getRemoveStateButton() { return cudliknaodstranenistavu; }
	public JButton	getNextButton() { return cudliknext; }
	public JButton	getStartBackButton() { return startbackcudlik; }
	public JLabel	getInstruction(){ return instruction; }
	public DefaultListModel<String>getTapeAlphabetItems() { return abeceda;}
    public DefaultListModel<String> getInputAlphabetItems() { return input;}
	public DefaultListModel<String> getStateItems() { return states;}
	public DefaultComboBoxModel<String> getStartItems() { return start;}
    
	// konstruktor
    public TMstartovaci() {
    	setLayout(null);
    	    	// popisky
    	instruction = new JLabel("Nastav abecedu, abecedu pasky, a stav");
    	instruction.setLocation(140,30);
    	instruction.setSize(800, 40);
    	add(instruction);    	
    	JLabel label = new JLabel("vstupni abeceda:");
  		label.setLocation(140,70);
		label.setSize(150, 40);
    	add(label);        
        label = new JLabel("abeceda pasky:");
  		label.setLocation(140,350);
		label.setSize(150, 40);
    	add(label);    	
    	label = new JLabel("stavy:");
		label.setLocation(540,70);
		label.setSize(150, 40);
    	add(label);        
        label = new JLabel("pocatecni stav");
	 	label.setLocation(540,350);
		label.setSize(150, 40);
    	add(label);    	
    	//textova pole
    	paskaabecedytext = new JTextField();
     	paskaabecedytext.setDocument(new JTextFieldLimit(1));
		paskaabecedytext.setLocation(140,390);
		 paskaabecedytext.setSize(150, 40);
    	add(paskaabecedytext);        
         vstupabecedytext = new JTextField();
    	 vstupabecedytext.setDocument(new JTextFieldLimit(1));
		vstupabecedytext.setLocation(140,110);
		vstupabecedytext.setSize(150, 40);
    	add(vstupabecedytext);    	
    	stavovytext = new JTextField();
    	stavovytext.setDocument(new JTextFieldLimit(10));
		stavovytext.setLocation(540,110);
		stavovytext.setSize(150, 40);
    	add(stavovytext);    	
    	// listy
       	paskaabecedylist = new JList<String>(abeceda);
        abeceda.addElement("_");
    	  paskaabecedyscrolovaci = new JScrollPane(paskaabecedylist, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		   paskaabecedyscrolovaci.setLocation(140,440);
		paskaabecedyscrolovaci.setSize(150, 180);
    	add(paskaabecedyscrolovaci);
        
           vstupniabecedalist = new JList<String>(input);
    	  vstupabecedyscrolovaci = new JScrollPane(vstupniabecedalist, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
           vstupabecedyscrolovaci.setLocation(140,160);
	     	vstupabecedyscrolovaci.setSize(150, 180);
    	add(vstupabecedyscrolovaci);    	
    	listeckystavu = new JList<String>(states);
            states.addElement("prijato");
        states.addElement("odmitnuto");
            	stavyscrolovaci = new JScrollPane(listeckystavu, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		     stavyscrolovaci.setLocation(540,160);
		   stavyscrolovaci.setSize(150, 180);
    	add(stavyscrolovaci);  	
         startComboBox  = new JComboBox<String>(start);
		   startComboBox.setLocation(540,390);
		  startComboBox.setSize(150, 35);
    	add(startComboBox);
        
    	//čudlíci
    	addcudlikavecednipasky = new JButton("+ abceda pasky");
    	addcudlikavecednipasky.setLocation(300,390);
		addcudlikavecednipasky.setSize(180, 40);
    	add(addcudlikavecednipasky);        
        cudliknaabecedu = new JButton("+ abceda");
    	cudliknaabecedu.setLocation(300,110);
		cudliknaabecedu.setSize(180, 40);
    	add(cudliknaabecedu);    	
    	cudliknastavy = new JButton("+ stav");
    	cudliknastavy.setLocation(700,110);
		cudliknastavy.setSize(150, 40);
    	add(cudliknastavy);                   	
    	removecudlikabecedypasky = new JButton("- abeceda pasky");
    	removecudlikabecedypasky.setLocation(300,440);
		removecudlikabecedypasky.setSize(180, 40);
    	add(removecudlikabecedypasky);        
          odstranovacicudlikabecedu = new JButton("- abeceda");
    	  odstranovacicudlikabecedu.setLocation(300,160);
		    odstranovacicudlikabecedu.setSize(180, 40);
    	add(odstranovacicudlikabecedu);    	
    	   cudliknaodstranenistavu = new JButton("- stav");
    	  cudliknaodstranenistavu.setLocation(700,160);
		  cudliknaodstranenistavu.setSize(150, 40);
    	 add(cudliknaodstranenistavu);    	
    	  cudliknext = new JButton("dalsi");
    	  cudliknext.setLocation(860,600);
	 	  cudliknext.setSize(100, 40);
    	add(cudliknext);
        cudliknext.setEnabled(false);        
           startbackcudlik = new JButton("menu");
    	    startbackcudlik.setLocation(30,30);
		startbackcudlik.setSize(95, 40);
    	add(startbackcudlik);
        startbackcudlik.setEnabled(true);	
    }    
}