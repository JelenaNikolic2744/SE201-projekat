/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entiteti;


public class Artikal {
 
   
    protected int tip;
    protected String naziv;
    protected int cena;
    protected int id;
    protected int brKomada;

    public Artikal()
    {
    }

    public Artikal(String naziv, int cena) {
        this.naziv = naziv;
        this.cena = cena;
    }
    

    public Artikal(int tip, String naziv, int cena) {
        this.tip = tip;
        this.naziv = naziv;
        this.cena = cena;
    }

    public Artikal(int tip, String naziv, int cena, int id) {
        this.tip = tip;
        this.naziv = naziv;
        this.cena = cena;
        this.id = id;
        this.brKomada = 0;
    }
        
     public Artikal(Artikal rhs)
    {
        this.naziv = rhs.naziv;
        this.brKomada = 0;
        this.id = rhs.id;
        this.tip = rhs.tip;
        
        
    }

    public String getNaziv()
    {
        return naziv;
    }

    public void setNaziv(String naziv)
    {
        this.naziv = naziv;
    }

    public int getTip()
    {
        return tip;
    }

    public void setTip(int tip)
    {
        this.tip = tip;
    }

    public int getCena()
    {
        return cena;
    }

    public void setCena(int cena)
    {
        this.cena = cena;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getBrKomada()
    {
        return brKomada;
    }

    public void setBrKomada(int brKomada)
    {
        this.brKomada = brKomada;
    }

    @Override
    public String toString()
    {
        return "Artikal{" + "naziv=" + naziv + ", tip=" + tip + ", cena=" + cena + ", id=" + id + ", brKomada=" + brKomada + '}';
    }

    
    
}
