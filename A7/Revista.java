public class Revista extends Produto{

    private String editora;
    
    Revista(String nome, float valor, String editora) {
        super(nome, valor);
        this.editora = editora;
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
        + " Editora: " + editora;
    }
}
