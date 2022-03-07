/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;
import App.AppFrame;
import Arbol.Nodo;
import java.io.FileWriter;
import java.io.PrintWriter;
/**
 *
 * @author HUGO
 */
public class Arbol {

    public Arbol() {
    }
    
    public String texto(Nodo nodo){
        String txt = "";
        if(nodo != null){
            if(nodo.getIzquierda() == null && nodo.getDerecha() == null){
                if(nodo.getValor().length()== 3){
                    txt += String.valueOf(nodo.getIdentificador())+"[label=\""+nodo.getIdentificador()+"|{"+nodo.isAnulabilidad()+"|{"+nodo.getValor().substring(1, nodo.getValor().length()-1)+"}|"+"id: "+nodo.getIdentificador()+"}"+"|"+nodo.getIdentificador()+"\"];\n";
                }else{
                    txt += String.valueOf(nodo.getIdentificador())+"[label=\""+nodo.getIdentificador()+"|{"+nodo.isAnulabilidad()+"|{"+nodo.getValor()+"}|"+"id: "+nodo.getIdentificador()+"}"+"|"+nodo.getIdentificador()+"\"];\n";
                }
                
            }else{
                if(nodo.getIzquierda() != null){
                    txt += String.valueOf(nodo.getIdentificador())+"[label=\""+nodo.getPrimeros()+"|{"+nodo.isAnulabilidad()+"|{"+nodo.getValor()+"}|"+"id: 0"+"}"+"|"+nodo.getUltimos()+"\"];\n";
                    txt += texto(nodo.getIzquierda());
                }
                if(nodo.getDerecha() != null){
                    txt += String.valueOf(nodo.getIdentificador())+"[label=\""+nodo.getPrimeros()+"|{"+nodo.isAnulabilidad()+"|{"+nodo.getValor()+"}|"+"id: 0"+"}"+"|"+nodo.getUltimos()+"\"];\n";
                    txt += texto(nodo.getDerecha());
                }
            }
        }
        return txt;
    }
    
    public String flechas(Nodo nodo){
        String txt = "";
        if(nodo != null){
            if(nodo.getIzquierda() == null && nodo.getDerecha() == null){
                
            }else{ 
                if(nodo.getIzquierda() != null){
                    txt += String.valueOf(nodo.getIdentificador())+" -> "+String.valueOf(nodo.getIzquierda().getIdentificador())+";\n";
                    txt += flechas(nodo.getIzquierda());
                }
                if(nodo.getDerecha() != null){
                    txt += String.valueOf(nodo.getIdentificador())+" -> "+String.valueOf(nodo.getDerecha().getIdentificador())+";\n";
                    txt += flechas(nodo.getDerecha());
                }
            }
        }
        return txt;
    }
    
    public String grafo(Nodo nodo){
        String txt = "digraph structs {\n" +
        "    node [shape=record];";
        if (nodo != null){
            txt+= texto(nodo);
            txt+= flechas(nodo);
        }
        txt+= "\n}";
        return txt;
    }
    
    public void writeFile(String txt, String nombre){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            AppFrame.Contadorfiles++;
            fichero = new FileWriter("ARBOLES_201903004\\arbol"+nombre+".dot");
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
    
    public void dibujarArbol(Nodo nodo, String Nombre){
        try{
            writeFile(grafo(nodo), Nombre);
            ProcessBuilder proceso;
            proceso = new ProcessBuilder("dot", "-Tpng", "-o", "ARBOLES_201903004\\arbol"+Nombre+".png", "ARBOLES_201903004\\arbol"+Nombre+".dot");
            proceso.redirectErrorStream(true);
            proceso.start();
        }catch(Exception e){
            System.out.println(e.getMessage()+"ja1");
        }
    }
}
