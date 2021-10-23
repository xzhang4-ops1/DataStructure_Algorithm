package ParserAlgorithm3;

/**

 */
public class Tokeniser {
    private String _buffer;

    public Tokeniser(String buffer) {
        this._buffer = buffer;
    }

    /**
     * Get token at a specified index
     * @param index Index of the character to be tokenised from the buffer
     * @return {@link Token}
     */
    private Token getTokenAt(int index) {
        if (_buffer.isEmpty())
            return null;
        char firstChar=_buffer.charAt(0);
        if (Character.isDigit(firstChar)){
            int castInt=Integer.parseInt(firstChar+"");
            if (castInt%2==0){
                Token token=new Token(Token.Type.EVEN_NUMBER,firstChar+"");
                return token;
            }
            if (castInt%2!=0){
                Token token=new Token(Token.Type.ODD_NUMBER,firstChar+"");
                return token;
            }
        }

        return null;
    }

    /**
     * Return the next token without changing the buffer
     * @return the next token OR null when there is no more token or the next token is invalid.
     */
    public Token next() {
        return getTokenAt(0);
    }

    /**
     * Return the last token without changing the buffer
     * @return the last token OR null when there is no more token or the next token is invalid.
     */
    public Token last() {
        return getTokenAt(_buffer.length() - 1);
    }

    /**
     * Return the next token and remove it from the buffer
     * @return the next token OR null when there is no more token or the next token is invalid.
     */
    public Token takeNext() {
        Token token = next();
        if (token == null)
            return null;

        if (token.originalTokenStr.length() < _buffer.length()) {
            _buffer = _buffer.substring(token.originalTokenStr.length());
        } else {
        	_buffer = "";
        }
        
        return token;
    }

    /**
     * Return the last token and remove it from the buffer
     * @return the last token OR null when there is no more token or the next token is invalid.
     */
    public Token takeLast() {
        Token token = last();
        if (token == null)
            return null;

        if (token.originalTokenStr.length() < _buffer.length()) {
            _buffer = _buffer.substring(0, _buffer.length() - token.originalTokenStr.length());
        } else {
            _buffer = "";
        }

        return token;
    }

    /**
     * @return whether there is another token to parse in the buffer
     */
    public boolean hasNext() {
        return next() != null;
    }

    /**
     * @return True only if the next token is valid
     */
    public boolean isNextOrLastValid() {
        if ((next() == null || last() == null) && !_buffer.isEmpty()) {
            return false;
        }

        return true;
    }
}