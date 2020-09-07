/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 *
 * @author Bryan
 */
public class ArbolHuffman<E>{
        Node<E> raiz;
        private class Node<E>{
            E data;
            private Node<E> left;
            private Node<E> right;
            private String codigo;
            private String letra;
            
            public Node(E data) {
                this.data = data;
            }
            
            
        } 
        
        public boolean calcularArbol(HashMap<String,Integer> mapa){
            if(mapa.isEmpty()) return false;
            PriorityQueue<Node<Integer>> colaArboles = new PriorityQueue<>((Node<Integer> e1,Node<Integer> e2)->
                    (e1.data-e2.data));
            for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
                Node<Integer> n = new Node<>(entry.getValue());
                n.letra = entry.getKey();
                colaArboles.add(n);
            }
            while(colaArboles.size()!=1){
                Node<Integer> temp= colaArboles.poll();
                Node<Integer> temp2 = colaArboles.poll();
                temp.codigo="0";
                temp2.codigo="1";
                Node<Integer> nodoPadre = new Node<>(temp.data+temp.data);
                colaArboles.offer(nodoPadre);
            }     
            return true;
        }
        
        
        
        public HashMap<String,String> calcularCodigos(){
            return calcularCodigos(raiz);
        }
        
        public HashMap<String,String> calcularCodigos(Node<E> p){
            Node<E> temp = p;
            HashMap<String,String> mapa = new HashMap<>();
            if(temp==null) return mapa;
            if(temp.right==null && temp.left==null){
               mapa.put(temp.data.toString(),temp.codigo);
            }
            if(temp.right!=null && temp.left!=null){
                 temp.left.codigo=temp.codigo+temp.left.codigo;
                 temp.right.codigo=temp.codigo+temp.right.codigo;
                 mapa.putAll(calcularCodigos(temp.left));
                 mapa.putAll(calcularCodigos(temp.right));
            }
            return mapa;
        }
        
        public static String codificar (String texto, HashMap<String,String> mapa){
            String result = ""; 
            String[] cadena = texto.split("");
            for(int i =0;i<cadena.length;i++){
                result=result+mapa.get(cadena[i]);
            }
            return result;
        }
        public static String decodificar(String texto, HashMap<String,String> mapa){
            String result = "";
            String[] cadena = texto.split("");
            int contador = 0;
            while(contador<cadena.length){
                for (String key : mapa.keySet()) {
                    if(key.equals(cadena[contador])){
                        result+=key;
                    }
                }
                contador+=1;
            }   
            return result;
        }
}
