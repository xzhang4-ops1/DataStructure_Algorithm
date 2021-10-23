package ParserAlgorithm2;

/**
 * Write a parse to recognize the language specified by the following grammar:
 * S := () ; S := (S) ; S := SS ;
 */
public class Parser {
	Tokeniser _tokeniser;
    
    public Parser(Tokeniser tokeniser) {
    	_tokeniser = tokeniser;
    }

    /**
	 * @return True if the given tokens conform with the grammar. False, otherwise.
	 */
	public boolean parseExp() {
		if (!_tokeniser.isNextValid()) return false;
		if (!_tokeniser.hasNext()) {
			return true;
		}
		if (_tokeniser.next().type== Token.Type.LEFT_BRACKET&&_tokeniser.nextNext()!=null) {
			if (_tokeniser.nextNext().type == Token.Type.LEFT_BRACKET) {
				return this.parseDoubleS();
			}
			if (_tokeniser.nextNext().type== Token.Type.RIGHT_BRACKET){
				return this.parseSingle();
			}
		}



		return false;
    }
	public boolean parseDoubleS() {
		_tokeniser.takeNext();
		_tokeniser.takeNext();
		if (_tokeniser.next()==null)
			return false;
		if (_tokeniser.next().type== Token.Type.LEFT_BRACKET&&_tokeniser.nextNext()!=null) {
			if (_tokeniser.nextNext().type == Token.Type.LEFT_BRACKET) {
				this.parseDoubleS();
			}
			this.parseExp();
			if (_tokeniser.next()==null)
				return false;
			if (_tokeniser.next()!=null&&_tokeniser.nextNext()==null)
				return false;
		}if (_tokeniser.next().type!= Token.Type.RIGHT_BRACKET||_tokeniser.nextNext().type!= Token.Type.RIGHT_BRACKET)
			return false;
		_tokeniser.takeNext();
		_tokeniser.takeNext();
		return this.parseExp();
//		if (_tokeniser.next()!=null&&_tokeniser.nextNext()==null)
//			return false;
//		return true;

	}
	public boolean parseSingle(){
		_tokeniser.takeNext();
		_tokeniser.takeNext();
		return this.parseExp();

	}

}
