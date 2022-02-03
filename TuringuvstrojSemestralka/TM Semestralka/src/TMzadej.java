import javax.swing.*;

//TM vstup
public class TMzadej extends JPanel implements java.io.Serializable{
	
	// atributy
	private JTextField   vstupecek;
    private JButton   nabuildovacicudlik, cudlikzpet, cudlikpridej, cudlikodstran, cudlikvycisti;
    private JList<String> vstupnilist;
    private JLabel inputLabels[], instrukce;
    private JSlider slider;
    private JScrollPane inputScrollPane;
    private DefaultListModel<String> vstupnisymboly = new DefaultListModel<String>();
	
    // metody
	public JTextField	getInputField() { return vstupecek; }
	public JButton getAddButton() { return cudlikpridej; }
	public JButton getRemoveButton() { return cudlikodstran; }
	public JButton getBuildButton() { return nabuildovacicudlik; }
	public JButton getBackButton() { return cudlikzpet; }
	public JButton getClearButton() { return cudlikvycisti; }
    public JList<String> getInputList() { return vstupnilist; }
    public JSlider  getSlider() { return slider; }
    public JLabel getInputLabels(int i) { return inputLabels[i]; }
    public JLabel  getInstruction() { return instrukce; }
    public DefaultListModel<String> getInputSymbols() { return vstupnisymboly; }
    
    // konstruktor
    public TMzadej() {
    	setLayout(null);    	
        //poipisky      
    	instrukce = new JLabel("Pridej si 'pismenka na pasku co jsi si nastavil'.");
    	instrukce.setLocation(30,30);
    	instrukce.setSize(500, 40);
    	add(instrukce);
    	
    	JLabel label = new JLabel("vstup:");
  		label.setLocation(30,50);
	    	label.setSize(150, 40);
    	add(label);        
        label = new JLabel("Vstupní abeceda:");
  		 label.setLocation(398,170);
		label.setSize(150, 40);
    	add(label);        
         label = new JLabel("jaky koliv nevyplneny blok pasky bude zaplnen prazdnym symbolem   _   ");
  		 label.setLocation(280,500);
	 	label.setSize(500, 40);
    	add(label);
                  	
        // popisky vstupu
        inputLabels = new JLabel[31];
        for(int i=0; i<31; i++) {
            inputLabels[i] = new JLabel();
            inputLabels[i].setLocation(30*(i+1),90);
            inputLabels[i].setSize(25, 25);
            inputLabels[i].setBorder(BorderFactory.createRaisedBevelBorder());
            inputLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            add(inputLabels[i]);
        }          	
        // posuvnik
        slider = new JSlider(JSlider.HORIZONTAL,1,31,1);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setLocation(33,120);
		slider.setSize(920, 40);
        add(slider);   	
    	 	//list
        vstupnilist = new JList<String>(vstupnisymboly);
        inputScrollPane = new JScrollPane(vstupnilist, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		inputScrollPane.setLocation(380,200);
		inputScrollPane.setSize(120, 270);
        add(inputScrollPane);
    	  	//čudlikove   	
    	cudlikpridej = new JButton("pridej");
    	cudlikpridej.setLocation(520,200);
		cudlikpridej.setSize(100, 40);
    	add(cudlikpridej);
    	  	cudlikodstran = new JButton("odstran");
    	cudlikodstran.setLocation(520,260);
		cudlikodstran.setSize(100, 40);
    	add(cudlikodstran);
    	    	cudlikvycisti = new JButton("vycisti");
    	cudlikvycisti.setLocation(150,600);
		cudlikvycisti.setSize(100, 40);
    	add(cudlikvycisti);
    	 	cudlikzpet = new JButton("zpet");
    	cudlikzpet.setLocation(30,600);
		cudlikzpet.setSize(100, 40);
    	add(cudlikzpet);
    	 	nabuildovacicudlik = new JButton("nabuildi");
    	nabuildovacicudlik.setLocation(860,600);
		nabuildovacicudlik.setSize(100, 40);
    	add(nabuildovacicudlik);
    }    
}