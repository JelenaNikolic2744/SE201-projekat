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
public class Sto {
      protected int brojStola;

    public Sto(){}
    
    public Sto(int brojStola) {
        this.brojStola = brojStola;
    }

    public int getBrojStola() {
        return brojStola;
    }

    public void setBrojStola(int brojStola) {
        this.brojStola = brojStola;
    }

    @Override
    public String toString() {
        return "" + brojStola ;
    }
}
