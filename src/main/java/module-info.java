module com.example.cursobasicojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cursobasicojavafx to javafx.fxml;
    exports com.example.cursobasicojavafx;
}