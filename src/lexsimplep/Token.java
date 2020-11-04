package lexsimplep;
public class Token {
     private Tipos tipo;
   private String valor;
    
   public Tipos getTipo() {
        return tipo;
    }
 
    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }
 
    public String getValor() {
        return valor;
    }
 
    public void setValor(String valor) {
        this.valor = valor;
    }

    enum Tipos {
        PALABRA ("[A-Za-z]+"),
        NUMERO ("[0-9]+"), 
        INICIO ("INICIO"),
        FINAL ("FIN"),
        OPERADOR_ARITMETICO("[-+/*]"),
        OPERADOR_RELACIONAL("[>=<=><) = <> , ; . { } (]");
        public final String patron;
        Tipos(String s) {
            this.patron = s;
        }
    }
}
