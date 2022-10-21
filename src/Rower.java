public class Rower extends Pojazd{

    private int iloscPrzerzutek;
    private int zajetaPowierzchnia;
    private String marka;
    private String numerSeryjny;

    RodzajRoweru rodzajRoweru;


    public Rower(String marka,String numerSeryjny, int wysokosc, int szerokosc, int dlugosc, RodzajRoweru stanRoweru) {
        super(marka, numerSeryjny,wysokosc, szerokosc, dlugosc);

    this.iloscPrzerzutek= iloscPrzerzutek;
    this.rodzajRoweru=stanRoweru;
    this.zajetaPowierzchnia=dlugosc*szerokosc*wysokosc;
    this.marka=marka;
    this.numerSeryjny = numerSeryjny;

    }
    public void setPowierzchnia(){
        int powierzchnia=0;

        if(rodzajRoweru==rodzajRoweru.Stały){

            powierzchnia =(this.getSzerokosc()*this.getDlugosc()*this.getWysokosc());

            System.out.println("Powierzchnia roweru: "+powierzchnia+" o nazwie: "+ getMarka());

        }else if(rodzajRoweru==rodzajRoweru.Skladany){

            powierzchnia= this.getSzerokosc()*this.getDlugosc()*this.getWysokosc()/2;

            System.out.println("Powierzchnia roweru: "+powierzchnia+" o nazwie: "+ getMarka());
        }
    }
    public int getWolnaPowierzchnia() {
        return zajetaPowierzchnia;
    }

    @Override
    public String toString() {
        return "Rower{" +
                "iloscPrzerzutek=" + iloscPrzerzutek +
                ", zajetaPowierzchnia=" + zajetaPowierzchnia +
                ", marka='" + marka + '\'' +
                ", numerSeryjny='" + numerSeryjny + '\'' +
                ", rodzajRoweru=" + rodzajRoweru +
                '}';
    }
}
