/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.factory;

/**
 *
 * @author ElHadji
 */
public abstract class Livraison
{
    protected double price = 4;
    protected Colis colis;
    protected int day = 0;
    
    protected Livraison(Colis colis, int day)
    {
     this.colis = colis;
     this.day = day;
     if (colis.isEstFragile())
         price++;
    }
    
    protected Livraison(Colis colis)
    {
     this.colis = colis;
     if (colis.isEstFragile())
         price++;
    }
    
    public void print()
    {
        if(0 == day)
            System.out.println("le prix d'un colis de " + colis.getPoidsColis() + " kilos avec des " + colis.getDescriptionColis() + " que l'on doit livrer quand on peut est de " + price);
        else
        System.out.println("le prix d'un colis de " + colis.getPoidsColis() + " kilos avec des " + colis.getDescriptionColis() + " que l'on doit livrer en " + day + " jour est de " + price);
    }  
}
