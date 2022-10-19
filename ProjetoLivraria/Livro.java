package ProjetoLivraria;

public class Livro extends Produto{
    
    private String autor;
    private String editora;

    Livro (String nome, float valor, String autor, String editora){
        super(nome, valor);
        this.autor = autor;
        this.editora = editora;
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
     * @return String return the editora
     */
    public String getEditora() {
        return editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return super.toString() 
        + " Autor: " + autor 
        + " Editora: " + editora;
    }
}
