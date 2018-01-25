/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.ArrayList;


public class Porudzbina {
    protected Sto brStola;
    protected ArrayList<Proizvod> narudzbina;

    public Porudzbina(){}
    
    public Porudzbina(Sto brStola) {
        this.brStola = brStola;
        narudzbina = new ArrayList();
    }

    public Sto getBrStola() {
        return brStola;
    }

    public ArrayList<Proizvod> getNarudzbina() {
        return narudzbina;
    }

    public void setBrStola(Sto brStola) {
        this.brStola = brStola;
    }

    void upisi(Proizvod... proizvod) {
        for (Proizvod pr : proizvod) {
            narudzbina.add(pr);
        }
    }

    @Override
    public String toString() {
        return "Broj Stola je " + brStola + ", Porudzbina je: " + narudzbina;
    }
    
}
