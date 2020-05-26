
package Semafori;


public class Auto extends Thread{
    private Parcheggio park;
public Auto(String nome, Parcheggio p) {
super(nome);
this.park = p;
start();
}
public void run() {
while (true) {
synchronized(park){
park.entrata();
System.out.println(getName()+": è entrata liberi:"+park.posti_disponibili);
} 
try { sleep((int)(Math.random() * 20000));
} catch (InterruptedException e) {e.printStackTrace();} synchronized(park){
  park.uscita();
  System.out.println(getName()+": è uscita liberi:"+park.posti_disponibili);
  } 
 }
 }
}
