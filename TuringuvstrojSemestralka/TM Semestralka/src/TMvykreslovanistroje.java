import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

//TM vykreslovani stroje
public class TMvykreslovanistroje extends JPanel {
	
     // attributes
     private int hlavapasky, poradnikvykresleni;
     private JLabel stavy, tiskerror;
     private JButton spoustecicudlik, ukladacicudlik, cudliknazzmenuvstupu, resetovacicudlik;
     private JSlider slider;
     private JSpinner spinner;
     private SpinnerNumberModel cell; 
     private ArrayList<String> vstupecek;
         
     // metody
     public int getTapeHeadCell() { return hlavapasky; }
     public int	 getPrintOrder() { return poradnikvykresleni; }
     public JLabel getState() { return stavy; }
     public JLabel getPrintError() { return tiskerror; }
     public JButton getRunButton() { return spoustecicudlik; }
     public JButton getSaveMachineButton() { return ukladacicudlik; }
     public JButton getChangeInputButton() { return cudliknazzmenuvstupu; }
     public JButton getResetButton() { return resetovacicudlik; }
     public JSlider getSlider() { return slider; }
     public JSpinner getSpinner() { return spinner; }
     public ArrayList<String> getInput() { return vstupecek; } 
     public void setTapeHeadCell(int cell) { hlavapasky = cell; }
     public void setPrintOrder(int order) { poradnikvykresleni = order; }
     public void setInput(ArrayList<String> anInput) { vstupecek = anInput; }
     
     // konstruktor
     public TMvykreslovanistroje() {
    	 setLayout(null);
    	 setBackground(Color.white);
    	 hlavapasky = 1;
    	 vstupecek = new ArrayList<String>();
        
    	 //pridal jsem tady i rychlost vykreslovani takovy zajmavy bonus :-D co sem si sti mvyhraval
    	 JLabel label = new JLabel("1 pomaly 10 rychly");
    	 label.setLocation(335,555);
    	 label.setSize(200, 40);
    	 add(label);
        
    	 label = new JLabel("zvol si stratovaci blok");
    	 label.setLocation(680,555);
    	 label.setSize(200, 40);
    	 add(label);
        
    	 label = new JLabel();
    	 label.setLocation(1,520);
    	 label.setSize(998, 30);
    	 label.setBorder(BorderFactory.createRaisedBevelBorder());
    	 add(label);
        
    	 label = new JLabel();
    	 label.setLocation(1,515);
    	 label.setSize(998, 5);
    	 label.setBorder(BorderFactory.createRaisedBevelBorder());
    	 add(label);
                       
    	 label = new JLabel("st");
    	 label.setLocation(32,520);
    	 label.setSize(80 , 30);
    	 add(label);
        
    	 stavy = new JLabel("");
    	 stavy.setLocation(120,518);
    	 stavy.setSize(200 , 35);
    	 stavy.setFont(new Font("arial", Font.BOLD,12));
    	 stavy.setForeground(Color.black);
    	 add(stavy);
        
    	 tiskerror = new JLabel("");
    	 tiskerror.setLocation(830,518);
    	 tiskerror.setSize(200 , 30);
    	 tiskerror.setForeground(Color.RED);
    	 add(tiskerror);
    	 
    	 // cudliky
    	 cudliknazzmenuvstupu = new JButton("uprav nastaveni");
    	 cudliknazzmenuvstupu.setLocation(30,565);
    	 cudliknazzmenuvstupu.setSize(150, 40);
    	 add(cudliknazzmenuvstupu);
       	 resetovacicudlik = new JButton("resetuj");
    	 resetovacicudlik.setLocation(870,615);
    	 resetovacicudlik.setSize(100, 40);
    	 add(resetovacicudlik);
    	 spoustecicudlik = new JButton("start");
    	 spoustecicudlik.setLocation(870,565);
    	 spoustecicudlik.setSize(100, 40);
    	 add(spoustecicudlik);
        
    	 ukladacicudlik = new JButton("uloz si stroj");
    	 ukladacicudlik.setLocation(30,615);
    	 ukladacicudlik.setSize(150, 40);
    	 add(ukladacicudlik);
          cell = new SpinnerNumberModel(1,1,31,1);
    	 spinner = new JSpinner(cell);
    	 spinner.setEditor(new JSpinner.DefaultEditor(spinner));
    	 spinner.setLocation(710,592);
    	 spinner.setSize(60, 50);
    	 add(spinner);
         slider = new JSlider(JSlider.HORIZONTAL,1,10,6);
    	 slider.setMajorTickSpacing(1);
    	 slider.setPaintTicks(true);
    	 slider.setPaintLabels(true);
    	 slider.setLocation(230,600);
    	 slider.setSize(400, 40);
    	 add(slider);	
     }
     
     // vykreslovaci fce
     public void paintComponent(Graphics g){
    	 super.paintComponent(g);
        
       
         g.setColor(new Color(238,238,238));
         g.fillRect(0, 550, 1000, 150);
        
         // vykresleni stavu
         g.setColor(Color.black);
         g.drawRect(350, 50, 300, 80);
         g.setFont(new Font("sans", Font.PLAIN, 30));
         g.drawString("Stav",414,103);
        
         // to je ta zatracena prokleta šipka
	     int tapeHeadX = hlavapasky * 30;        
	     g.drawLine(tapeHeadX+16, 180, tapeHeadX+16, 460);
	     g.drawLine(tapeHeadX+16, 460, tapeHeadX+11, 455);
	     g.drawLine(tapeHeadX+16, 460, tapeHeadX+21, 455);
	     g.drawLine(500 , 180, tapeHeadX+16, 180);
	     g.drawLine(500 , 180, 500, 130);      
      
         // nakresli bloky 
         int a = 0;
         for(int i = 0; i < 33; i++){
        	 g.setColor(Color.black);
             g.drawRect(1+a, 460, 30, 30);
             a = a+30;
         }
      
         //nakresli symboly
	     a = 12;
	     for(int i = 0; i<vstupecek.size(); i++){
	     	g.setColor(Color.black);
	        g.setFont(new Font("arial", Font.PLAIN, 18)); 
	        String blank = (String)vstupecek.get(i);
	        if((poradnikvykresleni == 0) && (i == hlavapasky)){}
	        else{
	        	if((blank.equals("")) || (blank.equals(("_")))){
	        		g.drawRect(a-3, 468, 14, 15);
			    }
			    else{
			    	g.drawString((String)vstupecek.get(i),a,481); 
			    }
	        }
	        a = a+30;
	     }
     }
}