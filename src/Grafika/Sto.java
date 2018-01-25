/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafika;

import Entiteti.Artikal;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Sto extends Circle
{
    
    private final ArrayList<Artikal> listArtikala;
    
    public Sto(int x, int y)
    {
        super(x, y, 60);
        super.setFill(Color.BLACK);
        listArtikala = new ArrayList<>();
        
    }
    
    public void dodajArtikal(Artikal a)
    {
        listArtikala.add(a);
    }
    
    public void ukloniArtikal(Artikal a)
    {
        listArtikala.remove(a);
    }
    
    public void isprazniListu()
    {
        listArtikala.clear();
    }

    public ArrayList<Artikal> getListArtikala()
    {
        return listArtikala;
    }
    
    

}
