package org.example.repository;

import org.example.domain.Carte;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class RepositoryDatabase implements Repository<Carte>{
    private String url, username, password;

    public RepositoryDatabase(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public void addEntity(Carte entity) {
        String sql = "INSERT INTO carti (titlu, autor, gen, pret) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, entity.getTitlu());
            statement.setString(2, entity.getAutor());
            statement.setString(3, entity.getGen());
            statement.setDouble(4, entity.getPret());
            statement.executeUpdate();
        }
        catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public List<Carte> getAllEntities() {
        List<Carte> listOfEntities = new ArrayList<>();
        String sql = "SELECT * FROM carti";
        try(Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String titlu = resultSet.getString("titlu");
                String autor = resultSet.getString("autor");
                String gen = resultSet.getString("gen");
                double pret = resultSet.getDouble("pret");
                Carte carte = new Carte(titlu, autor, gen, pret);
                carte.setId(id);
                listOfEntities.add(carte);
            }
            return listOfEntities;
        }
        catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return listOfEntities;
    }
}
