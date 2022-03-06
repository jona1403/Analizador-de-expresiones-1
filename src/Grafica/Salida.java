/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import App.AppFrame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author HUGO
 */
public class Salida {

    public Salida() {
    }

    private String GenerateSalida() {
        String txt = "";
        txt += "[\n";
        int contador = 0;

        
        for (Iterator<Map.Entry<String, String>> entries = App.AppFrame.expresionesEvaluar.entrySet().iterator(); entries.hasNext();) {
            contador++;
            
            Map.Entry<String, String> entry = entries.next();
            int finn = App.AppFrame.Arboles.get(entry.getValue()).getDerecha().getIdentificador();
            txt+= "    {\n";
            
            txt+="        \"Valor\": "+entry.getKey()+ ",\n";
            txt+="        \"ExpresionRegular\": \""+entry.getValue()+ "\",\n";
            
            Transiciones.TablaTrans trtable = App.AppFrame.TablasTR.get(entry.getValue());
            Transiciones.Estado est = trtable.getEstados().get(0);
            boolean aceptado = false;
            boolean caracteraceptado = false;
            String temp = "";
            String[] chars = entry.getKey().split("");
            //Se recorre la cadena 
            for(int i = 1; i< chars.length-1; i++){
                caracteraceptado = false;
                //Se recorren los movimientos del estado actual
                for(int j = 0; j < est.getTerminales().size(); j++){
                    //Se valida que haya transicion y que no se haya aceptado una transicion
                    if(!est.getTerminales().get(j).equals("--") && !caracteraceptado){
                        String exp= trtable.getTerms().get(j);
                        //Se verifica si es un conjunto o un caracter
                        if(exp.substring(0,1).equals("\"")){
                            if(exp.substring(1, exp.length()-1).equals(chars[i])){
                                caracteraceptado = true;
                                temp = est.getTerminales().get(j);
                                break;
                            }
                        }else{
                            String conj = App.AppFrame.conjuntos.get(exp);
                            if(conj.subSequence(1, 2).equals(",")){
                                String[] parts = conj.split(",");
                                for(int w = 0; w < parts.length; w++){
                                    if(parts[w].equals(chars[i])){
                                        caracteraceptado = true;
                                        temp = est.getTerminales().get(j);
                                        break;
                                    }
                                }
                            }else{
                                String[] partes = conj.split("~");
                                byte[] inicio = partes[0].getBytes(StandardCharsets.US_ASCII), fin = partes[1].getBytes(StandardCharsets.US_ASCII), c = chars[i].getBytes(StandardCharsets.US_ASCII);
                                
                                if(c[0]>=inicio[0] && c[0]<=fin[0]){
                                    caracteraceptado = true;
                                    temp = est.getTerminales().get(j);
                                    break;
                                }
                                
                            }
                        }
                    }
                }
                if(!caracteraceptado){
                    break;
                }else{
                    for(int l = 0; l < trtable.getEstados().size(); l++){
                        /*System.out.println(entry.getKey());
                        System.out.println(chars[i]);
                        System.out.println("Este:"+temp);*/
                        
                        if(trtable.getEstados().get(l).getNombre().equals(temp)){
                            est = trtable.getEstados().get(l);
                            temp = "";
                            break;
                        }
                    }
                    Grafica.AFD af = new Grafica.AFD();
                    if(i == chars.length-2 && caracteraceptado && af.esAceptacion(est.getLista(), finn)){
                        aceptado = true;
                    }
                }
            }
            
            if(aceptado){
                txt+="        \"Resultado\": \"Aceptada por la expresion regular\" \n";
            }else{
                txt+="        \"Resultado\": \"No aceptada por la expresion regular\" \n";
            }
            if(contador == App.AppFrame.expresionesEvaluar.size()){
                txt +="    }\n";
            }else{
                txt +="    }, \n";
            }
        }

        txt += "]";
        return txt;
    }

    public void DrawTable(String Name) throws IOException {
        String jsontxt = "";
        jsontxt = GenerateSalida();
        File f = new File("SALIDAS_201903004\\" + Name + ".json");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(jsontxt);
        bw.close();
    }
}
