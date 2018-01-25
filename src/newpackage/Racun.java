/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.ArrayList;

/**
 *
 * @author Ivan
 */
public class Racun {
     private Porudzbina narudzbina;
    private String datumIzdavanja;

    public Racun() {
    }

    public Racun(Porudzbina narudzbina, String datumIzdavanja) {
        this.narudzbina = narudzbina;
        this.datumIzdavanja = datumIzdavanja;
    }

    public Porudzbina getNarudzbina() {
        return narudzbina;
    }

    public String getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setNarudzbina(Porudzbina narudzbina) {
        this.narudzbina = narudzbina;
    }

    public void setDatumIzdavanja(String datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    @Override
    public String toString() {
        return "Racun ->  " + "Naruceno je: " + narudzbina + ", Datum Izdavanja racuna je: " + datumIzdavanja;
    }
    
    public int izracunaj(ArrayList<Proizvod> p){
        
        int cenaProizvoda = 0;
        int cena;
        
        for(int i = 0; i < p.size(); i++){
            
            cena = p.get(i).getCena();
             cenaProizvoda += cena;
        }
        return cenaProizvoda;
        
    }
}
