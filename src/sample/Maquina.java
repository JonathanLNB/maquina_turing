package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Maquina {
    private ObservableList pasos = FXCollections.observableArrayList();
    private String result, cadena;
    private Integer posicion, estado;
    boolean salir;
    public void inicializar(){
        result="";
    }
    public String binario(int n){
        if(n<=0)
            return "0";
        else
            binario(n/2);
        return result=result+n%2;
    }
    public void resta(String cadena){
        posicion = 0;
        estado = 0;
        char[] tempCharArray = cadena.toCharArray();
        try {
            while(true){
                salir = false;
                if (estado == 0 && tempCharArray[posicion] == '1') {
                    tempCharArray[posicion] = '1';
                    posicion++;
                    estado = 0;
                    salir = true;
                    pasos.add("(q0, 1) -> (q0, 1, R)");
                }
                if (estado == 0 && tempCharArray[posicion] == '0') {
                    tempCharArray[posicion] = '0';
                    posicion++;
                    estado = 0;
                    salir = true;
                    pasos.add("(q0, 0) -> (q0, 0, R)");
                }
                if (estado == 0 && tempCharArray[posicion] == 'I') {
                    tempCharArray[posicion] = 'I';
                    posicion++;
                    estado = 0;
                    salir = true;
                    pasos.add("(q0, I) -> (q0, I, R)");
                }
                if (estado == 0 && tempCharArray[posicion] == 'O') {
                    tempCharArray[posicion] = 'O';
                    posicion++;
                    estado = 0;
                    salir = true;
                    pasos.add("(q0, O) -> (q0, O, R)");
                }
                if (estado == 0 && tempCharArray[posicion] == '-') {
                    tempCharArray[posicion] = '-';
                    posicion++;
                    estado = 1;
                    salir = true;
                    pasos.add("(q0, -) -> (q1, -, R)");
                }
                if (estado == 1 && tempCharArray[posicion] == '1') {
                    tempCharArray[posicion] = '1';
                    posicion++;
                    estado = 1;
                    salir = true;
                    pasos.add("(q1, 1) -> (q1, 1, R)");
                }
                if (estado == 1 && tempCharArray[posicion] == '0') {
                    tempCharArray[posicion] = '0';
                    posicion++;
                    estado = 1;
                    salir = true;
                    pasos.add("(q1, 0) -> (q1, 0, R)");
                }
                if (estado == 1 && tempCharArray[posicion] == 'B') {
                    tempCharArray[posicion] = 'B';
                    posicion--;
                    estado = 2;
                    salir = true;
                    pasos.add("(q1, B) -> (q2, B, L)");
                }
                if (estado == 2 && tempCharArray[posicion] == '-') {
                    pasos.add("(q2, -) -> Final");
                    this.cadena = String.valueOf(tempCharArray);
                    break;
                }
                if (estado == 2 && tempCharArray[posicion] == '1') {
                    tempCharArray[posicion] = 'B';
                    posicion--;
                    estado = 3;
                    salir = true;
                    pasos.add("(q2, 1) -> (q3, B, L)");
                }
                if (estado == 2 && tempCharArray[posicion] == '0') {
                    tempCharArray[posicion] = 'B';
                    posicion--;
                    estado = 6;
                    salir = true;
                    pasos.add("(q2, 0) -> (q3, B, L)");
                }
                if (estado == 3 && tempCharArray[posicion] == '0') {
                    tempCharArray[posicion] = '0';
                    posicion--;
                    estado = 3;
                    salir = true;
                    pasos.add("(q3, 0) -> (q3, 0, L)");
                }
                if (estado == 3 && tempCharArray[posicion] == '1') {
                    tempCharArray[posicion] = '1';
                    posicion--;
                    estado = 3;
                    salir = true;
                    pasos.add("(q3, 1) -> (q3, 1, L)");
                }
                if (estado == 3 && tempCharArray[posicion] == '-') {
                    tempCharArray[posicion] = '-';
                    posicion--;
                    estado = 4;
                    salir = true;
                    pasos.add("(q3, 1) -> (q4, -, L)");
                }
                if (estado == 4 && tempCharArray[posicion] == '1') {
                    tempCharArray[posicion] = 'O';
                    posicion++;
                    estado = 0;
                    salir = true;
                    pasos.add("(q4, 1) -> (q0, O, R)");
                }
                if (estado == 4 && tempCharArray[posicion] == '0') {
                    tempCharArray[posicion] = 'I';
                    posicion--;
                    estado = 5;
                    salir = true;
                    pasos.add("(q4, 0) -> (q5, I, L)");
                }
                if (estado == 4 && tempCharArray[posicion] == 'O') {
                    tempCharArray[posicion] = 'O';
                    posicion--;
                    estado = 4;
                    salir = true;
                    pasos.add("(q4, O) -> (q4, O, L)");
                }
                if (estado == 4 && tempCharArray[posicion] == 'I') {
                    tempCharArray[posicion] = 'I';
                    posicion--;
                    estado = 4;
                    salir = true;
                    pasos.add("(q4, I) -> (q4, I, L)");
                }
                if (estado == 5 && tempCharArray[posicion] == '0') {
                    tempCharArray[posicion] = '1';
                    posicion--;
                    estado = 5;
                    salir = true;
                    pasos.add("(q5, 0) -> (q5, 1, L)");
                }
                if (estado == 5 && tempCharArray[posicion] == '1') {
                    tempCharArray[posicion] = '0';
                    posicion++;
                    estado = 0;
                    salir = true;
                    pasos.add("(q5, 1) -> (q0, 0, R)");
                }
                if (estado == 6 && tempCharArray[posicion] == '0') {
                    tempCharArray[posicion] = '0';
                    posicion--;
                    estado = 6;
                    salir = true;
                    pasos.add("(q6, 0) -> (q0, 0, L)");
                }
                if (estado == 6 && tempCharArray[posicion] == '1') {
                    tempCharArray[posicion] = '1';
                    posicion--;
                    estado = 6;
                    salir = true;
                    pasos.add("(q6, 1) -> (q6, 1, L)");
                }
                if (estado == 6 && tempCharArray[posicion] == '-') {
                    tempCharArray[posicion] = '-';
                    posicion--;
                    estado = 7;
                    salir = true;
                    pasos.add("(q7, -) -> (q7, -, L)");
                }
                if (estado == 7 && tempCharArray[posicion] == '0') {
                    tempCharArray[posicion] = 'O';
                    posicion++;
                    estado = 0;
                    salir = true;
                    pasos.add("(q7, 0) -> (q0, O, R)");
                }
                if (estado == 7 && tempCharArray[posicion] == '1') {
                    tempCharArray[posicion] = 'I';
                    posicion++;
                    estado = 0;
                    salir = true;
                    pasos.add("(q7, 1) -> (q0, I, R)");
                }
                if (estado == 7 && tempCharArray[posicion] == 'O') {
                    tempCharArray[posicion] = 'O';
                    posicion--;
                    estado = 7;
                    salir = true;
                    pasos.add("(q7, O) -> (q7, O, L)");
                }
                if (estado == 7 && tempCharArray[posicion] == 'I') {
                    tempCharArray[posicion] = 'I';
                    posicion--;
                    estado = 7;
                    salir = true;
                    pasos.add("(q7, I) -> (q7, I, L)");
                }
                if (!salir) {
                    pasos.add("Operación no valida");
                    break;
                }
            }
        }catch (Exception e){
            salir = false;
            pasos.add("Operación no valida");
        }
    }
    public String getResult(){
        String aux = cadena.split("-")[0];
        int sum = 0;
        double cont = 0;
        for(int i = aux.length()-1; i>=0; i--) {
            if (aux.charAt(i) == 'I' || aux.charAt(i) == '1')
                sum += Math.pow(2, cont);
            cont++;
        }
        return sum+"";
    }
    public boolean isSalir() {
        return salir;
    }
    public ObservableList<String> getPasos(){
        return pasos;
    }
}
