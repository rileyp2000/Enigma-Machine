import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlP5.ControlP5;
import processing.core.*;

public class Plugboard {
	private char[] connections;
	PApplet parent;
	ControlP5 cp5;
	
	public Plugboard(PApplet p) {
		connections = new char[26];
		parent = p;
		cp5 = new ControlP5(p);
	}
	
	void setup() {
		Object[] fields = new Object[52];
		
		for(int i = 0; i < 26; i++) {
			String s = "" + (char)(i+65);
			fields[2*i] = s;
			fields[(2*i)+1] = new JTextField(25);
		}
		
		
		JOptionPane.showConfirmDialog(null,fields, "PlugBoard Arrangement", JOptionPane.OK_CANCEL_OPTION);
	}
	
	void draw() {
		PFont f = parent.createFont("Arial", 24, true);
		parent.textFont(f,60);
		parent.fill(0);
		int x = 50;
		  for (int i = 0; i < 26; i++) {
		    parent.text((char)(i+65),x,1200);
		    // textWidth() spaces the characters out properly.
		    //cp5.addTextfield("" + i).setPosition((i *80)+50 , 1250).setSize(60, 60).setAutoClear(false).setFont(parent.createFont("arial", 20)).setColorBackground(0).setId(i);
		    x += (parent.textWidth((char)(i+65)) + 15);
		    
		    
		    
		  }
	}
}
