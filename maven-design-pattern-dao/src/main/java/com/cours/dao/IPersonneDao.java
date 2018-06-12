package com.cours.dao;

import java.util.List;

import com.cours.entities.Personne;

public interface IPersonneDao {

    public List<Personne> findAll();

    public Personne findById(int id);

    public Personne create(Personne p);

    public Personne update(Personne p);

    public boolean delete(Personne p);
}
