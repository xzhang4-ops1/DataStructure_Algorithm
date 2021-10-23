package ParserAlgorithm3;

/**
 * Write a parse to recognize the language specified by the following grammar:
 * X := 1 | 3 | 5 | 7 | 9 ; Y := 0 | 2 | 4 | 6 | 8 ; X := YX ; Y := XY ; S := X | Y ;
 *
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
		if (!_tokeniser.isNextOrLastValid()) return false;
		if (!_tokeniser.hasNext()) {
			return true;
		}

		if (_tokeniser.next().type== Token.Type.ODD_NUMBER){
			_tokeniser.takeNext();
			if (!_tokeniser.isNextOrLastValid())
				return false;
			if (!_tokeniser.hasNext())
			{
				return true;
			}
			if (_tokeniser.next().type==Token.Type.EVEN_NUMBER){
				return this.parseYX();
			}
			if (_tokeniser.next().type==Token.Type.ODD_NUMBER){
				return this.parseYYX();
			}
		}

		if (_tokeniser.next().type== Token.Type.EVEN_NUMBER){
			_tokeniser.takeNext();
			if (!_tokeniser.isNextOrLastValid())
				return false;
			if (!_tokeniser.hasNext())
			{
				return true;
			}

			if (_tokeniser.next().type==Token.Type.ODD_NUMBER){
			return 	this.parseYX();
			}
			if (_tokeniser.next().type==Token.Type.EVEN_NUMBER){
			return 	this.parseXYY();
			}

		}

		// END YOUR CODE
		return false;
	}
	public boolean parseYX() {
		_tokeniser.takeNext();
		return this.parseExp();

	}
	public boolean parseXYY() {
		if (!_tokeniser.hasNext()){
			return false;
		}
		if (_tokeniser.next().type== Token.Type.ODD_NUMBER){
			_tokeniser.takeNext();
		return 	this.parseExp();
		}
		if (_tokeniser.next().type== Token.Type.EVEN_NUMBER){
			_tokeniser.takeNext();
		return 	this.parseXYY();
		}
		return true;
	}
	public boolean parseYYX() {
		if (!_tokeniser.hasNext()){
			return false;
		}
		if (_tokeniser.next().type== Token.Type.EVEN_NUMBER){
			_tokeniser.takeNext();
			return 	this.parseExp();
		}
		if (_tokeniser.next().type== Token.Type.ODD_NUMBER){
			_tokeniser.takeNext();
			return 	this.parseYYX();
		}
		return true;
	}

}
