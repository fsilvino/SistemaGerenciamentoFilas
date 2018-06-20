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
public class Cliente extends Thread {

    private final String senha;
    private int numCaixa;
    
    public Cliente(String senha) {
        super();
        this.senha = senha;
    }

    @Override
    public void run() {
        System.out.println(String.format("O cliente com a senha %s foi atendido pelo caixa numero %d!", this.senha, this.numCaixa));
    }
    
    public void atende(int numCaixa) {
        this.numCaixa = numCaixa;
        start();
    }
    
}
