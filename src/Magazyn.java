import java.util.*;

public class Magazyn {
    private Map<Pomieszczenie,Osoba> Magazyn;
    private Osoba osoba;

    public Magazyn(){
        Magazyn= new HashMap<>();
    }

    public void dodajDoPomieszczenie(Pomieszczenie pomieszczenie){
        Magazyn.put(pomieszczenie, null);
    }
    public void dodajDoPomieszczenie(Pomieszczenie pomieszczenie, Osoba osoba){
        Magazyn.put(pomieszczenie, osoba);
    }

    public Map<Pomieszczenie, Osoba> getMagazyn() {
        return Magazyn;
    }


}
