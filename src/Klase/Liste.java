/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Klase;

import Entiteti.Artikal;
import Entiteti.Magacin;
import Entiteti.Pazar;
import Entiteti.Pivo;
import Entiteti.Sokovi;
import Entiteti.TopliNapitci;
import Entiteti.Zestina;
import java.util.ArrayList;
import java.util.List;


public class Liste {
    
    private ArrayList<Artikal> listSvihProizvoda;
    private  ArrayList<Pivo> piva;
    private  ArrayList<TopliNapitci> napitci;
    private  ArrayList<Sokovi> sokovi;
    private  ArrayList<Zestina> zestina;
    private  ArrayList<Magacin> magacin;
    private ArrayList<Pazar> pazar;      
    private static Liste instanca = null;
    
    
    private Liste()
    {
        listSvihProizvoda = new ArrayList<>();
        piva = new ArrayList<>(Krud.Krud.getInstanca().readall("from Pivo"));
        napitci = new ArrayList<>(Krud.Krud.getInstanca().readall("from TopliNapitci"));
        sokovi = new ArrayList<>(Krud.Krud.getInstanca().readall("from Sokovi"));
        zestina = new ArrayList<>(Krud.Krud.getInstanca().readall("from Zestina"));
        magacin = new ArrayList<>(Krud.Krud.getInstanca().readall("from Magacin"));
        pazar = new ArrayList<>(Krud.Krud.getInstanca().readall("from Pazar"));
        System.out.println("Pazar 2"+pazar.toString());
        listSvihProizvoda.addAll(piva);
       listSvihProizvoda.addAll(napitci);
        listSvihProizvoda.addAll(sokovi);
        listSvihProizvoda.addAll(zestina);
        
    }

    public ArrayList<Pazar> getPazar()
    {
        return pazar;
    }

    public void setPazar(ArrayList<Pazar> pazar)
    {
        this.pazar = pazar;
    }
    
    public static Liste getInstanca()
    {
        if (instanca == null) {
            
            instanca = new Liste();
            return instanca;
            
        }
        else{
            return instanca;
        }
    }

    public ArrayList<Artikal> getListSvihProizvoda() {
        return listSvihProizvoda;
    }

    public ArrayList<Pivo> getPiva() {
        return piva;
    }

    public ArrayList<TopliNapitci> getNapitci() {
        return napitci;
    }

    public ArrayList<Sokovi> getSokovi() {
        return sokovi;
    }

    public ArrayList<Zestina> getZestina() {
        return zestina;
    }

    public ArrayList<Magacin> getMagacin() {
        return magacin;
    }
      
    
    
}
