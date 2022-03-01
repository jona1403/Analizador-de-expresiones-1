/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;
import java.io.*;
/**
 *
 * @author HUGO
 */
public class TablaErrores {
    public TablaErrores(){
    }
    
    private String GenerateTable(Errores.TablaErrores tb){
        String txt = "";
        txt+="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                    "<head>\n" +
                  "  <title>Tabla de Errores</title>\n" +
                  "  <meta charset=\"utf-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n" +
                "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n" +
                "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n" +
                "</head>\n" +
                "<body>";
        txt+="<div class=\"container\">\n" +
            "  <h2>Tabla de errores</h2>\n" +
            "  <table class=\"table table-hover\">\n" +
            "    <thead>\n" +
            "      <tr>\n" +
            "        <th>#</th>\n" +
            "        <th>Tipo de Error</th>\n" +
            "        <th>Descripción</th>\n" +
            "        <th>Linea</th>\n" +
            "        <th>Columna</th>\n" +
            "      </tr>\n" +
            "    </thead>\n" +
            "    <tbody>";
        
        
        for(int i = 0; i < tb.errores.size(); i++){
            txt+="      <tr>\n" +
            "        <td>"+String.valueOf(tb.errores.get(i).getId())+"</td>\n" +
            "        <td>"+tb.errores.get(i).getTipo()+"</td>\n" +
            "        <td>"+tb.errores.get(i).getDescripcion()+"</td>\n" +
            "        <td>"+String.valueOf(tb.errores.get(i).getLinea())+"</td>\n" + 
            "        <td>"+String.valueOf(tb.errores.get(i).getColumna())+"</td>\n" +
            "      </tr>";
        }
        
        
        txt+="    </tbody>\n" +
            "  </table>\n" +
            "</div>\n" +
            "\n" +
            "</body>\n" +
            "</html>";
        return txt; 
    }
    public void DrawTable(Errores.TablaErrores tb, String Name) throws IOException{
        String htmltxt = "";
        htmltxt = GenerateTable(tb);
        File f = new File("ERRORES_201903004\\"+Name+".html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(htmltxt);
        bw.close();
    }
}
