public class Samochod extends Pojazd{
    private RodzajSilnika rodzajSilnika;
    private int zajetaPowierzchnia;
    private String numerSeryjny;
    private String marka;

    public Samochod(String marka, String numerSeryjny,int wysokosc, int szerokosc, int dlugosc, RodzajSilnika rodzajSilnika) {
        super(marka, numerSeryjny,wysokosc, szerokosc, dlugosc);

        this.rodzajSilnika=rodzajSilnika;
        this.zajetaPowierzchnia=dlugosc*szerokosc*wysokosc;
        this.numerSeryjny=numerSeryjny;
        this.marka=marka;
    }

    @Override
    public int getZajetaPowierzchnia() {
        return zajetaPowierzchnia;
    }

    public void setPowierzchnia(){

        int powierzchnia=0;

        powierzchnia=this.getDlugosc()*this.getSzerokosc()*this.getWysokosc();

        System.out.println("Samochód marki: "+this.getMarka()+ "O numerze seryjnym" + this.getNumerSeryjny() + " zajmuje powierzchnie: "+powierzchnia);
    }




    @Override
    public String toString() {
        return "Samochod{" +
                "rodzajSilnika=" + rodzajSilnika +
                ", zajetaPowierzchnia=" + zajetaPowierzchnia +
                ", numerSeryjny='" + numerSeryjny + '\'' +
                ", marka='" + marka + '\'' +
                '}';
    }
}