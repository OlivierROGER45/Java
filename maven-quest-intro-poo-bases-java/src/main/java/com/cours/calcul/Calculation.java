/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.calcul;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elhad
 */
public class Calculation implements ICalculation
{

    private static final Log log = LogFactory.getLog(Calculation.class);

    @Override
    public int addition(int value1, int value2)
    {
        return value1 + value2;
    }

    @Override
    public int[] initMyArray(int taille)
    {
        if (log.isDebugEnabled())
        {
            log.debug("initMyArray");
        }
        int[] t = new int[100];
        int randomNum;
        for (int i = 0; i < 100; i++)
        {
            randomNum = ThreadLocalRandom.current().nextInt(1, 100 + 1);
            t[i] = randomNum;
        }
        return t;
    }

    @Override
    public int[] sortMyArray(int[] arrayToSort)
    {        
        boolean sorted = false;
        int l = arrayToSort.length;
        while(!sorted)
        {
            sorted = true;
            for(int i=0 ; i < l-1 ; i++)
            {
                if(arrayToSort[i] > arrayToSort[i+1])
                {
                    int tmp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i+1];
                    arrayToSort[i+1] = tmp;
                    sorted = false;
                }
            }
            l--;
        }
        return arrayToSort;
    }
    
    /**
     * Attention pour simplifier l'exercice on ne mettre que de petit nombre entier
     * inferieur à 17. Sinon on risque de depasser la limite prévu pour le type int.
     * Vous pouvez donc utiliser le type entier int.
     */
    @Override
    public int factorielItterative(int number)
    {
        int res = 1;
        for (int i = 2; i <= number; i++) {
            res *= i;
        }
        return res;
    }

    /**
     * Attention pour simplifier l'exercice on ne mettre que de petit nombre entier
     * inferieur à 17. Sinon on risque de depasser la limite prévu pour le type int.
     * Vous pouvez donc utiliser le type entier int.
     */
    @Override
    public int factorielRecursive(int number)
    {
        if (number == 0)
            return 1;
        else
            return number * factorielRecursive(number - 1);
    }

    /**
     * renvois 0 si les deux chaines de caractères sont identiques, 1 si la premiere
     * chaine est supérieur à la seconde chaine (en terme de code ASCII), -1 si la
     * premiere chaine est inférieur à la seconde chaine (en terme de code ASCII)
     *
     * @param firstChaine
     * @param secondeChaine
     * @return result
     */
    @Override
    public int compareChaines(String firstChaine, String secondeChaine)
    {
//        if (null == firstChaine || secondeChaine == null)
//            return -42;

        if (firstChaine.equals(secondeChaine))
            return 0;
        if (firstChaine.length() == secondeChaine.length())
        {
            for (int j = 0; j < firstChaine.length(); j++)
            {
                char c1 = firstChaine.charAt(j);
                char c2 = secondeChaine.charAt(j);
                if (c1 == c2)
                    continue;
                if (c1 < c2)
                    return -1;
                else
                    return 1;
            }
            return 0;
        }
        else if (firstChaine.length() > secondeChaine.length())
            return 1;
        else
            return -1;
    }

    /**
     * renvoie 0 si le nombre est égale à 0, 1 s’il est pair et positif, 2 s’il est
     * négatif et paire, 3 s’il est impair et positif et 4 s’il est négatif et
     * impair renvoie -1 si l'input est mauvais
     * 
     * @param chaine
     * @return result
     */
    @Override
    public int verifyParite(String chaine)
    {

        if (!checkStringInput(chaine))
            return -1;
        int n;
        try
        {
            n = Integer.parseInt(chaine);
        }
        catch (NumberFormatException nfe)
        {
            return -1;
        }

        if (n > 0)
            if (n % 2 == 0)
                return 1;
            else
                return 3;
        else if (n != 0)
            if (n % 2 == 0)
                return 2;
            else
                return 4;
        else
            return 0;
    }

    /**
     * check str == null 
     * check char str can be convert to int 
     * check first char check
     * integer default memory
     * 
     * @param s
     * @return
     */
    private boolean checkStringInput(String s)
    {
        if (s == null)
        {
            return false;
        }
        int length = s.length();
        if (length == 0)
        {
            return false;
        }
        int j = 0;
        if (s.charAt(0) == '-')
        {
            if (length == 1)
            {
                return false;
            }
            j = 1;
        }
        while (j < s.length())
        {
            char c = s.charAt(j);
            if (c < '0' || c > '9')
            {
                return false;
            }
            j++;
        }
        return true;
    }

    @Override
    public int nombreMagique(int[] array)
    {
        int min = array[0];
        int max = array[0];
        for (int k = 0; k < 100; k++)
        {
            if (array[k] < min)
                min = array[k];
            else if (array[k] > max)
                max = array[k];
        }
        return (min + max);
    }
}
