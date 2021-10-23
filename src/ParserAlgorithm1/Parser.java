package ParserAlgorithm1;

/**

 * Write a parse to recognize the language specified by the following grammar:
 * S := () ; S := )S( ; S := SS ;
 *
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
		while (_tokeniser.hasNext()&&_tokeniser.nextNext()!=null){
			boolean a = true;
			if (_tokeniser.next().type== Token.Type.LEFT_BRACKET){
				return this.parseLeftBegin();
			}
			if (_tokeniser.next().type== Token.Type.RIGHT_BRACKET){
				this.parseRightBegin();
			}
			return this.parseExp();
		}

		return false;
	}
	public boolean parseLeftBegin(){
		Token ccc=_tokeniser.nextNext();
		if (ccc.type!= Token.Type.RIGHT_BRACKET)
			return false;
		if (_tokeniser.nextNext().type== Token.Type.RIGHT_BRACKET){
			_tokeniser.takeNext();
			_tokeniser.takeNext();
			return this.parseExp();

		}
		return true;
	}
	public boolean parseRightBegin(){
		Token ccc=_tokeniser.nextNext();
		if (ccc==null)
			return false;

		if (ccc.type== Token.Type.RIGHT_BRACKET) {
			_tokeniser.takeNext();
			this.parseRightBegin();
		}
		if (ccc.type== Token.Type.LEFT_BRACKET){
			_tokeniser.takeNext();
			if (_tokeniser.nextNext().type== Token.Type.RIGHT_BRACKET){
				_tokeniser.takeNext();
				_tokeniser.takeNext();
			}
			if (_tokeniser.next().type== Token.Type.LEFT_BRACKET&&_tokeniser.nextNext()!=null){
				if (_tokeniser.nextNext().type== Token.Type.RIGHT_BRACKET) {
					_tokeniser.takeNext();
					_tokeniser.takeNext();
				}
			}

		}
		_tokeniser.takeNext();
		return true;
	}

}
