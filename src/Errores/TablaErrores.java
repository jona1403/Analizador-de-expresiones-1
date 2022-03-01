/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

import java.util.ArrayList;

/**
 *
 * @author HUGO
 */
public class TablaErrores {
    public String Nombre;
    public ArrayList<Error> errores;

    public TablaErrores() {
        this.Nombre = "Tabla Errores";
        this.errores = new ArrayList<>();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<Error> getErrores() {
        return errores;
    }

    public void setErrores(ArrayList<Error> errores) {
        this.errores = errores;
    }
    
    public void setError(int id, String tipo, String Descripcion, int linea, int columna){
        Errores.Error er = new Errores.Error(id, tipo, Descripcion, linea, columna);
        this.errores.add(er);
    }
    
}
