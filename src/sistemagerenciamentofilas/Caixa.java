/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagerenciamentofilas;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Flávio
 */
public class Caixa extends Thread {
    
    private final int numCaixa;
    
    public Caixa(int numCaixa) {
        super();
        this.numCaixa = numCaixa;
    }
    
    private void atende(Cliente cliente) {
        cliente.atende(this.numCaixa);
    }

    @Override
    public void run() {
        while (true) {
            Cliente cliente = SistemaGerenciamentoFilas.filaPrincipal.desenfilera();
            if (cliente != null) {
                atende(cliente);
            } else {
                System.out.println(String.format("Caixa numero %d chamou, mas a fila esta vazia.", this.numCaixa));
                break;
            }
            try {
                sleep(1000); // espera um segundo pra podermos acompanhar no console
            } catch (InterruptedException ex) {
                Logger.getLogger(Caixa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
