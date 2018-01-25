package Entiteti;
// Generated Aug 18, 2016 3:29:18 AM by Hibernate Tools 4.3.1



public class Sokovi extends Artikal implements java.io.Serializable {


    public Sokovi() {
    }

    public Sokovi(int tip, String naziv, int cena) {
        super(tip, naziv, cena);
    }

    public Sokovi(String naziv, int cena) {
        super(naziv, cena);
    }

 

    public Sokovi(Artikal rhs) {
        super(rhs);
    }
    
    
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getTip() {
        return this.tip;
    }
    
    public void setTip(int tip) {
        this.tip = tip;
    }
    public String getNaziv() {
        return this.naziv;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    public int getCena() {
        return this.cena;
    }
    
    public void setCena(int cena) {
        this.cena = cena;
    }
@Override
    public String toString() {
        return this.naziv+" "+this.cena+" "+this.tip+" "+this.id; //To change body of generated methods, choose Tools | Templates.
    }



}


