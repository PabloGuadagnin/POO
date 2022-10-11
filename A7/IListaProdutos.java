public interface IListaProdutos {
    
    public boolean incluirProduto ( Produto produto);
    public Produto consultar ( int codigo );
    public boolean removerProduto (int codigo);
    public boolean ListarProdutos();

}
