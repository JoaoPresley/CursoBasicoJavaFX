package com.example.cursobasicojavafx;

import com.example.cursobasicojavafx.DAO.estudanteDAO;
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

        }catch (NumberFormatException e){
            exibirerro("Numero errado!", "Digite um numero válido");
        }catch (Exception e){
            exibirerro("Erro", "Ocorreu um erro ao salvar: " + e.getMessage());
        }
    }
    public void exibirerro(String titulo, String mensagem){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
