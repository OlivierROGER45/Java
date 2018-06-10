package com.cours.dao.manual;

import java.util.ArrayList;
import java.util.List;

import com.cours.dao.AbstractPersonneDao;
import com.cours.entities.Personne;

public class ManualPersonneDao extends AbstractPersonneDao
{

    private List<Personne> manualPersonnes;

    public ManualPersonneDao()
    {
        // TODO Auto-generated constructor stub
    }
    
    public List<Personne> initData() {
        manualPersonnes = new ArrayList<Personne>();
        for(int i = 0; i < 20; i++)
        {
            manualPersonnes.add(new Personne());
        }
        return manualPersonnes;
    }

    public List<Personne> findAll()
    {
        return manualPersonnes;
    }

    public Personne findById(int id)
    {
        for (Personne p : manualPersonnes)
        {
            if (p.getIdPersonne() == id)
                return p;
        }
        return null;
    }

    public Personne create(Personne person)
    {
        manualPersonnes.add(person);
        return person;
    }

    public Personne update(Personne person)
    {
        for (int i = 0; i < manualPersonnes.size(); i++)
        {
            if (manualPersonnes.get(i).getIdPersonne() == person.getIdPersonne())
            {
                manualPersonnes.set(i, person);
                return person;
            }
        }
        return null;

    }

    public boolean delete(Personne person)
    {
        if (null != findById(person.getIdPersonne()))
        {
            manualPersonnes.remove(person);
            return true;
        }
        return false;
    }

}
