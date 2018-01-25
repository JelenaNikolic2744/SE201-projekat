package Entiteti;
// Generated Aug 18, 2016 3:29:18 AM by Hibernate Tools 4.3.1


public class TopliNapitci extends Artikal implements java.io.Serializable {


    public TopliNapitci() {
    }


    public TopliNapitci(int tip, String naziv, int cena) {
        super(tip, naziv, cena);
    }

    public TopliNapitci(String naziv, int cena) {
        super(naziv, cena);
    }
            
    public TopliNapitci(Artikal rhs) {
        super(rhs);
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
    
    /**
     *
     * @param tip
     */
    @Override
    public void setTip(int tip) {
        this.tip = tip;
    }

    /**
     *
     * @return
     */
    @Override
    public String getNaziv() {
        return this.naziv;
    }
    
    @Override
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    /**
     *
     * @return
     */
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


