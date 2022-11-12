/*○ Modifique o método deposita da classe Conta para lançar uma
exceção do tipo IllegalArgumentException (que já faz parte da
biblioteca do java) com a mensagem “Valor negativo” sempre que o valor
passado como argumento for negativo.
○ Crie a exceção SaldoInsuficienteException que estende da
classe Exception, conforme apresentado nos slides.
○ Modifique o método saca da classe Conta para que ao invés de retornar
um boolean, esse método lance uma exceção do tipo
IllegalArgumentException com a mensagem “Valor negativo”
sempre que o valor passado como argumento for negativo e lance uma
exceção do tipo SaldoInsuficienteException com a mensagem
“Saldo insuficiente” quando o saldo da conta for menor do que o valor
informado.
○ Modifique a classe Banco para contemplar o tratamento de exceções. */

public class Ex4 {
    public static void main(String[] args) {

        Conta c1 = new Conta("ALine");
        Conta c2 = new Conta("Maria");
        Conta c3 = new Conta("Joao");

        c1.setLimite(1000);
        c1.setTitular("Ana");

        try {
            c1.deposita(1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());

        System.out.println("Saldo = " + c1.getSaldo());

        try {
            c1.saca(2000);
            System.out.println("Saque realizado com sucesso!");
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Saldo = " + c1.getSaldo());

        try {
            c1.saca(100);
            System.out.println("Saque realizado com sucesso!");
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Saldo = " + c1.getSaldo());
    }
}