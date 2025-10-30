package com.nickolss.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    
    private Label lblResposta;
    
    private void mostrarResposta(Atendimento atendimento) {
        lblResposta.setText(atendimento.responder());
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema de Atendimento");

        Button btnVendas = new Button("Atendimento Vendas");
        Button btnSuporte = new Button("Atendimento Suporte");
        Button btnFinanceiro = new Button("Atendimento Financeiro");

        lblResposta = new Label("Escolha o setor de atendimento.");

        btnVendas.setOnAction(e -> mostrarResposta(new AtendimentoVendas()));
        btnSuporte.setOnAction(e -> mostrarResposta(new AtendimentoSuporte()));
        btnFinanceiro.setOnAction(e -> mostrarResposta(new AtendimentoFinanceiro()));

        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20;");
        layout.getChildren().addAll(btnVendas, btnSuporte, btnFinanceiro, lblResposta);

        Scene scene = new Scene(layout, 500, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}