/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import App.AppFrame;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author HUGO
 */
public class AFD {

    public AFD() {
    }

    private String Nodos(Transiciones.TablaTrans tbl, int fin) {
        boolean encontrado = false;
        String txt = "{\n";
        for (int i = 0; i < tbl.getEstados().size(); i++) {
            txt += "\n";
            txt += tbl.getEstados().get(i).getNombre();
            if (esAceptacion(tbl.getEstados().get(i).getLista(), fin)) {
                txt += "[shape=doublecircle fixedsize=true]";
            } else {
                txt += "[shape=circle fixedsize=true]";
            }
        }
        txt += "}";
        return txt;
    }

    private String Arrows(Transiciones.TablaTrans tbl) {
        String txt = "";
        for (int i = 0; i < tbl.getEstados().size(); i++) {
            for (int j = 0; j < tbl.getEstados().get(i).getTerminales().size(); j++) {
                if (!tbl.getEstados().get(i).getTerminales().get(j).equals("--")) {
                    txt += "\n";
                    txt += tbl.getEstados().get(i).getNombre() + " -> " + tbl.getEstados().get(i).getTerminales().get(j)+"[label= "+ tbl.getTerms().get(j)+"]";
                }
            }
        }
        return txt;
    }

    private String grafo(Transiciones.TablaTrans tbl, int fin) {
        String txt = "digraph structs {\n";
        txt+= "rankdir=LR \n";
        txt += Nodos(tbl, fin);
        txt += Arrows(tbl);
        txt += "\n }";
        return txt;
    }

    private void writeFile(String txt, String nombre) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("AFD_201903004\\afd" + nombre + ".dot");
            pw = new PrintWriter(fichero);
            pw.write(txt);
            pw.close();

        } catch (Exception e) {
            System.out.println(e.getMessage() + "ja");
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public void dibujarArbol(Transiciones.TablaTrans tbl, int fin, String Nombre) {
        try {
            writeFile(grafo(tbl, fin), Nombre);
            ProcessBuilder proceso;
            proceso = new ProcessBuilder("dot", "-Tpng", "-o", "AFD_201903004\\afd" + Nombre + ".png", "AFD_201903004\\afd" + Nombre + ".dot");
            proceso.redirectErrorStream(true);
            proceso.start();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "ja1");
        }
    }

    public boolean esAceptacion(ArrayList<Integer> lista, int fin) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(fin)) {
                return true;
            }
        }
        return false;
    }
}
