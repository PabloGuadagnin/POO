package ProjetoBanco;

public class Titular {
    private String nome;
    private long CPF;
    private String cidade;
    private String estado;

    public Titular(String nome, long CPF, String cidade, String estado) {
        this.nome = nome;
        this.CPF = CPF;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Titular(String nome, long CPF) {
        this(nome, CPF, "", "");
    }

    public String getNome() {
        return nome;
    }

    public long getCPF() {
        return CPF;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setNome(String novoNome) {
        nome = novoNome;
    }

    public void setCPF(long novoCPF) {
        CPF = novoCPF;
    }

    public void setCidade(String novaCidade) {
        cidade = novaCidade;
    }

    public void setEstado(String novoEstado) {
        estado = novoEstado;
    }

    public String toString() {
        return "Nome: " + nome + " CPF: " + CPF + " Cidade: " + cidade + " Estado: " + estado;
    }
}
