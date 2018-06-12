package com.cours.entities;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ElHadji
 */
public class Personne
{

    private static final AtomicInteger count = new AtomicInteger(0); 
    
    private int    idPersonne;
    private String prenom;
    private String nom;
    private double poids;
    private double taille;
    private String rue;
    private String ville;
    private String codePostal;
    
    public Personne()
    {

    }
    
    public Personne(int idPersonne, String prenom, String nom, double poids, double taille, String rue, String ville, String codePostal)
    {
        this.idPersonne = idPersonne;
        this.prenom = prenom;
        this.nom = nom;
        this.poids = poids;
        this.taille = taille;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    @Override
    public String toString()
    {
        return ""+idPersonne+prenom+nom+poids+taille+rue+ville+codePostal;
    }
    
    public String toStringCSV()
    {
        return idPersonne+";"+prenom+";"+nom+";"+poids+";"+taille+";"+rue+";"+ville+";"+codePostal;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof Personne)) return false;
        Personne a = (Personne) obj;
        return Objects.equals(idPersonne, a.idPersonne);
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(idPersonne).hashCode();
    }

    public double getImc()
    {
        return (poids / (taille * taille));
    }

    public boolean isMaigre()
    {
        if(getImc() <= 30 && getImc() >= 25)
            return true;
        return false;
    }

    public boolean isSurPoids()
    {
        if(getImc() <= 18.5)
            return true;
        return false;
    }

    public boolean isObese()
    {
        if(getImc()> 30)
            return true;
        return false;
    }

    public int getIdPersonne()
    {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne)
    {
        this.idPersonne = idPersonne;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public double getPoids()
    {
        return poids;
    }

    public void setPoids(double poids)
    {
        this.poids = poids;
    }

    public double getTaille()
    {
        return taille;
    }

    public void setTaille(double taille)
    {
        this.taille = taille;
    }

    public String getRue()
    {
        return rue;
    }

    public void setRue(String rue)
    {
        this.rue = rue;
    }

    public String getVille()
    {
        return ville;
    }

    public void setVille(String ville)
    {
        this.ville = ville;
    }

    public String getCodePostal()
    {
        return codePostal;
    }

    public void setCodePostal(String codePostal)
    {
        this.codePostal = codePostal;
    }
    
    

}
