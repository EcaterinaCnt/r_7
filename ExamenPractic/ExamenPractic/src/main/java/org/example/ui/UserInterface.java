package org.example.ui;

import org.example.domain.Carte;
import org.example.service.ServiceCarte;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private ServiceCarte service;
    private Scanner scan;

    public UserInterface(ServiceCarte service) {
        this.service = service;
        this.scan = new Scanner(System.in);
    }

    private void adaugareCarteUi() {
        System.out.print("\tDati titlul: ");
        String titlu = this.scan.next();
        System.out.print("\tDati autorul: ");
        String autor = this.scan.next();
        System.out.print("\tDati genul: ");
        String gen = this.scan.next();
        System.out.print("\tDati pretul: ");
        double pret = this.scan.nextDouble();
        this.service.addCarte(titlu, autor, gen, pret);
        System.out.println("\tSUCCES: Carte adaugata cu succes!!");
    }

    private void getCartiUi() {
        List<Carte> listaCarti = this.service.getCarti();
        if(listaCarti.size() == 0) {
            System.out.println("EROARE: Nu exista carti!!");
        }
        else{
            System.out.println("Toate cartile sunt: ");
            listaCarti.forEach(x -> System.out.println(x));
        }
    }

    private void searchCarteUi() {
        List<Carte> listaCarti = this.service.searchCarte();
        if(listaCarti.size() == 0) {
            System.out.println("EROARE: Nu exista carti!!");
        }
        else {
            System.out.println("Toate cartile sunt: ");
            listaCarti.forEach(x -> System.out.println(x));
        }
    }

    private void filterCartiUi() {
        List<Carte> listaCarti = this.service.filterCarti();
        if(listaCarti.size() == 0) {
            System.out.println("EROARE: Nu exista carti!!");
        }
        else {
            System.out.println("Toate cartile sunt: ");
            listaCarti.forEach(x -> System.out.println(x));
        }
    }

    private void filterDupaGenUi() {
        List<Carte> listaCarti = this.service.filterDupaGen();
        if(listaCarti.size() == 0) {
            System.out.println("EROARE: Nu exista carti!!");
        }
        else {
            System.out.println("Toate cartile sunt: ");
            listaCarti.forEach(x -> System.out.println(x));
        }
    }

    private void sortDupaGenUi() {
        List<Carte> listaCarti = this.service.sortDupaGen();
        if(listaCarti.size() == 0) {
            System.out.println("EROARE: Nu exista carti!!");
        }
        else {
            System.out.println("Toate cartile sunt: ");
            listaCarti.forEach(x -> System.out.println(x.toStringSortareDupaGen()));
        }
    }

    private void sortDupaPretUi() {
        List<Carte> listaCarti = this.service.sortDupaPret();
        if(listaCarti.size() == 0) {
            System.out.println("EROARE: Nu exista carti!!");
        }
        else {
            System.out.println("Toate cartile sunt: ");
            listaCarti.forEach(x -> System.out.println(x.toStringSortareDupaPret()));
        }
    }

    private void sortDupaTituAutorUi() {
        List<Carte> listaCarti = this.service.sortDupaTitluAutor();
        if(listaCarti.size() == 0) {
            System.out.println("EROARE: Nu exista carti!!");
        }
        else {
            System.out.println("Toate cartile sunt: ");
            listaCarti.forEach(x -> System.out.println(x.toStringSortareTitluAutor()));
        }
    }

    public void runMenu() {
        boolean shouldRun = true;
        while(shouldRun) {
            System.out.println();
            System.out.println("(1) Adaugare carte.");
            System.out.println("(2) Afisare carti.");
            System.out.println("(3) Cautare carte.");
            System.out.println("(4) Filtrare carti dupa gen.");
            System.out.println("(5) Filtrare carti dupa gen si pret.");
            System.out.println("(6) Sortare carti dupa gen, crescator.");
            System.out.println("(7) Sortare carti dupa pret, descrescator.");
            System.out.println("(8) Sortare carti dupa autor si titlu alfabetic, crescator.");
            System.out.println("(x) Iesire.");
            System.out.print("Dati o optiune: ");
            String optiune = this.scan.next();
            if(optiune.equals("1")) {
                this.adaugareCarteUi();
            }
            else if(optiune.equals("2")) {
                this.getCartiUi();
            }
            else if(optiune.equals("3")) {
                this.searchCarteUi();
            }
            else if(optiune.equals("4")) {
                this.filterCartiUi();
            }
            else if(optiune.equals("5")) {
                this.filterDupaGenUi();
            }
            else if(optiune.equals("6")) {
                this.sortDupaGenUi();
            }
            else if(optiune.equals("7")) {
                this.sortDupaPretUi();
            }
            else if(optiune.equals("8")) {
                this.sortDupaTituAutorUi();
            }
            else if(optiune.equals("x")) {
                shouldRun = false;
            }
            else {
                System.out.println("\tOptiune gresita! Reincercati!");
            }
        }
    }
}
