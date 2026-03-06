module com.example.cursobasicojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;

    opens com.example.cursobasicojavafx to javafx.fxml;
    exports com.example.cursobasicojavafx;
}