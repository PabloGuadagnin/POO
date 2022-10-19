package ProjetoLivraria;

abstract class Produto {
    
    private static int codigoGeral=1;
    private String nome;
    private int codigo;
    private float valor;

    Produto (String nome, float valor){
        this.nome = nome;
        this.codigo = codigoGeral++;
        this.valor = valor;
    }

    /**
     * @return int return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return float return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }


    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "Nome: "+nome
        +" Codigo: "+codigo+" Valor: R$"+valor;
    }

}