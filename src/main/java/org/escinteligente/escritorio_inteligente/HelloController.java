package org.escinteligente.escritorio_inteligente;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label olaMundo;

    @FXML
    protected void onHelloButtonClick() {
        olaMundo.setText("Bem vindo à primeira tela!");
    }
}