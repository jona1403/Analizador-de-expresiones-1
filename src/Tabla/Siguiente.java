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
public class Siguiente {
    private int identificador;
    private ArrayList<Integer> SigPos;
    private String Nombre;

    public Siguiente(String Nombre,int identificador, ArrayList<Integer> sig) {
        this.Nombre = Nombre;
        this.identificador = identificador;
        this.SigPos = sig;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setSigPos(int id){
        this.SigPos.add(id);
    }

    public int getIdentificador() {
        return identificador;
    }

    public ArrayList<Integer> getSigPos() {
        return SigPos;
    }
    
    
}
