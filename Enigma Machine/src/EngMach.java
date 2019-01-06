/**
 * Represents the actual enigma machine
 * @author Patrick
 *
 */
public class EngMach {
	private Rotor r1, r2, r3;
	private final String REFLECTOR = "YRUHQSLDPXNGOKMIEBFZCWVJAT";

	public EngMach(Rotor r1, Rotor r2, Rotor r3) {
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
	}

	public EngMach(Rotor[] r) {
		r1 = r[0];
		r2 = r[1];
		r3 = r[2];
	}

	public int[] getRotorPos() {
		return new int[] { r1.getPos(), r2.getPos(), r3.getPos() };
	}

	/*
	 * public int encode(char inChar) { System.out.println(); return 65 +
	 * r3.process(r2.process(r1.process(r1.process(r2.process(r3.process(((int)
	 * inChar) - 65)))))); }
	 */

	/**
	 * Encodes the input character through the rotors
	 * 
	 * @param inChar inputed char
	 * @return The int value of the encoded letter
	 */
	public int encode(char inChar) {
		int p = ((int) inChar) - 65;

		p = r3.process(p, true);
		p = r2.process(p, true);
		p = r1.process(p, true);

		p = reflect(p);

		p = r1.process(p, false);
		p = r2.process(p, false);
		p = r3.process(p, false);

		return 65 + p;
	}
	
	/**
	 * Reflects the letter at the end of the first pass through the rotors
	 * @param in input char
	 * @return the reflected char
	 */
	public int reflect(int in) {
		return REFLECTOR.charAt(in) - 65;
	}
	
	/**
	 * Advances the rotors properly
	 */
	public void advance() {
		int p = r3.advance();
		if (p >= 26) {
			int p2 = r2.advance();
			if (p2 >= 26)
				r1.advance();
		}
	}
}
