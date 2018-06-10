package com.cours.dao;

import java.util.List;

import com.cours.entities.Personne;

public abstract class AbstractPersonneDao
{

    public abstract List findAll();
    public abstract Personne findById(int id);
    public abstract Personne create(Personne person);
    public abstract Personne update(Personne person);
    public abstract boolean delete(Personne person);
}
