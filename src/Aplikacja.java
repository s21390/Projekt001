import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Aplikacja {
    private List<Osoba> listaOsob = new ArrayList<>();
    private String x;
    Scanner scan = new Scanner(System.in);
    String id;
    private int actualValue;
    String exit = "exit";


    private Magazyn magazyn = new Magazyn();

    public Aplikacja() {
    }

    public Magazyn getMagazyn() {
        return magazyn;
    }

    public void addOsobe(Osoba osoba) {
        listaOsob.add(osoba);
    }

    public void poczatek() throws TooManyThingsException, InterruptedException {
        System.out.println();
        System.out.println("Witaj w magazynie.");
        System.out.println("Drogi kliencie, wybierz swoje konto");
        System.out.println();
        for (Osoba o : listaOsob) {
            System.out.println(o.getDane());
        }
        System.out.println();
        System.out.println("Podaj swoje imię lub jeżeli chcesz wyjśc wpisz (exit)");
        System.out.println();
        x = scan.nextLine();
        actualValue = exit.compareTo(x);
        if (actualValue == 0) {
            System.exit(0);
        } else {
            osoba();
        }
    }

    public void osoba() throws TooManyThingsException, InterruptedException {
        boolean istnieje = false;
        String exit = "exit";
        for (Osoba o : listaOsob) {
            if (x.compareTo(o.getImie()) == 0) {
                System.out.println();
                System.out.println("Witaj " + o.getImie() + "!!!");
                menu(o);

            }

        }
        actualValue = exit.compareTo(x);
        if (actualValue == 0){
            System.exit(0);
        }
    }

    public void menu(Osoba o) throws TooManyThingsException, InterruptedException {
        String dane = "dane";
        String zawartosc = "zawartosc";
        String wolne = "wolne";
        String zapis = "zapis";
        String rezerwuj = "rezerwuj";
        System.out.println();
        System.out.println("Witamy w menu, wybierz jedną z opcji: " + "\n");
        System.out.println("Sprawdz swoje informacje.(Wpisz: dane) ");
        System.out.println("Wyświetl zawartość moich pomieszczeń lub dodaj nowy przedmiot.(Wpisz: zawartosc) ");
        System.out.println("Wyświetl wolne pomieszczenia w magazynie lub je zarezerwuj.(Wpisz: wolne) ");
        System.out.println("Zapisz zawartość magazynu.(Wpisz: zapis) ");
        System.out.println("Jeśli chcesz wyjść wpisz exit.(Wpisz: exit) ");
        x = scan.nextLine();
        actualValue = exit.compareTo(x);
        if (actualValue == 0) {
            System.exit(0);
        }
        actualValue = dane.compareTo(x);
        if (actualValue == 0) {
            System.out.println(o.toString());
            System.out.println();
            System.out.println(o.getImie()+ " wynajmuje :");
for (Pomieszczenie pomieszczenie : magazyn.getMagazyn().keySet()){
    if (magazyn.getMagazyn().get(pomieszczenie)==o){
        System.out.println(pomieszczenie);
    }
}
            menu(o);
        }

        actualValue = zawartosc.compareTo(x);
        if (actualValue == 0) {
            zawartoscPomieszczenie(o);

            menu(o);
        }
        actualValue = wolne.compareTo(x);
        if (actualValue == 0) {
            String menu = "menu";


            for (Pomieszczenie p : magazyn.getMagazyn().keySet()) {
                if (p.getStatus() == p.getStatus().Wolny) {
                    System.out.println(p + " Jeżeli chcesz zarezerwować wpisz " + p.getId() + "\n");
                }


            }
            System.out.println("Jeżeli chcesz wrócić do menu (Wpisz menu)");
            x = scan.next();
            actualValue = menu.compareTo(x);
            if (actualValue == 0) {
                System.out.println();
                menu(o);

            } else if (Integer.parseInt(x) > 0 && Integer.parseInt(x) <= magazyn.getMagazyn().size()) {
                for (Pomieszczenie p : magazyn.getMagazyn().keySet()) {
                    if (Integer.parseInt(x) == p.getId()) {
                        magazyn.dodajDoPomieszczenie(p, o);
                        System.out.println("Zarezewowano!!!");
                    }
                }
                System.out.println("Wróć do menu (wpisz menu)");
                x = scan.nextLine();
                actualValue = menu.compareTo(x);
                if (actualValue == 0) {
                    System.out.println();
                    menu(o);
                }


            }

            x = scan.nextLine();
            actualValue = menu.compareTo(x);
            if (actualValue == 0) {
                System.out.println();
                menu(o);
            }
        }





        actualValue = zapis.compareTo(x);
        if (actualValue == 0) {
            try {
                zapisDoPliku();
            } catch (IOException e) {
                e.printStackTrace();
            }
            menu(o);
        }

    }

    public void zawartoscPomieszczenie(Osoba o) throws TooManyThingsException, InterruptedException {
        boolean posiada = false;
        for (Pomieszczenie pomieszczenie : magazyn.getMagazyn().keySet()) {
            if (magazyn.getMagazyn().get(pomieszczenie) == o) {
                System.out.println(pomieszczenie);
                posiada = true;
            }
        }
        if (posiada == false) {

            System.out.println("Brak pomieszczen.");
            System.out.println();

            menu(o);
        }
        String y;
        String back = "back";

        System.out.println("Wybierz pomieszczenie.");

        y = scan.nextLine();

        for (Pomieszczenie pomieszczenie : magazyn.getMagazyn().keySet()) {
            if (pomieszczenie.getId() == Integer.parseInt(y)) {
                System.out.println("Wybrałeś pomieszczenie: " + pomieszczenie.getId());
                Collections.sort(pomieszczenie.getListaPojazdow());
                pomieszczenie.zawartosc();

                String dodaj = "dodaj";
                String usun = "usun";

                String exit = "exit";
                System.out.println("Dodaj pojazd(Wpisz dodaj)");
                System.out.println("Usuń pojazd(Wpisz usun)");
                System.out.println("Wyjdz (Wpisz exit)");
                System.out.println("Cofnij do menu (Wpisz back)");
                System.out.println();
                x = scan.nextLine();

                actualValue = dodaj.compareTo(x);

                if (actualValue == 0) {
                    System.out.println();
                    System.out.println("Jaki typ pojazdu chcesz dodać?");
                    System.out.println("Samochod(Wpisz samochod)");
                    System.out.println("Motocykl(Wpisz motor)");
                    System.out.println("Rower(Wpisz rower)");
                    System.out.println("Cofnij do menu (Wpisz back)");
                    System.out.println("Wyjdz (Wpisz exit)");
                    System.out.println();
                    dodajPojazd(o, y);


                }

                actualValue = usun.compareTo(x);

                if (actualValue == 0) {
                    System.out.println();
                    usunPojazd(o, y);

                }

actualValue = exit.compareTo(x);
                if (actualValue == 0){
                    System.exit(0);
                }
                actualValue = back.compareTo(x);
                if (actualValue == 0){
                    menu(o);
                }
            }
        }


    }

    private void dodajPojazd(Osoba o, String y) throws TooManyThingsException, InterruptedException {
        String samochod = "samochod";
        String motor = "motor";
        String rower = "rower";

        x = scan.nextLine();
        actualValue = samochod.compareTo(x);
        if (actualValue == 0) {
            addSamochod(o, y);
        }
        actualValue = motor.compareTo(x);
        if (actualValue == 0) {
            addMotor(o, y);
        }
        actualValue = rower.compareTo(x);
        if (actualValue == 0) {
            addRower(o, y);
        }
    }

    public void addRower(Osoba o, String y) throws TooManyThingsException, InterruptedException {
        String rozlozony = "rozlozony";
        String zlozony = "Zlozony";
        System.out.println("Wpisz informacje o twoim rowerze. ");
        System.out.println("Jakiej jest marki? ");
        String marka = scan.next();
        System.out.println("Podaj numer seryjny:");
        String numerSeryjny = scan.next();
        System.out.println("Ile posiada przerzutek? ");
        int przerzutki = scan.nextInt();
        System.out.println("Jest stały czy rozkładany?(Wpisz 'Staly, Skladany')");
        RodzajRoweru rodzajRoweru = RodzajRoweru.Skladany;
        String stan = scan.next();
        String rec = "exit";
        actualValue = rozlozony.compareTo(stan);
        if (actualValue == 0) {
            rodzajRoweru = RodzajRoweru.Skladany;
        }
        actualValue = zlozony.compareTo(stan);
        if (actualValue == 0) {
            rodzajRoweru = RodzajRoweru.Stały;
        }
        System.out.println("Wysokosc");
        int wysokosc = scan.nextInt();
        System.out.println("Szerokosc");
        int szerokosc = scan.nextInt();
        System.out.println("Dlugosc");
        int dlugosc = scan.nextInt();

        Rower rower = new Rower(marka, numerSeryjny, wysokosc, szerokosc, dlugosc, rodzajRoweru);
        for (Pomieszczenie p : magazyn.getMagazyn().keySet()) {
            if (magazyn.getMagazyn().get(p) == o && p.getId() == Integer.parseInt(y)) {
                if (p.getWolnaPowierzchnia() - rower.getWolnaPowierzchnia() < 0) {
                    throw new TooManyThingsException();
                } else {
                    p.setWolnaPowierzchnia((p.getWolnaPowierzchnia() - rower.getWolnaPowierzchnia()));
                    p.getListaPojazdow().add(rower);
                    System.out.println("Dodano rower marki: " + marka);
                    System.out.println("Teraz powierzchnia wynosi: " + p.getWolnaPowierzchnia());

                }
            }

        }
        x = scan.nextLine();
        actualValue = rec.compareTo(x);
        if (actualValue == 0) {
            menu(o);
        }

    }

    public void addMotor(Osoba o, String y) throws TooManyThingsException, InterruptedException {
        String tak = "tak";
        String nie = "Nie";
        String rec = "exit";
        System.out.println("Wpisz informacje o twoim motocyklu. ");
        System.out.println("Jakiej jest marki?");
        String marka = scan.next();
        System.out.println("Podaj numer seryjny?");
        String numerSeryjny = scan.next();
        System.out.println("Czy posiada homologacje?(Tak, Nie)");
        String homologacja = scan.next();
        actualValue = tak.compareTo(homologacja);
        Homologacja homologa = Homologacja.Nie;
        if (actualValue == 0) {
            homologa = Homologacja.Tak;
        }
        actualValue = nie.compareTo(homologacja);
        if (actualValue == 0) {
            homologa = Homologacja.Nie;
        }
        System.out.println("Wysokosc");
        int wysokosc = scan.nextInt();
        System.out.println("Szerokosc");
        int szerokosc = scan.nextInt();
        System.out.println("Dlugosc");
        int dlugosc = scan.nextInt();

        Motocykl motocykl = new Motocykl(marka, numerSeryjny, wysokosc, szerokosc, dlugosc, homologa);
        for (Pomieszczenie p : magazyn.getMagazyn().keySet()) {
            if (magazyn.getMagazyn().get(p) == o && p.getId() == Integer.parseInt(y)) {
                if (p.getWolnaPowierzchnia() - motocykl.getWolnaPowierzchnia() < 0) {
                    throw new TooManyThingsException();
                } else {
                    p.setWolnaPowierzchnia((p.getWolnaPowierzchnia() - motocykl.getWolnaPowierzchnia()));
                    p.getListaPojazdow().add(motocykl);
                    System.out.println("Dodano motocykl marki: " + marka);
                    System.out.println("Teraz powierzchnia wynosi: " + p.getWolnaPowierzchnia());
                }
            }
        }
        x = scan.nextLine();
        actualValue = rec.compareTo(x);
        if (actualValue == 0) {
            menu(o);

        }
    }

    public void addSamochod(Osoba o, String y) throws TooManyThingsException, InterruptedException {
        String diesel = "Diesel";
        String benzyna = "Benzyna";
        String lpg = "LPG";
        String hybryda = "Hybryda";
        String rec = "exit";
        System.out.println("Wpisz informacje o twoim samochodzie.");
        System.out.println("Jakiej jest marki?");
        String marka = scan.nextLine();
        System.out.println("Podaj numer seryjny:");
        String numerSeryjny = scan.next();
        System.out.println("Jaki ma silnik?");
        System.out.println("-Diesel,");
        System.out.println("-Benzyna,");
        System.out.println("-LPG,");
        System.out.println("-Hybryda.");

        String silnik = scan.next();
        RodzajSilnika rodzajSilnika = RodzajSilnika.Diesel;
        actualValue = diesel.compareTo(silnik);
        if (actualValue == 0) {
            rodzajSilnika = RodzajSilnika.Diesel;
        }

        actualValue = benzyna.compareTo(silnik);
        if (actualValue == 0) {
            rodzajSilnika = RodzajSilnika.Benzyna;
        }
        actualValue = lpg.compareTo(silnik);
        if (actualValue == 0) {
            rodzajSilnika = RodzajSilnika.LPG;
        }
        actualValue = hybryda.compareTo(silnik);
        if (actualValue == 0) {
            rodzajSilnika = RodzajSilnika.Hybryda;
        }
        System.out.println("Wysokosc");
        int wysokosc = scan.nextInt();
        System.out.println("Szerokosc");
        int szerokosc = scan.nextInt();
        System.out.println("Dlugosc");
        int dlugosc = scan.nextInt();

        Samochod samochod = new Samochod(marka, numerSeryjny, wysokosc, szerokosc, dlugosc, rodzajSilnika);
        for (Pomieszczenie p : magazyn.getMagazyn().keySet()) {
            if (magazyn.getMagazyn().get(p) == o && p.getId() == Integer.parseInt(y)) {
                if (p.getWolnaPowierzchnia() - samochod.getZajetaPowierzchnia() < 0) {
                    throw new TooManyThingsException();
                } else {
                    p.setWolnaPowierzchnia((p.getWolnaPowierzchnia() - samochod.getZajetaPowierzchnia()));
                    p.getListaPojazdow().add(samochod);
                    System.out.println("Dodano samochod marki: " + marka);
                    System.out.println("Teraz powierzchnia wynosi: " + p.getWolnaPowierzchnia());
                }

            }
        }
        x = scan.nextLine();
        actualValue = rec.compareTo(x);
        if (actualValue == 0) {
            menu(o);
        }

    }

    public void usunPojazd(Osoba o, String y) throws TooManyThingsException, InterruptedException {
        System.out.println("Aby usunąć pojazd, wpisz numer seryjny, lub exit aby cofnąć się do menu:");
        String rec = "exit";
        String z = scan.next();
        for (Pomieszczenie p : magazyn.getMagazyn().keySet()) {
            if (magazyn.getMagazyn().get(p) == o && p.getId() == Integer.parseInt(y)) {
                for (int i = 0; i < p.getListaPojazdow().size(); i++) {
                    Pojazd pojazd = p.getListaPojazdow().get(i);
                    if (z.equals(pojazd.getNumerSeryjny())) {
                        p.getListaPojazdow().remove(pojazd);
                        p.setWolnaPowierzchnia((p.getWolnaPowierzchnia() + pojazd.getZajetaPowierzchnia()));
                        System.out.println("Usunąłeś pojazd o numerze seryjnym " + pojazd.getNumerSeryjny());
                        System.out.println("wolna powierzchnia wynosi " + p.getWolnaPowierzchnia());
                    }
                }
            }
        }
        x = scan.nextLine();
        actualValue = rec.compareTo(x);
        if (actualValue == 0) {
            menu(o);
        }
    }

    void zapisDoPliku() throws IOException {

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("stanMagazynu.txt");
            fileWriter.write("listaPrzedmiotow" + "\n");
            fileWriter.flush();
            for (Pomieszczenie pomieszczenie : magazyn.getMagazyn().keySet()) {
                for (int i = 0; i < pomieszczenie.getListaPojazdow().size(); i++) {
                    fileWriter.write("W pomieszczeniu numer :" +" " + pomieszczenie.getId() + " znajduje się " + pomieszczenie.getListaPojazdow().get(i).toString() + "\n");
                    fileWriter.flush();
                }
            }

            fileWriter.write("Lista osob  : " + "\n");
            fileWriter.flush();
            for (Osoba o : listaOsob){

                    fileWriter.write("Człowiek o imieniu i nazwisku " + o.toString()+ "\n");
                    fileWriter.flush();


            }

            fileWriter.write("Pomieszczenia " + "\n");
            fileWriter.flush();
            for (Pomieszczenie pomieszczenie : magazyn.getMagazyn().keySet()) {
                if (magazyn.getMagazyn().get(pomieszczenie)== null){
                    fileWriter.write(pomieszczenie + " : Nikt nie wynajmuje " + "\n");
                    fileWriter.flush();
                }else {
                    fileWriter.write(pomieszczenie + " wynajmuje : " + magazyn.getMagazyn().get(pomieszczenie).getImie() + " " + magazyn.getMagazyn().get(pomieszczenie).getNazwisko()+ "\n");
                    fileWriter.flush();
                }
            }
        } catch (IOException e) {

        }
    }
    public void wolnePomieszczenia(Osoba o) throws TooManyThingsException, InterruptedException {
        for(Pomieszczenie p:magazyn.getMagazyn().keySet() ){
            if(magazyn.getMagazyn().get(p) !=o){
                if(magazyn.getMagazyn().get(p) ==null){
                    System.out.println(p);
                }
            }
        }
        String rezerwacja="rezerwacja";
        String back="back";
        String menu="menu";

        System.out.println("Jesli chcesz zarezerwowac pomieszczenie wpisz rezerwacja.");
        System.out.println("Jesli chcesz wyjsc wpisz exit.");
        System.out.println("Jestli chcesz wrocic wpisz back");
        x=scan.nextLine();
        actualValue=exit.compareTo(x);
        if(actualValue==0){
            System.exit(0);
        }
        actualValue=back.compareTo(x);
        if(actualValue==0){
            System.out.println();
            menu(o);
        }
        actualValue=rezerwacja.compareTo(x);
        if(actualValue==0){
            System.out.println("Ktore pomieszczenie chcesz zarezerwowac? ");
            int i=0;
            i=scan.nextInt();
            for (Pomieszczenie p: magazyn.getMagazyn().keySet()){
                if(p.getId()==i) {
                    getMagazyn().dodajDoPomieszczenie(p,o);
                }
            }
            System.out.println();
            x=scan.nextLine();
            actualValue=menu.compareTo(x);
            if(actualValue==0) {
                menu(o);
            }
        }



            System.out.println("Jesli chcesz wrocic wpisz menu. ");
            System.out.println("Jesli chcesz wyjsc wpisz exit ");
            x=scan.nextLine();
            actualValue=menu.compareTo(x);
            if(actualValue==0){
                menu(o);
            }
            actualValue=exit.compareTo(x);
            if(actualValue==0){
                System.exit(0);
            }


        }


    }








