package ParseCalculator;

public class Testparser {
    public static void main(String[] args) {
       MyTokenizer tokenizer = new MyTokenizer("1+2");
        Exp exp = new Parser(tokenizer).parseExp();
        System.out.println(exp.evaluate());
    }
}
