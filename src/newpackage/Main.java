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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Sto sto = new Sto(1);
        Proizvod proizvod1 = new Proizvod("kafa", 150);
        Proizvod proizvod2 = new Proizvod("koka kola", 200);
        Proizvod proizvod3 = new Proizvod("kolac sa jabukama", 350);
        Proizvod proizvod4 = new Proizvod("cheese cake", 400);
        
        Porudzbina porudzbina = new Porudzbina(sto);
        porudzbina.upisi(proizvod1,proizvod2,proizvod3,proizvod4);
        
        Racun racun = new Racun(porudzbina,"12.12.2017.");
        
        
        System.out.println("Racun za musteriju : " + racun);
        System.out.println("________________________________________________________________________");
        System.out.println("Ukupna cena racuna musterije je : " + racun.izracunaj(porudzbina.getNarudzbina()));
    }
    
}
