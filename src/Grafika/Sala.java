/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafika;

import Listeneri.Lisener1;
import java.awt.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class Sala extends Pane
{

    private static Sto s1 = new Sto(100, 85);
    private static Sto s2 = new Sto(400, 85);
    private static Sto s3 = new Sto(250, 163);
    private static Sto s4 = new Sto(100, 250);
    private static Sto s5 = new Sto(400, 250);

    public Sala()
    {
        super();
        this.getChildren().addAll(s1, s2, s3, s4, s5);
        //s1.setOnMouseClicked(Lisener1.getInstanca().getZaSto1());
        
      s1.setOnMouseClicked((MouseEvent event) ->
        {
            Pozornice.getInstana().getStage2().setScene(new Scene(new NaplataForm(s1), 800, 500));
            Pozornice.getInstana().getStage2().show();
        });
        
        s2.setOnMouseClicked((MouseEvent event) ->
        {
            Pozornice.getInstana().getStage2().setScene(new Scene(new NaplataForm(s2), 500, 500));
            Pozornice.getInstana().getStage2().show();
        });
        
        s3.setOnMouseClicked((MouseEvent event) ->
        {
            Pozornice.getInstana().getStage2().setScene(new Scene(new NaplataForm(s3), 500, 500));
            Pozornice.getInstana().getStage2().show();
        });
        
        s4.setOnMouseClicked((MouseEvent event) ->
        {
            Pozornice.getInstana().getStage2().setScene(new Scene(new NaplataForm(s4), 500, 500));
            Pozornice.getInstana().getStage2().show();
        });
        
        s5.setOnMouseClicked((MouseEvent event) ->
        {
            Pozornice.getInstana().getStage2().setScene(new Scene(new NaplataForm(s5), 500, 500));
            Pozornice.getInstana().getStage2().show();
        });

    }

    public static Sto getS1()
    {
        return s1;
    }

    public static void setS1(Sto s1)
    {
        Sala.s1 = s1;
    }

    public static Sto getS2()
    {
        return s2;
    }

    public static void setS2(Sto s2)
    {
        Sala.s2 = s2;
    }

    public static Sto getS3()
    {
        return s3;
    }

    public static void setS3(Sto s3)
    {
        Sala.s3 = s3;
    }

    public static Sto getS4()
    {
        return s4;
    }

    public static void setS4(Sto s4)
    {
        Sala.s4 = s4;
    }

    public static Sto getS5()
    {
        return s5;
    }

    public static void setS5(Sto s5)
    {
        Sala.s5 = s5;
    }

    

}
