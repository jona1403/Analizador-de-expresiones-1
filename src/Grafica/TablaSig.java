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
public class TablaSig {

    public TablaSig() {
    }
    
    private String grafo(ArrayList<Tabla.Siguiente> lista){
        String txt = "";
        txt +=  " digraph html {\n" +
                "abc [shape=none, margin=0, label=<\n" +
                "<TABLE BORDER=\"0\" CELLBORDER=\"1\" CELLSPACING=\"0\" CELLPADDING=\"4\">"
                + "<tr><td>HOJA</td><td>HOJA</td><td>SIGUIENTES</td></tr>";
        for(int i = 0; i< lista.size(); i++){
            txt+="<tr><td>"+lista.get(i).getNombre()+"</td>";
            txt+="<td>"+String.valueOf(lista.get(i).getIdentificador())+"</td>";
            txt+="<td>"+lista.get(i).getSigPos()+"</td></tr>";
        }
        txt+= "</TABLE>>];\n" +
        "}";
        
        return txt;
    }
    
    private void writeFile(String txt, String Nombre){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter("SIGUIENTES_201903004\\Siguientes"+Nombre+".dot");
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
    
    public void dibujarTabla(String Nombre, ArrayList<Tabla.Siguiente> lista){
        try{
            writeFile(grafo(lista), Nombre);
            ProcessBuilder proceso;
            proceso = new ProcessBuilder("dot", "-Tpng", "-o", "SIGUIENTES_201903004\\Siguientes"+Nombre+".png", "SIGUIENTES_201903004\\Siguientes"+Nombre+".dot");
            proceso.redirectErrorStream(true);
            proceso.start();
        }catch(Exception e){
            System.out.println(e.getMessage()+"ja1");
        }
    }
    
}
