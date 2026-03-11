package com.example.cursobasicojavafx;

import com.example.cursobasicojavafx.DAO.estudanteDAO;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ToggleGroup Sexo;

    @FXML
    private Button bt_deletar;

    @FXML
    private Button bt_editar;

    @FXML
    private Button bt_salvar;
    //Definição dos interativos
    @FXML
    private RadioButton rb_F;

    @FXML
    private RadioButton rb_M;

    @FXML
    private TableColumn<Estudante, Long> tc_id;

    @FXML
    private TableColumn<Estudante, Integer> tc_idade;

    @FXML
    private TableColumn<Estudante, String> tc_nome;

    @FXML
    private TableColumn<Estudante, String> tc_sexo;

    @FXML
    private TextField tf_idade;

    @FXML
    private TextField tf_nome;

    @FXML
    private TableView<Estudante> tv_estudante;
    //FUNÇÕES FXML
    //Função ao clicar no botão deletar
    @FXML
    void Deletar(ActionEvent event) {

    }
    //Função ao clicar no botão editar
    @FXML
    void Editar(ActionEvent event) {

    }
    //Função ao clicar do botão salvar
    @FXML
    void Salvar(ActionEvent event) {
        try {
            //Se não for preenchido todos os dados
            if (tf_nome.getText().isBlank() ||
                tf_idade.getText().isBlank() ||
                Sexo.getSelectedToggle() == null){
                exibirerro("Informações incompletas","Preencha a idade, nome e selecione o sexo para salvar");
                return; //PARE!!
            }
            //Se tiver tudo preenchido continua o código

            //objeto que recebe os dados do estudante
            Estudante estudante = new Estudante();
            estudante.setNome(tf_nome.getText());
            estudante.setIdade(Integer.parseInt(tf_idade.getText()));
            RadioButton rb = (RadioButton) Sexo.getSelectedToggle();
            estudante.setSexo(rb.getText());

            //insere no BD
            estudanteDAO DAO = new estudanteDAO();
            DAO.inserir(estudante);
            //atualiza tabela estudantes
            updatetable();
            limpaInserts();

        }catch (NumberFormatException e){
            exibirerro("Numero errado!", "Digite um numero válido");
        }catch (Exception e){
            exibirerro("Erro", "Ocorreu um erro ao salvar: " + e.getMessage());
        }
    }


    //FUNÇÃO DE INICIALIZAÇÃO
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tc_id.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("id"));
        tc_idade.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("idade"));
        tc_nome.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("nome"));
        tc_sexo.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("sexo"));

        //atualiza tabela estudantes
        updatetable();
        limpaInserts();
    }

    //FUNÇÕES JAVA
    public void exibirerro(String titulo, String mensagem){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    public  void updatetable(){
        estudanteDAO DAO = new estudanteDAO();
        ObservableList <Estudante> estudantes = FXCollections.observableArrayList(DAO.buscarTodos());

        tv_estudante.setItems(estudantes);
    }

    public void limpaInserts(){
        tf_idade.clear();
        tf_nome.clear();
        Sexo.selectToggle(null);
    }
}

