/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

import java.util.HashMap;

/**
 *
 * @author Bryan
 */
public class ArbolHuffman<E> {
        Node<E> raiz;
        private class Node<E>{
            E data;
            private Node<E> left;
            private Node<E> right;
            
            public Node(E data) {
                this.data = data;
            }
            
            
        } 
        
        public boolean calcularArbol(HashMap<String,Integer> mapa){
            
            return true;
        }
        
        
        public HashMap<String,String> calcularCodigos(){
            return calcularCodigos(raiz);
        }
        
        public HashMap<String,String> calcularCodigos(Node<E> p){
            HashMap<String,String> mapa = new HashMap<>();
            if(p==null) return null;
            return mapa;
        }
}
