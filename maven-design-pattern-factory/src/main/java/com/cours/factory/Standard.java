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
public class Standard extends Livraison
{

    public Standard(Colis colis)
    {
        super(colis);
        this.price += colis.getPoidsColis() * 2.5;
    }

}
