/**
 * @author Pablo Guadagnin
 * Trabalho para apresentar Threads e Semáforos, usando um exemplo de aéroporto,
 * onde uma aterrissagem tem que ser feita por vez.
 * 
 * As posições de partida, velocidade de voo e chegada são aleatórias, porém,
 * a aterrissagem é por ordem de chegada.
 * 
*/

import java.util.concurrent.Semaphore;

public class Trab1ThreadAeroporto extends Thread{

    private int avioes;
    private Semaphore aeroporto;

    /**
     * Construtor que obriga que sejam passadas variáveis int e Semaphore
     * @param avioes
     * @param aeroporto
     */
    public Trab1ThreadAeroporto(int avioes, Semaphore aeroporto) { 
        this.aeroporto = aeroporto;
        this.avioes = avioes;
    }

    /**
     * Método que faz com que verifica quando os aviões chegaram e gerencia a fila de aterrissagem.
     */
    public void run() {

        voar();
        try {
            System.out.println("O Avião " + avioes + " chegou no Aeroporto");
            // ----> P <----
            aeroporto.acquire();
            Thread.sleep((int) (Math.random() * 1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // ----> V <----
            aeroporto.release();
            aviaoAterrissou();            
        }

    }

    /**
     * Método que faz os aviões voarem por alguns metros depois chegarem ao aeroporto.
     */
    private void voar() {

        int percorrido = 0;
        System.out.println("O Avião " + avioes + " Começou a Voar");

        while (percorrido < 50) {
            percorrido += (int) (Math.random() * 2) + 4;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }

    private void aviaoAterrissou() {
        System.out.println("O Avião " + avioes + " Aterrissou");
    }
}
