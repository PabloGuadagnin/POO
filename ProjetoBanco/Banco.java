package ProjetoBanco;

public class Banco {
    private Conta[] conjuntoConta;
    private String nome;
    private int nContas = 0;

    public Banco(String nome, int maxContas) {
        this.nome = nome;
        conjuntoConta = new Conta[maxContas];
    }

    public String getNome() {
        return nome;
    }

    /**
     * Metodo que abri uma conta no banco.
     * Titular - nome do titular da conta.
     * 
     * @return True caso a conta tenha sido aberta com sucesso e False caso
     *         contrário.
     */
    public int abrirConta(String titular) {
        if (nContas < conjuntoConta.length) {
            conjuntoConta[nContas] = new Conta(titular);
            return conjuntoConta[nContas++].getNumero();
        }
        return -1;
    }

    /**
     * Captura a conta com o número informado.
     * numero - número da conta a ser encontrada.
     * 
     * @return O objeto da conta com o número informado ou null caso não exista uma
     *         conta com o número.
     */
    private Conta getConta(int numero) {
        for (int i = 0; i < nContas; i++) {
            if (conjuntoConta[i].getNumero() == numero)
                return conjuntoConta[i];
        }
        return null;
    }

    /**
     * Captura o titular da conta com o número informado.
     * numero - número da conta a ser encontrada.
     * 
     * @return O nome do titular da conta com o número informado ou "" caso não
     *         exista uma conta com o número.
     */
    public String getTitular(int numero) {
        Conta c1 = getConta(numero);
        if (c1 != null) {
            return c1.getTitular();
        }
        return "";
    }

    /**
     * Captura o saldo da conta com o número informado.
     * numero - número da conta a ser encontrada.
     * 
     * @return O saldo da conta com o número informado ou -1 caso não exista uma
     *         conta com o número.
     */
    public double getSaldo(int numero) {
        Conta c1 = getConta(numero);
        if (c1 != null) {
            return c1.getSaldo();
        }
        return -1;
    }

    /**
     * Captura o limite da conta com o número informado.
     * numero - número da conta a ser encontrada.
     * 
     * @return O limite da conta com o número informado ou -1 caso não exista uma
     *         conta com o número.
     */
    public double getLimite(int numero) {
        Conta c1 = getConta(numero);
        if (c1 != null) {
            return c1.getLimite();
        }
        return -1;
    }

    /**
     * Saca o valor informado da conta com o número informado.
     * numero - número da conta.
     * valor - valor a ser sacado.
     * 
     * @return True caso o saque tenha sido realizado com sucesso ou False caso
     *         contrário.
     */
    public boolean saca(int numero, double valor) {
        Conta c1 = getConta(numero);
        if (c1 != null) {
            return c1.saca(valor);
        }
        return false;
    }

    /**
     * Deposita o valor informado na conta com o número informado.
     * numero - número da conta a ser encontrada.
     * valor - valor a ser depositado.
     * 
     * @return True caso o deposito tenha sido realizado com sucesso ou False caso a
     *         conta não exista.
     */
    public boolean deposita(int numero, double valor) {
        Conta c1 = getConta(numero);
        if (c1 != null) {
            c1.deposita(valor);
            return true;
        }
        return false;
    }

    /**
     * Captura uma String com os dados de todas as contas do banco.
     * return String com os dados de todas as contas do banco.
     */
    public String toString() {
        String dados = "";
        for (int i = 0; i < nContas; i++) {
            dados += conjuntoConta[i].toString() + "\n";
        }
        return dados;
    }
}