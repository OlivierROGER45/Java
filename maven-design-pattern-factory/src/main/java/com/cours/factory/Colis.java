/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.factory;

import java.util.Random;

/**
 *
 * @author ElHadji
 */
public class Colis
{

    private String  descriptionColis;
    private double  poidsColis;
    private boolean estFragile;
    private String  numeroSuiviColis;

    public Colis(String descriptionColis, double poidsColis, boolean estFragile)
    {
        StringBuilder sb = new StringBuilder();
        char randomLetter;
        for (int i = 0; i < 9; i++)
        {
            randomLetter = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
            sb.append(randomLetter);
        }
        numeroSuiviColis = sb.toString();

        this.descriptionColis = descriptionColis;
        this.poidsColis = poidsColis;
        this.estFragile = estFragile;
    }

    public String getDescriptionColis()
    {
        return descriptionColis;
    }

    public double getPoidsColis()
    {
        return poidsColis;
    }

    public boolean isEstFragile()
    {
        return estFragile;
    }

    public String getNumeroSuiviColis()
    {
        return numeroSuiviColis;
    }
}
