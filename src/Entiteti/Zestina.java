package Entiteti;
// Generated Aug 18, 2016 3:29:18 AM by Hibernate Tools 4.3.1


public class Zestina extends Artikal implements java.io.Serializable {


  
    public Zestina() {
    }

    public Zestina(int tip, String naziv, int cena) {
        super(tip, naziv, cena);
    }

    public Zestina(Artikal rhs) {
        super(rhs);
    }

    public Zestina(String naziv, int cena) {
        super(naziv, cena);
    }
    
    
    
   
    @Override
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

  
    @Override
    public int getTip() {
        return this.tip;
    }
    
    @Override
    public void setTip(int tip) {
        this.tip = tip;
    }
    @Override
    public String getNaziv() {
        return this.naziv;
    }
    
    @Override
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    @Override
    public int getCena() {
        return this.cena;
    }
    
    @Override
    public void setCena(int cena) {
        this.cena = cena;
    }

@Override
    public String toString() {
        return this.naziv+" "+this.cena+" "+this.tip+" "+this.id; //To change body of generated methods, choose Tools | Templates.
    }


}


