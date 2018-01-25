/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafika;

import java.awt.Panel;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class Postavka extends GridPane{
    
   private Sala sala;
   private Meni meni;
   
    
    
    public Postavka()
    {
        super();
        meni = new Meni();
        sala = new Sala();
        
        
        super.add(meni, 0, 0);
        super.add(sala, 0, 1);
        
        
    }
    
    
   
}
