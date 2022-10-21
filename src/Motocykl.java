public class Motocykl extends Pojazd {
    Homologacja homologacja;
    private int zajetaPowierzchnia;
    private String numerSeryjny;
    private String marka;

    public Motocykl(String marka, String numerSeryjny,int wysokosc, int szerokosc, int dlugosc, Homologacja homologacja) {
        super(marka, numerSeryjny,wysokosc, szerokosc, dlugosc);
        this.homologacja=homologacja;
        this.zajetaPowierzchnia=dlugosc*szerokosc*wysokosc;
        this.numerSeryjny=numerSeryjny;
       this.marka=marka;
    }


    @Override
    public String toString() {
        return "Motocykl{" +
                "homologacja=" + homologacja +
                ", zajetaPowierzchnia=" + zajetaPowierzchnia +
                ", numerSeryjny='" + numerSeryjny + '\'' +
                ", marka='" + marka + '\'' +
                '}';
    }

    public void setPowierzchnia(){
        double powierzchnia =0;
        powierzchnia=this.getDlugosc()*this.getSzerokosc()*this.getWysokosc();
        System.out.println("Motocykl marki: "+this.getMarka()+ "O numerze seryjnym" + this.getNumerSeryjny() + " zajmuje powierzchnie: "+powierzchnia);
    }
    public int getWolnaPowierzchnia() {
        return zajetaPowierzchnia;
    }
}
