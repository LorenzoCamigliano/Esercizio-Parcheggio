
package WaitNotify;

public class Parcheggio {

public int posti_disponibili = 10;

    public int getPosti_disponibili() {
        return posti_disponibili;
    }

public Parcheggio(int posti) {this.posti_disponibili= posti;}
public synchronized void entrata() {
while (posti_disponibili==0) {
try {wait();
}catch (InterruptedException e) {e.printStackTrace();}
}
posti_disponibili--;
}
public synchronized void uscita() {
posti_disponibili++;
notifyAll();
}
}
