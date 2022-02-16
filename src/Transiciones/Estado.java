/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transiciones;

import java.util.ArrayList;

/**
 *
 * @author HUGO
 */
public class Estado {
    private String Nombre;
    private ArrayList<Integer> lista;
    public ArrayList<String> terminales;

    public Estado(String Nombre, ArrayList<Integer> lista) {
        this.Nombre = Nombre;
        this.lista = lista;
        this.terminales = new ArrayList<String>();
    }

    public ArrayList<String> getTerminales() {
        return terminales;
    }

    public void setTerminales(ArrayList<String> terminales) {
        this.terminales = terminales;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<Integer> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Integer> lista) {
        this.lista = lista;
    }
    
}
