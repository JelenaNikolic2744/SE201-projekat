/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafika;

import javafx.stage.Stage;


public class Pozornice {
    
    private Stage stage1 = new Stage();
    private Stage stage2 = new Stage();
    private static Pozornice instanca = null;
    
    private Pozornice()
    {
        
    }
    
    public static Pozornice getInstana()
    {
        if(instanca == null)
        {
            instanca = new Pozornice();
            return instanca;
        }
        else
        {
            return instanca;
            
        }
       
        
               
    }
    
    public Stage getStage1()
    {
        return stage1;
    }
    public Stage getStage2()
    {
        return stage2;
    }
    
    
    
}
