/* Sua classe deve tratar as seguintes exceções:

○ ArithmeticException quando ocorrer uma divisão por zero.
○ InputMismatchException quando o valor informado não é numérico.

A cada ocorrência de exceção, o usuário deve ser alertado sobre qual é o problema e deve ser permitida uma nova entrada de valores. */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        boolean ok = true;
        int a, b;
        double r;
        do {
            try {
                ok = true;

                System.out.println("Vamos dividir?");
                System.out.println("");
                System.out.print("Informe o primeiro número: ");
                a = entrada.nextInt();

                System.out.print("Informe o segundo número: ");
                b = entrada.nextInt();

                r = (a / b);

                System.out.print("Resultado da divisão: " + r);

            } catch (ArithmeticException e) {

                System.out.println("");
                System.out.println("Não é possível dividir por zero.");
                ok = false;
                entrada.nextLine();
                System.out.println("");

            } catch (InputMismatchException e) {

                System.out.println("");
                System.out.println("Utilize apenas números.");
                ok = false;
                entrada.nextLine();
                System.out.println("");
            }
        } while (!ok);
        entrada.close();
    }
}
