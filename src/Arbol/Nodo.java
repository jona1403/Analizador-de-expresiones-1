/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.util.ArrayList;

/**
 *
 * @author HUGO
 */
public class Nodo {
    private String Valor;
    private int Identificador;
    private boolean Anulabilidad;
    private ArrayList<Integer> Primeros;
    private ArrayList<Integer> Ultimos;
    private Nodo Izquierda;
    private Nodo Derecha;   

    public Nodo(String Valor, int Identificador, boolean Anulabilidad, ArrayList<Integer> Primeros, ArrayList<Integer> Ultimos, Nodo Izquierda, Nodo Derecha) {
        this.Valor = Valor;
        this.Identificador = Identificador;
        this.Anulabilidad = Anulabilidad;
        this.Primeros = Primeros;
        this.Ultimos = Ultimos;
        this.Izquierda = Izquierda;
        this.Derecha = Derecha;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public int getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(int Identificador) {
        this.Identificador = Identificador;
    }

    public boolean isAnulabilidad() {
        return Anulabilidad;
    }

    public void setAnulabilidad(boolean Anulabilidad) {
        this.Anulabilidad = Anulabilidad;
    }

    public ArrayList<Integer> getPrimeros() {
        return Primeros;
    }

    public void setPrimeros(ArrayList<Integer> Primeros) {
        this.Primeros = Primeros;
    }

    public ArrayList<Integer> getUltimos() {
        return Ultimos;
    }

    public void setUltimos(ArrayList<Integer> Ultimos) {
        this.Ultimos = Ultimos;
    }

    public Nodo getIzquierda() {
        return Izquierda;
    }

    public void setIzquierda(Nodo Izquierda) {
        this.Izquierda = Izquierda;
    }

    public Nodo getDerecha() {
        return Derecha;
    }

    public void setDerecha(Nodo Derecha) {
        this.Derecha = Derecha;
    }
    

}
