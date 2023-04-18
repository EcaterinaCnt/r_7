package org.example.service;

import org.example.domain.Carte;
import org.example.repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceCarte {
    private Repository<Carte> repo;

    public ServiceCarte(Repository<Carte> repo) {
        this.repo = repo;
    }

    public void addCarte(String titlu, String autor, String gen, double pret) {
        Carte carte = new Carte(titlu, autor, gen, pret);
        this.repo.addEntity(carte);
    }

    public List<Carte> getCarti() {
        return this.repo.getAllEntities();
    }

    public List<Carte> searchCarte() {
        List<Carte> listaCarti = this.repo.getAllEntities();
        List<Carte> rezultat = listaCarti.stream()
                .filter(x -> x.getTitlu().equals("Ciuleandra"))
                .collect(Collectors.toList());
        return rezultat;
    }

    public List<Carte> filterCarti() {
        List<Carte> listaCarti = this.repo.getAllEntities();
        List<Carte> listaFiltrata = listaCarti.stream()
                .filter(x->x.getGen().equals("sci-fi"))
                .collect(Collectors.toList());
        return listaFiltrata;
    }

    public List<Carte> filterDupaGen() {
        List<Carte> listaCarti = this.repo.getAllEntities();
        List<Carte> listaFiltrata = listaCarti.stream()
                .filter(x->x.getGen().equals("sci-fi") && x.getPret() < 50)
                .collect(Collectors.toList());
        return listaFiltrata;
    }

    public List<Carte> sortDupaGen() {
        List<Carte> listaCarti = this.repo.getAllEntities();
        List<Carte> listaSortata = listaCarti.stream()
                .sorted((x, y) -> x.getGen().compareTo(y.getGen()))
                .toList();
        List<Carte> rezultat = new ArrayList<>();
        for(Carte carte:listaSortata) {
            Carte carteNoua = new Carte(carte.getTitlu(), carte.getAutor(), carte.getGen());
            rezultat.add(carteNoua);
        }
        return rezultat;
    }

    public List<Carte> sortDupaPret() {
        List<Carte> listaCarti = this.repo.getAllEntities();
        List<Carte> listaSortataPret = listaCarti.stream()
                .sorted((x, y) -> Double.compare(y.getPret(), x.getPret()))
                .toList();
        List<Carte> rezultat = new ArrayList<>();
        for(Carte carte:listaSortataPret) {
            Carte carteNoua = new Carte(carte.getId(), carte.getPret());
            rezultat.add(carteNoua);
        }
        return  rezultat;
    }

    public List<Carte> sortDupaTitluAutor() {
        List<Carte> listaCarti = this.repo.getAllEntities();
        List<Carte> listaSortataPretAutor = listaCarti.stream()
                .sorted((x, y) -> x.getTitlu().compareTo(y.getTitlu()))
                .sorted((x, y) -> x.getAutor().compareTo(y.getAutor()))
                .toList();
        List<Carte> rezultat = new ArrayList<>();
        for(Carte carte:listaSortataPretAutor) {
            Carte carteNoua = new Carte(carte.getId(), carte.getTitlu(), carte.getAutor());
            rezultat.add(carteNoua);
        }
        return  rezultat;
    }
}
