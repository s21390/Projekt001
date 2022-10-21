import java.io.IOException;

public class Main {
    public static void main(String[] args) throws TooManyThingsException, InterruptedException, IOException {


        Osoba osoba1 = new Osoba("Dominik","Stypułkowski","ul.Głębocka 5e","13654724864","24.09.1997","22.03.2020");
        Osoba osoba2 = new Osoba ("Aleksandra","Hermanowska","Szosa 13","1451537586","20.10.1997","20.05.2020");
        Osoba osoba3 = new Osoba("Kamil","Sulewski","Prusa 12","9783654243","11.09.1995",null);
        Osoba osoba4 = new Osoba("Szymon","Stadnicki","Chełmianka 666","7315635468","12.09.1997","15.1.2018");
        Osoba osoba5 = new Osoba("Jakub","Kołakowski","Leśna 6","5725658471736","09.02.1999",null);
        Aplikacja aplikacja = new Aplikacja();

        Pomieszczenie p1 = new Pomieszczenie(8,5,6,StatusPomieszczenia.Zajety ,StanPomieszczenia.Wyremontowany);
        Pomieszczenie p2 = new Pomieszczenie(3,3,5, StatusPomieszczenia.Zajety, StanPomieszczenia.Wyremontowany);
        Pomieszczenie p3 = new Pomieszczenie(8,4,5, StatusPomieszczenia.Wolny, StanPomieszczenia.Wyremontowany);
        Pomieszczenie p4 = new Pomieszczenie(1,4,5, StatusPomieszczenia.Zajety, StanPomieszczenia.Wyremontowany);
        Pomieszczenie p5 = new Pomieszczenie(4,4,5, StatusPomieszczenia.Wolny, StanPomieszczenia.Wyremontowany);
        Pomieszczenie p6 = new Pomieszczenie(7,2,5, StatusPomieszczenia.Wolny, StanPomieszczenia.Wyremontowany);
        Pomieszczenie p7 = new Pomieszczenie(9,2,5, StatusPomieszczenia.Wolny, StanPomieszczenia.Wyremontowany);
        Pomieszczenie p8 = new Pomieszczenie(3,3,5, StatusPomieszczenia.Wolny, StanPomieszczenia.Wyremontowany);
        Pomieszczenie p9 = new Pomieszczenie(5,5,5, StatusPomieszczenia.Wolny, StanPomieszczenia.Wyremontowany);
        Pomieszczenie p10 = new Pomieszczenie(15,6,5, StatusPomieszczenia.Wolny, StanPomieszczenia.Wyremontowany);


        for(Pojazd pojazd: p1.getListaPojazdow()){
            System.out.println(pojazd);
        }
        aplikacja.addOsobe(osoba1);
        aplikacja.addOsobe(osoba2);
        aplikacja.getMagazyn().dodajDoPomieszczenie(p1,osoba1);
        aplikacja.getMagazyn().dodajDoPomieszczenie(p2,osoba2);
        aplikacja.getMagazyn().dodajDoPomieszczenie(p4,osoba2);
        aplikacja.getMagazyn().dodajDoPomieszczenie(p3);
        aplikacja.getMagazyn().dodajDoPomieszczenie(p5);
        aplikacja.getMagazyn().dodajDoPomieszczenie(p6);
        aplikacja.getMagazyn().dodajDoPomieszczenie(p7);
        aplikacja.getMagazyn().dodajDoPomieszczenie(p8);
        aplikacja.getMagazyn().dodajDoPomieszczenie(p9);
        aplikacja.getMagazyn().dodajDoPomieszczenie(p10);
        aplikacja.poczatek();

    }
}
