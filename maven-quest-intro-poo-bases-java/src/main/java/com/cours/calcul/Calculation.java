/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.calcul;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author elhad
 */
public class Calculation implements ICalculation {

    @Override
    public int addition(int value1, int value2) {
        return value1 + value2;
    }

    @Override
    public int[] initMyArray(int taille) {
        return null;
    }

    @Override
    public int[] sortMyArray(int[] arrayToSort) {
        return null;
    }

    /**
     * Attention pour simplifier l'exercice on ne mettre que de petit nombre
     * entier inferieur à 17. Sinon on risque de depasser la limite prévu pour
     * le type int. Vous pouvez donc utiliser le type entier int.
     */
    @Override
    public int factorielItterative(int number) {

        return 0;
    }

    /**
     * Attention pour simplifier l'exercice on ne mettre que de petit nombre
     * entier inferieur à 17. Sinon on risque de depasser la limite prévu pour
     * le type int. Vous pouvez donc utiliser le type entier int.
     */
    @Override
    public int factorielRecursive(int number) {

        return 0;
    }

    /**
     * renvois 0 si les deux chaines de caractères sont identiques, 1 si la
     * premiere chaine est supérieur à la seconde chaine (en terme de code
     * ASCII), -1 si la premiere chaine est inférieur à la seconde chaine (en
     * terme de code ASCII)
     *
     * @param firstChaine
     * @param secondeChaine
     * @return result
     */
    @Override
    public int compareChaines(String firstChaine, String secondeChaine) {

        return 0;
    }

    /**
     * renvois 0 si le nombre est égale à 0, 1 s’il est pair et positif, 2 s’il
     * est négatif et paire, 3 s’il est impair et positif et 4 s’il est négatif
     * et impair
     *
     * @param chaine
     * @return result
     */
    @Override
    public int verifyParite(String chaine) {
        return 0;
    }

    @Override
    public int nombreMagique(int[] array) {
        return 0;
    }
}
