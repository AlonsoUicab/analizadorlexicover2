package lexsimplep;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lexsimplep.Token.Tipos;
public class LexSimpleP {
   private static ArrayList<Token> lex(String input) {
        final ArrayList<Token> tokens = new ArrayList<Token>();
        final StringTokenizer st = new StringTokenizer(input);

        while(st.hasMoreTokens()) {
            String palabra = st.nextToken();
            boolean matched = false;

            for (Tipos tokenTipo : Tipos.values()) {
                Pattern patron = Pattern.compile(tokenTipo.patron, Pattern.MULTILINE);
                Matcher matcher = patron.matcher(palabra);
                if(matcher.find()) {
                    Token tk = new Token();
                    tk.setTipo(tokenTipo);
                    tk.setValor(palabra);
                    tokens.add(tk);
                    matched = true;
                }
            }
            if (!matched) {
                throw new RuntimeException("Se encontró un token invalido.");
            }
        }
       return tokens;
    }
    public static void main(String[] args) {
        // TODO code application logic here
       String input = "INICIO Hola + 2 - 21 * 33 / 44 + 51 / 60 * 70 - >= <= < > = <> { } ( )  , ; . FIN";
        ArrayList<Token> tokens = lex(input);
        for (Token token : tokens) {
            System.out.println("(" + token.getTipo() + ": " + token.getValor() +")");          
        }

       
    }
    
}
