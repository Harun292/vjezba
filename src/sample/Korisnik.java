package sample;

import javafx.beans.property.SimpleStringProperty;

public class Korisnik {
    private SimpleStringProperty ime=new SimpleStringProperty("");
    private SimpleStringProperty prezime=new SimpleStringProperty("");
    private SimpleStringProperty br_tel=new SimpleStringProperty("");
    private SimpleStringProperty index=new SimpleStringProperty("");

    public Korisnik() {
    }

    public Korisnik(String ime, String  prezime, String br_tel, String index) {
        this.ime = new SimpleStringProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.br_tel = new SimpleStringProperty(br_tel);
        this.index = new SimpleStringProperty(index);
    }

    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public String getBr_tel() {
        return br_tel.get();
    }

    public SimpleStringProperty br_telProperty() {
        return br_tel;
    }

    public void setBr_tel(String br_tel) {
        this.br_tel.set(br_tel);
    }

    public String getIndex() {
        return index.get();
    }

    public SimpleStringProperty indexProperty() {
        return index;
    }

    public void setIndex(String index) {
        this.index.set(index);
    }

    @Override
    public String toString() {
        return prezime.get()+" "+ime.get();
    }
}
