/**
 * This class is a rotor within the enigma machine
 * @author Patrick Riley
 *
 */
public class Rotor {
	private int rotorNum;
	private int pos;
	private int intlPos;
	//index rep A-Z, num in each the paired value
	private int[] wiring;
	private final String[] WIRINGSETUPS = new String[] {"EKMFLGDQVZNTOWYHXUSPAIBRCJ",
			"AJDKSIRUXBLHWTMCQGZNPYFVOE","BDFHJLCPRTXVZNYEIWGAKMUSQO","ESOVPZJAYQUIRHXLNFTGKDCMWB",
			"VZBRGITYUPSDNHLXAWMJQOFECK"};
	
	/**
	 * Creates a new rotor from the wiring setups and an initial position
	 * @param num rotor number 0-5
	 * @param initialPos starting position of each of the rotors
	 */
	public Rotor(int num, int initialPos) {
		rotorNum = num;
		if(num >= 5 || num < 0)
			throw new IllegalArgumentException("Invalid Rotor Number");
		pos = initialPos;
		intlPos = initialPos;
		wiring = new int[26];
		
		for(int i =0; i < 26; i++)
			wiring[i] = WIRINGSETUPS[rotorNum].charAt(i) - 65;
	}
	
	/**
	 * take the input
	 *based on rotation of rotor find pinned letter
	 *from that pinned letter go to wiring setup and find that pair
	 *then find pinned output letter from wiring setup pair output
	 *
	 * @param in input position/letter
	 * @return output of wiring setup
	 */
	public int process(int in) {
		int intermed = (in + pos) %26;
		intermed = wiring[intermed];
		return intermed - pos;
	}
	
	/**
	 * Advances the position of the rotor
	 * @return The new position of the rotor
	 */
	public int advance() {
		int p = pos + 1;
		pos = p % 26;
		return p;
	}
	
	/**
	 * resets the rotor to its initial position
	 */
	public void reset() {
		pos = intlPos;
	}
	
	/**
	 * Sets the initial position of the rotor and sets the rotor to that position
	 * @param intl
	 * @return
	 */
	public int setIntlPos(int intl) {
		intlPos = intl;
		pos = intl;
		return intl;
	}
	
	public int getPos() {
		return pos;
	}

}
