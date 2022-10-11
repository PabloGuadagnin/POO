import java.util.ArrayList;

public class ListaProdutos implements IListaProdutos {

    private ArrayList<Produto> listaProduto = new ArrayList<Produto>();

    public boolean incluirProduto(Produto produto) {
        listaProduto.add(produto);
        System.out.println(produto.toString());
        return true;
    }

    public Produto consultar(int codigo) {
        Produto produto = null;
        for (int i = 0; i < listaProduto.size(); i++) {
            if (listaProduto.get(i).getCodigo() == codigo) {
                produto = listaProduto.get(i);
            }
        }
        return produto;
    }

    public boolean removerProduto(int codigo) {
        boolean retorno = false;
        for (int i = 0; i < listaProduto.size(); i++) {
            if (listaProduto.get(i).getCodigo() == codigo) {
                listaProduto.remove(i);
                retorno = true;
            }
        }
        return retorno;
    }

    public boolean ListarProdutos() {
        for (int i = 0; i < listaProduto.size(); i++) {
            System.out.println(listaProduto.get(i).toString());
        }
        return true;
    }

}
