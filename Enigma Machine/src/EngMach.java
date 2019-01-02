
public class EngMach {
	private Rotor r1,r2,r3;
	
	public EngMach(Rotor r1, Rotor r2, Rotor r3) {
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
	}
	
	public void advance() {
		int p = r3.advance();
		if(p >= 26) {
			int p2 = r2.advance();
			if(p2 >= 26)
				r1.advance();
		}
	}
}
