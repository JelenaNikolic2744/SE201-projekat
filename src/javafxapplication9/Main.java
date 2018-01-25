/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication9;

import Grafika.Postavka;
import Grafika.Pozornice;
import Klase.Liste;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application
{

    @Override
    public void start(Stage primaryStage)
    {

        Liste.getInstanca();
        Pozornice.getInstana().getStage1().setScene(new Scene(new Postavka(), 500, 400));
        Pozornice.getInstana().getStage1().show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}
