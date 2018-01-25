package Entiteti;
// Generated Aug 18, 2016 3:29:18 AM by Hibernate Tools 4.3.1


public class Pazar  implements java.io.Serializable {


     private Integer id;
     private int idPica;
     private String naziv;
     private int prodatoKomada;
     private int ukupnaCena;

    public Pazar() {
    }

    public Pazar(int idPica, String naziv, int prodatoKomada, int ukupnaCena) {
       this.idPica = idPica;
       this.naziv = naziv;
       this.prodatoKomada = prodatoKomada;
       this.ukupnaCena = ukupnaCena;
    }
    public Pazar(Artikal a)
    {
        this.naziv = a.naziv;
        this.prodatoKomada = a.brKomada;
        this.ukupnaCena = a.cena;
        this.idPica = a.tip;
    }

   
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getIdPica() {
        return this.idPica;
    }
    
    public void setIdPica(int idPica) {
        this.idPica = idPica;
    }
    public String getNaziv() {
        return this.naziv;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    public int getProdatoKomada() {
        return this.prodatoKomada;
    }
    
    public void setProdatoKomada(int prodatoKomada) {
        this.prodatoKomada = prodatoKomada;
    }
    public int getUkupnaCena() {
        return this.ukupnaCena;
    }
    
    public void setUkupnaCena(int ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    @Override
    public String toString()
    {
        return "Pazar{" + "id=" + id + ", idPica=" + idPica + ", naziv=" + naziv + ", prodatoKomada=" + prodatoKomada + ", ukupnaCena=" + ukupnaCena + '}';
    }




}


