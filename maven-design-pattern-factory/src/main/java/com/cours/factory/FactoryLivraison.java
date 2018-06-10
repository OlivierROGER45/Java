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
public class FactoryLivraison
{
    public Livraison createLivraison(Colis col, int day)
    {
        Livraison livraison = null;

        switch (day)
        {
        case 1:
            livraison = new Chronopost(col, day);
            break;
        case 2:
            livraison = new DHL(col, day);
            break;
        case 3:
            livraison = new Fedex(col, day);
            break;
        default:
            livraison = new Standard(col);
        }
        return livraison;
    }

    public Livraison createLivraison(Colis col)
    {
        Livraison livraison = null;

        livraison = new Standard(col);
        return livraison;
    }

}