/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Ivan
 */
public class Proizvod {
     private String ime;
    private int cena;

    public Proizvod() {
    }

    public Proizvod(String ime, int cena) {
        this.ime = ime;
        this.cena = cena;
    }

    public String getIme() {
        return ime;
    }

    public int getCena() {
        return cena;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return  "ime: " + ime + ", cena: " + cena;
    }
    
    
}
