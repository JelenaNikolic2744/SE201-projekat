/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeneri;

import Grafika.FormaZaUnos;
import Grafika.Meni;

import Grafika.NaplataForm;
import Grafika.Pozornice;
import Grafika.Sala;
import Grafika.Scena;
import Klase.Funkcije;
import Klase.FunkcijeUnos;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Lisener1
{

    private EventHandler<MouseEvent> zaSto1;

    private EventHandler<ActionEvent> postaviFormuZaUnosPica1;
    private EventHandler<ActionEvent> postaviFormuZaUnosPica2;
    private EventHandler<ActionEvent> postaviFormuZaUnosPica3;
    private EventHandler<ActionEvent> postaviFormuZaUnosPica4;
    private EventHandler<ActionEvent> zaUnosPiva;
    private EventHandler<ActionEvent> unesiSokove;
    private EventHandler<ActionEvent> unesiZestinu;
    private EventHandler<ActionEvent> unesiNapitke;
    private static Lisener1 instanca = null;

    private Lisener1()
    {
    }

    public static Lisener1 getInstanca()
    {
        if (instanca == null)
        {
            instanca = new Lisener1();
            return instanca;

        } else
        {
            return instanca;
        }
    }

    public EventHandler<ActionEvent> getPostaviFormuZaUnosPica1()
    {

        postaviFormuZaUnosPica1 = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Funkcije.postavkaFormeZaUnosPiva();

            }
        };

        return postaviFormuZaUnosPica1;
    }

    public EventHandler<ActionEvent> getZaUnosPiva()
    {
        zaUnosPiva = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {

                FunkcijeUnos.unesiPivo();
                Meni.refrashObrisi();
                //  FormaZaUnos.getUnesi().disableProperty().bind(FormaZaUnos.getBind());

            }
        };

        return zaUnosPiva;
    }

    public EventHandler<ActionEvent> getUnesiSokove()
    {
        unesiSokove = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {

                FunkcijeUnos.unesiSok();

                Meni.refrashObrisi();
            }
        };

        return unesiSokove;
    }

    public EventHandler<ActionEvent> getUnesiZestinu()
    {
        unesiZestinu = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                FunkcijeUnos.unesiZestinu();
                Meni.refrashObrisi();
            }
        };

        return unesiZestinu;
    }

    public EventHandler<ActionEvent> getUnesiNapitke()
    {

        unesiNapitke = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                FunkcijeUnos.unesiNapitke();
                Meni.refrashObrisi();
            }
        };

        return unesiNapitke;
    }

    public EventHandler<ActionEvent> getPostaviFormuZaUnosPicaSokova()
    {
        postaviFormuZaUnosPica2 = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Funkcije.postavkaFormeZaUnosSokova();
            }
        };

        return postaviFormuZaUnosPica2;
    }

    public EventHandler<ActionEvent> getPostaviFormuZaUnosPicaNapitaka()
    {
        postaviFormuZaUnosPica3 = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Funkcije.postavkaFormeZaUnosNapitaka();
            }
        };

        return postaviFormuZaUnosPica3;
    }

    public EventHandler<ActionEvent> getPostaviFormuZaUnosPicaZestina()
    {
        postaviFormuZaUnosPica4 = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Funkcije.postavkaFormeZaUnosZestine();
            }
        };

        return postaviFormuZaUnosPica4;
    }

}
