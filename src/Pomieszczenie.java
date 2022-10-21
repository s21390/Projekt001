import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pomieszczenie {
    public int wolnaPowierzchnia;
    private int id;
    private static int idNowePomieszczenie;
    private int dlugosc;
    private int wysokosc;
    private int szerokosc;

    StanPomieszczenia stan;

    StatusPomieszczenia status;

    List<Pojazd> listaPojazdow = new ArrayList<>();

    public List<Pojazd> getListaPojazdow() {

        return listaPojazdow;
    }

    public void dodajPojazd(Pojazd pojazd){

        getListaPojazdow().add(pojazd);
    }


    public int getWolnaPowierzchnia() {

        return wolnaPowierzchnia;
    }

    public int getId() {

        return id;
    }

    public void setWolnaPowierzchnia(int wolnaPowierzchnia) {

        this.wolnaPowierzchnia = wolnaPowierzchnia;
    }

    public Pomieszczenie(int dlugosc, int wysokosc, int szerokosc, StatusPomieszczenia status, StanPomieszczenia stan) {

        idNowePomieszczenie++;
        this.id = idNowePomieszczenie;
        this.dlugosc = dlugosc;
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
        this.stan=stan;
        this.status=status;
        this.wolnaPowierzchnia = dlugosc * szerokosc * wysokosc;
    }

    public void setWolnaPowierzchnia() {

    }


    public void setStatus(StatusPomieszczenia status) {
        this.status = status;
    }

    public int setPowierzchnia() {

        return wolnaPowierzchnia;
    }

    public int addSamochod(Samochod s, Pomieszczenie p) throws TooManyThingsException {
        if (p.wolnaPowierzchnia - s.getZajetaPowierzchnia() <= 0) {

            throw new TooManyThingsException();

        } else {
            p.wolnaPowierzchnia = p.wolnaPowierzchnia - s.getZajetaPowierzchnia();

            System.out.println("Dodano!");
        }
        return 0;
    }

    public int addMotocykl(Motocykl m, Pomieszczenie p) throws TooManyThingsException {
        if (p.wolnaPowierzchnia - m.getWolnaPowierzchnia() <= 0) {
            throw new TooManyThingsException();
        } else {
            p.wolnaPowierzchnia = p.wolnaPowierzchnia - m.getWolnaPowierzchnia();
            System.out.println("Dodano!");
        }
        return 0;
    }

    public int addRower(Rower r, Pomieszczenie p) throws TooManyThingsException {
        if (p.wolnaPowierzchnia - r.getWolnaPowierzchnia() <= 0) {
            throw new TooManyThingsException();
        } else {
            p.wolnaPowierzchnia = p.wolnaPowierzchnia - r.getWolnaPowierzchnia();
            System.out.println("Dodano!");
        }
        return 0;
    }

    public void zawartosc() {
        System.out.println(getWolnaPowierzchnia());
        System.out.println();
        for(Pojazd pojazd:listaPojazdow){

            System.out.println(pojazd);
        }
    }

    public StatusPomieszczenia getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Pomieszczenie{" +
                "numer=" + id +
                '}';
    }
}