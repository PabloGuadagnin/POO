/*O que será impresso se tentarmos compilar e executar a classe TesteExcecao?
 * 
 * --> E. Erro de compilação <--
 * 
 */

public class Ex3 extends Exception {

    public static void teste() throws MinhaExcecao {
        throw new MinhaExcecao();
    }

    public static void main(String[] args) {
        MinhaExcecao me = null;
        try {
            System.out.println("try ");
            teste();
        } catch (MinhaExcecao e) {
            System.out.println("catch ");
            me = e;
        } finally {
            System.out.println("finally ");
            throw me;
        }
        System.out.println("fim");
    }
}
