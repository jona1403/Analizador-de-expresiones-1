/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author HUGO
 */
public class TablaTrans {

    public TablaTrans() {
    }
    
    private String grafo(Transiciones.TablaTrans tbl){
        String txt = "";
        txt +=  " digraph html {\n" +
                "abc [shape=none, margin=0, label=<\n" +
                "<TABLE BORDER=\"0\" CELLBORDER=\"1\" CELLSPACING=\"0\" CELLPADDING=\"4\">";
                //+ "<tr><td>HOJA</td><td>HOJA</td><td>SIGUIENTES</td></tr>";/
                txt+= "<tr><td>Estado</td   >";
                for(int i = 0; i < tbl.getTerms().size()-1; i++){
                    txt+= "<td>"+tbl.getTerms().get(i)+"</td>";
                }
                txt+= "</tr>";
        for(int i = 0; i< tbl.getEstados().size(); i++){
            txt+="<tr><td>"+tbl.getEstados().get(i).getNombre()+tbl.getEstados().get(i).getLista()+"</td>";
            for(int j = 0; j < tbl.getEstados().get(i).getTerminales().size(); j++){
                txt+= "<td>"+tbl.getEstados().get(i).getTerminales().get(j)+"</td>";
            }
            txt+="</tr>";
        }
        txt+= "</TABLE>>];\n" +
        "}";
        
        return txt;
    }
    
    private void writeFile(String txt, String Nombre){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter("TRANSICIONES_201903004\\Transiciones"+Nombre+".dot");
            pw = new PrintWriter(fichero);
            pw.write(txt);
            pw.close();
            
        }catch(Exception e){
            System.out.println(e.getMessage()+"ja");
        } finally{
            if(pw != null){
                pw.close();
            }
        }
    }
    
    public void dibujarTabla(String Nombre, Transiciones.TablaTrans tbl){
        try{
            writeFile(grafo(tbl), Nombre);
            ProcessBuilder proceso;
            proceso = new ProcessBuilder("dot", "-Tpng", "-o", "TRANSICIONES_201903004\\Transiciones"+Nombre+".png", "TRANSICIONES_201903004\\Transiciones"+Nombre+".dot");
            proceso.redirectErrorStream(true);
            proceso.start();
        }catch(Exception e){
            System.out.println(e.getMessage()+"ja1");
        }
    }   
    
}
