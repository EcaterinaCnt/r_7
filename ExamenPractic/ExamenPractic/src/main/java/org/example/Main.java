package org.example;

import org.example.domain.Carte;
import org.example.repository.Repository;
import org.example.repository.RepositoryDatabase;
import org.example.service.ServiceCarte;
import org.example.ui.UserInterface;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/ExamenPractic";
        String username = "postgres";
        String password = "andrey100f";
        Repository<Carte> repo = new RepositoryDatabase(url, username, password);
        ServiceCarte service = new ServiceCarte(repo);
        UserInterface ui = new UserInterface(service);
        ui.runMenu();
    }
}