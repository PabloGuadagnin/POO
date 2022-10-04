package ProjetoBanco;

import java.util.Scanner;

public class BancoUI {
    private Banco meuBanco;
    private Scanner entrada;

    public BancoUI() {
        meuBanco = new Banco("Banco POO", 10);
        entrada = new Scanner(System.in);
    }

    public void menu() {
        int op;
        do {
            System.out.println("\n" + meuBanco.getNome() + "\n");
            System.out.println("1. Abrir conta");
            System.out.println("2. Consultar saldo");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Listar contas");
            System.out.println("0. Sair\n");
            System.out.print("Informe a opção desejada (0 a 5): ");
            op = entrada.nextInt();
            entrada.nextLine();

            switch (op) {
                case 1:
                    abriConta();
                    break;
                case 2:
                    consultarSaldo();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    sacar();
                    break;
                case 5:
                    listar();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (op != 0);

    }

    public void abriConta() {
        int numeroConta;
        String nome, cidade, estado;
        long CPF;

        System.out.println("Abertura de conta");
        System.out.print("Informe o nome do titular: ");
        nome = entrada.nextLine();
        System.out.print("Informe o CPF do titular: ");
        CPF = entrada.nextLong();
        entrada.nextLine();
        System.out.print("Informe a cidade do titular: ");
        cidade = entrada.nextLine();
        System.out.print("Informe o estado do titular: ");
        estado = entrada.nextLine();

        numeroConta = meuBanco.abrirConta(new Titular(nome, CPF, cidade, estado));
        if (numeroConta != -1) {
            System.out.println("Abertura de conta realizada com sucesso. Numero de conta = " + numeroConta);
        } else {
            System.out.println("Não foi possível abrir a conta");
        }
    }

    public void consultarSaldo() {
        int numeroConta;
        double saldo;

        System.out.println("Consultar saldo");
        System.out.print("Informe o número da conta: ");
        numeroConta = entrada.nextInt();
        entrada.nextLine();
        saldo = meuBanco.getSaldo(numeroConta);
        if (saldo != -1) {
            System.out.println("Saldo = " + saldo);
        } else {
            System.out.println("O número da conta inexistente");
        }

    }

    public void depositar() {
        int numeroConta;
        double valor;

        System.out.println("Depositar");
        System.out.print("Informe o número da conta: ");
        numeroConta = entrada.nextInt();
        entrada.nextLine();
        System.out.print("Informe o valor a ser depositado: ");
        valor = entrada.nextInt();
        entrada.nextLine();

        if (meuBanco.deposita(numeroConta, valor)) {
            System.out.println("O deposito foi realizado com sucesso. Saldo atual: " + meuBanco.getSaldo(numeroConta));
        } else {
            System.out.println("Não foi possível realizar o depósito");
        }

    }

    public void sacar() {
        int numeroConta;
        double valor;

        System.out.println("Sacar");
        System.out.print("Informe o número da conta: ");
        numeroConta = entrada.nextInt();
        entrada.nextLine();
        System.out.print("Informe o valor a ser sacado: ");
        valor = entrada.nextInt();
        entrada.nextLine();

        if (meuBanco.saca(numeroConta, valor)) {
            System.out.println("O saque foi realizado com sucesso. Saldo atual: " + meuBanco.getSaldo(numeroConta));
        } else {
            System.out.println("Não foi possível realizar o saque.");
        }
    }

    public void listar() {
        System.out.println("Listagem das Contas:");
        System.out.println(meuBanco.toString());
    }

}