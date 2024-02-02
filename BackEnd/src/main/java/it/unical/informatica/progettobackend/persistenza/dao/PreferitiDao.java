package it.unical.informatica.progettobackend.persistenza.dao;

import it.unical.informatica.progettobackend.persistenza.model.Piatto;

import java.util.List;

public interface PreferitiDao {

    boolean checkPreferiti(String piatto, String username);

    void changePreferiti(String piatto, String username);

    List<Piatto> findAllPreferiti(String username); }

