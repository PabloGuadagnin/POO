package ProjetoBanco;

public class Conta {
	private static int numeroGeral = 10000; // variavel de classe
	private int numero;
	private Titular titular;
	private double saldo;
	private double limite;

	public Conta(Titular titular) {
		this.numero = numeroGeral++; // garante que não haverá duas contas com o mesmo número
		this.titular = titular;
		this.saldo = 0;
		this.limite = 1000;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getLimite() {
		return limite;
	}

	public Titular getTitular() {
		return titular;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public void deposita(double valor) {
		saldo = saldo + valor;
	}

	public boolean saca(double valor) {
		if (valor <= saldo + limite) {
			saldo = saldo - valor;
			return true;
		}
		return false;
	}

	public String toString() {
		// return "Numero: "+numero+" Titular: "+titular.getNome()+" Saldo: "+saldo+"
		// Limite: "+limite;
		return "Numero: " + numero + " " + titular + " Saldo: " + saldo + " Limite: " + limite;
	}

}