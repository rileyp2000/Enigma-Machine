
public class Rotor {
	private int rotorNum;
	int pos;
	int intlPos;
	//index rep A-Z, num in each the paired value
	private int[] wiring;
	private final String[] WIRINGSETUPS = new String[] {"EKMFLGDQVZNTOWYHXUSPAIBRCJ",
			"AJDKSIRUXBLHWTMCQGZNPYFVOE","BDFHJLCPRTXVZNYEIWGAKMUSQO","ESOVPZJAYQUIRHXLNFTGKDCMWB",
			"VZBRGITYUPSDNHLXAWMJQOFECK"};
	
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
	
	public int process(int in, boolean rotate) {
		//take the input
		//based on rotation of rotor find pinned letter
		//from that pinned letter go to wiring setup and find that pair
		//then find pinned output letter from wiring setup pair output
		int intermed = (in + pos) %26;
		intermed = wiring[intermed];
		return intermed - pos;
	}
	
	public int advance() {
		int p = pos + 1;
		pos = p % 26;
		return p;
	}
	
	public void reset() {
		pos = intlPos;
	}

}
