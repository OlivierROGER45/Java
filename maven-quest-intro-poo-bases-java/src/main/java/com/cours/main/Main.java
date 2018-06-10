/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.main;

import com.cours.calcul.Calculation;
import com.cours.calcul.ICalculation;
import com.cours.process.IProcessAnimal;

import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elhad
 */
public class Main
{

    private static final Log      log           = LogFactory.getLog(Main.class);
    private static ICalculation   calculation   = null;
    private static IProcessAnimal processAnimal = null;

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        testVerifyParite();
        testCompareChaines();
        testFactorielItterative();
        testFactorielRecursive();
        testNombreMagique();
        testSortMyArray();
        testProcessAnimal();
    }

    public static void testVerifyParite()
    {
        Calculation calcul = new Calculation();

        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez un nombre entier:");
        String chaine = scan.next();
        int retour = calcul.verifyParite(chaine);
        switch (retour)
        {
        case (0):
            System.out.println("Le nombre est nul.");
            break;
        case (1):
            System.out.println("Le nombre est positif et pair");
            break;
        case (2):
            System.out.println("Le nombre est négatif et pair");
            break;
        case (3):
            System.out.println("Le nombre est positif et impair");
            break;
        case (4):
            System.out.println("Le nombre est négatif et impair");
            break;
        default:
            System.out.println("Ce n'est pas un nombre entier");
            break;
        }

    }

    public static void testCompareChaines()
    {
        Calculation calcul = new Calculation();

        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez une premiere chaine:");
        String chaine1 = scan.next();
        System.out.println("Entrez une seconde chaine:");
        String chaine2 = scan.next();

        int retour = calcul.compareChaines(chaine1, chaine2);
        switch (retour)
        {
        case (0):
            System.out.println("Les deux chaines sont identiques");
            break;
        case (1):
            System.out.println("La premiere chaine est supérieur à la deuxième");
            break;
        case (-1):
            System.out.println("La deuxième chaine est supérieur à la première");
            break;
        }
    }

    /**
     * Attention pour simplifier l'exercice on ne mettre que de petit nombre entier
     * inferieur à 17. Sinon on risque de depasser la limite prévu pour le type int.
     * Vous pouvez donc utiliser le type entier int.
     */
    public static void testFactorielItterative()
    {
        Calculation calcul = new Calculation();

        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez un nombre entier (entre 0 et 17) :");
        String input = scan.next();
        try
        {
            int entier = Integer.parseInt(input);
            int factoriel = calcul.factorielItterative(entier);
            System.out.println("Le factoriel est : " + factoriel);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Attention pour simplifier l'exercice on ne mettre que de petit nombre entier
     * inferieur à 17. Sinon on risque de depasser la limite prévu pour le type int.
     * Vous pouvez donc utiliser le type entier int.
     */
    public static void testFactorielRecursive()
    {
        Calculation calcul = new Calculation();

        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez un nombre entier (entre 0 et 17) :");
        String input = scan.next();
        try
        {
            int entier = Integer.parseInt(input);
            int factoriel = calcul.factorielRecursive(entier);
            System.out.println("Le factoriel est : " + factoriel);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void testNombreMagique()
    {
        Calculation calcul = new Calculation();

        int[] array = calcul.initMyArray(100);
        for (int i = 0; i < array.length; i++)
        {
            System.out.println("tableau index " + i + " : " + array[i]);
        }
        int magicNumber = calcul.nombreMagique(array);
        System.out.println("Nombre magique " + magicNumber);
    }

    public static void testSortMyArray()
    {
        Calculation calcul = new Calculation();

        int[] array = calcul.initMyArray(100);
        for (int i = 0; i < array.length; i++)
        {
            System.out.println("tableau index " + i + " : " + array[i]);
        }
        array = calcul.sortMyArray(array);
        for (int i = 0; i < array.length; i++)
        {
            System.out.println("tableau trié index " + i + " : " + array[i]);
        }
    }

    public static void testProcessAnimal()
    {
        // processAnimal.loadAnimalsManually();
        // processAnimal.loadAnimalsFile();
        // processAnimal.calculMoyennePoidsAnimaux();
        // processAnimal.calculEcartTypePoidsAnimaux();
    }
}
