package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class KorisnikController implements Initializable {
    public TableView<Korisnik> tabelak;
    public TableColumn<Korisnik,String> kolona;
    private KorisnikModel model;
    public TextField imefld;
    public TextField prezimefld;
    public TextField telfld;
    public TextField indexfld;
    public KorisnikController(KorisnikModel model) {
        this.model = model;
    }

    public void dodajact(ActionEvent actionEvent) {
        model.dodaj(new Korisnik());
        tabelak.getSelectionModel().selectLast();
        model.setTrenutni(model.getKorisnici().get(model.getKorisnici().size()-1));
    }

    public void izbrisiact(ActionEvent actionEvent) {
        model.obrisi();
    }
    @Override
    public void initialize(URL location, ResourceBundle resourceBundle)
    {



        tabelak.setItems(model.getKorisnici());

        model.setTrenutni(model.getKorisnici().get(0));
        imefld.textProperty().bindBidirectional(model.getTrenutni().imeProperty());
        prezimefld.textProperty().bindBidirectional(model.getTrenutni().prezimeProperty());
        telfld.textProperty().bindBidirectional(model.getTrenutni().br_telProperty());
        indexfld.textProperty().bindBidirectional(model.getTrenutni().indexProperty());
        kolona.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().getIme().concat(" ").concat(data.getValue().getPrezime())));
        tabelak.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Korisnik>() {
            @Override
            public void changed(ObservableValue<?extends Korisnik> observableValue, Korisnik stari, Korisnik novi) {
                model.setTrenutni(novi);
                tabelak.refresh();
            }
        });
        model.trenutniProperty().addListener(new ChangeListener<Korisnik>() {
            @Override
            public void changed(ObservableValue<? extends Korisnik> observableValue, Korisnik stari, Korisnik novi) {
                if(stari!=null)
                {
                    imefld.textProperty().unbindBidirectional(stari.imeProperty());
                    prezimefld.textProperty().unbindBidirectional(stari.prezimeProperty());
                    telfld.textProperty().unbindBidirectional(stari.br_telProperty());
                    indexfld.textProperty().unbindBidirectional(stari.indexProperty());
                }
                if(novi==null)
                {
                    imefld.setText("");
                    prezimefld.setText("");
                    telfld.setText("");
                    indexfld.setText("");
                }
                else {
                    imefld.textProperty().bindBidirectional(novi.imeProperty());
                    prezimefld.textProperty().bindBidirectional(novi.prezimeProperty());
                    telfld.textProperty().bindBidirectional(novi.br_telProperty());
                    indexfld.textProperty().bindBidirectional(novi.indexProperty());
                    tabelak.refresh();
                }
            }
        });
    }
}
