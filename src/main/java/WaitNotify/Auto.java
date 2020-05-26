
package WaitNotify;


public class Auto extends Thread {
private Parcheggio p;
public Auto(String nome, Parcheggio p) {
super(nome);
this.p = p;
start();
}
public void run() {
while (true) {
synchronized(p){
p.entrata();
System.out.println(getName()+": i posti rimanenti: " + p.getPosti_disponibili());
} 
try { sleep((int)(Math.random() * 20000));
} catch (InterruptedException e) {e.printStackTrace();} synchronized(p){
  p.uscita();
  System.out.println(getName()+": i posti momenti: " + p.getPosti_disponibili());
  } 
 }
 }
}

