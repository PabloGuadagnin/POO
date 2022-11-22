
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import construtores.*;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Classe responsável por controlar a interface gráfica de Clientes ( Controller
 * )
 */
public class MenuClientes implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    Cliente cliente = new Cliente(null, null, null, null, null);

    // Cadastro de Clientes
    @FXML
    private TextField cnhCliente;

    @FXML
    private TextField cpfCliente;

    @FXML
    private TextField enderecoCliente;

    @FXML
    private TextField nomeCliente;

    @FXML
    private TextField telefoneCliente;

    @FXML
    private TableView<Cliente> tabelaClientes;

    @FXML
    private TableColumn<Cliente, String> colunaCPF;

    @FXML
    private TableColumn<Cliente, String> colunaNome;

    // Funcionalidades
    public void setNomeCliente() {
        String nomeClienteString = nomeCliente.getText();
        cliente.setNome(nomeClienteString);
        System.out.println(nomeClienteString);
    }

    public void setCPFCliente() {
        String cpfClienteString = cpfCliente.getText();
        cliente.setCpf(cpfClienteString);
        System.out.println(cpfClienteString);
    }

    public void setCNHCliente() {
        String cnhClienteString = cnhCliente.getText();
        cliente.setCnh(cnhClienteString);
        System.out.println(cnhClienteString);
    }

    public void setEnderecoCliente() {
        String enderecoClienteString = enderecoCliente.getText();
        cliente.setEndereco(enderecoClienteString);
        System.out.println(enderecoClienteString);
    }

    public void setTelefoneCliente() {
        String telefoneClienteString = nomeCliente.getText();
        cliente.setTelefone(telefoneClienteString);
        System.out.println(telefoneClienteString);
    }

    @FXML
    void confirmarCadastro(ActionEvent event) {

    }

    @FXML
    void voltarMenuInicial(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("layoutInicio.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}