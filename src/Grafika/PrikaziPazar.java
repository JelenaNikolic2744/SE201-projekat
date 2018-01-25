/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafika;

import Entiteti.Artikal;
import Entiteti.Pazar;
import Klase.Liste;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;

public class PrikaziPazar extends StackPane
{
    private ListView<Pazar> listView;
    private ObservableList<Pazar> items;

    public PrikaziPazar()
    {
        super();
        listView = new ListView<>();
        items = FXCollections.observableArrayList(Liste.getInstanca().getPazar());
        listView.setItems(items);
        this.getChildren().add(listView);
    }
    
    
}
