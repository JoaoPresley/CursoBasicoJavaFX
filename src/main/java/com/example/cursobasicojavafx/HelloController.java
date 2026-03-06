package com.example.cursobasicojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private ToggleGroup Sexo;

    @FXML
    private Button bt_deletar;

    @FXML
    private Button bt_editar;

    @FXML
    private Button bt_salvar;

    @FXML
    private RadioButton rb_F;

    @FXML
    private RadioButton rb_M;

    @FXML
    private TableColumn<?, ?> tc_id;

    @FXML
    private TableColumn<?, ?> tc_idade;

    @FXML
    private TableColumn<?, ?> tc_nome;

    @FXML
    private TableColumn<?, ?> tc_sexo;

    @FXML
    private TextField tf_idade;

    @FXML
    private TextField tf_nome;

    @FXML
    private TableView<?> tv_estudante;

    @FXML
    void showname(ActionEvent event) {
        String nome = tf_nome.getText().toString();
        String sexo = "Não selecionado";
        RadioButton selecionado = (RadioButton) Sexo.getSelectedToggle();

        if (selecionado != null){
            sexo = selecionado.getText();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Testando o sistema");
        alert.setHeaderText("Dados coletados");

        alert.setContentText("Nome: " + nome + "\nIdade: " + tc_idade.getText().toString()+
                "\nSexo: "+ sexo);

        alert.show();
    }

}
