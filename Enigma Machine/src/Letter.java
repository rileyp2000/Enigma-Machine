import processing.core.*;

public class Letter {
	String val;
	int xPos, yPos;
	boolean isLit = false;
	PApplet parent;
	static int diameter = 100;
	static int spacing = 10;
	static int vertSpacing = spacing + diameter;

	Letter(PApplet p, String v, int x, int y) {
		parent = p;
		val = v;
		xPos = x;
		yPos = y;
	}

	Letter copy() {
		return new Letter(parent,val, xPos, yPos);
	}

	int getYPos() {
		return yPos;
	}

	void setYPos(int y) {
		yPos = y;
	}
	
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
