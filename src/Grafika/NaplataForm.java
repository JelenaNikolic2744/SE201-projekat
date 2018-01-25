/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafika;

import Entiteti.Artikal;
import Entiteti.Magacin;
import Entiteti.Pivo;
import Entiteti.Sokovi;
import Entiteti.TopliNapitci;
import Entiteti.Zestina;
import Klase.ComboBoxAutoComplete;
import Klase.Liste;
import Klase.StringTranslator;
import Listeneri.Lisener1;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


public class NaplataForm extends GridPane
{

    //private static TextField sta;
    private static ComboBox<String> comboSta;
    private static ComboBox<Artikal> comboSta2;
    private static TextField koliko;
    private static Button potvrdi, naplati;
    private static ArrayList<TopliNapitci> listaNapitci;
    private static ArrayList<Pivo> listaPivo;
    private static ArrayList<Zestina> listaZestina;
    private static ArrayList<Sokovi> listaSokovi;
    private ListView<Artikal> listView;
    private ObservableList<Artikal> items;
    private Label stanjeLabela;
    private int stanje;
    private Sto sto;
    private static Artikal b;
    private static ArrayList<Artikal> listaCombo;
    private ArrayList<Magacin> listaMagacin;

    public NaplataForm(Sto sto)
    {
        super();
        //sta = new TextField();
        comboSta = new ComboBox<>();
        comboSta2 = new ComboBox<>();
        listaCombo = new ArrayList<>();
        listView = new ListView<>();
        stanjeLabela = new Label();

        this.sto = sto;

        comboSta.setMaxWidth(80);
        comboSta.getItems().addAll("Pivo", "TopliNapitci", "Zestina", "Sokovi");
        comboSta.setOnAction((ActionEvent event)
                -> 
                {
                    String s = StringTranslator.translate(comboSta.getSelectionModel().getSelectedItem());
                    System.out.println(s);
                    listaNapitci = new ArrayList(Liste.getInstanca().getNapitci());
                    listaSokovi = new ArrayList(Liste.getInstanca().getSokovi());
                    listaZestina = new ArrayList(Liste.getInstanca().getZestina());
                    listaPivo = new ArrayList(Liste.getInstanca().getPiva());
                    listaMagacin = new ArrayList(Liste.getInstanca().getMagacin());

                    listaCombo.clear();
                    comboSta2.getItems().clear();
                    if (s == "Pivo")
                    {
                        listaCombo = new ArrayList<>(listaPivo);
                    } else if (s == "TopliNapitci")
                    {
                        listaCombo = new ArrayList<>(listaNapitci);
                    } else if (s == "Zestina")
                    {
                        listaCombo = new ArrayList<>(listaZestina);
                    } else
                    {
                        listaCombo = new ArrayList<>(listaSokovi);
                    }

                    comboSta2.getItems().clear();
                    comboSta2.getItems().addAll(listaCombo);
                    new ComboBoxAutoComplete<>(comboSta2);

        });
        koliko = new TextField();
        
        potvrdi = new Button("Potvrdi");
        naplati = new Button("Naplati");

//        sta.setMaxWidth(80);
        koliko.setMaxWidth(80);
        potvrdi.setMaxWidth(80);
        this.add(comboSta, 0, 0);
        this.add(comboSta2, 1, 0);
        this.add(stanjeLabela, 2, 0);
        this.add(koliko, 3, 0);
        this.add(potvrdi, 4, 0);
        this.add(listView, 1, 1);
        
        this.add(naplati, 1, 4);
        this.setHgap(5);
        this.setVgap(5);
        // potvrdi.setOnAction(Lisener1.getInstanca().zaPotvrdi());

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
                        items = FXCollections.observableArrayList(sto.getListArtikala());

                        final CountDownLatch latch = new CountDownLatch(1);
                        Platform.runLater(()
                                -> 
                                {
                                    try
                                    {
                                        //FX Stuff done here
                                        listView.setItems(items);
                                        listView.refresh();

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
       
       
        naplati.setOnAction((ActionEvent event) ->
        {
            Pozornice.getInstana().getStage2().setScene(new Scene(new Fiskalizacija(sto), 200, 200));
            Pozornice.getInstana().getStage2().show();
        });
        
        potvrdi.setOnAction((ActionEvent event) ->
        {
            if (comboSta.getSelectionModel().isEmpty())
            {
                return;
            }
            if (comboSta2.getSelectionModel().isEmpty())
            {
                return;
            }
            if (koliko.getText().trim().equals(""))
            {
                return;
            }
            int kolicina = Integer.parseInt(koliko.getText().trim());
            int tip = comboSta2.getSelectionModel().getSelectedItem().getTip();
            Artikal a;
            System.out.println(tip);
            switch (tip)
            {
                case 1:
                    a = new Pivo(comboSta2.getSelectionModel().getSelectedItem());
                    // a.setCena(kolicina * comboSta2.getSelectionModel().getSelectedItem().getCena());
                  //  a.setBrKomada(kolicina);
                    System.out.println("kejs pivo");
                    System.out.println(a.toString());
                    break;
                case 2:
                    a = new Sokovi(comboSta2.getSelectionModel().getSelectedItem());
                   // a.setTip(2);
                    System.out.println("Kejs sok");
                    System.out.println(a.toString());
                    break;
                case 3:
                    a = new TopliNapitci(comboSta2.getSelectionModel().getSelectedItem());
                   // a.setTip(3);
                    System.out.println("kejs napitci");
                    System.out.println(a.toString());
                    break;
                default:
                    
                    a = new Zestina(comboSta2.getSelectionModel().getSelectedItem());
                   // a.setTip(4);
                    System.out.println("kejs zestina");
                    System.out.println(a.toString());
                    break;
            }
            //                for (Magacin m : listaMagacin)
//                {
//                    System.out.println("jashdjashd");
//                    if (m.getIdPica() == a.getTip() && m.getNaziv().equals(a.getNaziv()))
//                    {
//                        System.out.println("if magacin ");
//                        stanje = m.getKolicina();
//                        stanjeLabela.setText("" + stanje);
//                        if (kolicina > m.getKolicina())
//                        {
//                            System.out.println("Nema na stanju ");
//                            return;
//
//                        }
//
//                    }
//
//                }
boolean nePostoji = true;
for (Artikal artical : sto.getListArtikala())
{
    
    if (artical.getId() == a.getId() && artical.getTip() == a.getTip())
    {
        System.out.println(a.getId() + "   " + artical.getId() + " tipovi" + a.getTip() + "  " + artical.getTip());
        int oldValue = artical.getBrKomada();
        
        artical.setBrKomada(oldValue + kolicina);
        
        artical.setCena(comboSta2.getSelectionModel().getSelectedItem().getCena() * artical.getBrKomada());
        
        nePostoji = false;
        System.out.println("Izlaz if");
        
    }
}
if (nePostoji)
{
    a.setBrKomada(kolicina);
    a.setCena(comboSta2.getSelectionModel().getSelectedItem().getCena() * a.getBrKomada());
    sto.getListArtikala().add(a);
}
System.out.println(sto.getListArtikala().toString());
//                    comboSta.getSelectionModel().clearSelection();
comboSta2.getSelectionModel().clearSelection();
koliko.clear();
Service<Void> service1 = new Service<Void>()
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
                items = FXCollections.observableArrayList(sto.getListArtikala());
                
                final CountDownLatch latch = new CountDownLatch(1);
                Platform.runLater(()
                        ->
                {
                    try
                    {
                        //FX Stuff done here
                        listView.setItems(items);
                        listView.refresh();
                        
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
            service1.start();
        });
        
      
            
 /*      comboSta2.valueProperty().addListener(new ChangeListener<Artikal>()
       {
            @Override
            public void changed(ObservableValue<? extends Artikal> observable, Artikal oldValue, Artikal newValue)
            {
                    b = new Artikal(comboSta2.getSelectionModel().getSelectedItem());
                 for (Magacin m : listaMagacin)
             {                 System.out.println("jashdjashd");
                 if (m.getIdPica() == b.getTip() && m.getNaziv().equals(b.getNaziv()))
                 {
                     System.out.println("if magacin ");
                     System.out.println(m.getNaziv());
                     stanje = m.getKolicina()  ;      
                     stanjeLabela.setText("" + stanje);
                    return;
                  }

              }
                
            }
        });*/
        

    }

    public static ComboBox<String> getComboSta()
    {
        return comboSta;
    }

    public static void setComboSta(ComboBox<String> comboSta)
    {
        NaplataForm.comboSta = comboSta;
    }

    public static TextField getKoliko()
    {
        return koliko;
    }

    public static void setKoliko(TextField koliko)
    {
        NaplataForm.koliko = koliko;
    }

    public static Button getPotvrdi()
    {
        return potvrdi;
    }

    public static void setPotvrdi(Button potvrdi)
    {
        NaplataForm.potvrdi = potvrdi;
    }
}
