import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Arrays;

import processing.core.*;

public class EnigmaMachine extends PApplet {
	PFont f;
	Letter[] letters = new Letter[26];
	Letter[] l2 = new Letter[26];
	public static final String KYBD = "QWERTYUIOPASDFGHJKLZXCVBNM";
	boolean keyDown = false;
	char c;
	public static void main(String[] args) {
		PApplet.main("EnigmaMachine");
	}

	public void settings() {
		size(1250, 1000);
	}

	public void setup() {
		f = createFont("Arial", 16, true);
		textFont(f, 40);

		int diameter = 100;
		int spacing = 10;
		int vertSpacing = spacing + diameter;

		for (int i = 0; i < 26; i++) {
			int offset = 0;
			int trueVert = vertSpacing;
			if (i < 10) {
				offset = 100 + i * (vertSpacing);
			} else {
				if (i < 19) {
					offset = 150 + (i - 10) * (vertSpacing);
					trueVert *= 2;
				} else {
					offset = 250 + (i - 19) * (vertSpacing);
					trueVert *= 3;
				}
			}
			// String letter = Character.toString((char) (i + 65));
			letters[i] = new Letter(this, Character.toString(KYBD.charAt(i)), offset, trueVert);
		}

		for (int i = 0; i < letters.length; i++) {
			l2[i] = letters[i].copy();
			l2[i].setYPos(l2[i].getYPos() + 600);
		}

	}

	public void draw() {
		text("Inputed Key:",10,50);
		for (Letter l : letters) {
			l.draw();
		}
		fill(255);
		rect(475,475, 75,75);
		rect(575,475, 75,75);
		rect(675,475, 75,75);
		
		for (Letter l : l2) {
			l.draw();
		}
	}

	public void keyPressed() {
		if (!keyDown) {
			String s = Character.toString(key);
			s = s.toUpperCase();
			c = s.charAt(0);
			letters[KYBD.indexOf(c)].isLit = !letters[KYBD.indexOf(c)].isLit;
			keyDown = true;
			
		}
	}

	public void keyReleased() {
		String s = Character.toString(key);
		s = s.toUpperCase();
		if (keyDown && s.charAt(0) == c) {
			letters[KYBD.indexOf(c)].isLit = !letters[KYBD.indexOf(c)].isLit;
			keyDown = false;
		}
	}
}
