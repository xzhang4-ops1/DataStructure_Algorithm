package ParserString;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TokenizerTest {

    private static Tokenizer tokenizer;
    private static final String testCase = "(10 + 24 - 4) / 6 * 45";
    private static final String passCase = "+-";

    @Test(timeout=1000)
    public void testAddToken() {
    	tokenizer = new MyTokenizer(passCase);

    	//check the type of the first token
        assertEquals("wrong token type", Token.Type.ADD, tokenizer.current().type());

        //check the actual token value"
        assertEquals("wrong token value", "+", tokenizer.current().token());
    }

    @Test(timeout=1000)
    public void testSubToken() {
    	tokenizer = new MyTokenizer(passCase);

        //extract next token (just to skip first passCase token)
        tokenizer.next();

        //check the type of the first token
        assertEquals("wrong token type", Token.Type.SUB, tokenizer.current().type());

        //check the actual token value
        assertEquals("wrong token value", "-", tokenizer.current().token());
    }

    @Test(timeout=1000)
    public void testFirstToken(){
    	tokenizer = new MyTokenizer(testCase);

    	//check the type of the first token
        assertEquals("wrong token type", Token.Type.LBRA, tokenizer.current().type());
        //check the actual token value
        assertEquals("wrong token value", "(", tokenizer.current().token());
    }

    @Test(timeout=1000)
    public void testTokenResult(){
    	tokenizer = new MyTokenizer(testCase);

        // test first token (
        assertEquals(Token.Type.LBRA, tokenizer.current().type());

        // test second token 100
        tokenizer.next();
        assertEquals(Token.Type.INT, tokenizer.current().type());
        assertEquals("10", tokenizer.current().token());

        // test third token +
        tokenizer.next();
        assertEquals(Token.Type.ADD, tokenizer.current().type());
        assertEquals("+", tokenizer.current().token());

        // test fourth token 2
        tokenizer.next();
        assertEquals(Token.Type.INT, tokenizer.current().type());
        assertEquals("24", tokenizer.current().token());

        // test fourth token -
        tokenizer.next();
        assertEquals(Token.Type.SUB, tokenizer.current().type());
        assertEquals("-", tokenizer.current().token());

        //we skip token 5
        tokenizer.next();
        assertEquals(Token.Type.INT, tokenizer.current().type());
        assertEquals("4", tokenizer.current().token());


        // test sixth token ), note that we call next twice.
        // Correct implementation of tokenizer.current() should return ')' this case (not 40)
        tokenizer.next();
        assertEquals(Token.Type.RBRA, tokenizer.current().type());

        tokenizer.next();
        assertEquals(Token.Type.DIV, tokenizer.current().type());
        assertEquals("/", tokenizer.current().token());

        //we skip token 5
        tokenizer.next();

        assertEquals(Token.Type.INT, tokenizer.current().type());
        assertEquals("6", tokenizer.current().token());

        //we skip token 5
        tokenizer.next();

        assertEquals(Token.Type.MUL, tokenizer.current().type());
        assertEquals("*", tokenizer.current().token());

        //we skip token 5
        tokenizer.next();
        assertEquals(Token.Type.INT, tokenizer.current().type());
        assertEquals("45", tokenizer.current().token());

    }
}
