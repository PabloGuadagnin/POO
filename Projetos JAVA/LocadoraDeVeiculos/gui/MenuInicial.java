package gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Classe responsável por controlar a interface gráfica JavaFX ( Controller )
 */
public class MenuInicial implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

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

    // Cadastro de Veículos
    @FXML
    private TextField anoVeiculo;

    @FXML
    private TextField placaVeiculo;

    @FXML
    private TextField valorDiaVeiculo;

    @FXML
    public ChoiceBox<String> escolherTipoVeiculo = new ChoiceBox<>();
    public String[] tipoVeiculo = { "Carro", "Caminhão", "Ônibus" };

    @FXML
    public ChoiceBox<String> escolherTipoVeiculo2 = new ChoiceBox<>();
    public String[] tipoVeiculo2 = { "Carro", "Caminhão", "Ônibus" };

    // Cadastro Locação
    @FXML
    private DatePicker dataFimLocacao;

    @FXML
    private DatePicker dataInicLocacao;

    @FXML
    private TextField nomeClienteLocacao;

    @FXML
    private Label valorDiaLocacao;

    @FXML
    void cadastrarClientes(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("layoutMC.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cadastrarLocacao(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("layoutML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cadastrarVeiculos(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("layoutMV.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void voltarMenuInicial(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("layoutInicio.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void getDataFinalLocacao(ActionEvent event) {

        LocalDate dataFinal = dataFimLocacao.getValue();
        String dataFinalFormatada = dataFinal.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(dataFinalFormatada);
    }

    @FXML
    public void getDataInicialLocacao(ActionEvent event) {
        LocalDate dataInicial = dataInicLocacao.getValue();
        String dataInicialFormatada = dataInicial.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(dataInicialFormatada);
    }

    @FXML
    public void getValorDiaLocacao(MouseEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        escolherTipoVeiculo.getItems().addAll(tipoVeiculo);
        escolherTipoVeiculo.setOnAction(this::getTipoVeiculo);

        escolherTipoVeiculo2.getItems().addAll(tipoVeiculo2);
        escolherTipoVeiculo2.setOnAction(this::getTipoVeiculoMV);

    }

    public void getTipoVeiculoMV(ActionEvent event) {

        String tipoVeiculo2 = escolherTipoVeiculo2.getValue();
        System.out.println(tipoVeiculo2);

    }

    public void getTipoVeiculo(ActionEvent event) {

        String tipoVeiculo = escolherTipoVeiculo.getValue();
        System.out.println(tipoVeiculo);

        Period periodo = Period.between(dataInicLocacao.getValue(), dataFimLocacao.getValue());
        int dias = periodo.getDays();
        int meses = periodo.getMonths();
        int anos = periodo.getYears();

        if (escolherTipoVeiculo.getValue() == "Carro") {
            int total = (meses * 30) + (anos * 365) + dias;
            int valorDiaLocacaoVeiculo = total * 150;
            valorDiaLocacao.setText("Valor é R$" + valorDiaLocacaoVeiculo);
        } else if (escolherTipoVeiculo.getValue() == "Caminhão") {
            int total = (meses * 30) + (anos * 365) + dias;
            int valorDiaLocacaoVeiculo = total * 250;
            valorDiaLocacao.setText("Valor é R$" + valorDiaLocacaoVeiculo);
        } else if (escolherTipoVeiculo.getValue() == "Ônibus") {
            int total = (meses * 30) + (anos * 365) + dias;
            int valorDiaLocacaoVeiculo = total * 300;
            valorDiaLocacao.setText("Valor é R$" + valorDiaLocacaoVeiculo);
        }
    }
}