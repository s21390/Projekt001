public class Pojazd implements Comparable<Pojazd>
{
    private String marka;
    private int wysokosc;
    private int dlugosc;
    private int szerokosc;
    private int zajetaPowierzchnia;
    private String numerSeryjny;


    public Pojazd(String marka,String numerSeryjny, int wysokosc, int szerokosc, int dlugosc) {
        this.marka = marka;
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
        this.dlugosc = dlugosc;
        this.zajetaPowierzchnia = wysokosc*szerokosc*dlugosc;
        this.numerSeryjny= numerSeryjny;
    }

    public String getMarka() {

        return marka;
    }


    public int getWysokosc() {

        return  wysokosc;
    }


    public int getSzerokosc() {

        return  szerokosc;
    }


    public int getDlugosc() {

        return  dlugosc;
    }



    public int getZajetaPowierzchnia() {
        return zajetaPowierzchnia;
    }



    public String getNumerSeryjny(){
        return numerSeryjny;
    }


    @Override
    public int compareTo(Pojazd pojazd) {

        if(zajetaPowierzchnia == pojazd.zajetaPowierzchnia){
            return marka.compareToIgnoreCase(pojazd.marka);

        }
        else if(zajetaPowierzchnia > pojazd.zajetaPowierzchnia) {
            return -1;

        }else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Pojazd{" +
                "marka='" + marka + '\'' +
                ", Zajęta Powierzchnia=" + zajetaPowierzchnia +
                ", numerSeryjny='" + numerSeryjny + '\'' +
                '}';
    }
}
