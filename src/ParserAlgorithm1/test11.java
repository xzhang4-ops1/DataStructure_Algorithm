package ParserAlgorithm1;

public class test11 {
    public static void main(String[] args) {
        boolean a=new Parser(new Tokeniser(")()((")).parseExp();
        System.out.println(a);
    }
}
