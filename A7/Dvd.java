public class Dvd extends Produto{
    
    private String autor;
    private String estilo;

    Dvd(String nome, float valor, String autor, String estilo) {
        super(nome, valor);
        this.autor = autor;
        this.estilo = estilo;
    }

    /**
     * @return String return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return String return the estilo
     */
    public String getEstilo() {
        return estilo;
    }

    /**
     * @param estilo the estilo to set
     */
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    @Override
    public String toString() {
        return super.toString() 
        + " Autor: " + autor 
        + " Estilo: " + estilo;
    }
}
