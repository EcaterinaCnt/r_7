package org.example.domain;

public class Carte {
    long id;
    String titlu, autor, gen;
    double pret;

    public Carte(String titlu, String autor, String gen, double pret) {
        this.titlu = titlu;
        this.autor = autor;
        this.gen = gen;
        this.pret = pret;
    }

    public Carte(String titlu, String autor, String gen) {
        this.titlu = titlu;
        this.autor = autor;
        this.gen = gen;
    }

    public Carte(long id, double pret) {
        this.id = id;
        this.pret = pret;
    }

    public Carte(long id, String titlu, String autor) {
        this.id = id;
        this.titlu = titlu;
        this.autor = autor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "id=" + id +
                ", titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", gen='" + gen + '\'' +
                ", pret=" + pret +
                '}';
    }

    public String toStringSortareTitluAutor() {
        return "Carte{" +
                "id=" + id +
                ", titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }

    public String toStringSortareDupaGen() {
        return "Carte{" +
                ", titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", gen='" + gen + '\'' +
                '}';
    }

    public String toStringSortareDupaPret() {
        return "Carte{" +
                "id=" + id +
                ", pret=" + pret +
                '}';
    }
}
