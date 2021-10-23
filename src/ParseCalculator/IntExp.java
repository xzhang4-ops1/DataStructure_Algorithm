package ParseCalculator;

/**
 * LitExp: it is extended from the abstract class Exp,
 * 		   This class is used to represented the expression of 32-bit unsigned integer
 *

 */

public class IntExp extends Exp {
	
	private Integer value;

	public IntExp(Integer value) {
		this.value = value;
	}

	@Override
	public String show() {
		return value.toString();
	}

	@Override
	public int evaluate() {
		return value;
	}
}
