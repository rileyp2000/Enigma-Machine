
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
			wiring[i] = WIRINGSETUPS[rotorNum].charAt(i);
	}
	
	public int process(int in, boolean rotate) {
		int ret = wiring[(in + pos) % 26];
		if(rotate)
			advance();
		return ret;
	}
	
	public void advance() {
		pos = (pos + 1) % 26;
	}
	
	public void reset() {
		pos = intlPos;
	}
	
	
}
