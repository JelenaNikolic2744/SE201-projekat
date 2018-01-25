/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafika;

import Entiteti.Artikal;
import Entiteti.Magacin;
import Entiteti.Pazar;
import Klase.Liste;
import java.util.concurrent.CountDownLatch;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class PrikazMagacina extends StackPane
{

    private ListView<Magacin> listView;
    private ObservableList<Magacin> items;

    public PrikazMagacina()
    {
        super();
        listView = new ListView<>();
        items = FXCollections.observableArrayList(Liste.getInstanca().getMagacin());
        listView.setItems(items);
        this.getChildren().add(listView);
    }
    
    
}
