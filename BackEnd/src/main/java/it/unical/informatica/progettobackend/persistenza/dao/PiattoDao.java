package it.unical.informatica.progettobackend.persistenza.dao;

import it.unical.informatica.progettobackend.persistenza.model.Piatto;

import java.util.List;

public interface PiattoDao {
    public List<Piatto> findAll();

    public List<Piatto> findAllNonEfficiente();

    public List<Piatto> findAllLazy();


    public Piatto findByPrimaryKey(Long id);

    public void saveOrUpdate(Piatto piatto);

    public void delete(Piatto piatto);

    List<Piatto> findAllAntipasti();

    List<Piatto> findAllPrimi();

    List<Piatto> findAllSecondi();

    List<Piatto> findAllContorni();

    List<Piatto> findAllDolci();

    List<Piatto> findAllSenzaLattosio();

    List<Piatto> findAllSenzaGlutine();

    List<Piatto> findAllBevande();

    Piatto getPiatto(String name);


    List<Piatto> getSearch(String stringa);
}
