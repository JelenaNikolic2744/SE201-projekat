/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafika;

import Entiteti.Artikal;
import Entiteti.Magacin;
import Klase.Funkcije;
import Klase.Liste;
import Listeneri.Lisener1;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;


public class Meni extends HBox
{

    private static MenuBar menu;
    private static Menu dodaj;
    private static MenuItem pivo;
    private static MenuItem zestina;
    private static MenuItem sokovi;
    private static MenuItem topliNapitci;

    private static Menu pivoO;
    private static Menu zestinaO;
    private static Menu sokoviO;
    private static Menu topliNapitciO;
    private static Menu pivoM;
    private static Menu zestinaM;
    private static Menu sokoviM;
    private static Menu topliNapitciM;

    private static Menu dodajUmagacin;
    private static Menu prikaziPazar;
    private static MenuItem prikaziPazarItem;
    private static Menu prikaziMagacin;
    private static MenuItem prikaziMagacinItem;
    private static Menu obrisi;

    public Meni()
    {
        super();
        menu = new MenuBar();
        dodaj = new Menu("Dodaj u Meni");
        pivo = new MenuItem("Pivo");
        zestina = new MenuItem("Zestina");
        sokovi = new MenuItem("Sokovi");
        topliNapitci = new MenuItem("Topli Napitci");
        prikaziMagacinItem = new MenuItem("Prikazi magain");
        prikaziPazarItem = new MenuItem("Prikazi pazar");

        pivo.setOnAction(Lisener1.getInstanca().getPostaviFormuZaUnosPica1());
        zestina.setOnAction(Lisener1.getInstanca().getPostaviFormuZaUnosPicaZestina());
        sokovi.setOnAction(Lisener1.getInstanca().getPostaviFormuZaUnosPicaSokova());
        topliNapitci.setOnAction(Lisener1.getInstanca().getPostaviFormuZaUnosPicaNapitaka());

        menu.getMenus().add(dodaj);
        dodaj.getItems().addAll(pivo, zestina, sokovi, topliNapitci);

        obrisi = new Menu("Obrisi iz menia");
        pivoO = new Menu("Pivo");
        zestinaO = new Menu("Zestinu");
        sokoviO = new Menu("Sokove");
        topliNapitciO = new Menu("Tople napitke");

        obrisi.getItems().addAll(pivoO, zestinaO, sokoviO, topliNapitciO);
        pivoM = new Menu("Pivo");
        zestinaM = new Menu("Zestinu");
        sokoviM = new Menu("Sokove");
        topliNapitciM = new Menu("Tople napitke");

       

        for (MenuItem m : pivoM.getItems())
        {
            m.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    Pozornice.getInstana().getStage2().setScene(new Scene(new ZaUnosMagacin(m.getText()), 200, 100));
                    Pozornice.getInstana().getStage2().show();
                    System.out.println(m.getText());
                }
            });

        }
        for (MenuItem m : sokoviM.getItems())
        {
            m.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    Pozornice.getInstana().getStage2().setScene(new Scene(new ZaUnosMagacin(m.getText()), 200, 100));
                    Pozornice.getInstana().getStage2().show();
                    System.out.println(m.getText());
                }
            });
        }
        for (MenuItem m : topliNapitciM.getItems())
        {
            m.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    Pozornice.getInstana().getStage2().setScene(new Scene(new ZaUnosMagacin(m.getText()), 200, 100));
                    Pozornice.getInstana().getStage2().show();
                    System.out.println(m.getText());
                }
            });
        }
        for (MenuItem m : zestinaM.getItems())
        {
            m.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    Pozornice.getInstana().getStage2().setScene(new Scene(new ZaUnosMagacin(m.getText()), 200, 100));
                    Pozornice.getInstana().getStage2().show();
                    System.out.println(m.getText());
                }
            });
        }

        refrashObrisi();

        for (MenuItem i : pivoO.getItems())
        {

            i.setOnAction((ActionEvent event)
                    -> 
                    {

                        Funkcije.obrisi(i.getText());

            });

        }
        for (MenuItem i : zestinaO.getItems())
        {

            i.setOnAction((ActionEvent event)
                    -> 
                    {

                        Funkcije.obrisi(i.getText());

            });

        }
        for (MenuItem i : sokoviO.getItems())
        {

            i.setOnAction((ActionEvent event)
                    -> 
                    {

                        Funkcije.obrisi(i.getText());

            });

        }
        for (MenuItem i : topliNapitciO.getItems())
        {

            i.setOnAction((ActionEvent event)
                    -> 
                    {

                        Funkcije.obrisi(i.getText());

            });

        }

        dodajUmagacin = new Menu("Dodaj u magacin");
        dodajUmagacin.getItems().addAll(pivoM, zestinaM, sokoviM, topliNapitciM);
        prikaziPazar = new Menu("Prikazi pazar");
        prikaziMagacin = new Menu("Prikazi magacin");
        menu.getMenus().addAll(dodajUmagacin, prikaziPazar, prikaziMagacin, obrisi);
        prikaziMagacin.getItems().add(prikaziMagacinItem);
        prikaziPazar.getItems().add(prikaziPazarItem);
        prikaziPazarItem.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Pozornice.getInstana().getStage2().setScene(new Scene(new PrikaziPazar()));
                Pozornice.getInstana().getStage2().show();
            }
        });

        this.getChildren().addAll(menu);

        prikaziMagacinItem.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Pozornice.getInstana().getStage2().setScene(new Scene(new PrikazMagacina()));
                Pozornice.getInstana().getStage2().show();
            }
        });

    }

    public static void refrashObrisi()
    {        
        pivoO.getItems().clear();
        zestinaO.getItems().clear();
        sokoviO.getItems().clear();
        topliNapitciO.getItems().clear();
        
        pivoM.getItems().clear();
        zestinaM.getItems().clear();
        sokoviM.getItems().clear();
        topliNapitciM.getItems().clear();
        
        for (Artikal m : Liste.getInstanca().getListSvihProizvoda())
        {
            if (m.getTip() == 1)
            {
                pivoO.getItems().add(new MenuItem(m.getNaziv()));
                pivoM.getItems().add(new MenuItem(m.getNaziv()));

            }
            if (m.getTip() == 2)
            {
                sokoviO.getItems().add(new MenuItem(m.getNaziv()));
                sokoviM.getItems().add(new MenuItem(m.getNaziv()));

            }
            if (m.getTip() == 3)
            {
                topliNapitciO.getItems().add(new MenuItem(m.getNaziv()));
                topliNapitciM.getItems().add(new MenuItem(m.getNaziv()));

            }
            if (m.getTip() == 4)
            {
                zestinaO.getItems().add(new MenuItem(m.getNaziv()));
                zestinaM.getItems().add(new MenuItem(m.getNaziv()));

            }
            
        }
    }
    
    public static MenuBar getMenu()
    {
        return menu;
    }

    public static Menu getDodaj()
    {
        return dodaj;
    }

    public static MenuItem getPivo()
    {
        return pivo;
    }

    public static MenuItem getZestina()
    {
        return zestina;
    }

    public static MenuItem getSokovi()
    {
        return sokovi;
    }

    public static MenuItem getTopliNapitci()
    {
        return topliNapitci;
    }

    public static MenuItem getPivoO()
    {
        return pivoO;
    }

    public static MenuItem getZestinaO()
    {
        return zestinaO;
    }

    public static MenuItem getSokoviO()
    {
        return sokoviO;
    }

    public static MenuItem getTopliNapitciO()
    {
        return topliNapitciO;
    }

    public static Menu getDodajUmagacin()
    {
        return dodajUmagacin;
    }

    public static Menu getPrikaziPazar()
    {
        return prikaziPazar;
    }

    public static Menu getPrikaziMagacin()
    {
        return prikaziMagacin;
    }

    public static Menu getObrisi()
    {
        return obrisi;
    }

}
