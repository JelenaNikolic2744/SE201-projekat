/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Klase;

import Entiteti.Artikal;
import Entiteti.Magacin;
import Entiteti.Pivo;
import Entiteti.Sokovi;
import Entiteti.TopliNapitci;
import Entiteti.Zestina;
import Grafika.FormaZaUnos;
import Grafika.Meni;

import Grafika.NaplataForm;
import Grafika.Pozornice;
import Grafika.Scena;
import Krud.Krud;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import javafx.application.Platform;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.text.Text;


public class Funkcije
{

    public static void postavkaFormeZaUnosPiva()

    {
        FormaZaUnos.setSokoviProvera(false);
        FormaZaUnos.setPivoProvera(true);
        FormaZaUnos.setZestinaProvera(false);
        FormaZaUnos.setTopliNapitciProvera(false);

        Pozornice.getInstana().getStage2().setScene(new Scene(new FormaZaUnos(), 250, 100));
        Pozornice.getInstana().getStage2().show();

    }

    public static void postavkaFormeZaUnosSokova()

    {

        FormaZaUnos.setSokoviProvera(true);
        FormaZaUnos.setPivoProvera(false);
        FormaZaUnos.setZestinaProvera(false);
        FormaZaUnos.setTopliNapitciProvera(false);

        Pozornice.getInstana().getStage2().setScene(new Scene(new FormaZaUnos(), 250, 100));
        Pozornice.getInstana().getStage2().show();

    }

    public static void postavkaFormeZaUnosZestine()

    {

        FormaZaUnos.setSokoviProvera(false);
        FormaZaUnos.setPivoProvera(false);
        FormaZaUnos.setZestinaProvera(true);
        FormaZaUnos.setTopliNapitciProvera(false);

        Pozornice.getInstana().getStage2().setScene(new Scene(new FormaZaUnos(), 250, 100));
        Pozornice.getInstana().getStage2().show();

    }

    public static void postavkaFormeZaUnosNapitaka()

    {

        FormaZaUnos.setSokoviProvera(false);
        FormaZaUnos.setPivoProvera(false);
        FormaZaUnos.setZestinaProvera(false);
        FormaZaUnos.setTopliNapitciProvera(true);

        Pozornice.getInstana().getStage2().setScene(new Scene(new FormaZaUnos(), 250, 100));
        Pozornice.getInstana().getStage2().show();

    }

    public static void obrisi(String s)
    {
        for (Artikal a : Liste.getInstanca().getListSvihProizvoda())
        {
            if (a.getNaziv().equals(s))
            {
                if (a.getTip() == 1)

                {
                    Pivo p = new Pivo(a);
                    Krud.getInstanca().delete(p);
                    Liste.getInstanca().getPiva().remove(p);

                    Service<Void> service = new Service<Void>()
                    {
                        @Override
                        protected Task<Void> createTask()
                        {
                            return new Task<Void>()
                            {
                                @Override
                                protected Void call() throws Exception
                                {
                                    //Background work

                                    Liste.getInstanca().getListSvihProizvoda().remove(a);
                                    for (Magacin m : Liste.getInstanca().getMagacin())
                                    {

                                        if (a.getNaziv().equals(m.getNaziv()) && a.getTip() == m.getIdPica())
                                        {

                                            Krud.getInstanca().delete(m);
                                            Liste.getInstanca().getMagacin().remove(m);

                                        }

                                    }

                                    final CountDownLatch latch = new CountDownLatch(1);
                                    Platform.runLater(()
                                            -> 
                                            {
                                                try
                                                {
                                                    //FX Stuff done here
                                                    Meni.refrashObrisi();

                                                } finally
                                                {
                                                    latch.countDown();
                                                }
                                    });
                                    latch.await();
                                    //Keep with the background work

                                    return null;
                                }
                            };
                        }
                    };
                    service.start();

                }
                if (a.getTip() == 2)

                {
                    Sokovi p = new Sokovi(a);
                    Krud.getInstanca().delete(p);
                    Liste.getInstanca().getSokovi().remove(p);

                    Service<Void> service = new Service<Void>()
                    {
                        @Override
                        protected Task<Void> createTask()
                        {
                            return new Task<Void>()
                            {
                                @Override
                                protected Void call() throws Exception
                                {
                                    //Background work
                                    Liste.getInstanca().getListSvihProizvoda().remove(a);
                                    for (Magacin m : Liste.getInstanca().getMagacin())
                                    {

                                        if (a.getNaziv().equals(m.getNaziv()) && a.getTip() == m.getIdPica())
                                        {

                                            Krud.getInstanca().delete(m);
                                            Liste.getInstanca().getMagacin().remove(m);

                                        }

                                    }

                                    final CountDownLatch latch = new CountDownLatch(1);
                                    Platform.runLater(()
                                            -> 
                                            {
                                                try
                                                {
                                                    //FX Stuff done here
                                                    Meni.refrashObrisi();

                                                } finally
                                                {
                                                    latch.countDown();
                                                }
                                    });
                                    latch.await();
                                    //Keep with the background work

                                    return null;
                                }
                            };
                        }
                    };
                    service.start();
                }
                if (a.getTip() == 3)

                {
                    TopliNapitci p = new TopliNapitci(a);
                    Krud.getInstanca().delete(p);
                    Liste.getInstanca().getNapitci().remove(p);

                    Service<Void> service = new Service<Void>()

                    {
                        @Override
                        protected Task<Void> createTask()
                        {
                            return new Task<Void>()
                            {
                                @Override
                                protected Void call() throws Exception
                                {
                                    //Background work
                                    Liste.getInstanca().getListSvihProizvoda().remove(a);
                                    for (Magacin m : Liste.getInstanca().getMagacin())
                                    {

                                        if (a.getNaziv().equals(m.getNaziv()) && a.getTip() == m.getIdPica())
                                        {

                                            Krud.getInstanca().delete(m);
                                            Liste.getInstanca().getMagacin().remove(m);

                                        }

                                    }

                                    final CountDownLatch latch = new CountDownLatch(1);
                                    Platform.runLater(()
                                            -> 
                                            {
                                                try
                                                {
                                                    //FX Stuff done here
                                                    Meni.refrashObrisi();

                                                } finally
                                                {
                                                    latch.countDown();
                                                }
                                    });
                                    latch.await();
                                    //Keep with the background work

                                    return null;
                                }
                            };
                        }
                    };
                    service.start();
                }
                if (a.getTip() == 4)

                {
                    Zestina p = new Zestina(a);
                    Krud.getInstanca().delete(p);
                    Liste.getInstanca().getNapitci().remove(p);

                    Service<Void> service = new Service<Void>()
                    {
                        @Override
                        protected Task<Void> createTask()
                        {
                            return new Task<Void>()
                            {
                                @Override
                                protected Void call() throws Exception
                                {
                                    //Background work
                                    Liste.getInstanca().getListSvihProizvoda().remove(a);
                                    for (Magacin m : Liste.getInstanca().getMagacin())
                                    {

                                        if (a.getNaziv().equals(m.getNaziv()) && a.getTip() == m.getIdPica())
                                        {

                                            Krud.getInstanca().delete(m);
                                            Liste.getInstanca().getMagacin().remove(m);

                                        }

                                    }

                                    final CountDownLatch latch = new CountDownLatch(1);
                                    Platform.runLater(()
                                            -> 
                                            {
                                                try
                                                {
                                                    //FX Stuff done here
                                                    Meni.refrashObrisi();

                                                } finally
                                                {
                                                    latch.countDown();
                                                }
                                    });
                                    latch.await();
                                    //Keep with the background work

                                    return null;
                                }
                            };
                        }
                    };
                    service.start();
                }

            }
        }

    }

}
