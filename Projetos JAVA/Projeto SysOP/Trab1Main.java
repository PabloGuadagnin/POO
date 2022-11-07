/**
 * @author Pablo Guadagnin
 * Trabalho para apresentar Threads e Semáforos, usando um exemplo de aéroporto,
 * onde uma aterrissagem tem que ser feita por vez.
 * 
 * As posições de partida, velocidade de voo e chegada são aleatórias, porém,
 * a aterrissagem é por ordem de chegada
 * 
*/

import java.util.concurrent.Semaphore;

class Trab1Main {
   public static void main(String args[]) {

      int permitido = 1; // Seta o numero de avioes permitidos a pousar por vez.
      Semaphore aeroporto = new Semaphore(permitido); // Cria um objeto aeroporto da classe java Semaphore atribuindo valor int de permitido.
      
      for (int avioes = 1; avioes <= 10; avioes++){ // Cria 10 avioes que voarão até a aeroporto.
         Thread threadAeroporto = new Trab1ThreadAeroporto(avioes, aeroporto); // Cria a thread aeroporto e passa avioes e aeroporto como parametro.
         threadAeroporto.start(); // Inicia a Thread
      }
      
   }
}