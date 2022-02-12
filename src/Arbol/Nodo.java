/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import App.AppFrame;
import Tabla.Siguiente;
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

    public void GenerateSiguientes() {
        App.AppFrame.siguientes = new ArrayList<Tabla.Siguiente>();
        for (int i = 1; i <= this.Derecha.Identificador; i++) {
            App.AppFrame.auxiliarSigpor = new ArrayList<Integer>();
            GenerateSiguientes(this, i);
            Nom(this, i);
            System.out.println(App.AppFrame.aux);
            App.AppFrame.siguientes.add(new Siguiente(App.AppFrame.aux, i, App.AppFrame.auxiliarSigpor));
        }
    }

    private boolean YaExiste(int index) {
        for (int i = 0; i < App.AppFrame.auxiliarSigpor.size(); i++) {
            if (AppFrame.auxiliarSigpor.get(i).equals(index)) {
                return true;
            }
        }
        return false;
    }

    private void Nom(Nodo nodo, int index) {
        if (nodo != null) {
            Nom(nodo.getIzquierda(), index);

            if (nodo.Identificador > 0) {
                if (nodo.getIdentificador() == index) {
                    App.AppFrame.aux = nodo.getValor();
                    return;
                }

            }

            Nom(nodo.getDerecha(), index);
        }
    }

    private void GenerateSiguientes(Nodo nodo, int index) {
        if (nodo != null) {
            this.GenerateSiguientes(nodo.getIzquierda(), index);
            if (nodo.Derecha != null) {

                if (nodo.getValor().equals(".")) {
                    for (int i = 0; i < nodo.getIzquierda().getUltimos().size(); i++) {
                        if (nodo.getIzquierda().getUltimos().get(i) == index) {
                            for (int j = 0; j < nodo.getDerecha().getPrimeros().size(); j++) {
                                if (!YaExiste(nodo.getDerecha().getPrimeros().get(j))) {
                                    App.AppFrame.auxiliarSigpor.add(nodo.getDerecha().getPrimeros().get(j));
                                }
                            }
                        }
                    }
                } else if (nodo.getValor().equals("*") || nodo.getValor().equals("+")) {
                    for (int i = 0; i < nodo.getDerecha().getUltimos().size(); i++) {
                        if (nodo.getDerecha().getUltimos().get(i) == index) {
                            for (int j = 0; j < nodo.getDerecha().getPrimeros().size(); j++) {
                                if (!YaExiste(nodo.getDerecha().getPrimeros().get(j))) {
                                    App.AppFrame.auxiliarSigpor.add(nodo.getDerecha().getPrimeros().get(j));
                                }
                            }
                        }
                    }
                }

            }
            this.GenerateSiguientes(nodo.getDerecha(), index);
        }
    }
}
