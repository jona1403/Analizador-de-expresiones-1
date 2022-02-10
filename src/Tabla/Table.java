/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabla;

import java.util.ArrayList;

/**
 *
 * @author HUGO
 */
public class Table {
    private ArrayList<Siguiente> siguientes;

    public Table() {
        siguientes = new ArrayList<Siguiente>();
    }

    public void setSiguientes(ArrayList<Siguiente> siguientes) {
        this.siguientes = siguientes;
    }

    public ArrayList<Siguiente> getSiguientes() {
        return siguientes;
    }
    
    
}
