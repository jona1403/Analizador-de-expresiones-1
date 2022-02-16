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
public class TablaTrans {

    private String nombre;
    private ArrayList<Estado> estados;
    private ArrayList<String> terms;

    public TablaTrans() {
        this.nombre = "";
        this.estados = new ArrayList<Estado>();
        this.terms = new ArrayList<String>();
    }

    private boolean YaIngresado(ArrayList<Integer> lista, int Valor) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(Valor)) {
                return true;
            }
        }
        return false;
    }

    private boolean YaExisten(ArrayList<Integer> lista, ArrayList<ArrayList<Integer>> listas) {
        for (int i = 0; i < listas.size(); i++) {
            if (listas.get(i).equals(lista)) {
                return true;
            }
        }
        return false;
    }

    private boolean YaExisten(ArrayList<Integer> lista) {
        for (int i = 0; i < this.estados.size(); i++) {
            if (this.estados.get(i).getLista().equals(lista)) {
                return true;
            }
        }
        return false;
    }

    private String Existen(ArrayList<Integer> lista) {
        for (int i = 0; i < this.estados.size(); i++) {
            if (this.estados.get(i).getLista().equals(lista)) {
                return this.estados.get(i).getNombre();
            }
        }
        return "--";
    }

    public void calcTrans(ArrayList<Integer> inicial, ArrayList<Tabla.Siguiente> siguientes) {
        ArrayList<ArrayList<Integer>> auxarray = new ArrayList<ArrayList<Integer>>();
        int aux = 0;
        ArrayList<String> Stringaux = new ArrayList<>();
        ArrayList<Integer> auxiliar = new ArrayList<>();
        auxarray.add(inicial);
        while (auxarray.size() > 0) {
            this.estados.add(new Estado("S" + String.valueOf(App.AppFrame.contadoraux++), auxarray.get(auxarray.size() - 1)));
            for (int i = 0; i < this.terms.size(); i++) {
                for (int j = 0; j < auxarray.get(0).size(); j++) {
                    if (siguientes.get(auxarray.get(0).get(j) - 1).getNombre().equals(this.terms.get(i))) {
                        for (int w = 0; w < siguientes.get(auxarray.get(0).get(j) - 1).getSigPos().size(); w++) {
                            if (!YaIngresado(auxiliar, siguientes.get(auxarray.get(0).get(j) - 1).getSigPos().get(w))) {
                                auxiliar.add(siguientes.get(auxarray.get(0).get(j) - 1).getSigPos().get(w));
                            }
                        }
                    }
                }
                //Aqui se agregan l
                if (!YaExisten(auxiliar, auxarray) && auxiliar.size() > 0 && !YaExisten(auxiliar)) {
                    auxarray.add(auxiliar);
                    auxiliar = new ArrayList<Integer>();
                }

            }
            auxarray.remove(0);
        }
        
        
        auxarray.add(inicial);
        while (auxarray.size() > 0) {
            //this.estados.add(new Estado("S" + String.valueOf(App.AppFrame.contadoraux++), auxarray.get(auxarray.size() - 1)));
            for (int i = 0; i < this.terms.size(); i++) {
                for (int j = 0; j < auxarray.get(0).size(); j++) {
                    if (siguientes.get(auxarray.get(0).get(j) - 1).getNombre().equals(this.terms.get(i))) {
                        for (int w = 0; w < siguientes.get(auxarray.get(0).get(j) - 1).getSigPos().size(); w++) {
                            if (!YaIngresado(auxiliar, siguientes.get(auxarray.get(0).get(j) - 1).getSigPos().get(w))) {
                                auxiliar.add(siguientes.get(auxarray.get(0).get(j) - 1).getSigPos().get(w));
                            }
                        }
                    }
                }
                //Aqui se agregan l
                for(int j = 0; j< this.estados.size(); j++){
                    if(this.estados.get(j).getLista().equals(auxarray.get(0))){
                        Estado est = this.estados.get(j);
                        est.terminales.add(Existen(auxiliar));
                        this.estados.set(j, est);
                    }
                }
                if (!YaExisten(auxiliar, auxarray) && auxiliar.size() > 0) {
                    auxarray.add(auxiliar);
                    auxiliar = new ArrayList<Integer>();
                }

            }
            auxarray.remove(0);
        }        
        
 
        
    }

    /*public void calcTrans(ArrayList<Integer> inicial, ArrayList<Tabla.Siguiente> siguientes){
        ArrayList<ArrayList<Integer>> auxarray = new ArrayList<ArrayList<Integer>>();
        int aux = 0;
        ArrayList<Integer> auxiliar = new ArrayList<>();
       auxarray.add(inicial);
        while(auxarray.size()>0){
            this.estados.add(new Estado("S"+String.valueOf(App.AppFrame.contadoraux++), auxarray.get(auxarray.size()-1)));
            aux = auxarray.size()-1;
            for(int i = 0; i< this.terms.size(); i++){
                for(int j = 0; j < auxarray.get(auxarray.size()-1).size(); j++){
                    if(siguientes.get(auxarray.get(auxarray.size()-1).get(j)-1).getNombre().equals(this.terms.get(i))){
                        for(int w = 0; w < siguientes.get(auxarray.get(auxarray.size()-1).get(j)-1).getSigPos().size(); w++){
                            if(!YaIngresado(auxiliar, siguientes.get(auxarray.get(auxarray.size()-1).get(j)-1).getSigPos().get(w))){
                                auxiliar.add(siguientes.get(auxarray.get(auxarray.size()-1).get(j)-1).getSigPos().get(w));
                            }
                        }
                    }
                }
                //Aqui se agregan l
                if(!YaExisten(auxiliar, auxarray) && auxiliar.size()>0 && !YaExisten(auxiliar)){
                    auxarray.add(auxiliar);
                    auxiliar = new ArrayList<Integer>();
                }
                
                
            }
            auxarray.remove(aux);
        }
        
    }*/
    public ArrayList<String> getTerms() {
        return terms;
    }

    public void setTerms(ArrayList<String> terms) {
        this.terms = terms;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }

}
