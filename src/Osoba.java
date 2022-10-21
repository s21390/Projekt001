public class Osoba {
    private String imie, nazwisko, adres_zamieszkania, pesel, data_urodzenia, data_pierwszego_wynajmu;
    Pomieszczenie pomieszczenie;

    public Osoba(String imie, String nazwisko, String adres_zamieszkania, String pesel, String data_urodzenia, String data_pierwszego_wynajmu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres_zamieszkania = adres_zamieszkania;
        this.pesel = pesel;
        this.data_urodzenia = data_urodzenia;
        this.data_pierwszego_wynajmu = data_pierwszego_wynajmu;
    }
    public String getDane(){

        return imie+" "+nazwisko;
    }
    public void getDataPierwszegoWynajmu()throws NeverRentException{
    if(this.data_pierwszego_wynajmu==null){
        throw new NeverRentException();
    }
    }

    public String getNazwisko() {
        return nazwisko;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", adres_zamieszkania='" + adres_zamieszkania + '\'' +
                ", pesel=" + pesel +
                ", data_urodzenia=" + data_urodzenia +
                '}';
    }
    public String getImie(){
        return imie;
    }

}
