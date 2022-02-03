import java.awt.*;
import javax.swing.*;

//TMmenu
public class TMmenu extends JPanel{
	
    // attributy
    private int 	 vcilcudlik;
    private JLabel	 title, popis;
    private JButton  nacitacicudlik, vytvorcudlik;
         // metody
    public JButton getLoadButton() { return nacitacicudlik; }
    public JButton getCreateButton() { return vytvorcudlik; }     
        public void setCurrentButton(int button) { 
    	vcilcudlik = button;
    	repaint();
    }
    //konstruktor
	public TMmenu() {
        setLayout(null);
        setBackground(Color.white);
        vcilcudlik = 1;
        
    	//popisky      
        title = new JLabel("jednopaskovy TM");
        title.setLocation(258,35);
		title.setSize(500,80);
		title.setFont(new Font("arial", Font.BOLD,40)); 
        add(title);
        
        popis = new JLabel("Zvol si");
        popis.setLocation(424,150);
        popis.setSize(200,80);
        popis.setFont(new Font("arial", Font.BOLD, 30)); 
        add(popis);
        
        //čudlky	
        nacitacicudlik = new JButton("Nacti stroj");
    	nacitacicudlik.setLocation(150,430);
		nacitacicudlik.setSize(300,100);
		nacitacicudlik.setFont(new Font("arial", Font.PLAIN,30)); 	
    	add(nacitacicudlik);
        
        vytvorcudlik = new JButton("Vytvor stroj");
    	vytvorcudlik.setLocation(550,430);
		vytvorcudlik.setSize(300,100);
		vytvorcudlik.setFont(new Font("arial", Font.PLAIN,30)); 
    	add(vytvorcudlik);         	
    }
	
	//vykresůpvaci funkce
	public void paintComponent(Graphics g){
        super.paintComponent(g);

        //hranice
        g.setColor(Color.black);
        g.drawRect(350, 150, 300, 80);
        
        // šipka no to byl težký porod
	    int  tapeHeadX;
	    if(vcilcudlik == 1){
	    	tapeHeadX = 285;
	    }
	    else{
	    	tapeHeadX = 690;
	    }
	    g.drawLine(tapeHeadX+16, 280, tapeHeadX+16, 430);
	    g.drawLine(tapeHeadX+16, 430, tapeHeadX+11, 425);
	    g.drawLine(tapeHeadX+16, 430, tapeHeadX+21, 425);
	    g.drawLine(500 , 280, tapeHeadX+16, 280);
	    g.drawLine(500 , 230, 500, 280);          
    }
}