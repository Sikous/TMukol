import javax.swing.*;

//TM uvod
public class TMnacti extends JPanel{
	
	// atributy
	private JButton	 cudliknanacteni, cudliknaremove, nacitacicudlikback;
	private JList<String>   listsouboru;		   
	private JScrollPane     souboryscorlovacihopanelu;	
	private DefaultListModel<String> soubory = new DefaultListModel<String>();
		
	// metody
	public JList<String>getFileList() { return listsouboru;}
	public JScrollPane  getFileScrollPane() { return souboryscorlovacihopanelu; }
	public JButton getLoadMachineButton() { return cudliknanacteni; }
	public JButton getRemoveMachineButton() { return cudliknaremove; }
	public JButton getLoadBackButton() { return nacitacicudlikback; }
	public DefaultListModel<String> getFileItems() { return soubory; }
	//konstukrtor
    public TMnacti() {

    	setLayout(null);
    	
    	//popisky
    	JLabel label = new JLabel("Zvol ");
		label.setLocation(300,35);
		label.setSize(800, 40);
    	add(label);
    	
    	//list
 		listsouboru = new JList<String>(soubory);
    	souboryscorlovacihopanelu = new JScrollPane(listsouboru, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		souboryscorlovacihopanelu.setLocation(300,80);
		souboryscorlovacihopanelu.setSize(400, 485);
    	add(souboryscorlovacihopanelu);
    	
    	//čudliky   	    	   	
    	nacitacicudlikback = new JButton("menu");
    	nacitacicudlikback.setLocation(50,35);
		nacitacicudlikback.setSize(100, 40);
    	add(nacitacicudlikback);
    	cudliknanacteni = new JButton("nacti mašinu");
    	cudliknanacteni.setLocation(580,590);
		cudliknanacteni.setSize(120, 40);
    	add(cudliknanacteni);
    	cudliknaremove = new JButton("odstran mašinu");
    	cudliknaremove.setLocation(300,590);
		cudliknaremove.setSize(140, 40);
    	add(cudliknaremove);
    }    
}