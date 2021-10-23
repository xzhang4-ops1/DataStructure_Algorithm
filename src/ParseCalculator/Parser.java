package ParseCalculator;

/**
 * Name: Parser.java
 *
 *  The main objective of this class is to implement a simple parser.
 *  It should be able to parser the following grammar rule:
 *  <exp>    ::= <term> | <term> + <exp> | <term> - <exp>
 *  <term>   ::=  <factor> | <factor> * <term> | <factor> / <term>
 *  <factor> ::= <unsigned integer> | ( <exp> )
 *
 */

public class Parser {

    MyTokenizer _tokenizer;

    public Parser(MyTokenizer tokenizer) {
        _tokenizer = tokenizer;
    }

    /*
    <exp>    ::= <term> | <term> + <exp> | <term> - <exp>
     */
    public Exp parseExp() {
        // TODO: Implement parse function for <exp>
        // ########## YOUR CODE STARTS HERE ##########
        //无论是什么最终都回到第一个后面
//变成了term 直接跳过，符合以前的逻辑
            Exp term= this.parseTerm();
            if (_tokenizer.hasNext()) {

                if (_tokenizer.current().type() == Token.Type.ADD) {
                    _tokenizer.next();
                    Exp exp = this.parseExp();
                    return new AddExp(term, exp);
                }
                if (_tokenizer.current().type() == Token.Type.SUB) {
                    _tokenizer.next();
                    Exp exp = this.parseExp();
                    return new SubExp(term, exp);
                }
//                if (_tokenizer.current().type()== Token.Type.RBRA){
//                    _tokenizer.next();
//                }
//Note: for prentici 将单个数网上反，反到加的位置
            }
            else return term;


return term;

        // ########## YOUR CODE ENDS HERE ##########
    }

    //<term>   ::=  <factor> | <factor> * <term> | <factor> / <term>
    public Exp parseTerm() {
        // TODO: Implement parse function for <term>
        // ########## YOUR CODE STARTS HERE ##########
            Exp factor=this.parseFactor();
            _tokenizer.next();
            if (_tokenizer.hasNext()) {
                if (_tokenizer.current().type()== Token.Type.RBRA){
                    return factor;
                }

                if (this._tokenizer.current().type() == Token.Type.MUL) {
                    _tokenizer.next();
                    Exp term = this.parseTerm();
                    return new MultExp(factor, term);
                }
                if (this._tokenizer.current().type() == Token.Type.DIV) {
                    _tokenizer.next();
                    Exp term = this.parseTerm();
                    return new DivExp(factor, term);
                } else return factor;
            }
            return factor;



        // ########## YOUR CODE ENDS HERE ##########
    }

    //<factor> ::= <unsigned integer> | ( <exp> )
    public Exp parseFactor() {
        // TODO: Implement parse function for <factor>
        // ########## YOUR CODE STARTS HERE ##########
        if (_tokenizer.current().type()== Token.Type.INT)
        return new IntExp(Integer.parseInt(this._tokenizer.current().token()));
        else if (_tokenizer.current().type()== Token.Type.LBRA){
            _tokenizer.next();
            //返回的是1+2 是往上一层走的， 递归的方向搞懂
            return this.parseExp();
        }
        return null;
        // ########## YOUR CODE ENDS HERE ##########
    }

    public static void main(String[] args) {
        MyTokenizer mathTokenizer = new MyTokenizer("2+1");
        Exp t1 = new Parser(mathTokenizer).parseExp();
        System.out.println(t1.show());
        System.out.println(t1.evaluate());
    }
}
