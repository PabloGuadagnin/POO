package cadastramentos;

/**
 * Classe resposável pela inclusão, remoção e  capturação de dados dos clientes da lista de clientes.
 * 
 * @implaments IClientes
 */

import java.util.LinkedList;

import construtores.Cliente;
import interfaces.IClientes;

public class CadClientes implements IClientes {

    private LinkedList<Cliente> listaclientes;
 
    public CadClientes() {
    	this.listaclientes = new LinkedList<>();
    }

    @Override
    public void add(Cliente c) {
        listaclientes.add(c);
    }

    public Cliente get(String CPF) {
        for (Cliente c : listaclientes)
            if (c.getCpf().equals(CPF))
                return c;
        return null;
    }

    @Override
    public String getInfo(String CPF) {
        for (Cliente c : listaclientes)
            if (c.getCpf().equals(CPF))
                return c.toString();
        return null;
    }

    @Override
    public String getInfo() {
    	String dados = "";
        for (Cliente c : listaclientes)
        	dados+= c.toString() + "\n";
        return dados;
    }

    @Override
    public String getResumoInfo() {
        String dados = "";
        for (Cliente c : listaclientes)
            dados += "CPF: " + c.getCpf() + " e Nome: " + c.getNome() +"\n";
        return dados;
    }

    @Override
    public boolean remove(String CPF) {
        Cliente c = get(CPF);
        listaclientes.remove(c);
        return true;
    }

    @Override
    public boolean existe(String CPF) {
        for (Cliente c : listaclientes)
            if (c.getCpf().equals(CPF))
                return true;
        return false;
    }

    public void alterarNome(String cpf, String nome) {
    	Cliente c = get(cpf);
    	c.setNome(nome);    	
    }
    
    public LinkedList<Cliente> getListaCLientes(){
    	return listaclientes;
    }
}
