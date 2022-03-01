/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFND;

import java.awt.Frame;

/**
 *
 * @author HUGO
 */
public class Node {
    public String Name;
    public int id;
    public String tipo;
    public String SimUp;
    public String SimDown;
    public Node Up;
    public Node Down;

    public Node(int id, String tipo) {
        this.Name = null;
        this.id = id;
        this.tipo = tipo;
        this.SimUp = null;
        this.SimDown = null;
        this.Up = null;
        this.Down = null;
    }
    
    public Node _makeAFND(Arbol.Nodo root){
        return makeAFND(root);
    }
    
    private Node makeAFND(Arbol.Nodo nodo){
        Node aux = null;
        Node inicio = null;
        Node fin = null;
        if(nodo != null){
            if(nodo.getValor().equals(".")){
                aux = new Node(App.AppFrame.ContadorAfn++, ".");
                aux.Up = makeAFND(nodo.getIzquierda());
                aux.Down = makeAFND(nodo.getDerecha());
            }else if(nodo.getValor().equals("|")){
            }else if(nodo.getValor().equals("*")){
            }else if(nodo.getValor().equals("+")){
            }
        }
        return aux;
    }
    
    
    
}
