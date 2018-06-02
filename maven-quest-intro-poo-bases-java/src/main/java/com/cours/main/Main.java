/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.main;

import com.cours.calcul.ICalculation;
import com.cours.process.IProcessAnimal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elhad
 */
public class Main {

    private static final Log log = LogFactory.getLog(Main.class);
    private static ICalculation calculation = null;
    private static IProcessAnimal processAnimal = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //testVerifyParite();
        //testCompareChaines();
        //testFactorielItterative();
        //testFactorielRecursive();
        //testNombreMagique();
        //testSortMyArray();
        //testProcessAnimal();
    }

    public static void testVerifyParite() {

    }

    public static void testCompareChaines() {

    }

    /**
     * Attention pour simplifier l'exercice on ne mettre que de petit nombre
     * entier inferieur à 17. Sinon on risque de depasser la limite prévu pour
     * le type int. Vous pouvez donc utiliser le type entier int.
     */
    public static void testFactorielItterative() {

    }

    /**
     * Attention pour simplifier l'exercice on ne mettre que de petit nombre
     * entier inferieur à 17. Sinon on risque de depasser la limite prévu pour
     * le type int. Vous pouvez donc utiliser le type entier int.
     */
    public static void testFactorielRecursive() {

    }

    public static void testNombreMagique() {

    }

    public static void testSortMyArray() {

    }

    public static void testProcessAnimal() {
        //processAnimal.loadAnimalsManually();
        //processAnimal.loadAnimalsFile();
        //processAnimal.calculMoyennePoidsAnimaux();
        //processAnimal.calculEcartTypePoidsAnimaux();
    }
}
