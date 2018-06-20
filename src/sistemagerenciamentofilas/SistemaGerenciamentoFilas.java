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
public class SistemaGerenciamentoFilas {

    public static ListaPrioridade<Cliente> filaPrincipal;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        filaPrincipal = new ListaPrioridade<>();
        try {
            populaFila();
            criaCaixas();
        } catch (Exception e) {
            System.out.println("Erro ao popular a fila!");
            System.out.println(e.getMessage());
        }
    }
    
    private static void criaCaixas() {
        for (int i = 1; i < 6; i++) {
            new Caixa(i).start();
        }
    }
    
    private static void populaFila() throws Exception {
        int[] contadores = new int[3];
        
        for (int i = 0; i < 100; i++) {
            int prioridade = geraPrioridade();
            int posicao = ++contadores[prioridade];
            String senha = String.format("%dP%d", prioridade, posicao);
            filaPrincipal.enfilera(new Cliente(senha), prioridade);
        }
        
    }
    
    private static int geraPrioridade() {
        return (int)((Math.random() * 10) % 3);
    }
    
}
