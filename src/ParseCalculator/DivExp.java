package ParseCalculator;

/**
 * DivExp: it is extended from the abstract class Exp. This class is used to
 * represent the expression of division

 */

public class DivExp extends Exp {

	private Exp factor;
	private Exp term;

	public DivExp(Exp factor, Exp term) {
		this.factor = factor;
		this.term = term;
	}

	@Override
	public String show() {
		return "(" + factor.show() + " / " + term.show() + ")";
	}

	@Override
	public int evaluate() {
		return (factor.evaluate() / term.evaluate());
	}
}