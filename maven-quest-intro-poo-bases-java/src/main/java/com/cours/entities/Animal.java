/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author elhad
 */
public class Animal  {

    private int idAnimal;
    private String nom;
    private double poids;
    private Date dateNaissance;
    private String couleur;
    private int nombrePattes;
    private boolean estCarnivore;
    
    public Animal(int idAnimal, String nom, double poids, Date dateNaissance, String couleur, int nombrePattes,  boolean estCarnivore)
    {
        this.idAnimal = idAnimal;
        this.nom = nom;
        this.poids = poids;
        this.dateNaissance = dateNaissance;
        this.couleur = couleur;
        this.nombrePattes = nombrePattes;
        this.estCarnivore = estCarnivore;
    }
    
    public Animal()
    {
        
    }
    
    public void marcher()
    {
        System.out.println("L’animal "+nom+"marche avec "+nombrePattes+" pattes");
    }
    
    public void description()
    {
        String c = "n’est pas carnivore";
        if(estCarnivore)
            c = "est carnivore";
        System.out.println("L’animal "+nom+" est né le " +dateNaissance+" il pèse " + poids+", il est de couleur "+couleur+", il a «nombre de pattes "+ nombrePattes+" pattes, il "+c);
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(idAnimal).hashCode();
    }
  
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof Animal)) return false;
        Animal a = (Animal) obj;
        return Objects.equals(idAnimal, a.idAnimal);
    }
    
    @Override
    public String toString()
    {
        return idAnimal+","+nom+", "+poids+", "+dateNaissance+", " + couleur+ ", "+nombrePattes+", "+estCarnivore;
    }

    public int getIdAnimal()
    {
        return idAnimal;
    }

    public String getNom()
    {
        return nom;
    }

    public double getPoids()
    {
        return poids;
    }

    public Date getDateNaissance()
    {
        return dateNaissance;
    }

    public String getCouleur()
    {
        return couleur;
    }

    public int getNombrePattes()
    {
        return nombrePattes;
    }

    public boolean isEstCarnivore()
    {
        return estCarnivore;
    }
    
    
}
