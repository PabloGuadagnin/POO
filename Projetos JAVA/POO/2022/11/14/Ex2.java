/* O código abaixo lança uma exceção (propositalmente) e interrompe sua execução.
Utilizando o tratamento de exceções, corrija a classe com o objetivo de não parar
sua execução.
OBS: A Exception lançada é ArrayIndexOutOfBoundsException
 */

public class Ex2 {
    public static void main(String[] args) {

        System.out.println("Inicio da main");
        metodo1();
        System.out.println("fim da main");
    }

    public static void metodo1() {

        System.out.println("Inicio do método 1");
        metodo2();
        System.out.println("fim do método 1");
    }

    public static void metodo2() {

        try {
            System.out.println("Inicio do método 2");
            int[] array = new int[10];
            for (int i = 0; i <= 15; i++) { // Correto seria <10.
                array[i] = i;
                System.out.println(i);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro, o indice do Array nao deve superar 10 posições.");
        }
        System.out.println("fim do método 2");
    }
}
