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
import Grafika.Pozornice;
import Grafika.Scena;
import Krud.Krud;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class FunkcijeUnos {

    private static Artikal novo;
    private static Magacin magacin;

    public static void unesiPivo() {
        String naziv = FormaZaUnos.getFildNaziv().getText().toLowerCase();

        try {
            Integer.parseInt(naziv);
            System.out.println("An integer");
             FormaZaUnos.getFildNaziv().clear();
            FormaZaUnos.getFildCena().clear();
            return;
        } catch (NumberFormatException e) {

        }
        try {
            Integer.parseInt(FormaZaUnos.getFildCena().getText());
            System.out.println("An integer");

        } catch (NumberFormatException e) {
             FormaZaUnos.getFildNaziv().clear();
        FormaZaUnos.getFildCena().clear();
            return;
        }
        int cena = Integer.parseInt(FormaZaUnos.getFildCena().getText());
        novo = new Pivo(naziv, cena);
        novo.setNaziv(naziv);
        novo.setCena(cena);
        novo.setTip(1);
        boolean provera = true;

        for (Pivo p : Liste.getInstanca().getPiva()) {
            if (p.getNaziv().equals(novo.getNaziv())) {
                provera = false;
            }
        }

        

        if (provera) {
            magacin = new Magacin(novo);
            Krud.getInstanca().insert(novo);
            Krud.getInstanca().insert(magacin);
            Liste.getInstanca().getListSvihProizvoda().add(new Artikal(novo));
            Liste.getInstanca().getPiva().add((Pivo) novo);
            
        } else {
            JOptionPane.showMessageDialog(null, "Pice vec postoji u tabeli");
             FormaZaUnos.getFildNaziv().clear();
                FormaZaUnos.getFildCena().clear();
            return;

        }

        FormaZaUnos.getFildNaziv().clear();
        FormaZaUnos.getFildCena().clear();

    }

    public static void unesiSok() {
        String naziv = FormaZaUnos.getFildNaziv().getText().toLowerCase();
         try {
            Integer.parseInt(naziv);
            System.out.println("An integer");
             FormaZaUnos.getFildNaziv().clear();
            FormaZaUnos.getFildCena().clear();
            return;
        } catch (NumberFormatException e) {

        }
        try {
            Integer.parseInt(FormaZaUnos.getFildCena().getText());
            System.out.println("An integer");

        } catch (NumberFormatException e) {
             FormaZaUnos.getFildNaziv().clear();
        FormaZaUnos.getFildCena().clear();
            return;
        }
        
        int cena = Integer.parseInt(FormaZaUnos.getFildCena().getText());
        novo = new Sokovi();
        novo.setCena(cena);
        novo.setNaziv(naziv);
        novo.setTip(2);
        boolean provera = true;
        
        for(Sokovi s : Liste.getInstanca().getSokovi() )
        {
            if(s.getNaziv().equals(novo.getNaziv()))
            {
                provera = false;
            }
        }
        
        
        if (provera) 
        {
            magacin = new Magacin(novo);
            Krud.getInstanca().insert(novo);
            Krud.getInstanca().insert(magacin);
            Liste.getInstanca().getListSvihProizvoda().add(new Artikal(novo));
            Liste.getInstanca().getSokovi().add((Sokovi) novo);
            
            

        }
        else
        {
            JOptionPane.showMessageDialog(null, "Pice vec postoji u tabeli");
            FormaZaUnos.getFildNaziv().clear();
            FormaZaUnos.getFildCena().clear();
            return;
        }
        FormaZaUnos.getFildNaziv().clear();
        FormaZaUnos.getFildCena().clear();
        


    }

    public static void unesiZestinu() {
        String naziv = FormaZaUnos.getFildNaziv().getText().toLowerCase();

        try {
            Integer.parseInt(naziv);
            System.out.println("An integer");
            FormaZaUnos.getFildNaziv().clear();
            FormaZaUnos.getFildCena().clear();
            return;
        } catch (NumberFormatException e) {

        }
        try {
            Integer.parseInt(FormaZaUnos.getFildCena().getText());
            System.out.println("An integer");

        } catch (NumberFormatException e) {
            FormaZaUnos.getFildNaziv().clear();
            FormaZaUnos.getFildCena().clear();
            return;
        }

        int cena = Integer.parseInt(FormaZaUnos.getFildCena().getText());
        novo = new Zestina();
        novo.setCena(cena);
        novo.setNaziv(naziv);
        novo.setTip(4);
        boolean provera = true;
        
        
        for (Zestina e : Liste.getInstanca().getZestina()) 
        {
            
            if (e.getNaziv().equals(novo.getNaziv()))
            {
                provera = false;
            }
            
        }
        
        if(provera)
        {
            magacin = new Magacin(novo);
            Krud.getInstanca().insert(novo);
            Krud.getInstanca().insert(magacin);
            Liste.getInstanca().getListSvihProizvoda().add(new Artikal(novo));
            Liste.getInstanca().getZestina().add((Zestina) novo);
        
        }
        else
        {
            FormaZaUnos.getFildNaziv().clear();
            FormaZaUnos.getFildCena().clear();
            return;
        }
        
        

    }

    public static void unesiNapitke() {
        String naziv = FormaZaUnos.getFildNaziv().getText().toLowerCase();
        
        try {
            Integer.parseInt(naziv);
            System.out.println("An integer");
            FormaZaUnos.getFildNaziv().clear();
            FormaZaUnos.getFildCena().clear();
            return;
        } catch (NumberFormatException e) {

        }
        try {
            Integer.parseInt(FormaZaUnos.getFildCena().getText());
            System.out.println("An integer");

        } catch (NumberFormatException e) {
            FormaZaUnos.getFildNaziv().clear();
            FormaZaUnos.getFildCena().clear();
            return;
        }
        
        int cena = Integer.parseInt(FormaZaUnos.getFildCena().getText());
        novo = new TopliNapitci();
        novo.setCena(cena);
        novo.setNaziv(naziv);
        novo.setTip(3);
        boolean provera = true;
        
        for(TopliNapitci e : Liste.getInstanca().getNapitci())
        {
            if (e.getNaziv().equals(novo.getNaziv())) 
            {
                
                provera = false;
            }
        }
        
        if (provera)
        {
            magacin = new Magacin(novo);
            Krud.getInstanca().insert(novo);
            Krud.getInstanca().insert(magacin);
            Liste.getInstanca().getListSvihProizvoda().add(new Artikal(novo));
            Liste.getInstanca().getNapitci().add((TopliNapitci) novo);
            
            
        }
        else {
            FormaZaUnos.getFildNaziv().clear();
            FormaZaUnos.getFildCena().clear();
            return;
        }
        
        
        

    }

}
