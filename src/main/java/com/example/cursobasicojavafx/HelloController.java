package com.example.cursobasicojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

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

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Testando o sistema");
        alert.setHeaderText("Parabéns funcionou!!");

        alert.setContentText(nome);

        alert.show();
    }

}
