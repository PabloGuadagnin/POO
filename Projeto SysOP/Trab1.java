public class Trab1 extends Thread
{
   public void run()
   {
      System.out.println("A Thread comecou!");
   }
   public static void main(String args[]) {

      (new Trab1()).start();
   }
}