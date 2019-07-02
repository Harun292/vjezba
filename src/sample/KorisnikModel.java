package sample;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisnikModel {
    public ObservableList<Korisnik> korisnici= FXCollections.observableArrayList();
    public SimpleObjectProperty<Korisnik> trenutni=new SimpleObjectProperty<>();

    public KorisnikModel() {
    }

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getTrenutni() {
        return trenutni.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniProperty() {
        return trenutni;
    }

    public void setTrenutni(Korisnik trenutni) {
        this.trenutni.set(trenutni);
    }
    public void unesi()
    {
        korisnici.add(new Korisnik("Harun","Ajkunic","06299666","35-ST"));
        korisnici.add(new Korisnik("Asmir","Tataraga","062123322","21312312"));
        korisnici.add(new Korisnik("Ahmed","Huber","06299666","32131231"));
        korisnici.add(new Korisnik("Ammar","Pipic","062456789","3232323"));

    }
    public void obrisi()
    {
        int index=korisnici.indexOf(trenutni.get());
        korisnici.remove(index);
        if(korisnici.size()!=0)
        {
            trenutni.set(korisnici.get(0));
        }
        else
            trenutni.set(null);
    }
    public void dodaj(Korisnik a)
    {
        korisnici.add(a);
        trenutni.set(korisnici.get(korisnici.size()-1));
    }

}
