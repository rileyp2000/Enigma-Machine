
/**
 * This class handles most of the p5 stuff and runs the machine
 * @author Patrick Riley
 */

import processing.core.PApplet;
import javax.swing.JOptionPane;
import processing.core.*;

public class EnigmaMachine extends PApplet {
	PFont f;
	Letter[] letters = new Letter[26];
	Letter[] l2 = new Letter[26];
	public static final String KYBD = "QWERTYUIOPASDFGHJKLZXCVBNM";
	private static final int RBOX = 475;
	boolean keyDown = false;
	char c;
	int encoded;
	EngMach enigma;
	private Plugboard p;

	/**
	 * Starts the window applet for the machine
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main("EnigmaMachine");
	}

	public void settings() {
		size(1800, 1500);
	}

	public void setup() {
		enigma = new EngMach(createRotors());
		p = new Plugboard(this);
		f = createFont("Arial", 16, true);
		textFont(f, 40);
		fill(0);
		text("Inputed Key:", 10, 50);
		drawRotorBox();
		createLetters();
		p.setup();
		p.draw();
		textFont(f, 40);
		
		
	}

	/**
	 * Draws the boxes in which the current pos of the rotors will appear
	 */
	public void drawRotorBox() {

		textFont(f, 40);
		fill(0);
		text("Rotors: ", 275, 525);
		fill(255);
		rect(RBOX, RBOX, 75, 75);
		rect(575, RBOX, 75, 75);
		rect(675, RBOX, 75, 75);
	}

	/**
	 * Draws the letters every frame, whether lit or not
	 */
	public void draw() {
		for (Letter l : letters) {
			l.draw();
		}
		for (Letter l : l2) {
			l.draw();
		}
		drawRotorPos();
	}

	/**
	 * What happens when a key is pressed
	 */
	public void keyPressed() {
		// Makes sure only one is pressed at a time
		if (!keyDown && Character.isLetter(key)) {
			String s = Character.toString(key);
			s = s.toUpperCase();
			c = s.charAt(0);
			letters[KYBD.indexOf(c)].isLit = !letters[KYBD.indexOf(c)].isLit;
			keyDown = true;
			enigma.advance();
			encoded = enigma.encode(c);
			System.out.println(encoded + " " + (char) encoded);
			l2[KYBD.indexOf((char) encoded)].isLit = !l2[KYBD.indexOf((char) encoded)].isLit;
		}
	}

	/**
	 * Makes sure only one key is lit up
	 */
	public void keyReleased() {
		String s = Character.toString(key);
		s = s.toUpperCase();
		if (keyDown && s.charAt(0) == c) {
			letters[KYBD.indexOf(c)].isLit = !letters[KYBD.indexOf(c)].isLit;
			l2[KYBD.indexOf((char) encoded)].isLit = !l2[KYBD.indexOf((char) encoded)].isLit;
			keyDown = false;
		}
	}

	/**
	 * Creates the rotors based on user input of rotor choice and initial position
	 * 
	 * @return An array of the rotors to be used in the machine
	 */
	public Rotor[] createRotors() {
		// Scanner kybd = new Scanner(System.in);
		// System.out.println("please input 3 rotors seperated by spaces");
		String str = JOptionPane.showInputDialog("Please input 3 rotors (0-4) seperated by spaces:");// kybd.nextLine();
		String[] rotors = str.split(" ");

		// System.out.println("Please the 3 starting positions of the rotors");
		String intlPoses = JOptionPane.showInputDialog("Please pick the 3 starting positions of the rotors:");// kybd.nextLine();
		String[] starting = intlPoses.split(" ");

		Rotor[] ret = new Rotor[3];
		for (int i = 0; i < 3; i++) {
			ret[i] = new Rotor(Integer.parseInt(rotors[i]), Integer.parseInt(starting[i]));
		}

		return ret;

	}

	/**
	 * Draws the rotor letters
	 */
	public void drawRotorPos() {
		int[] poss = enigma.getRotorPos();
		for (int i = 0; i < 3; i++) {
			fill(255);
			rect((i * 100) + RBOX, RBOX, 75, 75);
			fill(0);
			text(poss[i], (i * 100) + 500, 525);
		}
	}

	/**
	 * Creates the arrays of letters for the panels of the machine
	 */
	public void createLetters() {
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
}
