/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafika;

import Listeneri.Lisener1;
import javafx.beans.binding.BooleanBinding;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class FormaZaUnos extends GridPane
{

    private static Label labelaNziv;
    private static Label labelaCena;
    private static TextField fildNaziv;
    private static TextField fildCena;
    private static Button unesi;
    private static BooleanBinding bind ;
    private static boolean pivoProvera;
    private static boolean zestinaProvera;
    private static boolean sokoviProvera;
    private static boolean topliNapitciProvera;

    public FormaZaUnos()
    {
        super();

        this.setAlignment(Pos.CENTER);
        this.setHgap(20);
        this.setVgap(10);
        labelaNziv = new Label("Naziv pica");
        labelaCena = new Label("Cena pica");
        this.add(labelaNziv, 0, 0);
        this.add(labelaCena, 0, 1);

        fildNaziv = new TextField();
        fildCena = new TextField();

        this.add(fildNaziv, 1, 0);
        this.add(fildCena, 1, 1);

        unesi = new Button("Unesi");
        unesi.setMaxWidth(222);

        this.add(unesi, 0, 2, 2, 1);
        this.prepareBinding();

        if (pivoProvera)
        {
            unesi.setOnAction(Lisener1.getInstanca().getZaUnosPiva());
            System.out.println("Upecao je pivo proveru");
        } else if (sokoviProvera)
        {
            unesi.setOnAction(Lisener1.getInstanca().getUnesiSokove());
            System.out.println("Upecao je sokovi proveru");
            
        } else if (zestinaProvera)
        {
            unesi.setOnAction(Lisener1.getInstanca().getUnesiZestinu());
            System.out.println("Upecao je Zestina proveru");

        } else if (topliNapitciProvera)
        {   
            unesi.setOnAction(Lisener1.getInstanca().getUnesiNapitke());
            System.out.println("Upecao je napitke");
        } else
        {
            System.out.println("neradi djubre");
        }
        
    }

    public void prepareBinding()
    {
        bind = new BooleanBinding()
        {
            {
                super.bind(fildCena.textProperty(), fildNaziv.textProperty());

            }

            @Override
            protected boolean computeValue()
            {

                return fildCena.getText().isEmpty() || fildNaziv.getText().isEmpty();

            }
        };
        unesi.disableProperty().bind(bind);

    }

    public static Label getLabelaNziv()
    {
        return labelaNziv;
    }

    public static void setLabelaNziv(Label labelaNziv)
    {
        FormaZaUnos.labelaNziv = labelaNziv;
    }

    public static Label getLabelaCena()
    {
        return labelaCena;
    }

    public static void setLabelaCena(Label labelaCena)
    {
        FormaZaUnos.labelaCena = labelaCena;
    }

    public static TextField getFildNaziv()
    {
        return fildNaziv;
    }

    public static void setFildNaziv(TextField fildNaziv)
    {
        FormaZaUnos.fildNaziv = fildNaziv;
    }

    public static TextField getFildCena()
    {
        return fildCena;
    }

    public static void setFildCena(TextField fildCena)
    {
        FormaZaUnos.fildCena = fildCena;
    }

    public static Button getUnesi()
    {
        return unesi;
    }

    public static void setUnesi(Button unesi)
    {
        FormaZaUnos.unesi = unesi;
    }

    public static boolean isPivoProvera()
    {
        return pivoProvera;
    }

    public static void setPivoProvera(boolean pivoProvera)
    {
        FormaZaUnos.pivoProvera = pivoProvera;
    }

    public static boolean isZestinaProvera()
    {
        return zestinaProvera;
    }

    public static void setZestinaProvera(boolean zestinaProvera)
    {
        FormaZaUnos.zestinaProvera = zestinaProvera;
    }

    public static boolean isSokoviProvera()
    {
        return sokoviProvera;
    }

    public static void setSokoviProvera(boolean sokoviProvera)
    {
        FormaZaUnos.sokoviProvera = sokoviProvera;
    }

    public static boolean isTopliNapitciProvera()
    {
        return topliNapitciProvera;
    }

    public static void setTopliNapitciProvera(boolean topliNapitciProvera)
    {
        FormaZaUnos.topliNapitciProvera = topliNapitciProvera;
    }

    public static BooleanBinding getBind() {
        return bind;
    }

   

}
