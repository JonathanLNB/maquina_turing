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
            while(true){
                salir = false;
                if (estado == 0 && tempCharArray[posicion] == '#') {
                    tempCharArray[posicion] = '#';
                    pasos.add("(q0, "+cadena+", "+posicion+") -> (q0, "+String.valueOf(tempCharArray)+", R)");
                    posicion++;
                    estado = 0;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 0 && tempCharArray[posicion] == '1') {
                    tempCharArray[posicion] = '1';
                    pasos.add("(q0, "+cadena+", "+posicion+") -> (q0, "+String.valueOf(tempCharArray)+", R)");
                    posicion++;
                    estado = 0;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 0 && tempCharArray[posicion] == '0') {
                    tempCharArray[posicion] = '0';
                    pasos.add("(q0, "+cadena+", "+posicion+") -> (q0, "+String.valueOf(tempCharArray)+", R)");
                    posicion++;
                    estado = 0;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);

                }
                if (estado == 0 && tempCharArray[posicion] == 'I') {
                    tempCharArray[posicion] = 'I';
                    pasos.add("(q0, "+cadena+", "+posicion+") -> (q0, "+String.valueOf(tempCharArray)+", R)");
                    posicion++;
                    estado = 0;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 0 && tempCharArray[posicion] == 'O') {
                    tempCharArray[posicion] = 'O';
                    pasos.add("(q0, "+cadena+", "+posicion+") -> (q0, "+String.valueOf(tempCharArray)+", R)");
                    posicion++;
                    estado = 0;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 0 && tempCharArray[posicion] == '-') {
                    tempCharArray[posicion] = '-';
                    pasos.add("(q0, "+cadena+", "+posicion+") -> (q1, "+String.valueOf(tempCharArray)+", R)");
                    posicion++;
                    estado = 1;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 1 && tempCharArray[posicion] == '1') {
                    tempCharArray[posicion] = '1';
                    pasos.add("(q1, "+cadena+", "+posicion+") -> (q1, "+String.valueOf(tempCharArray)+", R)");
                    posicion++;
                    estado = 1;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 1 && tempCharArray[posicion] == '0') {
                    tempCharArray[posicion] = '0';
                    pasos.add("(q1, "+cadena+", "+posicion+") -> (q1, "+String.valueOf(tempCharArray)+", R)");
                    posicion++;
                    estado = 1;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 1 && tempCharArray[posicion] == 'B') {
                    tempCharArray[posicion] = 'B';
                    pasos.add("(q1, "+cadena+", "+posicion+") -> (q2, "+String.valueOf(tempCharArray)+", L)");
                    posicion--;
                    estado = 2;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 2 && tempCharArray[posicion] == '#') {
                    salir = false;
                    pasos.add("Operación no valida");
                    break;
                }
                if (estado == 2 && tempCharArray[posicion] == '-') {
                    pasos.add("(q2, "+cadena+", "+posicion+") -> Final");
                    this.cadena = String.valueOf(tempCharArray);
                    break;
                }
                if (estado == 2 && tempCharArray[posicion] == '1') {
                    tempCharArray[posicion] = 'B';
                    pasos.add("(q2, "+cadena+", "+posicion+") -> (q3, "+String.valueOf(tempCharArray)+", L)");
                    posicion--;
                    estado = 3;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 2 && tempCharArray[posicion] == '0') {
                    tempCharArray[posicion] = 'B';
                    pasos.add("(q2, "+cadena+", "+posicion+") -> (q3, "+String.valueOf(tempCharArray)+", L)");
                    posicion--;
                    estado = 6;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 3 && tempCharArray[posicion] == '0') {
                    tempCharArray[posicion] = '0';
                    pasos.add("(q3, "+cadena+", "+posicion+") -> (q3, "+String.valueOf(tempCharArray)+", L)");
                    posicion--;
                    estado = 3;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 3 && tempCharArray[posicion] == '1') {
                    tempCharArray[posicion] = '1';
                    pasos.add("(q3, "+cadena+", "+posicion+") -> (q3, "+String.valueOf(tempCharArray)+", L)");
                    posicion--;
                    estado = 3;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 3 && tempCharArray[posicion] == '-') {
                    tempCharArray[posicion] = '-';
                    pasos.add("(q3, "+cadena+", "+posicion+") -> (q4, "+String.valueOf(tempCharArray)+", L)");
                    posicion--;
                    estado = 4;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 4 && tempCharArray[posicion] == '1') {
                    tempCharArray[posicion] = 'O';
                    pasos.add("(q4, "+cadena+", "+posicion+") -> (q0, "+String.valueOf(tempCharArray)+", R)");
                    posicion++;
                    estado = 0;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 4 && tempCharArray[posicion] == '0') {
                    tempCharArray[posicion] = 'I';
                    pasos.add("(q4, "+cadena+", "+posicion+") -> (q5, "+String.valueOf(tempCharArray)+", L)");
                    posicion--;
                    estado = 5;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 4 && tempCharArray[posicion] == 'O') {
                    tempCharArray[posicion] = 'O';
                    pasos.add("(q4, "+cadena+", "+posicion+") -> (q4, "+String.valueOf(tempCharArray)+", L)");
                    posicion--;
                    estado = 4;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 4 && tempCharArray[posicion] == 'I') {
                    tempCharArray[posicion] = 'I';
                    pasos.add("(q4, "+cadena+", "+posicion+") -> (q4, "+String.valueOf(tempCharArray)+", L)");
                    posicion--;
                    estado = 4;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 5 && tempCharArray[posicion] == '0') {
                    tempCharArray[posicion] = '1';
                    pasos.add("(q5, "+cadena+", "+posicion+") -> (q5, "+String.valueOf(tempCharArray)+", L)");
                    posicion--;
                    estado = 5;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 5 && tempCharArray[posicion] == '1') {
                    tempCharArray[posicion] = '0';
                    pasos.add("(q5, "+cadena+", "+posicion+") -> (q0, "+String.valueOf(tempCharArray)+", R)");
                    posicion++;
                    estado = 0;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 6 && tempCharArray[posicion] == '0') {
                    tempCharArray[posicion] = '0';
                    pasos.add("(q6, "+cadena+", "+posicion+") -> (q0, "+String.valueOf(tempCharArray)+", L)");
                    posicion--;
                    estado = 6;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 6 && tempCharArray[posicion] == '1') {
                    tempCharArray[posicion] = '1';
                    pasos.add("(q6, "+cadena+", "+posicion+") -> (q6, "+String.valueOf(tempCharArray)+", L)");
                    posicion--;
                    estado = 6;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 6 && tempCharArray[posicion] == '-') {
                    tempCharArray[posicion] = '-';
                    pasos.add("(q6, "+cadena+", "+posicion+") -> (q7, "+String.valueOf(tempCharArray)+", L)");
                    posicion--;
                    estado = 7;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 7 && tempCharArray[posicion] == '0') {
                    tempCharArray[posicion] = 'O';
                    pasos.add("(q7, "+cadena+", "+posicion+") -> (q0, "+String.valueOf(tempCharArray)+", R)");
                    posicion++;
                    estado = 0;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 7 && tempCharArray[posicion] == '1') {
                    tempCharArray[posicion] = 'I';
                    pasos.add("(q7, "+cadena+", "+posicion+") -> (q0, "+String.valueOf(tempCharArray)+", R)");
                    posicion++;
                    estado = 0;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 7 && tempCharArray[posicion] == 'O') {
                    tempCharArray[posicion] = 'O';
                    pasos.add("(q7, "+cadena+", "+posicion+") -> (q7, "+String.valueOf(tempCharArray)+", L)");
                    posicion--;
                    estado = 7;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (estado == 7 && tempCharArray[posicion] == 'I') {
                    tempCharArray[posicion] = 'I';
                    pasos.add("(q7, "+cadena+", "+posicion+") -> (q7, "+String.valueOf(tempCharArray)+", L)");
                    posicion--;
                    estado = 7;
                    salir = true;
                    cadena = String.valueOf(tempCharArray);
                }
                if (!salir) {
                    pasos.add("Operación no valida");
                    break;
                }
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
