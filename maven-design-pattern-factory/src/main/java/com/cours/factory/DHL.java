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
public class DHL extends Livraison
{

    public DHL(Colis colis, int day)
    {
        super(colis, day);
        this.price += colis.getPoidsColis() * 3.5 + 1;
    }

}
