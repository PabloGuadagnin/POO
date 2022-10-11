public interface IListaProdutos {
    // interface sempre será public e abristact
    boolean incluirProduto ( Produto produto);
    Produto consultar ( int codigo );
    boolean removerProduto (int codigo);
    boolean ListarProdutos();

}
