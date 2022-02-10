/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expanalyzer;
import App.AppFrame;
import java.util.ArrayList;
/**
 *
 * @author HUGO
 */
public class ExpAnalyzer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        generarCompilador("src/Parser/");
        App.AppFrame app = new App.AppFrame();
        app.setVisible(true);
    }

    public static void generarCompilador(String path) {
        try {
            String opcFlex[] = {path + "Lexico.jflex", "-d", path};
            jflex.Main.generate(opcFlex);
            
            String opcCUP[] = {"-destdir", path, "-parser", "Sintactico", path + "Sintactico.cup"};
            java_cup.Main.main(opcCUP);
        } catch (Exception e) {
        }
    }
}
