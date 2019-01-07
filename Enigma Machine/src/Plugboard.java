import processing.core.*;

public class Plugboard {
	private char[] connections;
	PApplet parent;
	
	public Plugboard(PApplet p) {
		connections = new char[26];
		parent = p;
	}
	
	void draw() {
		for(int i = 0; i < 26; i++) {
			parent.text((char)(i+65),i * 50,1200);
		}
	}
}
