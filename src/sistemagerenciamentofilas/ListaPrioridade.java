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
public class ListaPrioridade<T> {
    
    private Fila<T>[] filas;
    private int[] contadores;
    private final int FATOR_ENVELHECIMENTO = 3;
    
    public ListaPrioridade() {
        filas = new Fila[] { new Fila(), new Fila(), new Fila() };
        contadores = new int[filas.length];
    }
    
    public synchronized void enfilera(T item, int prioridade) throws Exception {
        if (prioridade < 0 || prioridade >= filas.length) {
            throw new Exception("Prioridade inválida!");
        }
        filas[prioridade].enfilera(item);
    }
    
    private synchronized T desenfilera(int prioridade) {
        if (filas[prioridade].count() > 0) {
            T item = filas[prioridade].desenfilera();
            contadores[prioridade]++;
            if (prioridade < filas.length - 1 && contadores[prioridade] == FATOR_ENVELHECIMENTO) {
                filas[prioridade].enfilera(filas[prioridade + 1].desenfilera());
                contadores[prioridade] = 0;
            }
            return item;
        } else if (prioridade < filas.length - 1) {
            return desenfilera(prioridade + 1);
        }
        return null;
    }
    
    public synchronized T desenfilera() {
        return desenfilera(0);
    }
    
}
