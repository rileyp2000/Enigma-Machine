/**
 * Represents a letter on the keyboard of the applet
 */
import processing.core.*;

public class Letter {
	String val;
	int xPos, yPos;
	boolean isLit = false;
	PApplet parent;
	static int diameter = 100;
	static int spacing = 10;
	static int vertSpacing = spacing + diameter;
	
	/**
	 * Creates a basic letter
	 * @param p the Applet to be used, dont worry about this much
	 * @param v value of the letter
	 * @param x X position of the letter in the panel
	 * @param y Y position of the letter in the panel
	 */
	Letter(PApplet p, String v, int x, int y) {
		parent = p;
		val = v;
		xPos = x;
		yPos = y;
	}
	
	/**
	 * Copy method
	 * @return a copy of the letter
	 */
	Letter copy() {
		return new Letter(parent,val, xPos, yPos);
	}
	
	/**
	 * Getter for y position
	 * @return y position
	 */
	int getYPos() {
		return yPos;
	}
	
	/**
	 * Sets the y position
	 * @param y the new y position
	 */
	void setYPos(int y) {
		yPos = y;
	}
	
	/**
	 * Draws the letter at the current position
	 */
	void draw(){
		if(isLit)
			parent.fill(parent.color(255, 237, 107));
		else
			parent.fill(255);
		parent.ellipse(xPos,yPos,diameter, diameter);
		parent.fill(0);
		parent.text(val, xPos-10, yPos+10);
	}
}
