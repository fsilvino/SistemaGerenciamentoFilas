/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagerenciamentofilas;

/**
 *
 * @author Flávio
 */
public class Fila<T> {
    
    private Nodo primeiro;
    private Nodo ultimo;
    private int count;
    
    public Fila() {
        primeiro = null;
        ultimo = null;
        count = 0;
    }
    
    public synchronized void enfilera(T item) {
        Nodo novo = new Nodo(item);
        if (ultimo != null) {
            ultimo.setProximo(novo);
            ultimo = novo;
        } else {
            primeiro = novo;
            ultimo = novo;
        }
        count++;
    }
    
    public synchronized T desenfilera() {
        if (primeiro != null) {
            T item = primeiro.getItem();
            primeiro = primeiro.getProximo();
            count--;
            if (count <= 1) {
                ultimo = primeiro;
            }
            return item;
        }
        return null;
    }
    
    public int count() {
        return this.count;
    }
    
    private class Nodo {
        
        private Nodo proximo;
        private T item;
        
        public Nodo(T item) {
            this.item =  item;
            this.proximo = null;
        }
        
        public Nodo(T item, Nodo proximo) {
            this(item);
            this.proximo = proximo;
        }
        
        public T getItem() {
            return item;
        }
        
        public Nodo getProximo() {
            return proximo;
        }
        
        public void setProximo(Nodo proximo) {
            this.proximo = proximo;
        }
        
    }
    
}
