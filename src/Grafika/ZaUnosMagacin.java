/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafika;

import Entiteti.Magacin;
import Klase.Liste;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class ZaUnosMagacin extends GridPane
{
    private static TextField neki;
    private static Button s;
   public ZaUnosMagacin(String string)
    {
        super();
        neki = new TextField();
        s = new Button("Unesi");
        this.add(neki , 0  , 0);
        this.add(s,0,1);
        Magacin stari;
       s.setOnAction((ActionEvent event) ->
        {
           for(Magacin m:Liste.getInstanca().getMagacin())
               
               {
                   if (m.getNaziv() == string)
                   {
                       
                       m.setKolicina(m.getKolicina()+Integer.parseInt(neki.getText().trim()));
                       Krud.Krud.getInstanca().update(m);
                   }
               
               }
        });
        
        
    }
   
}
