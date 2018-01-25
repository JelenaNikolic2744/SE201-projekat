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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class Fiskalizacija extends GridPane
{

    private static TextField text1;

    private static Button naplati;
    private static Label kusur;
    private static Label cenaZaNaplatu;
    private static int cena = 0;
    // private static Pazar  pazar;

    public Fiskalizacija(Sto s)
    {
        super();
        int cena = 0;
        this.setAlignment(Pos.CENTER);
        text1 = new TextField();

        naplati = new Button("Napltai");
        kusur = new Label();
        cenaZaNaplatu = new Label();

        for (Artikal a : s.getListArtikala())
        {
            cena += a.getCena();
        }
        cenaZaNaplatu.setText("" + cena);

        this.add(cenaZaNaplatu, 0, 0);
        this.add(text1, 0, 1);
        this.add(kusur, 0, 2);
        this.add(naplati, 0, 3);

        naplati.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {

                int kusur1 = 0;
                int n = Integer.parseInt(text1.getText());
                int p = 0;
                for (Artikal a : s.getListArtikala())
                {
                    p += a.getCena();
                }
                kusur1 = n - p;
                kusur.setText("Kudur :" + kusur1);
                for (Artikal a : s.getListArtikala())
                {

                    for (Magacin m : Liste.getInstanca().getMagacin())
                    {

                        if (m.getNaziv().equals(a.getNaziv()) && m.getIdPica() == a.getTip())
                        {
                            System.out.println("Usao u if za skidanje iz baze");

                            m.setKolicina(m.getKolicina() - a.getBrKomada());
                            Krud.Krud.getInstanca().update(m);

                        }
                    }

                }

                for (Artikal a : s.getListArtikala())

                {

                    Pazar o = new Pazar(a);
                    if (!Liste.getInstanca().getPazar().equals(o))
                    {
                        Krud.Krud.getInstanca().update(o);
                        Liste.getInstanca().getPazar().add(o);
                    } else
                    {
                        for (Pazar e : Liste.getInstanca().getPazar())

                        {
                            System.out.println("for pazar");
                            if (e.getNaziv().equals(a.getNaziv()) && e.getIdPica() == a.getTip())
                            {
                                System.out.println("usao u if za upis u pazar");
                                e.setUkupnaCena(e.getUkupnaCena() + a.getCena());
                                e.setProdatoKomada(e.getProdatoKomada() + a.getBrKomada());
                                Krud.Krud.getInstanca().update(e);
                            }

                        }
                    }
                }

                s.getListArtikala().clear();

            }
        });
    }

}
