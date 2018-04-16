package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML ListView<String> lResultados;
    @FXML Button bInterpretar;
    @FXML TextField tOperacion;
    private String num1, num2, cadena;
    private  Maquina m;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        m = new Maquina();
        bInterpretar.setDisable(false);
        bInterpretar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                m.inicializar();
                num1 = tOperacion.getText().split("-")[0];
                num1 = m.binario(Integer.parseInt(num1));
                m.inicializar();
                num2 = tOperacion.getText().split("-")[1];
                num2 = m.binario(Integer.parseInt(num2));
                cadena = num1+"-"+num2+"BB";
                m.resta(cadena);
                if(m.isSalir()){
                    Alert msg=new Alert(Alert.AlertType.CONFIRMATION);
                    msg.setTitle("Resultado");
                    msg.setHeaderText("Resultado");
                    msg.setContentText(m.getResult());
                    msg.show();
                }
                else{
                    Alert msg=new Alert(Alert.AlertType.CONFIRMATION);
                    msg.setTitle("Resultado");
                    msg.setHeaderText("Error");
                    msg.setContentText("No pertenece al lenguaje");
                    msg.show();
                }
                bInterpretar.setDisable(true);
                lResultados.getItems().setAll(m.getPasos());
            }
        });
    }

}
