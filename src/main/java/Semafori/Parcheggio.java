
package Semafori;

import java.util.concurrent.Semaphore;
public class Parcheggio {
    int posti_disponibili;
    private Semaphore postiLiberi;
    private Semaphore postiOccupati;
    
    public Parcheggio(int nPosti)
    {
        this.posti_disponibili = posti_disponibili;
        postiLiberi = new Semaphore(nPosti, true);
        postiOccupati = new Semaphore(0, true);
    }
    
    public int getPosti()
    {
        return posti_disponibili;
    }
    
    public synchronized void entrata()
    {
        try
        {
            postiLiberi.acquire();
        } catch (InterruptedException e) {}
        postiOccupati.release();
        posti_disponibili--;
    }
    
    public synchronized void uscita()
    {
        try
        {
            postiOccupati.acquire();
        } catch (InterruptedException e) {}
        postiLiberi.release();
        posti_disponibili++;
    }
}
