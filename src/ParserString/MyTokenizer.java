package ParserString;

/**
 * Name: Tokenizer.java

 */

public class MyTokenizer extends Tokenizer {

    private String _buffer;		//save text
    private Token currentToken;	//save token extracted from next()

    /**
     *  Tokenizer class constructor
     *  The constructor extracts the first token and save it to currentToken
     */
    public MyTokenizer(String text) {
    	_buffer = text;		// save input text (string)
    	next();		// extracts the first token.
    }

    /**
     *  This function will find and extract a next token from {@code _buffer} and
     *  save the token to {@code currentToken}.
     */
    public void next() {
        _buffer = _buffer.trim(); // remove whitespace

         if(_buffer.isEmpty()) {
            currentToken = null;	// if there's no string left, set currentToken null and return
            return;
         }

        char firstChar = _buffer.charAt(0);
        if(firstChar == '+')
        	currentToken = new Token("+", Token.Type.ADD);
        if(firstChar == '-')
        	currentToken = new Token("-", Token.Type.SUB);
            if (firstChar=='(')
                currentToken=new Token("(", Token.Type.LBRA);
            if (firstChar==')')
                currentToken=new Token(")", Token.Type.RBRA);
        if (firstChar=='*')
            currentToken=new Token("*",Token.Type.MUL);
        if (firstChar=='/')
            currentToken=new Token("/",Token.Type.DIV);
        //Note:要处理用最简单的case 试过
        //错是因为没有处理
        if (Character.isDigit(firstChar)){
            int count=0;
            if (_buffer.length()>1) {
                while (Character.isDigit(_buffer.charAt(count+1))) {
                    count = count + 1;
                    if (count+1==_buffer.length())
                        break;
                }
                String bufferint = _buffer.substring(0, count + 1);
                currentToken = new Token(bufferint, Token.Type.INT);
            }else {
                String bufferint = _buffer;
                currentToken = new Token(bufferint, Token.Type.INT);
            }

        }
        else if (currentToken==null){
            currentToken=new Token(firstChar+"",Token.Type.UNKNOWN);
        }


        // ########## YOUR CODE ENDS HERE ##########

        // Remove the extracted token from buffer
        int tokenLen = currentToken.token().length();
        _buffer = _buffer.substring(tokenLen);
    }

    /**
     *  returned the current token extracted by {@code next()}
     *  **** please do not modify this part ****
     *
     * @return type: Token
     */
    public Token current() {
    	return currentToken;
    }

    /**
     *  check whether there still exists another tokens in the buffer or not
     *  **** please do not modify this part ****
     *
     * @return type: boolean
     */
    public boolean hasNext() {
    	return currentToken != null;
    }
}